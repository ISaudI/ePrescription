package com.eprescription.aarogya.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;

/**
 * 
 * @ModelCoreReference [platform:/resource/TestJPA/models/com/eprescription/aarogya/domain/PrescriptionDrugRel.datatype]
 * @generated
 */

@IdClass(com.eprescription.aarogya.domain.PrescriptionDrugRelPK.class)
@Entity
@NamedQueries( {
		@NamedQuery(name = "FindAllPrescriptionDrugRels", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel"),
		@NamedQuery(name = "FindAllPrescriptionDrugRelsCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelUpdatedby", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelUpdatedby = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelUpdatedbyCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelUpdatedby = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelStatus", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelStatus = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelStatusCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelStatus = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelDosage", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelDosage = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelDosageCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelDosage = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelFrequency", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelFrequency = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelFrequencyCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelFrequency = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelId", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelId = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelIdCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelId = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelDrugId", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelDrugId = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelDrugIdCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelDrugId = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelFrequencyContaining", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelFrequency like ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelFrequencyContainingCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelFrequency like ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelUpn", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelUpn = :upn"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelUpnCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelUpn = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPrimaryKey", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelId = :id"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPrimaryKeyCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelId = ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelUpnContaining", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelUpn like ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelUpnContainingCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelUpn like ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelDosageContaining", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelDosage like ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelDosageContainingCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelDosage like ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelStatusContaining", query = "select myPrescriptionDrugRel from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelStatus like ?1"),
		@NamedQuery(name = "FindPrescriptionDrugRelByPresDrugRelStatusContainingCount", query = "select count(myPrescriptionDrugRel.presDrugRelId) from PrescriptionDrugRel myPrescriptionDrugRel where myPrescriptionDrugRel.presDrugRelStatus like ?1") })
@Table(catalog = "aarogya", name = "prescription_drug_rel")
public class PrescriptionDrugRel implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @generated
	 */

	@Column(name = "pres_drug_rel_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	private Integer presDrugRelId;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "pres_drug_rel_upn", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String presDrugRelUpn;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "pres_drug_rel_drug_id")
	@Basic(fetch = FetchType.EAGER)
	private Integer presDrugRelDrugId;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "pres_drug_rel_dosage", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String presDrugRelDosage;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "pres_drug_rel_frequency", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String presDrugRelFrequency;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "pres_drug_rel_status", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String presDrugRelStatus;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "pres_drug_rel_updatedby")
	@Basic(fetch = FetchType.EAGER)
	private Integer presDrugRelUpdatedby;

	/**
	 * @generated  
	 */
	public PrescriptionDrugRel() {
	}

	/**
	 *  
	 * @generated
	 */
	public void setPresDrugRelId(Integer presDrugRelId) {
		this.presDrugRelId = presDrugRelId;
	}

	/**
	 *  
	 * @generated
	 */
	public Integer getPresDrugRelId() {
		return this.presDrugRelId;
	}

	/**
	 *  
	 * @generated
	 */
	public void setPresDrugRelUpn(String presDrugRelUpn) {
		this.presDrugRelUpn = presDrugRelUpn;
	}

	/**
	 *  
	 * @generated
	 */
	public String getPresDrugRelUpn() {
		return this.presDrugRelUpn;
	}

	/**
	 *  
	 * @generated
	 */
	public void setPresDrugRelDrugId(Integer presDrugRelDrugId) {
		this.presDrugRelDrugId = presDrugRelDrugId;
	}

	/**
	 *  
	 * @generated
	 */
	public Integer getPresDrugRelDrugId() {
		return this.presDrugRelDrugId;
	}

	/**
	 *  
	 * @generated
	 */
	public void setPresDrugRelDosage(String presDrugRelDosage) {
		this.presDrugRelDosage = presDrugRelDosage;
	}

	/**
	 *  
	 * @generated
	 */
	public String getPresDrugRelDosage() {
		return this.presDrugRelDosage;
	}

	/**
	 *  
	 * @generated
	 */
	public void setPresDrugRelFrequency(String presDrugRelFrequency) {
		this.presDrugRelFrequency = presDrugRelFrequency;
	}

	/**
	 *  
	 * @generated
	 */
	public String getPresDrugRelFrequency() {
		return this.presDrugRelFrequency;
	}

	/**
	 *  
	 * @generated
	 */
	public void setPresDrugRelStatus(String presDrugRelStatus) {
		this.presDrugRelStatus = presDrugRelStatus;
	}

	/**
	 *  
	 * @generated
	 */
	public String getPresDrugRelStatus() {
		return this.presDrugRelStatus;
	}

	/**
	 *  
	 * @generated
	 */
	public void setPresDrugRelUpdatedby(Integer presDrugRelUpdatedby) {
		this.presDrugRelUpdatedby = presDrugRelUpdatedby;
	}

	/**
	 *  
	 * @generated
	 */
	public Integer getPresDrugRelUpdatedby() {
		return this.presDrugRelUpdatedby;
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 * @generated  
	 */
	public void copy(PrescriptionDrugRel that) {
		setPresDrugRelId(that.getPresDrugRelId());
		setPresDrugRelUpn(that.getPresDrugRelUpn());
		setPresDrugRelDrugId(that.getPresDrugRelDrugId());
		setPresDrugRelDosage(that.getPresDrugRelDosage());
		setPresDrugRelFrequency(that.getPresDrugRelFrequency());
		setPresDrugRelStatus(that.getPresDrugRelStatus());
		setPresDrugRelUpdatedby(that.getPresDrugRelUpdatedby());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 * @generated  
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("presDrugRelId=[").append(presDrugRelId).append("] ");
		buffer.append("presDrugRelUpn=[").append(presDrugRelUpn).append("] ");
		buffer.append("presDrugRelDrugId=[").append(presDrugRelDrugId).append("] ");
		buffer.append("presDrugRelDosage=[").append(presDrugRelDosage).append("] ");
		buffer.append("presDrugRelFrequency=[").append(presDrugRelFrequency).append("] ");
		buffer.append("presDrugRelStatus=[").append(presDrugRelStatus).append("] ");
		buffer.append("presDrugRelUpdatedby=[").append(presDrugRelUpdatedby).append("] ");

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
		result = prime * result + ((presDrugRelId == null) ? 0 : presDrugRelId.hashCode());
		return result;
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PrescriptionDrugRel))
			return false;
		if (obj == null)
			return false;
		PrescriptionDrugRel equalCheck = (PrescriptionDrugRel) obj;
		if ((presDrugRelId == null && equalCheck.presDrugRelId != null) || (presDrugRelId != null && equalCheck.presDrugRelId == null))
			return false;
		if (presDrugRelId != null && !presDrugRelId.equals(equalCheck.presDrugRelId))
			return false;
		return true;
	}

}
