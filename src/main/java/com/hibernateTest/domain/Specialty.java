package com.hibernateTest.domain;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: suay
 * Date: 8/30/13
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Specialty {

    private long id;
    private String name;

    private Set<Doctor> doctorList;

    public Specialty(String name, Set<Doctor> doctors) {
        this.name = name;
        this.doctorList = doctors;
    }

    public Specialty() {
    }

    public Specialty(String name) {
        this.name = name;
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

    public Set<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(Set<Doctor> doctorList) {
        this.doctorList = doctorList;
    }


}
