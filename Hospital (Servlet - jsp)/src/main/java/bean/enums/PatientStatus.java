package bean.enums;

/**
 * Created by Egor on 12.01.2017.
 */
public enum PatientStatus {
    NOT_TREATED(1), TREATED(2), DISCHARGE(3);

    private int value;

    PatientStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PatientStatus getValue(String status) {
        for (PatientStatus patientStatus : values()) {
            if (patientStatus.toString().equalsIgnoreCase(status)) {
                return patientStatus;
            }
        }
        return null;
    }
}
