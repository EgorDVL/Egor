package db.dao;

import bean.Healing;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface HealingDAO {
    int createHealing(Healing healing);

    Healing getHealingById(int healingId);

    Healing getHealingByHospitalCard(int hospitalCard);

    Healing getHealingByAppointmentId(int appointmentId);

    List<Healing> getAllHealings();

    List<Healing> getAllHealingsByHospitalCard(int hospitalCard);

    boolean updateHealing(Healing healing);

    boolean deletehealingById(int healingId);

    Healing getlastHealingPatient(int hospitalCardId);
}
