package com.eprescription.aarogya.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;

/**
 * 
 * @ModelCoreReference [platform:/resource/TestJPA/models/com/eprescription/aarogya/domain/Drug.datatype]
 * @generated
 */

@IdClass(com.eprescription.aarogya.domain.DrugPK.class)
@Entity
@NamedQueries( {
		@NamedQuery(name = "FindDrugByDrugNameContaining", query = "select myDrug from Drug myDrug where myDrug.drugName like ?1"),
		@NamedQuery(name = "FindDrugByDrugNameContainingCount", query = "select count(myDrug.drugId) from Drug myDrug where myDrug.drugName like ?1"),
		@NamedQuery(name = "FindDrugByDrugId", query = "select myDrug from Drug myDrug where myDrug.drugId = ?1"),
		@NamedQuery(name = "FindDrugByDrugIdCount", query = "select count(myDrug.drugId) from Drug myDrug where myDrug.drugId = ?1"),
		@NamedQuery(name = "FindDrugByPrimaryKey", query = "select myDrug from Drug myDrug where myDrug.drugId = ?1"),
		@NamedQuery(name = "FindDrugByPrimaryKeyCount", query = "select count(myDrug.drugId) from Drug myDrug where myDrug.drugId = ?1"),
		@NamedQuery(name = "FindAllDrugs", query = "select myDrug from Drug myDrug"),
		@NamedQuery(name = "FindAllDrugsCount", query = "select count(myDrug.drugId) from Drug myDrug"),
		@NamedQuery(name = "FindDrugByDrugType", query = "select myDrug from Drug myDrug where myDrug.drugType = ?1"),
		@NamedQuery(name = "FindDrugByDrugTypeCount", query = "select count(myDrug.drugId) from Drug myDrug where myDrug.drugType = ?1"),
		@NamedQuery(name = "FindDrugByDrugName", query = "select myDrug from Drug myDrug where myDrug.drugName = ?1"),
		@NamedQuery(name = "FindDrugByDrugNameCount", query = "select count(myDrug.drugId) from Drug myDrug where myDrug.drugName = ?1"),
		@NamedQuery(name = "FindDrugByDrugTypeContaining", query = "select myDrug from Drug myDrug where myDrug.drugType like ?1"),
		@NamedQuery(name = "FindDrugByDrugTypeContainingCount", query = "select count(myDrug.drugId) from Drug myDrug where myDrug.drugType like ?1") })
@Table(catalog = "aarogya", name = "drug")
public class Drug implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @generated
	 */

	@Column(name = "drug_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	private Integer drugId;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "drug_name", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String drugName;
	/**
	 * 
	 * @generated
	 */

	@Column(name = "drug_type", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String drugType;

	/**
	 * @generated  
	 */
	public Drug() {
	}

	/**
	 *  
	 * @generated
	 */
	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}

	/**
	 *  
	 * @generated
	 */
	public Integer getDrugId() {
		return this.drugId;
	}

	/**
	 *  
	 * @generated
	 */
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	/**
	 *  
	 * @generated
	 */
	public String getDrugName() {
		return this.drugName;
	}

	/**
	 *  
	 * @generated
	 */
	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	/**
	 *  
	 * @generated
	 */
	public String getDrugType() {
		return this.drugType;
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 * @generated  
	 */
	public void copy(Drug that) {
		setDrugId(that.getDrugId());
		setDrugName(that.getDrugName());
		setDrugType(that.getDrugType());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 * @generated  
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("drugId=[").append(drugId).append("] ");
		buffer.append("drugName=[").append(drugName).append("] ");
		buffer.append("drugType=[").append(drugType).append("] ");

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
		result = prime * result + ((drugId == null) ? 0 : drugId.hashCode());
		return result;
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Drug))
			return false;
		if (obj == null)
			return false;
		Drug equalCheck = (Drug) obj;
		if ((drugId == null && equalCheck.drugId != null) || (drugId != null && equalCheck.drugId == null))
			return false;
		if (drugId != null && !drugId.equals(equalCheck.drugId))
			return false;
		return true;
	}

}
