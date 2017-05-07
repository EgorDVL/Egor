package db.dao;

import bean.Nurse;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface NurseDAO {
    int createNurse(Nurse nurse);

    Nurse getNurseById(int nurseId);

    Nurse getNurseByUserId(int userId);

    List<Nurse> getAllNurses();

    List<Nurse> getAllNurseByDepartment(int departmentId);

    boolean updateNurse(int nurseId, String name, String surname, String phone, String specialty, int experience);

    boolean updateNurseTransfer(Nurse nurse);

    boolean deleteNurseById(int nurseId);

}
