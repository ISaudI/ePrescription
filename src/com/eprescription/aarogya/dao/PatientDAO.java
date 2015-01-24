package com.eprescription.aarogya.dao;

import com.eprescription.aarogya.domain.Patient;

public interface PatientDAO {
	
	public Patient findPatientDetailsByAurogyaId(String au360Id);

}
