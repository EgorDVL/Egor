package bean;

import bean.enums.PatientStatus;

import java.util.Date;

/**
 * Created by Egor on 05.01.2017.
 */
public class Patient {
    private int patientId;
    private String name;
    private String surname;
    private String phone;
    private Date dateOfBirth;
    private String address;
    private String photo;
    private PatientStatus patientStatus;
    private int userId;

    public Patient() {
    }

    public Patient(String name, String surname, String phone, Date dateOfBirth, String address, String photo, PatientStatus patientStatus, int userId) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.photo = photo;
        this.patientStatus = patientStatus;
        this.userId = userId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(PatientStatus patientStatus) {
        this.patientStatus = patientStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", photo='" + photo + '\'' +
                ", patientStatus=" + patientStatus +
                ", userId=" + userId +
                '}';
    }
}
