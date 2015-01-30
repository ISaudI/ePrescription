package com.eprescription.aarogya.dao;

import java.util.Map;

import com.eprescription.aarogya.domain.Patient;

public interface PatientDAO {
	
	public Patient findPatientDetailsByAurogyaId(String au360Id);
	
	public Map<Integer, String> getPatientDetails();

}
