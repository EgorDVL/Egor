package bean.enums;

/**
 * Created by Egor on 05.01.2017.
 */
public enum DepartmentEnum {
    THERAPY(1), SURGERY(2), TRAUMATOLOGY(3), STOMATOLOGY(4), PEDIATRICS(5), OPHTHALMOLOGY(6), NEUROLOGY(7), CARDIOLOGY(8), GYNECOLOGY(9), VENEREOLOGY(10), OBSTETRICS(11);

    private int value;

    DepartmentEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DepartmentEnum getValue(String departments) {
        for (DepartmentEnum departmentEnum : values()) {
            if (departmentEnum.toString().equalsIgnoreCase(departments)) {
                return departmentEnum;
            }
        }
        return null;
    }

    public static DepartmentEnum fromValue(int value) {
        for (DepartmentEnum departmentEnum : values()) {
            if (departmentEnum.getValue() == value) {
                return departmentEnum;
            }
        }
        return null;
    }
}
