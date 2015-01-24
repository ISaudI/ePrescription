package com.eprescription.aarogya.dao;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eprescription.aarogya.domain.Doctor;
import com.eprescription.aarogya.domain.Drug;
import com.eprescription.aarogya.domain.Patient;
import com.eprescription.aarogya.domain.PharmacyStaff;

/**
 * This is Implementation of DoctorDAO Class
 * @author Chinnu
 *
 */
@Scope("singleton")
@Repository("doctorDAO")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class DoctorDAOImpl implements DoctorDAO {

	
	private static transient Logger logger = LoggerFactory.getLogger(DoctorDAOImpl.class);
	
	@Autowired
	private SessionFactory hibernate4AnnotatedSessionFactory;
	
	public DoctorDAOImpl() {
		super();
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Set<Doctor> findAllDoctors() throws DataAccessException {
		logger.info("Entering into findAllDoctors()");
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		org.hibernate.Query query =  session.createQuery("select myDoctor from Doctor myDoctor ");
		logger.info("The query is :"+query.toString());
		@SuppressWarnings("unchecked")
		List<Doctor> doctors = query.list();
		logger.info("No fo doctors :"+doctors.size());
		Set<Doctor> doctorSet = new HashSet<Doctor>(doctors);
		logger.info("Exiting into findAllDoctors()");
		return doctorSet;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Doctor findDoctorByPrimaryKey(String id, int startResult, int maxRows) throws DataAccessException {
		logger.info("Entering into findDoctorByPrimaryKey()");
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		org.hibernate.Query query = session.getNamedQuery("FindDoctorByDoctorId");
		query.setInteger("id", Integer.parseInt(id));
		Doctor doctor = (Doctor) query.uniqueResult();
		logger.info("Exitting from findDoctorByPrimaryKey()");
		return doctor;
	}

		
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Doctor save(Doctor doctor){
		logger.info("Entering into saveOrUpdate()");
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		session.saveOrUpdate(doctor);
		logger.info("Exiting from saveOrUpdate()");
		return doctor;
	}
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public void removeDoctor(Doctor doctor){
		logger.info("Entering into removeDoctor()");
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		session.delete(doctor);
		logger.info("Exiting from removeDoctor()");
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Doctor findDoctorByLoginCredentils(String au360Id, String password) {
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("FindDoctorByLoginDetails");
		query.setString("au360Id",au360Id);
		query.setString("password", password);
		Doctor doctor = (Doctor) query.uniqueResult();
		logger.info("Exitting from FindDoctorByLoginDetails()");
		return doctor;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Patient findPatientByLoginCredentils(String au360Id, String password) {
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("FindPatientLoginCredentials");
		query.setString("au360Id",au360Id);
		query.setString("password", password);
		Patient patient = (Patient) query.uniqueResult();
		logger.info("Exitting from FindPatientLoginCredentials()");
		return patient;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public PharmacyStaff findChemistByLoginCredentils(String au360Id, String password) {
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("FindPharmacyStaffByLoginCresentials");
		query.setString("au360Id",au360Id);
		query.setString("password", password);
		PharmacyStaff pharmacyStaff = (PharmacyStaff) query.uniqueResult();
		logger.info("Exitting from findChemistByLoginCredentils()");
		return pharmacyStaff;
	}
	
	@SuppressWarnings("unchecked")
	public List<Drug> getMedicineList(){
		List<Drug>  result = new ArrayList<Drug>();
		logger.info("Entering into getMedicineList()");
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		org.hibernate.Query query =  session.createQuery("select myDrug from Drug myDrug ");
		logger.info("The query is :"+query.toString());
		result = query.list();
		logger.info("No of drugs  :"+result.size());
		logger.info("Exiting into getMedicineList()");
		return result;
	}

}
