package com.eprescription.aarogya.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;

/**
 * 
 * @ModelCoreReference [platform:/resource/TestJPA/models/com/eprescription/aarogya/domain/Doctor.datatype]
 * @generated
 */

@IdClass(com.eprescription.aarogya.domain.DoctorPK.class)
@Entity
@NamedQueries( {
		@NamedQuery(name = "FindDoctorByAa360idContaining", query = "select myDoctor from Doctor myDoctor where myDoctor.aa360id like ?1"),
		@NamedQuery(name = "FindDoctorByAa360idContainingCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.aa360id like ?1"),
		@NamedQuery(name = "FindDoctorByPhoneNoContaining", query = "select myDoctor from Doctor myDoctor where myDoctor.phoneNo like ?1"),
		@NamedQuery(name = "FindDoctorByPhoneNoContainingCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.phoneNo like ?1"),
		@NamedQuery(name = "FindDoctorByEmailId", query = "select myDoctor from Doctor myDoctor where myDoctor.emailId = ?1"),
		@NamedQuery(name = "FindDoctorByEmailIdCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.emailId = ?1"),
		@NamedQuery(name = "FindDoctorByDoctorId", query = "select myDoctor from Doctor myDoctor where myDoctor.doctorId = :id"),
		@NamedQuery(name = "FindDoctorByDoctorIdCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.doctorId = ?1"),
		@NamedQuery(name = "FindDoctorByAa360id", query = "select myDoctor from Doctor myDoctor where myDoctor.aa360id = ?1"),
		@NamedQuery(name = "FindDoctorByLoginDetails", query = "select myDoctor from Doctor myDoctor where myDoctor.aa360id = :au360Id and myDoctor.password = :password "),
		@NamedQuery(name = "FindDoctorByAa360idCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.aa360id = ?1"),
		@NamedQuery(name = "FindDoctorByPasswordContaining", query = "select myDoctor from Doctor myDoctor where myDoctor.password like ?1"),
		@NamedQuery(name = "FindDoctorByPasswordContainingCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.password like ?1"),
		@NamedQuery(name = "FindDoctorByDoctorName", query = "select myDoctor from Doctor myDoctor where myDoctor.doctorName = ?1"),
		@NamedQuery(name = "FindDoctorByDoctorNameCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.doctorName = ?1"),
		@NamedQuery(name = "FindDoctorByEmailIdContaining", query = "select myDoctor from Doctor myDoctor where myDoctor.emailId like ?1"),
		@NamedQuery(name = "FindDoctorByEmailIdContainingCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.emailId like ?1"),
		@NamedQuery(name = "FindDoctorByPrimaryKey", query = "select myDoctor from Doctor myDoctor where myDoctor.doctorId = ?1"),
		@NamedQuery(name = "FindDoctorByPrimaryKeyCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.doctorId = ?1"),
		@NamedQuery(name = "FindAllDoctors", query = "select myDoctor from Doctor myDoctor"),
		@NamedQuery(name = "FindAllDoctorsCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor"),
		@NamedQuery(name = "FindDoctorByDoctorNameContaining", query = "select myDoctor from Doctor myDoctor where myDoctor.doctorName like ?1"),
		@NamedQuery(name = "FindDoctorByDoctorNameContainingCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.doctorName like ?1"),
		@NamedQuery(name = "FindDoctorByPhoneNo", query = "select myDoctor from Doctor myDoctor where myDoctor.phoneNo = ?1"),
		@NamedQuery(name = "FindDoctorByPhoneNoCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.phoneNo = ?1"),
		@NamedQuery(name = "FindDoctorByPassword", query = "select myDoctor from Doctor myDoctor where myDoctor.password = ?1"),
		@NamedQuery(name = "FindDoctorByPasswordCount", query = "select count(myDoctor.doctorId) from Doctor myDoctor where myDoctor.password = ?1") })
@Table(catalog = "aarogya", name = "doctor")
public class Doctor implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @generated
	 */

	@Column(name = "doctor_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	private Integer doctorId;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "doctor_name", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String doctorName;
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
	public Doctor() {
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
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 *  
	 * @generated
	 */
	public String getDoctorName() {
		return this.doctorName;
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
	public void copy(Doctor that) {
		setDoctorId(that.getDoctorId());
		setDoctorName(that.getDoctorName());
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

		buffer.append("doctorId=[").append(doctorId).append("] ");
		buffer.append("doctorName=[").append(doctorName).append("] ");
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
		result = prime * result + ((doctorId == null) ? 0 : doctorId.hashCode());
		return result;
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Doctor))
			return false;
		if (obj == null)
			return false;
		Doctor equalCheck = (Doctor) obj;
		if ((doctorId == null && equalCheck.doctorId != null) || (doctorId != null && equalCheck.doctorId == null))
			return false;
		if (doctorId != null && !doctorId.equals(equalCheck.doctorId))
			return false;
		return true;
	}

}
