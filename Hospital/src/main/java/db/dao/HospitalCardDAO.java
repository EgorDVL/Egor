package db.dao;

import bean.HospitalCard;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface HospitalCardDAO {
    int createHospitalCard(HospitalCard hospitalCard);

    HospitalCard getHospitalCardById(int hospitalCardId);

    HospitalCard getHospitalCardByPatientId(int patientId);

    List<HospitalCard> getAllHospitalCards();

    boolean updateHospitalCard(HospitalCard hospitalCard);

    boolean deleteHospitalCardById(int hospitalCardId);
}
