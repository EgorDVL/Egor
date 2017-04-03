package bean;

import java.util.Date;

/**
 * Created by Egor on 05.01.2017.
 */
public class Appointment {
    private int appointmentId;
    private String nameAppointment;
    private Date dateAppointment;
    private Integer operationId;
    private Integer medicamentId;
    private Integer proceduresId;

    public Appointment() {
    }

    public Appointment(String nameAppointment, Date dateAppointment, Integer operationId, Integer medicamentId, Integer proceduresId) {
        this.nameAppointment = nameAppointment;
        this.dateAppointment = dateAppointment;
        this.operationId = operationId;
        this.medicamentId = medicamentId;
        this.proceduresId = proceduresId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getNameAppointment() {
        return nameAppointment;
    }

    public void setNameAppointment(String nameAppointment) {
        this.nameAppointment = nameAppointment;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Integer getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(Integer medicamentId) {
        this.medicamentId = medicamentId;
    }

    public Integer getProceduresId() {
        return proceduresId;
    }

    public void setProceduresId(Integer proceduresId) {
        this.proceduresId = proceduresId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", nameAppointment='" + nameAppointment + '\'' +
                ", dateAppointment=" + dateAppointment +
                ", operationId=" + operationId +
                ", medicamentId=" + medicamentId +
                ", proceduresId=" + proceduresId +
                '}';
    }
}
