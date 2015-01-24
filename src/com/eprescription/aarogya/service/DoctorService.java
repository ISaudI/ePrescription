package com.eprescription.aarogya.service;


import java.util.List;
import java.util.Set;

import com.eprescription.aarogya.domain.Doctor;
import com.eprescription.aarogya.domain.Patient;
import com.eprescription.aarogya.domain.PrescriptionDrugRel;

/**
 * This is the service layer for performing CURD operations of Doctor details
 * @author Chinnu
 *
 */
public interface DoctorService {

	/**
	 * This is used to delete the doctor details
	 * @param doctor
	 * @throws java.lang.Exception
	 */
	public void deleteDoctor(Doctor doctor) throws java.lang.Exception;

	/**
	 * This function is used to get the list of doctors
	 * @return
	 * @throws java.lang.Exception
	 */
	public Set<Doctor> loadDoctors() throws java.lang.Exception;

	/**
	 * This service is used to save or update the doctor details
	 * @param doctor
	 * @throws java.lang.Exception
	 */
	public void saveDoctor(Doctor doctor) throws java.lang.Exception;
	
	public void savePrescription(Doctor doctor, List<PrescriptionDrugRel> prescriptionList  , Patient patient);
}