package com.eprescription.aarogya.service;

import java.util.List;

import com.eprescription.aarogya.domain.PrescriptionDrugRel;
import com.eprescription.aarogya.web.model.PrescriptionDrugRelWebModel;

/**
 * This service is used to get the details about the prescription
 * @author Chinnu
 *
 */
public interface PrescriptionService {
	
	/**
	 * This method is used to get the delivered drugs in the prescription 
	 * @param upnNumber
	 * @return
	 */
	public List<PrescriptionDrugRelWebModel> getDrugsInPrescription(String upnNumber);
	
	
	/**
	 * This function is used to display the patient prescriptions
	 * @param patientId
	 * @return
	 * @throws java.lang.Exception
	 */
	public List<PrescriptionDrugRel> getPatientPrescriptions(Integer patientId) throws java.lang.Exception;
	
	/**
	 * This function is used to display the doctors prescriptions
	 * @param patientId
	 * @return
	 * @throws java.lang.Exception
	 */
	public List<PrescriptionDrugRel> getDoctorPrescriptions(Integer doctorId) throws java.lang.Exception;
	
	
	public void updatePresDrugDetails(String presDrugIdList, String upnNumber,
			   String auid);
	
}
