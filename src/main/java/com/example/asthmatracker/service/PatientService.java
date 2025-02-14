package com.example.asthmatracker.service;

import com.example.asthmatracker.models.Patient;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Service;

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

}
