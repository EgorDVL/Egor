package service;

import bean.Procedures;
import bean.enums.ProcedureStatus;

/**
 * Created by Egor on 22.01.2017.
 */
public interface ProceduresService {

    void cancelExecuteProcedures();

    boolean executeProcedures(int proceduresId);

    boolean updateProcedures(Procedures procedures);

    int createProcedures(Procedures procedures);

    Procedures getProceduresById(int proceduresId);
}
