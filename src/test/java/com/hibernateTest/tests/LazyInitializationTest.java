package com.hibernateTest.tests;

import com.hibernateTest.dao.IMedicalDao;
import com.hibernateTest.domain.Doctor;
import com.hibernateTest.domain.Patient;
import com.hibernateTest.domain.Specialty;
import org.hibernate.LazyInitializationException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: suay
 * Date: 9/2/13
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class LazyInitializationTest {

    private static IMedicalDao service;

    @BeforeClass
    public static void init(){

        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");

        Specialty specialty = new Specialty("Specialty");
        List<Specialty> specialties = new ArrayList<Specialty>();
        specialties.add(specialty);

        Doctor doctorA = new Doctor ("Doctor A", specialty);

        Patient patientA = new Patient("Patient A", doctorA);
        Patient patientB = new Patient("Patient B", doctorA);

        List<Patient> patients = new ArrayList<Patient>();
        patients.add(patientA);
        patients.add(patientB);

        service = (IMedicalDao) ctx.getBean("medicalDao");

        service.savePatients(patients);

    }

    @Test(expected = LazyInitializationException.class)
    public void getLazyInitializationException(){

        Specialty specialty = service.getSpecialtyByName("Specialty");

        System.out.println("Specialty ID: " + specialty.getId() + " Name: " + specialty.getName());

        //This call will throw a Lazy Initialization Exception
        Doctor d = specialty.getDoctorList().iterator().next();
    }

    @Test
    public void testOpenSession(){

        Specialty specialty = service.getSpecialtyByNameOpenSession("Specialty");

        System.out.println("Specialty ID: " + specialty.getId() + " Name: " + specialty.getName());

        Doctor doctor = specialty.getDoctorList().iterator().next();

        System.out.println("Doctor ID: " + doctor.getId() + " Name: " + doctor.getName());

        Patient patient = doctor.getPatientList().iterator().next();

        System.out.println("Patient ID: " + patient.getId() + " Name: " + patient.getName());
    }


    @Test
    public void testEagerlyFetched(){

        Specialty specialty = service.getSpecialtyByNameEagerlyFetched("Specialty");

        System.out.println("Specialty ID: " + specialty.getId() + " Name: " + specialty.getName());

        Doctor doctor = specialty.getDoctorList().iterator().next();

        System.out.println("Doctor ID: " + doctor.getId() + " Name: " + doctor.getName());

        Patient patient = doctor.getPatientList().iterator().next();

        System.out.println("Patient ID: " + patient.getId() + " Name: " + patient.getName());
    }






}
