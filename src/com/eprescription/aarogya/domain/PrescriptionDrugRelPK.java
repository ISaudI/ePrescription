package com.eprescription.aarogya.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @generated
 */
public class PrescriptionDrugRelPK implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	public PrescriptionDrugRelPK() {
	}

	/**
	 * @generated
	 */

	@Column(name = "pres_drug_rel_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer presDrugRelId;

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
		if (!(obj instanceof PrescriptionDrugRelPK))
			return false;
		if (obj == null)
			return false;
		PrescriptionDrugRelPK equalCheck = (PrescriptionDrugRelPK) obj;
		if ((presDrugRelId == null && equalCheck.presDrugRelId != null) || (presDrugRelId != null && equalCheck.presDrugRelId == null))
			return false;
		if (presDrugRelId != null && !presDrugRelId.equals(equalCheck.presDrugRelId))
			return false;
		return true;
	}

}
