package bean.enums;

/**
 * Created by Egor on 20.01.2017.
 */
public enum OperationStatus {
    DONE(1), NOT_DONE(2);
    private int value;

    OperationStatus(int value) {
        this.value = value;
    }

    public int getValueInt() {
        return value;
    }

    public static OperationStatus getValue(String status) {
        for (OperationStatus operationStatus : values()) {
            if (operationStatus.toString().equalsIgnoreCase(status)) {
                return operationStatus;
            }
        }
        return null;
    }
}
