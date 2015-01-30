package com.eprescription.aarogya.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eprescription.aarogya.domain.Patient;

@Scope("singleton")
@Repository("patientDAO")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class PatientDAOImpl implements PatientDAO {

	private static transient Logger logger = LoggerFactory.getLogger(PatientDAOImpl.class);
	
	@Autowired
	private SessionFactory hibernate4AnnotatedSessionFactory;
	
	public PatientDAOImpl() {
		super();
	}
	
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Patient findPatientDetailsByAurogyaId(String au360Id) {
		logger.info("entering into findPatientDetailsByAurogyaId()");
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("FindPatientByAa360id");
		query.setString("au360Id",au360Id);
		Patient patient = (Patient) query.uniqueResult();
		logger.info("Exitting from findPatientDetailsByAurogyaId()");
		return patient;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, String> getPatientDetails() {
		Map<Integer, String> patientMap = new HashMap<Integer, String>();
		String hql = "from Patient";
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Patient> patientList = query.list();
		for (Patient patient : patientList){
			patientMap.put(patient.getPatientId(), patient.getPatientName());
		}
		return patientMap;
	} 
}
