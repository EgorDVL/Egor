package bean;

/**
 * Created by Egor on 05.01.2017.
 */
public class HospitalCard {
    private int hospitalCardId;
    private int patientId;

    public HospitalCard() {
    }

    public HospitalCard(int patientId) {
        this.patientId = patientId;
    }

    public int getHospitalCardId() {
        return hospitalCardId;
    }

    public void setHospitalCardId(int hospitalCardId) {
        this.hospitalCardId = hospitalCardId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "HospitalCard{" +
                "hospitalCardId=" + hospitalCardId +
                ", patientId=" + patientId +
                '}';
    }
}
