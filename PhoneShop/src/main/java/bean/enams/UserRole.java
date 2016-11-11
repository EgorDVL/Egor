package bean.enams;

import bean.User;

public enum UserRole {
    ADMIN(1), USER(2), GUEST(3);

    private int value;

    UserRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UserRole getUserRole(User user) {
        int roleId = user.getRoleId();
        return UserRole.values()[--roleId];
    }

    public static UserRole getValue(String userRole) {
        for (UserRole role : values()) {
            if (role.toString().equalsIgnoreCase(userRole)) {
                return role;
            }
        }
        return null;
    }
}
