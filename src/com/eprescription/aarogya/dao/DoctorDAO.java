package com.eprescription.aarogya.dao;


import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.eprescription.aarogya.domain.Doctor;
import com.eprescription.aarogya.domain.Drug;
import com.eprescription.aarogya.domain.Patient;
import com.eprescription.aarogya.domain.PharmacyStaff;

/**
 * This class is used to perform the doctor operations
 * @author Chinnu
 *
 */
public interface DoctorDAO  {

	/**
	 * This method is used to get the doctors list
	 * @return
	 * @throws DataAccessException
	 */
	public Set<Doctor> findAllDoctors() throws DataAccessException;
	
	/**
	 * This method is used to save or update the doctor details 
	 * @param doctor
	 * @return
	 */
	public Doctor save(Doctor doctor);

	
	/**
	 * This method is used to get the doctor details depending on the doctor id 
	 * @param id
	 * @param startResult
	 * @param maxRows
	 * @return
	 * @throws DataAccessException
	 */
	public Doctor findDoctorByPrimaryKey(String id, int startResult, int maxRows) throws DataAccessException;
    /**
     * This method is used to remove a doctor from the database
     * @param doctor
     */
	public void removeDoctor(Doctor doctor);
	
	
	/**
	 * Get the doctor details from doctor login details 
	 * @param au360Id
	 * @param password
	 * @return
	 */
	public Doctor findDoctorByLoginCredentils(String au360Id, String password);
	
	/**
	 * Get the patient details from  login details
	 * @param au360Id
	 * @param password
	 * @return
	 */
	public Patient findPatientByLoginCredentils(String au360Id, String password);
	
	/**
	 * Get the Chemist details from  login details
	 * @param au360Id
	 * @param password
	 * @return
	 */
	public PharmacyStaff findChemistByLoginCredentils(String au360Id, String password);
	
	/**
	 * 
	 * @return
	 */
	public List<Drug> getMedicineList();
}