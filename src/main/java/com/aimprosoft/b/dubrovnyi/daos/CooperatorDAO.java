package com.aimprosoft.b.dubrovnyi.daos;


import com.aimprosoft.b.dubrovnyi.db.beans.Cooperator;

import java.util.List;


public interface CooperatorDAO {

    public List<Cooperator> getCooperatorsByDepartmentName(String departmentName);

    public Cooperator getCooperatorByEmail(String email);

    public boolean addNewCooperator(Cooperator newCooperator);

    public boolean deleteCooperatorByEmail(String cooperatorEmail);

    public boolean editCooperatorByEmail(String cooperatorEmail, Cooperator newCooperatorData);
}