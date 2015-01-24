package com.eprescription.aarogya.service;


import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eprescription.aarogya.dao.DoctorDAO;
import com.eprescription.aarogya.dao.PrescriptionDrugDAO;
import com.eprescription.aarogya.domain.Doctor;
import com.eprescription.aarogya.domain.Patient;
import com.eprescription.aarogya.domain.Prescription;
import com.eprescription.aarogya.domain.PrescriptionDrugRel;

/**
 * 
 * @author Chinnu
 *
 */
@Scope("singleton")
@Service("doctorService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class DoctorServiceImpl implements DoctorService {

	
	private transient Logger logger = LoggerFactory.getLogger(getClass());

	
	@Resource(name = "doctorDAO")
	protected DoctorDAO doctorDAO;
	
	@Resource(name = "prescriptionDrugDAO")
	protected PrescriptionDrugDAO prescriptionDrugDAO;
	
	
	public DoctorServiceImpl() {
	}

	

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public void deleteDoctor(Doctor doctor) throws java.lang.Exception {
		doctorDAO.removeDoctor(doctor);
	}


	/**
	 * The variables maxresults are used for pagination.
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Set<Doctor> loadDoctors() throws java.lang.Exception {
		Set<Doctor> doctors = null;
		//int maxResults;
		Set<Doctor> queryResult;
		//int startResult;
		queryResult = null;
		//startResult = -1;
		//maxResults = -1;
		queryResult = doctorDAO.findAllDoctors();
		doctors = queryResult;
		return doctors;
	}


	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public void saveDoctor(Doctor doctor) throws java.lang.Exception {
		doctor = doctorDAO.save(doctor);
	}

	public Logger getLogger() {
		return logger;
	}
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public void savePrescription(Doctor doctor, List<PrescriptionDrugRel> prescriptionList, Patient patient){
		int noOfPres =   prescriptionDrugDAO.getNoOfPresprectionsCount();
		noOfPres = noOfPres + 1;
		String upnNo = "UPN"+noOfPres;
		Prescription prescription = new Prescription();
		prescription.setPatientId(patient.getPatientId());
		prescription.setDoctorId(doctor.getDoctorId());
		prescription.setStatus("To Deliver");
		prescription.setUpn(upnNo);
		int noOfMedicines = prescriptionDrugDAO.getNoOfPresprectionsDrugCount();
		prescriptionDrugDAO.savePrescriptionDetails(prescription);
		int i=1;
		for(PrescriptionDrugRel drugRel : prescriptionList){
			drugRel.setPresDrugRelUpn(upnNo);
			drugRel.setPresDrugRelId(noOfMedicines+i);
			prescriptionDrugDAO.savePrescriptionDrugDetails(drugRel);
			i++;
		}
	}

	
}
