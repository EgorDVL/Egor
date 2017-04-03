package service;

import bean.Healing;

import java.util.List;

/**
 * Created by Egor on 22.01.2017.
 */
public interface HealingService {

    boolean updateHealing(Healing healing);

    int createHealing(Healing healing);

    Healing getHealingById(int healingId);

    Healing getHealingByAppointmentId(int appointmentId);

    List<Healing> getAllHealingByHospitalCard(int hospitalCard);

    boolean deleteHealingById(int healingId);

    Healing getLastPatientHealing(int hospitalCardId);
}
