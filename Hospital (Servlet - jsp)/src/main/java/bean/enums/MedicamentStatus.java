package bean.enums;

/**
 * Created by Egor on 20.01.2017.
 */
public enum MedicamentStatus {
    DONE(1), NOT_DONE(2);
    private int value;

    MedicamentStatus(int value) {
        this.value = value;
    }

    public int getValueInt() {
        return value;
    }

    public static MedicamentStatus getValue(String status) {
        for (MedicamentStatus medicamentStatus : values()) {
            if (medicamentStatus.toString().equalsIgnoreCase(status)) {
                return medicamentStatus;
            }
        }
        return null;
    }
}
