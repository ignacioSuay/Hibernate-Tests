package com.hibernateTest.dao;

import com.hibernateTest.domain.Doctor;
import com.hibernateTest.domain.Patient;
import com.hibernateTest.domain.Specialty;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: suay
 * Date: 8/30/13
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class MedicalDao implements IMedicalDao {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    public void savePatients(List<Patient> patients){
        Session session	= sessionFactory.openSession();
        session.getTransaction().begin();
        for(Patient patient: patients){
            session.saveOrUpdate(patient.getDoctor().getSpecialty());
            session.saveOrUpdate(patient.getDoctor());
            session.saveOrUpdate(patient);
        }
        session.getTransaction().commit();
    }


    public Specialty getSpecialtyByName(String name) {
        Session session	=sessionFactory.openSession();

        Query query = session.createQuery("From Specialty where name =:nameSpec");
        query.setParameter("nameSpec", name);

        Specialty specialty = (Specialty) query.uniqueResult();

        session.close();
        return specialty;
    }

    public Specialty getSpecialtyByNameOpenSession(String name) {
        Session session	=sessionFactory.openSession();

        Query query = session.createQuery("From Specialty where name =:nameSpec");
        query.setParameter("nameSpec", name);

        Specialty specialty = (Specialty) query.uniqueResult();

        //session.close();
        return specialty;
    }

    public Specialty getSpecialtyByNameEagerlyFetched(String name) {
        Session session	=sessionFactory.openSession();

        Query query = session.createQuery("From Specialty s " +
                "left join fetch s.doctorList d " +
                "left join fetch d.patientList " +
                "where name =:nameSpec");

        query.setParameter("nameSpec", name);

        Specialty specialty = (Specialty) query.uniqueResult();
        session.close();
        return specialty;
    }


}
