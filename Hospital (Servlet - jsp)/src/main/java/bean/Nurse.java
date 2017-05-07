package bean;

import bean.enums.DepartmentEnum;

import java.util.Date;

/**
 * Created by Egor on 05.01.2017.
 */
public class Nurse {
    private int nurseId;
    private String name;
    private String surname;
    private String phone;
    private String specialty;
    private Date dateOfBirth;
    private int experience;
    private String photo;
    private DepartmentEnum department;
    private int userId;

    public Nurse() {
    }

    public Nurse(String name, String surname, String phone, String specialty, Date dateOfBirth, int experience, String photo, DepartmentEnum department, int userId) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.specialty = specialty;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.photo = photo;
        this.department = department;
        this.userId = userId;
    }

    public Nurse(int nurseId, String name, String surname, String phone, String specialty, Date dateOfBirth, int experience, String photo, DepartmentEnum department, int userId) {
        this(name, surname, phone, specialty, dateOfBirth, experience, photo, department, userId);
        this.nurseId = nurseId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public DepartmentEnum getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEnum department) {
        this.department = department;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseId=" + nurseId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", specialty='" + specialty + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", experience=" + experience +
                ", photo='" + photo + '\'' +
                ", department=" + department +
                ", userId=" + userId +
                '}';
    }
}
