package bean;

/**
 * Created by Egor on 05.01.2017.
 */
public class AttendingDoctor {
    private int attendingDoctorId;
    private int doctorId;
    private int patientId;

    public AttendingDoctor() {
    }

    public AttendingDoctor(int doctorId, int patientId) {
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public int getAttendingDoctorId() {
        return attendingDoctorId;
    }

    public void setAttendingDoctorId(int attendingDoctorId) {
        this.attendingDoctorId = attendingDoctorId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "AttendingDoctor{" +
                "attendingDoctorId=" + attendingDoctorId +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                '}';
    }
}
