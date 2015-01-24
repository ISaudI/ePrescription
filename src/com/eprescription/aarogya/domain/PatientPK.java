package com.eprescription.aarogya.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @generated
 */
public class PatientPK implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	public PatientPK() {
	}

	/**
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
		if (!(obj instanceof PatientPK))
			return false;
		if (obj == null)
			return false;
		PatientPK equalCheck = (PatientPK) obj;
		if ((patientId == null && equalCheck.patientId != null) || (patientId != null && equalCheck.patientId == null))
			return false;
		if (patientId != null && !patientId.equals(equalCheck.patientId))
			return false;
		return true;
	}

}
