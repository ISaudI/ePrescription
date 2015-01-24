package com.eprescription.aarogya.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;

/**
 * 
 * @ModelCoreReference [platform:/resource/TestJPA/models/com/eprescription/aarogya/domain/Prescription.datatype]
 * @generated
 */

@IdClass(com.eprescription.aarogya.domain.PrescriptionPK.class)
@Entity
@NamedQueries( {
		@NamedQuery(name = "FindAllPrescriptions", query = "select myPrescription from Prescription myPrescription"),
		@NamedQuery(name = "FindAllPrescriptionsCount", query = "select count(myPrescription.prescriptionId) from Prescription myPrescription"),
		@NamedQuery(name = "FindPrescriptionByStatusContaining", query = "select myPrescription from Prescription myPrescription where myPrescription.status like ?1"),
		@NamedQuery(name = "FindPrescriptionByStatusContainingCount", query = "select count(myPrescription.prescriptionId) from Prescription myPrescription where myPrescription.status like ?1"),
		@NamedQuery(name = "FindPrescriptionByStatus", query = "select myPrescription from Prescription myPrescription where myPrescription.status = ?1"),
		@NamedQuery(name = "FindPrescriptionByStatusCount", query = "select count(myPrescription.prescriptionId) from Prescription myPrescription where myPrescription.status = ?1"),
		@NamedQuery(name = "FindPrescriptionByUpnContaining", query = "select myPrescription from Prescription myPrescription where myPrescription.upn like ?1"),
		@NamedQuery(name = "FindPrescriptionByUpnContainingCount", query = "select count(myPrescription.prescriptionId) from Prescription myPrescription where myPrescription.upn like ?1"),
		@NamedQuery(name = "FindPrescriptionByPrimaryKey", query = "select myPrescription from Prescription myPrescription where myPrescription.prescriptionId = ?1"),
		@NamedQuery(name = "FindPrescriptionByPrimaryKeyCount", query = "select count(myPrescription.prescriptionId) from Prescription myPrescription where myPrescription.prescriptionId = ?1"),
		@NamedQuery(name = "FindPrescriptionByUpn", query = "select myPrescription from Prescription myPrescription where myPrescription.upn = :upn"),
		@NamedQuery(name = "FindPrescriptionByUpnCount", query = "select count(myPrescription.prescriptionId) from Prescription myPrescription where myPrescription.upn = ?1"),
		@NamedQuery(name = "FindPrescriptionByPrescriptionId", query = "select myPrescription from Prescription myPrescription where myPrescription.prescriptionId = ?1"),
		@NamedQuery(name = "FindPrescriptionByPrescriptionIdCount", query = "select count(myPrescription.prescriptionId) from Prescription myPrescription where myPrescription.prescriptionId = ?1"),
		@NamedQuery(name = "FindPrescriptionByPatientId", query = "select myPrescription from Prescription myPrescription where myPrescription.patientId = :id"),
		@NamedQuery(name = "FindPrescriptionByPatientIdCount", query = "select count(myPrescription.prescriptionId) from Prescription myPrescription where myPrescription.patientId = ?1"),
		@NamedQuery(name = "FindPrescriptionByDoctorId", query = "select myPrescription from Prescription myPrescription where myPrescription.doctorId = :id"),
		@NamedQuery(name = "FindPrescriptionByDoctorIdCount", query = "select count(myPrescription.prescriptionId) from Prescription myPrescription where myPrescription.doctorId = ?1") })
@Table(catalog = "aarogya", name = "prescription")
public class Prescription implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @generated
	 */

	@Column(name = "prescription_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	private Integer prescriptionId;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "upn", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String upn;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "patient_id")
	@Basic(fetch = FetchType.EAGER)
	private Integer patientId;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "doctor_id")
	@Basic(fetch = FetchType.EAGER)
	private Integer doctorId;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "status", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String status;

	/**
	 * @generated  
	 */
	public Prescription() {
	}

	/**
	 *  
	 * @generated
	 */
	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	/**
	 *  
	 * @generated
	 */
	public Integer getPrescriptionId() {
		return this.prescriptionId;
	}

	/**
	 *  
	 * @generated
	 */
	public void setUpn(String upn) {
		this.upn = upn;
	}

	/**
	 *  
	 * @generated
	 */
	public String getUpn() {
		return this.upn;
	}

	/**
	 *  
	 * @generated
	 */
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	/**
	 *  
	 * @generated
	 */
	public Integer getPatientId() {
		return this.patientId;
	}

	/**
	 *  
	 * @generated
	 */
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 *  
	 * @generated
	 */
	public Integer getDoctorId() {
		return this.doctorId;
	}

	/**
	 *  
	 * @generated
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 *  
	 * @generated
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 * @generated  
	 */
	public void copy(Prescription that) {
		setPrescriptionId(that.getPrescriptionId());
		setUpn(that.getUpn());
		setPatientId(that.getPatientId());
		setDoctorId(that.getDoctorId());
		setStatus(that.getStatus());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 * @generated  
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("prescriptionId=[").append(prescriptionId).append("] ");
		buffer.append("upn=[").append(upn).append("] ");
		buffer.append("patientId=[").append(patientId).append("] ");
		buffer.append("doctorId=[").append(doctorId).append("] ");
		buffer.append("status=[").append(status).append("] ");

		return buffer.toString();
	}

	/**
	 * @generated  
	 *
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prescriptionId == null) ? 0 : prescriptionId.hashCode());
		return result;
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Prescription))
			return false;
		if (obj == null)
			return false;
		Prescription equalCheck = (Prescription) obj;
		if ((prescriptionId == null && equalCheck.prescriptionId != null) || (prescriptionId != null && equalCheck.prescriptionId == null))
			return false;
		if (prescriptionId != null && !prescriptionId.equals(equalCheck.prescriptionId))
			return false;
		return true;
	}

}
