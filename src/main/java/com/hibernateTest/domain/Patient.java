package com.hibernateTest.domain;

/**
 * Created with IntelliJ IDEA.
 * User: suay
 * Date: 8/30/13
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Patient {

    private long id;
    private String name;
    private Doctor doctor;

    public Patient() {
    }

    public Patient(String name) {
        this.name = name;
    }

    public Patient(String name, Doctor doctor) {
        this.name = name;
        this.doctor = doctor;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
