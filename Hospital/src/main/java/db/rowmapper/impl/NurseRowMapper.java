package db.rowmapper.impl;

import bean.Nurse;
import bean.enums.DepartmentEnum;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class NurseRowMapper implements RowMapper<Nurse> {
    @Override
    public Nurse extract(ResultSet set) throws SQLException {
        Nurse nurse = new Nurse();
        nurse.setNurseId(set.getInt(1));
        nurse.setName(set.getString(2));
        nurse.setSurname(set.getString(3));
        nurse.setPhone(set.getString(4));
        nurse.setSpecialty(set.getString(5));
        nurse.setDateOfBirth(set.getDate(6));
        nurse.setExperience(set.getInt(7));
        nurse.setPhoto(set.getString(8));
        nurse.setDepartment(DepartmentEnum.fromValue(set.getInt(9)));
        nurse.setUserId(set.getInt(10));
        return nurse;
    }
}
