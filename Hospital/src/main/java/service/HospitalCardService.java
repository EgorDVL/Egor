package service;

import bean.HospitalCard;

/**
 * Created by Egor on 22.01.2017.
 */
public interface HospitalCardService {

    int createHospitalCard(int patientId);

    HospitalCard getHospitalCardByPatientId(int patientId);

    HospitalCard getHospitalCardById(int hospitalCardId);

    boolean deleteHospitalCardById(int hospitalCardId);
}
