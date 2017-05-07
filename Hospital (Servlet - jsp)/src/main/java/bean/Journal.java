package bean;

import java.util.Date;

/**
 * Created by Egor on 24.01.2017.
 */
public class Journal {

    private int journalId;
    private Date date;
    private int patientId;
    private String message;

    public Journal() {
    }

    public Journal(Date date, int patientId, String message) {
        this.date = date;
        this.patientId = patientId;
        this.message = message;
    }

    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "journalId=" + journalId +
                ", date=" + date +
                ", patientId=" + patientId +
                ", message='" + message + '\'' +
                '}';
    }
}
