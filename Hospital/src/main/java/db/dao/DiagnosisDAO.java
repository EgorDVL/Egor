package db.dao;

import bean.Diagnosis;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface DiagnosisDAO {
    int createDiagnosis(Diagnosis diagnosis);

    Diagnosis getDiagnosisById(int diagnosisId);

    List<Diagnosis> getAllDiagnosis();

    boolean updateDiagnosis(Diagnosis diagnosis);
}
