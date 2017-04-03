package db.dao.impl;

import bean.Procedures;
import bean.enums.ProcedureStatus;
import db.dao.ProceduresDAO;
import db.rowmapper.impl.ProceduresRowMapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class ProceduresDAOimpl implements ProceduresDAO {
    private static final String CREATE_PROCEDURES = "insert into procedures values(default, ?, ?, ?, ?, ?)";
    private static final String GET_PROCEDURES_BY_ID = "select * from procedures where proceduresId = ?";
    private static final String GET_ALL_PROCEDURES = "select * from procedures";
    private static final String GET_ALL_PROCEDURES_BY_STATUS = "select * from procedures where status = ?";
    private static final String UPDATE_PROCEDURES = "update procedures set name = ?, `use` = ?, date_start = ?, date_end = ?, status = ? where proceduresId = ?";
    private static final String UPDATE_PROCEDURE_STATUS = "update procedures set status = ? where proceduresId = ?";

    private JdbcTemplate<Procedures> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createProcedures(Procedures procedures) {
        return jdbcTemplate.create(CREATE_PROCEDURES, procedures.getNameProcedure(),
                procedures.getUseProcedure(),
                new Date(procedures.getDateStartProcedure().getTime()),
                new Date(procedures.getDateEndProcedure().getTime()),
                procedures.getProcedureStatus().toString());
    }

    @Override
    public Procedures getProceduresById(int proceduresId) {
        return jdbcTemplate.get(GET_PROCEDURES_BY_ID, new ProceduresRowMapper(), proceduresId);
    }

    @Override
    public List<Procedures> getAllProcedures() {
        return jdbcTemplate.getAll(GET_ALL_PROCEDURES, new ProceduresRowMapper());
    }

    @Override
    public List<Procedures> getAllProceduresByStatus(ProcedureStatus procedureStatus) {
        return jdbcTemplate.getAll(GET_ALL_PROCEDURES_BY_STATUS, new ProceduresRowMapper(), procedureStatus.toString());
    }

    @Override
    public boolean updateProcedures(Procedures procedures) {
        return jdbcTemplate.update(UPDATE_PROCEDURES, procedures.getNameProcedure(),
                procedures.getUseProcedure(),
                new Date(procedures.getDateStartProcedure().getTime()),
                new Date(procedures.getDateEndProcedure().getTime()),
                procedures.getProcedureStatus().toString(),
                procedures.getProceduresId());
    }

    @Override
    public boolean updateProcedureStatus(ProcedureStatus procedureStatus, int procedureId) {
        return jdbcTemplate.update(UPDATE_PROCEDURE_STATUS, procedureStatus.toString(), procedureId);
    }
}
