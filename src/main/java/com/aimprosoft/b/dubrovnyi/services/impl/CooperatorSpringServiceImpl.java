package com.aimprosoft.b.dubrovnyi.services.impl;

import com.aimprosoft.b.dubrovnyi.daos.spring.CooperatorJpaDao;
import com.aimprosoft.b.dubrovnyi.db.beans.Cooperator;
import com.aimprosoft.b.dubrovnyi.services.CooperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cooperatorSpringService")
public class CooperatorSpringServiceImpl implements CooperatorService {

    @Autowired
    private CooperatorJpaDao cooperatorJpa;

    @Override
    @Transactional(readOnly = true)
    public List<Cooperator> getCooperators(String departmentName) {
        return cooperatorJpa
                .getCooperatorsByDepartmentName(departmentName);
    }

    @Override
    @Transactional(readOnly = true)
    public Cooperator getCooperator(String email) {
        return cooperatorJpa.getCooperatorByEmail(email);
    }

    @Override
    @Transactional
    public boolean createCooperator(Cooperator newCooperator) {
        return cooperatorJpa.saveAndFlush(newCooperator) != null;
    }

    @Override
    @Transactional
    public boolean deleteCooperator(String cooperatorEmail) {
        return deleteCooperatorByEmail(cooperatorEmail);
    }

    @Override
    @Transactional
    public boolean editCooperator(String cooperatorEmail,
                                  Cooperator newCooperatorData) {
        return updateCooperator(cooperatorEmail, newCooperatorData);
    }

    private boolean deleteCooperatorByEmail(String email) {
        Cooperator cooperatorForDeleting = cooperatorJpa
                .getCooperatorByEmail(email);

        if (cooperatorForDeleting == null) {
            return false;
        }

        cooperatorJpa.delete(cooperatorForDeleting);
        return true;
    }

    private boolean updateCooperator(String cooperatorEmail,
                                     Cooperator newCooperatorData) {
        Cooperator currentCooperator = cooperatorJpa
                .getCooperatorByEmail(cooperatorEmail);

        if (currentCooperator == null) {
            return false;
        }

        // set Id and Department fields for new Entity
        newCooperatorData.setId(currentCooperator.getId());
        newCooperatorData.setDepartment(currentCooperator.getDepartment());

        return cooperatorJpa.saveAndFlush(newCooperatorData) != null;
    }
}
