package db.dao;

import bean.Procedures;
import bean.enums.ProcedureStatus;

import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface ProceduresDAO {
    int createProcedures(Procedures procedures);

    Procedures getProceduresById(int proceduresId);

    List<Procedures> getAllProcedures();

    List<Procedures> getAllProceduresByStatus(ProcedureStatus procedureStatus);

    boolean updateProcedures(Procedures procedures);

    boolean updateProcedureStatus(ProcedureStatus procedureStatus, int procedureId);
}
