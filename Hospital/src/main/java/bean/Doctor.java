package bean;

import bean.enums.DepartmentEnum;

import java.util.Date;

/**
 * Created by Egor on 05.01.2017.
 */
public class Doctor {
    private int doctorId;
    private String name;
    private String surname;
    private String phone;
    private String specialty;
    private Date dateOfBirth;
    private int experience;
    private String photo;
    private DepartmentEnum department;
    private int userId;

    public Doctor() {
    }

    public Doctor(String name, String surname, String phone, String specialty, Date dateOfBirth, int experience, String photo, DepartmentEnum department, int userId) {
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

    public Doctor(int doctorId, String name, String surname, String phone, String specialty, Date dateOfBirth, int experience, String photo, DepartmentEnum department, int userId) {
        this(name, surname, phone, specialty, dateOfBirth, experience, photo, department, userId);
        this.doctorId = doctorId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (doctorId != doctor.doctorId) return false;
        if (experience != doctor.experience) return false;
        if (userId != doctor.userId) return false;
        if (name != null ? !name.equals(doctor.name) : doctor.name != null) return false;
        if (surname != null ? !surname.equals(doctor.surname) : doctor.surname != null) return false;
        if (phone != null ? !phone.equals(doctor.phone) : doctor.phone != null) return false;
        if (specialty != null ? !specialty.equals(doctor.specialty) : doctor.specialty != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(doctor.dateOfBirth) : doctor.dateOfBirth != null) return false;
        if (photo != null ? !photo.equals(doctor.photo) : doctor.photo != null) return false;
        return department == doctor.department;

    }

    @Override
    public int hashCode() {
        int result = doctorId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + experience;
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
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
