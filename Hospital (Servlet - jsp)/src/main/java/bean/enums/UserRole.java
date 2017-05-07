package bean.enums;

public enum UserRole {
    ADMIN(1), DOCTOR(2), NURSE(3), PATIENT(4);

    private int value;

    UserRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UserRole getValue(String userRole) {
        for (UserRole role : values()) {
            if (role.toString().equalsIgnoreCase(userRole)) {
                return role;
            }
        }
        return null;
    }

    public static UserRole fromValue(int value) {
        for (UserRole role : values()) {
            if (role.getValue() == value) {
                return role;
            }
        }
        return null;
    }
}
