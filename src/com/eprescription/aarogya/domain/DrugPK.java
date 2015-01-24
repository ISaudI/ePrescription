package com.eprescription.aarogya.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @generated
 */
public class DrugPK implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	public DrugPK() {
	}

	/**
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
		if (!(obj instanceof DrugPK))
			return false;
		if (obj == null)
			return false;
		DrugPK equalCheck = (DrugPK) obj;
		if ((drugId == null && equalCheck.drugId != null) || (drugId != null && equalCheck.drugId == null))
			return false;
		if (drugId != null && !drugId.equals(equalCheck.drugId))
			return false;
		return true;
	}

}
