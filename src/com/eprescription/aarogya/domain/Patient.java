package com.eprescription.aarogya.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;

/**
 * 
 * @ModelCoreReference [platform:/resource/TestJPA/models/com/eprescription/aarogya/domain/Patient.datatype]
 * @generated
 */

@IdClass(com.eprescription.aarogya.domain.PatientPK.class)
@Entity
@NamedQueries( {
		@NamedQuery(name = "FindPatientByAa360idContaining", query = "select myPatient from Patient myPatient where myPatient.aa360id like ?1"),
		@NamedQuery(name = "FindPatientByAa360idContainingCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.aa360id like ?1"),
		@NamedQuery(name = "FindPatientByPatientId", query = "select myPatient from Patient myPatient where myPatient.patientId = :id"),
		@NamedQuery(name = "FindPatientByPatientIdCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.patientId = ?1"),
		@NamedQuery(name = "FindPatientByPatientName", query = "select myPatient from Patient myPatient where myPatient.patientName = ?1"),
		@NamedQuery(name = "FindPatientByPatientNameCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.patientName = ?1"),
		@NamedQuery(name = "FindPatientByPhoneNoContaining", query = "select myPatient from Patient myPatient where myPatient.phoneNo like ?1"),
		@NamedQuery(name = "FindPatientByPhoneNoContainingCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.phoneNo like ?1"),
		@NamedQuery(name = "FindPatientByPhoneNo", query = "select myPatient from Patient myPatient where myPatient.phoneNo = ?1"),
		@NamedQuery(name = "FindPatientByPhoneNoCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.phoneNo = ?1"),
		@NamedQuery(name = "FindAllPatients", query = "select myPatient from Patient myPatient"),
		@NamedQuery(name = "FindAllPatientsCount", query = "select count(myPatient.patientId) from Patient myPatient"),
		@NamedQuery(name = "FindPatientByPassword", query = "select myPatient from Patient myPatient where myPatient.password = ?1"),
		@NamedQuery(name = "FindPatientByPasswordCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.password = ?1"),
		@NamedQuery(name = "FindPatientByPasswordContaining", query = "select myPatient from Patient myPatient where myPatient.password like ?1"),
		@NamedQuery(name = "FindPatientByPasswordContainingCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.password like ?1"),
		@NamedQuery(name = "FindPatientByAa360id", query = "select myPatient from Patient myPatient where myPatient.aa360id = :au360Id"),
		@NamedQuery(name = "FindPatientLoginCredentials", query = "select myPatient from Patient myPatient where myPatient.aa360id = :au360Id and myPatient.password = :password"),
		@NamedQuery(name = "FindPatientByAa360idCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.aa360id = ?1"),
		@NamedQuery(name = "FindPatientByPrimaryKey", query = "select myPatient from Patient myPatient where myPatient.patientId = ?1"),
		@NamedQuery(name = "FindPatientByPrimaryKeyCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.patientId = ?1"),
		@NamedQuery(name = "FindPatientByEmailIdContaining", query = "select myPatient from Patient myPatient where myPatient.emailId like ?1"),
		@NamedQuery(name = "FindPatientByEmailIdContainingCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.emailId like ?1"),
		@NamedQuery(name = "FindPatientByEmailId", query = "select myPatient from Patient myPatient where myPatient.emailId = ?1"),
		@NamedQuery(name = "FindPatientByEmailIdCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.emailId = ?1"),
		@NamedQuery(name = "FindPatientByPatientNameContaining", query = "select myPatient from Patient myPatient where myPatient.patientName like ?1"),
		@NamedQuery(name = "FindPatientByPatientNameContainingCount", query = "select count(myPatient.patientId) from Patient myPatient where myPatient.patientName like ?1") })
@Table(catalog = "aarogya", name = "patient")
public class Patient implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @generated
	 */

	@Column(name = "patient_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	private Integer patientId;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "patient_name", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String patientName;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "aa360id", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	private String aa360id;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "phone_no", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String phoneNo;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "email_id", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String emailId;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "password", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String password;

	/**
	 * @generated  
	 */
	public Patient() {
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
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 *  
	 * @generated
	 */
	public String getPatientName() {
		return this.patientName;
	}

	/**
	 *  
	 * @generated
	 */
	public void setAa360id(String aa360id) {
		this.aa360id = aa360id;
	}

	/**
	 *  
	 * @generated
	 */
	public String getAa360id() {
		return this.aa360id;
	}

	/**
	 *  
	 * @generated
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 *  
	 * @generated
	 */
	public String getPhoneNo() {
		return this.phoneNo;
	}

	/**
	 *  
	 * @generated
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 *  
	 * @generated
	 */
	public String getEmailId() {
		return this.emailId;
	}

	/**
	 *  
	 * @generated
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 *  
	 * @generated
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 * @generated  
	 */
	public void copy(Patient that) {
		setPatientId(that.getPatientId());
		setPatientName(that.getPatientName());
		setAa360id(that.getAa360id());
		setPhoneNo(that.getPhoneNo());
		setEmailId(that.getEmailId());
		setPassword(that.getPassword());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 * @generated  
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("patientId=[").append(patientId).append("] ");
		buffer.append("patientName=[").append(patientName).append("] ");
		buffer.append("aa360id=[").append(aa360id).append("] ");
		buffer.append("phoneNo=[").append(phoneNo).append("] ");
		buffer.append("emailId=[").append(emailId).append("] ");
		buffer.append("password=[").append(password).append("] ");

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
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		return result;
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Patient))
			return false;
		if (obj == null)
			return false;
		Patient equalCheck = (Patient) obj;
		if ((patientId == null && equalCheck.patientId != null) || (patientId != null && equalCheck.patientId == null))
			return false;
		if (patientId != null && !patientId.equals(equalCheck.patientId))
			return false;
		return true;
	}

}
