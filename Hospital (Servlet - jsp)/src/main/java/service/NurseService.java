package service;

import bean.Nurse;

import java.util.List;

/**
 * Created by Egor on 22.01.2017.
 */
public interface NurseService {

    Nurse getNurseByUserId(int userId);


    List<Nurse> getAllNurseByDepartmentId(int departmentId);

    int createNurse(Nurse nurse);

    Nurse getNurseById(int nurseId);

    List<Nurse> getAllNurses();

    boolean deleteNurseById(int nurseId);

    boolean updateNurse(int nurseId, String name, String surname, String phone, String specialty, int experience);

    boolean updateNurseTransfer(Nurse nurse);
}
