package com.eprescription.aarogya.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eprescription.aarogya.dao.PatientDAO;
import com.eprescription.aarogya.domain.Patient;


@Scope("singleton")
@Service("patientService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class PatientServiceImpl implements PatientService {

	
	private transient Logger logger = LoggerFactory.getLogger(getClass());

	
	@Resource(name = "patientDAO")
	protected PatientDAO patientDAO;
	
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Patient getPatientDetailsByArogyaId(String arogyaId) {
		logger.info("Entering into getPatientDetailsByArogyaId()");
		Patient patient = patientDAO.findPatientDetailsByAurogyaId(arogyaId);
		return patient;
	}

}
