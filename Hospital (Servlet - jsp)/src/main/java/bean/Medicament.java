package bean;

import bean.enums.MedicamentEnum;
import bean.enums.MedicamentStatus;

import java.util.Date;

/**
 * Created by Egor on 05.01.2017.
 */
public class Medicament {
    private int medicamentId;
    private String nameMedicament;
    private MedicamentEnum medicamentEnum;
    private String useMedicament;
    private Date dateStartMedicament;
    private Date dateEndMedicament;
    private MedicamentStatus medicamentStatus;

    public Medicament() {
    }

    public Medicament(String nameMedicament, MedicamentEnum medicamentEnum, String useMedicament, Date dateStartMedicament, Date dateEndMedicament, MedicamentStatus medicamentStatus) {
        this.nameMedicament = nameMedicament;
        this.medicamentEnum = medicamentEnum;
        this.useMedicament = useMedicament;
        this.dateStartMedicament = dateStartMedicament;
        this.dateEndMedicament = dateEndMedicament;
        this.medicamentStatus = medicamentStatus;
    }

    public Medicament(int medicamentId, String nameMedicament, MedicamentEnum medicamentEnum, String useMedicament, Date dateStartMedicament, Date dateEndMedicament, MedicamentStatus medicamentStatus) {
        this(nameMedicament, medicamentEnum, useMedicament, dateStartMedicament, dateEndMedicament, medicamentStatus);
        this.medicamentId = medicamentId;
    }

    public int getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(int medicamentId) {
        this.medicamentId = medicamentId;
    }

    public String getNameMedicament() {
        return nameMedicament;
    }

    public void setNameMedicament(String nameMedicament) {
        this.nameMedicament = nameMedicament;
    }

    public MedicamentEnum getMedicamentEnum() {
        return medicamentEnum;
    }

    public void setMedicamentEnum(MedicamentEnum medicamentEnum) {
        this.medicamentEnum = medicamentEnum;
    }

    public String getUseMedicament() {
        return useMedicament;
    }

    public void setUseMedicament(String useMedicament) {
        this.useMedicament = useMedicament;
    }

    public Date getDateStartMedicament() {
        return dateStartMedicament;
    }

    public void setDateStartMedicament(Date dateStartMedicament) {
        this.dateStartMedicament = dateStartMedicament;
    }

    public Date getDateEndMedicament() {
        return dateEndMedicament;
    }

    public void setDateEndMedicament(Date dateEndMedicament) {
        this.dateEndMedicament = dateEndMedicament;
    }

    public MedicamentStatus getMedicamentStatus() {
        return medicamentStatus;
    }

    public void setMedicamentStatus(MedicamentStatus medicamentStatus) {
        this.medicamentStatus = medicamentStatus;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "medicamentId=" + medicamentId +
                ", nameMedicament='" + nameMedicament + '\'' +
                ", medicamentEnum=" + medicamentEnum +
                ", useMedicament='" + useMedicament + '\'' +
                ", dateStartMedicament=" + dateStartMedicament +
                ", dateEndMedicament=" + dateEndMedicament +
                ", medicamentStatus=" + medicamentStatus +
                '}';
    }
}
