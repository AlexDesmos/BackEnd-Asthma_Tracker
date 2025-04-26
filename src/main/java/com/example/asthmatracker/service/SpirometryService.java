package com.example.asthmatracker.service;

import com.example.asthmatracker.models.Spirometry;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Service;

import static com.example.jooq.generated.Tables.SPIROMETRY;

@Service
public class SpirometryService {

    private final DSLContext dsl;

    public SpirometryService(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Spirometry postResultOfSpirometry(Spirometry spirometry) {
        Record record = dsl.insertInto(SPIROMETRY)
                .set(SPIROMETRY.PATIENT_ID, spirometry.getPatient_id())
                .set(SPIROMETRY.RESULT, spirometry.getResult())
                .set(SPIROMETRY.DATE_TIME, spirometry.getDate_time())
                .returning(SPIROMETRY.ID)
                .fetchOne();

        if (record != null) {
            spirometry.setId(record.get(SPIROMETRY.ID));
        }

        return spirometry;
    }
}
