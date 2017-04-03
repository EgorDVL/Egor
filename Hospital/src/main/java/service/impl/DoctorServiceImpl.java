package service.impl;

import bean.Doctor;
import db.dao.DoctorDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import service.AttendingDoctorService;
import service.DoctorService;

import java.util.*;

/**
 * Created by Egor on 08.01.2017.
 */
public class DoctorServiceImpl implements DoctorService {
    private static final Logger LOG = Logger.getLogger(DoctorServiceImpl.class);

    private DoctorDAO doctorDAO;

    public DoctorServiceImpl(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }


    public List<Doctor> getAllDoctorsByDepartmentId(int departmentId) {
        try {
            return doctorDAO.getAllDoctorsByDepartment(departmentId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get all doctors by department id", e);
            throw new ServiceException("Can't get all doctors by department id");
        }
    }

    public int createDoctor(Doctor doctor) {
        try {
            return doctorDAO.createDoctor(doctor);
        } catch (PersistException e) {
            LOG.error("Can't create doctor", e);
            throw new ServiceException("Can't create doctor");
        }
    }

    public Doctor getDoctorById(int doctorId) {
        try {
            return doctorDAO.getDoctorById(doctorId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get doctor by Id", e);
            throw new ServiceException("Can't get Doctor by Id");
        }
    }

    public Doctor getDoctorByUserId(int userId) {
        try {
            return doctorDAO.getDoctorByUserId(userId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get doctor by userId", e);
            throw new ServiceException("Can't doctor by User Id");
        }
    }

    public List<Doctor> getAllDoctors() {
        try {
            return doctorDAO.getAllDoctors();
        } catch (ObtainObjectException e) {
            LOG.error("Can't get all doctors", e);
            throw new ServiceException("Can't get all doctors");
        }
    }

    @Override
    public boolean deleteDoctorById(int doctorId) {
        try {
            return doctorDAO.deleteDoctor(doctorId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't delete doctor by id", e);
            throw new ServiceException("Can't delete doctor by id", e);
        }
    }

    @Override
    public boolean updateDoctor(int doctorId, String name, String surname, String phone, String specialty, int experience) {
        try {
            return doctorDAO.updateDoctor(doctorId, name, surname, phone, specialty, experience);
        } catch (ObtainObjectException e) {
            LOG.error("Can't update doctor", e);
            throw new ServiceException("Can't update doctor", e);
        }
    }

    @Override
    public boolean updateDoctorTransfer(Doctor doctor) {
        try {
            return doctorDAO.updateDoctorTransfer(doctor);
        } catch (ObtainObjectException e) {
            LOG.error("Can't update doctor transfer", e);
            throw new ServiceException("Can't update doctor transfer", e);
        }
    }

//    @Override
//    public Map<Doctor, Integer> getAllDoctorsAndPatientCount() {
//        try {
//            Map<Doctor, Integer> doctorMap = new HashedMap();
//            for (Doctor doctor : doctorDAO.getAllDoctors()) {
//                List<Integer> count = attendingDoctorService.getAllPatientIdByDoctorId(doctor.getDoctorId());
//                doctorMap.put(doctor, count.size());
//            }
//            System.out.println(doctorMap + " doctorMap");
//            System.out.println(sortByValue(doctorMap) + " sort map");
//
//            return sortByValue(doctorMap);
//        } catch (ObtainObjectException e) {
//            LOG.error("Can't get all doctors", e);
//            throw new ServiceException("Can't get all doctors");
//        }
//    }
//
//    public static <Doctor, Integer extends Comparable<? super Integer>> Map<Doctor, Integer>
//    sortByValue(Map<Doctor, Integer> map) {
//
//        List<Map.Entry<Doctor, Integer>> list = new LinkedList<Map.Entry<Doctor, Integer>>();
//        Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));
//
//        Map<Doctor, Integer> sortedMap = new LinkedHashMap<>();
//
//        for (Map.Entry<Doctor, Integer> entry : list) {
//            sortedMap.put(entry.getKey(), entry.getValue());
//        }
//        return sortedMap;
//    }
}