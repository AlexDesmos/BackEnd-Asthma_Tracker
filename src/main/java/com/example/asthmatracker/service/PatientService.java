package com.example.asthmatracker.service;

import com.example.asthmatracker.exceptions.PatientNotFoundException;
import com.example.asthmatracker.models.Patient;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.jooq.generated.Tables.PATIENTS;

@Service
public class PatientService {

    private final DSLContext dsl;

    public PatientService(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Patient createPatient(Patient patient) {
        Record record = dsl.insertInto(PATIENTS)
                .set(PATIENTS.NAME, patient.getName())
                .set(PATIENTS.SURNAME, patient.getSurname())
                .set(PATIENTS.PATRONYMIC, patient.getPatronymic())
                .set(PATIENTS.BIRTHDAY, patient.getBirthday())
                .set(PATIENTS.EMAIL, patient.getEmail())
                .set(PATIENTS.PHONE_NUMBER, patient.getPhone_number())
                .set(PATIENTS.OMS, patient.getOms())
                .returning(PATIENTS.ID)
                .fetchOne();

        if (record != null) {
            patient.setId(record.get(PATIENTS.ID));
        }

        return patient;
    }

    public List<Patient> getPatientsByFilter(String fullName, String oms) {
        Condition condition = DSL.noCondition();
        if (fullName != null && !fullName.isBlank()) {
            String likePattern = "%" + fullName.toLowerCase() + "%";
            condition = condition.and(
                    DSL.lower(PATIENTS.NAME).like(likePattern)
                            .or(DSL.lower(PATIENTS.SURNAME).like(likePattern))
                            .or(DSL.lower(PATIENTS.PATRONYMIC).like(likePattern))
            );
        }

        if (oms != null && !oms.isBlank()) {
            condition = condition.and(
                    PATIENTS.OMS.like("%" + oms + "%")
            );
        }

        return dsl.selectFrom(PATIENTS)
                .where(condition)
                .fetchInto(Patient.class);
    }

    public Patient updatePatient(Patient patient, Integer id) {
        Record record = dsl.update(PATIENTS)
                .set(PATIENTS.NAME, patient.getName())
                .set(PATIENTS.SURNAME, patient.getSurname())
                .set(PATIENTS.PATRONYMIC, patient.getPatronymic())
                .set(PATIENTS.BIRTHDAY, patient.getBirthday())
                .set(PATIENTS.EMAIL, patient.getEmail())
                .set(PATIENTS.PHONE_NUMBER, patient.getPhone_number())
                .where(PATIENTS.ID.eq(id))
                .returning()
                .fetchOne();

        if (record == null) {
            throw new PatientNotFoundException("Пациента с id " + id + " не существует");
        }

        return record.into(Patient.class);
    }

    public void deletePatientByOms(String oms) {
        int rowsDeleted = dsl.deleteFrom(PATIENTS)
                .where(PATIENTS.OMS.eq(oms))
                .execute();

        if (rowsDeleted == 0) {
            throw new PatientNotFoundException("Пациента с таким ОМС не существует");
        }
    }

}
