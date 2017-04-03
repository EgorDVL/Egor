package bean;

/**
 * Created by Egor on 05.01.2017.
 */
public class Diagnosis {
    private int diagnosisId;
    private String nameDiagnos;

    public Diagnosis() {
    }

    public Diagnosis(String nameDiagnos) {
        this.nameDiagnos = nameDiagnos;
    }

    public Diagnosis(int diagnosisId, String nameDiagnos) {
        this(nameDiagnos);
        this.diagnosisId = diagnosisId;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getNameDiagnos() {
        return nameDiagnos;
    }

    public void setNameDiagnos(String nameDiagnos) {
        this.nameDiagnos = nameDiagnos;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosisId=" + diagnosisId +
                ", nameDiagnos='" + nameDiagnos + '\'' +
                '}';
    }
}
