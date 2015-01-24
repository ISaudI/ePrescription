package com.eprescription.aarogya.web.model;

public class PrescriptionDrugRelWebModel {
	
	
	private int presDrugRelId;
	private String upn;
	private String drugName;
	private String dosage;
	private String frequency;
	private String status;
	private int lastUpdatedUser;
	public int getPresDrugRelId() {
		return presDrugRelId;
	}
	public void setPresDrugRelId(int presDrugRelId) {
		this.presDrugRelId = presDrugRelId;
	}
	public String getUpn() {
		return upn;
	}
	public void setUpn(String upn) {
		this.upn = upn;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLastUpdatedUser() {
		return lastUpdatedUser;
	}
	public void setLastUpdatedUser(int lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}
	
	
	

}
