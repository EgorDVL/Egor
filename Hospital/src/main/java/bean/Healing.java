package bean;

import java.util.Date;

/**
 * Created by Egor on 05.01.2017.
 */
public class Healing {
    private int healingId;
    private String symptoms;
    private Date dateHealingStart;
    private Date dateHealingEnd;
    private int appointmentId;
    private int diagnosisId;
    private int hospitalCardId;

    public Healing() {
    }

    public Healing(String symptoms, Date dateHealingStart, Date dateHealingEnd, int appointmentId, int diagnosisId, int hospitalCardId) {
        this.symptoms = symptoms;
        this.dateHealingStart = dateHealingStart;
        this.dateHealingEnd = dateHealingEnd;
        this.appointmentId = appointmentId;
        this.diagnosisId = diagnosisId;
        this.hospitalCardId = hospitalCardId;
    }

    public Healing(int healingId, String symptoms, Date dateHealingStart, Date dateHealingEnd, int appointmentId, int diagnosisId, int hospitalCardId) {
        this(symptoms, dateHealingStart, dateHealingEnd, appointmentId, diagnosisId, hospitalCardId);
        this.healingId = healingId;
    }

    public int getHealingId() {
        return healingId;
    }

    public void setHealingId(int healingId) {
        this.healingId = healingId;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Date getDateHealingStart() {
        return dateHealingStart;
    }

    public void setDateHealingStart(Date dateHealingStart) {
        this.dateHealingStart = dateHealingStart;
    }

    public Date getDateHealingEnd() {
        return dateHealingEnd;
    }

    public void setDateHealingEnd(Date dateHealingEnd) {
        this.dateHealingEnd = dateHealingEnd;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public int getHospitalCardId() {
        return hospitalCardId;
    }

    public void setHospitalCardId(int hospitalCardId) {
        this.hospitalCardId = hospitalCardId;
    }

    @Override
    public String toString() {
        return "Healing{" +
                "healingId=" + healingId +
                ", symptoms='" + symptoms + '\'' +
                ", dateHealingStart=" + dateHealingStart +
                ", dateHealingEnd=" + dateHealingEnd +
                ", appointmentId=" + appointmentId +
                ", diagnosisId=" + diagnosisId +
                ", hospitalCardId=" + hospitalCardId +
                '}';
    }
}
