package com.hibernateTest.dao;

import com.hibernateTest.domain.Patient;
import com.hibernateTest.domain.Specialty;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: suay
 * Date: 8/30/13
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IMedicalDao {

    void savePatients(List<Patient> patients);

    Specialty getSpecialtyByName(String name);

    Specialty getSpecialtyByNameOpenSession(String name);

    Specialty getSpecialtyByNameEagerlyFetched(String name);
}
