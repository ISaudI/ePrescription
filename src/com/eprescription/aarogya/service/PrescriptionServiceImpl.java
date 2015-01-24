package com.eprescription.aarogya.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eprescription.aarogya.dao.PatientDAO;
import com.eprescription.aarogya.dao.PrescriptionDrugDAO;
import com.eprescription.aarogya.domain.Prescription;
import com.eprescription.aarogya.domain.PrescriptionDrugRel;
import com.eprescription.aarogya.web.model.PrescriptionDrugRelWebModel;

@Scope("singleton")
@Service("prescriptionService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class PrescriptionServiceImpl implements PrescriptionService {
	
private transient Logger logger = LoggerFactory.getLogger(getClass());

	
	@Resource(name = "prescriptionDrugDAO")
	protected PrescriptionDrugDAO prescriptionDrugDAO;

	@Resource(name = "patientDAO")
	protected PatientDAO patientDAO;

	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public List<PrescriptionDrugRelWebModel> getDrugsInPrescription(String upnNumber) {
		logger.info("Entering into the service method getDrugsInPrescription()");
		List<PrescriptionDrugRelWebModel> drugList = prescriptionDrugDAO.getPrescriptionDetails(upnNumber);
		logger.info("Exiting from the service method getDrugsInPrescription()");
		System.out.println("Exiting from the service method getDrugsInPrescription()");
		return drugList;
	}
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public List<PrescriptionDrugRel> getPatientPrescriptions(Integer patientId) throws java.lang.Exception {
		List<PrescriptionDrugRel> prescriptiondrugrels = null;
		List<PrescriptionDrugRel> queryResult;
		queryResult = prescriptionDrugDAO.getPrescriptionDetailsByPatient(patientId);
		prescriptiondrugrels = queryResult;
		return prescriptiondrugrels;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public List<PrescriptionDrugRel> getDoctorPrescriptions(Integer doctorId) throws Exception {
		List<PrescriptionDrugRel> prescriptiondrugrels = null;
		List<PrescriptionDrugRel> queryResult = prescriptionDrugDAO.getPrescriptionDetailsByDoctor(doctorId);
		System.out.println("The size of it is  "+queryResult.size());
		prescriptiondrugrels = queryResult;
		return prescriptiondrugrels;
	}
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public void updatePresDrugDetails(String presDrugIdList, String upnNumber,
									   String auid){
		
		String[] presDrugIdValues = presDrugIdList.split(",");
		for (String presDrugId : presDrugIdValues){
			PrescriptionDrugRel presDrugRel = prescriptionDrugDAO.
											getPrescriptionDrugDetailsById(presDrugId);
			presDrugRel.setPresDrugRelStatus("Delivered");
			prescriptionDrugDAO.savePrescriptionDrugDetails(presDrugRel);
		}
		
		
		try {
			Prescription prescription = prescriptionDrugDAO.getPrescriptionDetailsByUpn(upnNumber);
			List<PrescriptionDrugRelWebModel> presDrugDetails =  prescriptionDrugDAO.
					getPrescriptionDetailsByUPNandAUID(upnNumber, auid);
			int i=0;
			for (PrescriptionDrugRelWebModel drugRelWebModel : presDrugDetails){
				if ("To Deliver".equalsIgnoreCase(drugRelWebModel.getStatus())){
					i++;
					}
				}
			 if (i > 0){
				 //make it to partially delivered
				 prescription.setStatus("Partially Delivered");
			 }else{
				 prescription.setStatus("Delivered");
			 }
			 prescriptionDrugDAO.savePrescriptionDetails(prescription);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
}
