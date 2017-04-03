package bean;

import bean.enums.DepartmentEnum;

/**
 * Created by Egor on 05.01.2017.
 */
public class Department {
    private int departmentId;
    private DepartmentEnum departmentEnum;

    public Department() {
    }

    public Department(int departmentId, DepartmentEnum departmentEnum) {
        this.departmentId = departmentId;
        this.departmentEnum = departmentEnum;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public DepartmentEnum getDepartmentEnum() {
        return departmentEnum;
    }

    public void setDepartmentEnum(DepartmentEnum departmentEnum) {
        this.departmentEnum = departmentEnum;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentEnum=" + departmentEnum +
                '}';
    }
}
