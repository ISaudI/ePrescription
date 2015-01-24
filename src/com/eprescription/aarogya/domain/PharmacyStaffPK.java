package com.eprescription.aarogya.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @generated
 */
public class PharmacyStaffPK implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	public PharmacyStaffPK() {
	}

	/**
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
		if (!(obj instanceof PharmacyStaffPK))
			return false;
		if (obj == null)
			return false;
		PharmacyStaffPK equalCheck = (PharmacyStaffPK) obj;
		if ((pharmacyStaffId == null && equalCheck.pharmacyStaffId != null) || (pharmacyStaffId != null && equalCheck.pharmacyStaffId == null))
			return false;
		if (pharmacyStaffId != null && !pharmacyStaffId.equals(equalCheck.pharmacyStaffId))
			return false;
		return true;
	}

}
