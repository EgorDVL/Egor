package service;

import bean.Diagnosis;

/**
 * Created by Egor on 22.01.2017.
 */
public interface DiagnosisService {
    
    boolean updateDiagnosis(Diagnosis diagnosis);

    int createDiagnosis(String diagnosisName);

    Diagnosis getDiagnosisById(int diagnosisId);
}
