package com.eprescription.aarogya.web.model;

import java.util.ArrayList;
import java.util.List;

import com.eprescription.aarogya.domain.PrescriptionDrugRel;

public class PrescriptionDrugs {
	
	public List<PrescriptionDrugRel> prescriptionDrugRel = new ArrayList<PrescriptionDrugRel>();

	public List<PrescriptionDrugRel> getPrescriptionDrugRel() {
		return prescriptionDrugRel;
	}

	public void setPrescriptionDrugRel(List<PrescriptionDrugRel> prescriptionDrugRel) {
		this.prescriptionDrugRel = prescriptionDrugRel;
	}

	
	

}
