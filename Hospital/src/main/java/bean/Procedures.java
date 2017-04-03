package bean;

import bean.enums.ProcedureStatus;

import java.util.Date;

/**
 * Created by Egor on 05.01.2017.
 */
public class Procedures {
    private int proceduresId;
    private String nameProcedure;
    private String useProcedure;
    private Date dateStartProcedure;
    private Date dateEndProcedure;
    private ProcedureStatus procedureStatus;

    public Procedures() {
    }

    public Procedures(String nameProcedure, String useProcedure, Date dateStartProcedure, Date dateEndProcedure, ProcedureStatus procedureStatus) {
        this.nameProcedure = nameProcedure;
        this.useProcedure = useProcedure;
        this.dateStartProcedure = dateStartProcedure;
        this.dateEndProcedure = dateEndProcedure;
        this.procedureStatus = procedureStatus;
    }

    public Procedures(int proceduresId, String nameProcedure, String useProcedure, Date dateStartProcedure, Date dateEndProcedure, ProcedureStatus procedureStatus) {
        this(nameProcedure, useProcedure, dateStartProcedure, dateEndProcedure, procedureStatus);
        this.proceduresId = proceduresId;
    }

    public int getProceduresId() {
        return proceduresId;
    }

    public void setProceduresId(int proceduresId) {
        this.proceduresId = proceduresId;
    }

    public String getNameProcedure() {
        return nameProcedure;
    }

    public void setNameProcedure(String nameProcedure) {
        this.nameProcedure = nameProcedure;
    }

    public String getUseProcedure() {
        return useProcedure;
    }

    public void setUseProcedure(String useProcedure) {
        this.useProcedure = useProcedure;
    }

    public Date getDateStartProcedure() {
        return dateStartProcedure;
    }

    public void setDateStartProcedure(Date dateStartProcedure) {
        this.dateStartProcedure = dateStartProcedure;
    }

    public Date getDateEndProcedure() {
        return dateEndProcedure;
    }

    public void setDateEndProcedure(Date dateEndProcedure) {
        this.dateEndProcedure = dateEndProcedure;
    }

    public ProcedureStatus getProcedureStatus() {
        return procedureStatus;
    }

    public void setProcedureStatus(ProcedureStatus procedureStatus) {
        this.procedureStatus = procedureStatus;
    }

    @Override
    public String toString() {
        return "Procedures{" +
                "proceduresId=" + proceduresId +
                ", nameProcedure='" + nameProcedure + '\'' +
                ", useProcedure='" + useProcedure + '\'' +
                ", dateStartProcedure=" + dateStartProcedure +
                ", dateEndProcedure=" + dateEndProcedure +
                ", procedureStatus=" + procedureStatus +
                '}';
    }
}

