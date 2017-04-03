package bean.enums;

/**
 * Created by Egor on 20.01.2017.
 */
public enum ProcedureStatus {
    DONE(1), NOT_DONE(2);
    private int value;

    ProcedureStatus(int value) {
        this.value = value;
    }

    public int getValueInt() {
        return value;
    }

    public static ProcedureStatus getValue(String status) {
        for (ProcedureStatus procedureStatus : values()) {
            if (procedureStatus.toString().equalsIgnoreCase(status)) {
                return procedureStatus;
            }
        }
        return null;
    }
}
