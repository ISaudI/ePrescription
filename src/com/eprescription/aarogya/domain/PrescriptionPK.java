package com.eprescription.aarogya.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @generated
 */
public class PrescriptionPK implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	public PrescriptionPK() {
	}

	/**
	 * @generated
	 */

	@Column(name = "prescription_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer prescriptionId;

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
		if (!(obj instanceof PrescriptionPK))
			return false;
		if (obj == null)
			return false;
		PrescriptionPK equalCheck = (PrescriptionPK) obj;
		if ((prescriptionId == null && equalCheck.prescriptionId != null) || (prescriptionId != null && equalCheck.prescriptionId == null))
			return false;
		if (prescriptionId != null && !prescriptionId.equals(equalCheck.prescriptionId))
			return false;
		return true;
	}

}
