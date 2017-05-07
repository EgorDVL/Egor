package service;

import bean.Medicament;
import bean.enums.MedicamentStatus;

/**
 * Created by Egor on 22.01.2017.
 */
public interface MedicamentService {

    void cancelExecuteMedicament();

    boolean executeMedicament(int medicamentId);
    
    boolean updateMedicament(Medicament medicament);

    int createMedicament(Medicament medicament);

    Medicament getMedicamentById(int medicamentId);
}
