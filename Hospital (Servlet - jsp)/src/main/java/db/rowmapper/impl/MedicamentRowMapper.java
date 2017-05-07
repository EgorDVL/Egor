package db.rowmapper.impl;

import bean.Medicament;
import bean.enums.MedicamentEnum;
import bean.enums.MedicamentStatus;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class MedicamentRowMapper implements RowMapper<Medicament> {
    @Override
    public Medicament extract(ResultSet set) throws SQLException {
        Medicament medicament = new Medicament();
        medicament.setMedicamentId(set.getInt(1));
        medicament.setNameMedicament(set.getString(2));
        medicament.setMedicamentEnum(MedicamentEnum.getValue(set.getString(3)));
        medicament.setUseMedicament(set.getString(4));
        medicament.setDateStartMedicament(set.getDate(5));
        medicament.setDateEndMedicament(set.getDate(6));
        medicament.setMedicamentStatus(MedicamentStatus.getValue(set.getString(7)));
        return medicament;
    }
}
