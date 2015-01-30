package com.eprescription.aarogya.web.model;


public class PatientDocPresDrugRel {
	
	private Integer presDrugRelId;
	private String presDrugRelUpn;
	private Integer presDrugRelDrugId;
	private String presDrugRelDosage;
	private String presDrugRelFrequency;
	private Integer presDrugRelUpdatedby;
	private String presDrugRelStatus;
	private String doctorName;
	private String patientName;
	
	
	
	public String getPresDrugRelStatus() {
		return presDrugRelStatus;
	}
	public void setPresDrugRelStatus(String presDrugRelStatus) {
		this.presDrugRelStatus = presDrugRelStatus;
	}
	public Integer getPresDrugRelId() {
		return presDrugRelId;
	}
	public void setPresDrugRelId(Integer presDrugRelId) {
		this.presDrugRelId = presDrugRelId;
	}
	public String getPresDrugRelUpn() {
		return presDrugRelUpn;
	}
	public void setPresDrugRelUpn(String presDrugRelUpn) {
		this.presDrugRelUpn = presDrugRelUpn;
	}
	public Integer getPresDrugRelDrugId() {
		return presDrugRelDrugId;
	}
	public void setPresDrugRelDrugId(Integer presDrugRelDrugId) {
		this.presDrugRelDrugId = presDrugRelDrugId;
	}
	public String getPresDrugRelDosage() {
		return presDrugRelDosage;
	}
	public void setPresDrugRelDosage(String presDrugRelDosage) {
		this.presDrugRelDosage = presDrugRelDosage;
	}
	public String getPresDrugRelFrequency() {
		return presDrugRelFrequency;
	}
	public void setPresDrugRelFrequency(String presDrugRelFrequency) {
		this.presDrugRelFrequency = presDrugRelFrequency;
	}
	public Integer getPresDrugRelUpdatedby() {
		return presDrugRelUpdatedby;
	}
	public void setPresDrugRelUpdatedby(Integer presDrugRelUpdatedby) {
		this.presDrugRelUpdatedby = presDrugRelUpdatedby;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	
	

}
