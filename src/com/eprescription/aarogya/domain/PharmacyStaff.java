package com.eprescription.aarogya.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;

/**
 * 
 * @ModelCoreReference [platform:/resource/TestJPA/models/com/eprescription/aarogya/domain/PharmacyStaff.datatype]
 * @generated
 */

@IdClass(com.eprescription.aarogya.domain.PharmacyStaffPK.class)
@Entity
@NamedQueries( {
		@NamedQuery(name = "FindPharmacyStaffByPharmacyStaffId", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.pharmacyStaffId = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPharmacyStaffIdCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.pharmacyStaffId = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPharmacyStaffName", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.pharmacyStaffName = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPharmacyStaffNameCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.pharmacyStaffName = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPrimaryKey", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.pharmacyStaffId = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPrimaryKeyCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.pharmacyStaffId = ?1"),
		@NamedQuery(name = "FindAllPharmacyStaffs", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff"),
		@NamedQuery(name = "FindAllPharmacyStaffsCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff"),
		@NamedQuery(name = "FindPharmacyStaffByPassword", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.password = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPasswordCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.password = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPasswordContaining", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.password like ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPasswordContainingCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.password like ?1"),
		@NamedQuery(name = "FindPharmacyStaffByEmailId", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.emailId = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByEmailIdCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.emailId = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPhoneNoContaining", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.phoneNo like ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPhoneNoContainingCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.phoneNo like ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPharmacyStaffNameContaining", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.pharmacyStaffName like ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPharmacyStaffNameContainingCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.pharmacyStaffName like ?1"),
		@NamedQuery(name = "FindPharmacyStaffByAa360id", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.aa360id = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByLoginCresentials", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.aa360id = :au360Id and myPharmacyStaff.password = :password"),
		@NamedQuery(name = "FindPharmacyStaffByAa360idCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.aa360id = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByEmailIdContaining", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.emailId like ?1"),
		@NamedQuery(name = "FindPharmacyStaffByEmailIdContainingCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.emailId like ?1"),
		@NamedQuery(name = "FindPharmacyStaffByAa360idContaining", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.aa360id like ?1"),
		@NamedQuery(name = "FindPharmacyStaffByAa360idContainingCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.aa360id like ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPhoneNo", query = "select myPharmacyStaff from PharmacyStaff myPharmacyStaff where myPharmacyStaff.phoneNo = ?1"),
		@NamedQuery(name = "FindPharmacyStaffByPhoneNoCount", query = "select count(myPharmacyStaff.pharmacyStaffId) from PharmacyStaff myPharmacyStaff where myPharmacyStaff.phoneNo = ?1") })
@Table(catalog = "aarogya", name = "pharmacy_staff")
public class PharmacyStaff implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @generated
	 */

	@Column(name = "pharmacy_staff_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	private Integer pharmacyStaffId;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "pharmacy_staff_name", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String pharmacyStaffName;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "aa360id", length = 45)
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
	public PharmacyStaff() {
	}

	/**
	 *  
	 * @generated
	 */
	public void setPharmacyStaffId(Integer pharmacyStaffId) {
		this.pharmacyStaffId = pharmacyStaffId;
	}

	/**
	 *  
	 * @generated
	 */
	public Integer getPharmacyStaffId() {
		return this.pharmacyStaffId;
	}

	/**
	 *  
	 * @generated
	 */
	public void setPharmacyStaffName(String pharmacyStaffName) {
		this.pharmacyStaffName = pharmacyStaffName;
	}

	/**
	 *  
	 * @generated
	 */
	public String getPharmacyStaffName() {
		return this.pharmacyStaffName;
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
	public void copy(PharmacyStaff that) {
		setPharmacyStaffId(that.getPharmacyStaffId());
		setPharmacyStaffName(that.getPharmacyStaffName());
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

		buffer.append("pharmacyStaffId=[").append(pharmacyStaffId).append("] ");
		buffer.append("pharmacyStaffName=[").append(pharmacyStaffName).append("] ");
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
		result = prime * result + ((pharmacyStaffId == null) ? 0 : pharmacyStaffId.hashCode());
		return result;
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PharmacyStaff))
			return false;
		if (obj == null)
			return false;
		PharmacyStaff equalCheck = (PharmacyStaff) obj;
		if ((pharmacyStaffId == null && equalCheck.pharmacyStaffId != null) || (pharmacyStaffId != null && equalCheck.pharmacyStaffId == null))
			return false;
		if (pharmacyStaffId != null && !pharmacyStaffId.equals(equalCheck.pharmacyStaffId))
			return false;
		return true;
	}

}
