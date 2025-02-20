package com.example.asthmatracker.service;

import com.example.asthmatracker.models.Medicine;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.jooq.generated.Tables.MEDICINE;
import static com.example.jooq.generated.Tables.PATIENTS;

@Service
public class MedicineService {

    private final DSLContext dsl;

    public MedicineService(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Medicine createMedicine(Medicine medicine) {
        Record record = dsl.insertInto(MEDICINE)
                .set(MEDICINE.NAME, medicine.getName())
                .set(MEDICINE.MG, medicine.getMg())
                .returning(MEDICINE.ID)
                .fetchOne();

        if (record != null) {
            medicine.setId(record.get(MEDICINE.ID));
        }

        return medicine;
    }

    public List<Medicine> getMedicineByName(String name) {
        return dsl.selectFrom(MEDICINE)
                .where(MEDICINE.NAME.eq(name))
                .fetchInto(Medicine.class);
    }
}
