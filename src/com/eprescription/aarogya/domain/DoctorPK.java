package com.eprescription.aarogya.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @generated
 */
public class DoctorPK implements Serializable {
	// TopLink has a defect where inclusion of serialVersionUID results in an exception
	//private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	public DoctorPK() {
	}

	/**
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
		if (!(obj instanceof DoctorPK))
			return false;
		if (obj == null)
			return false;
		DoctorPK equalCheck = (DoctorPK) obj;
		if ((doctorId == null && equalCheck.doctorId != null) || (doctorId != null && equalCheck.doctorId == null))
			return false;
		if (doctorId != null && !doctorId.equals(equalCheck.doctorId))
			return false;
		return true;
	}

}
