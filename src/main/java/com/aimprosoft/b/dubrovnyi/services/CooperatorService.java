package com.aimprosoft.b.dubrovnyi.services;

import com.aimprosoft.b.dubrovnyi.db.beans.Cooperator;

import java.util.List;

public interface CooperatorService {

    public List<Cooperator> getCooperators(String departmentName);

    public Cooperator getCooperator(String email);

    public boolean createCooperator(Cooperator newCooperator);

    public boolean deleteCooperator(String cooperatorEmail);

    public boolean editCooperator(String cooperatorEmail, Cooperator newCooperatorData);
}
