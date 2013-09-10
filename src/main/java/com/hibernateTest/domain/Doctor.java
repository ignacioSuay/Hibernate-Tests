package com.hibernateTest.domain;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: suay
 * Date: 8/30/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Doctor {

    private long id;
    private String name;
    private Set<Patient> patientList;

    private Specialty specialty;

    public Doctor(String name, Set<Patient> patientList) {
        this.name = name;
        this.patientList = patientList;
    }

    public Doctor() {
    }


    public Doctor(String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(Set<Patient> patientList) {
        this.patientList = patientList;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
