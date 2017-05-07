package db.dao;

import bean.Medicament;
import bean.enums.MedicamentStatus;
import bean.enums.OperationStatus;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface MedicamentDAO {
    int createMedicament(Medicament medicament);

    Medicament getMedicamentById(int medicamentId);

    List<Medicament> getAllMedicaments();

    List<Medicament> getAllMedicamentByStatus(MedicamentStatus medicamentStatus);

    boolean updateMedicament(Medicament medicament);

    boolean updateMedicamentStatus(MedicamentStatus medicamentStatus, int medicamentId);
}
