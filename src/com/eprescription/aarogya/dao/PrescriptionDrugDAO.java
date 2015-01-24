package com.eprescription.aarogya.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.eprescription.aarogya.domain.Prescription;
import com.eprescription.aarogya.domain.PrescriptionDrugRel;
import com.eprescription.aarogya.web.model.PrescriptionDrugRelWebModel;

/**
 * This class is to perform operations on the prescription- drug relation table
 * @author Chinnu
 *
 */
public interface PrescriptionDrugDAO {
	
	/**
	 * This function obtains the list of drugs in the prescription.
	 * @return
	 */
	public List<PrescriptionDrugRelWebModel> getPrescriptionDetails(String upnNumber);
	
	public List<PrescriptionDrugRel> getPrescriptionDetailsByPatient(Integer patientId) throws DataAccessException;
	
	public List<PrescriptionDrugRel> getPrescriptionDetailsByDoctor(Integer doctorId) throws DataAccessException;
	
	public List<PrescriptionDrugRelWebModel> getPrescriptionDetailsByUPNandAUID(String upnNumber,String auid);
	
	public int getNoOfPresprectionsCount();
	
	public Prescription savePrescriptionDetails(Prescription prescription);
	
	public PrescriptionDrugRel savePrescriptionDrugDetails(PrescriptionDrugRel prescription);
	
	public int getNoOfPresprectionsDrugCount();
	
	public PrescriptionDrugRel getPrescriptionDrugDetailsById(String presDrugId);
	
	public Prescription getPrescriptionDetailsByUpn(String upnNumber);
}
