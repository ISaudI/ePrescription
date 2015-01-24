package com.eprescription.aarogya.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eprescription.aarogya.domain.Prescription;
import com.eprescription.aarogya.domain.PrescriptionDrugRel;
import com.eprescription.aarogya.web.model.PrescriptionDrugRelWebModel;

/**
 * 
 * @author Chinnu
 *
 */
@Scope("singleton")
@Repository("prescriptionDrugDAO")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class PrescriptionDrugDAOImpl implements PrescriptionDrugDAO {
	
	private static transient Logger logger = LoggerFactory.getLogger(PrescriptionDrugDAOImpl.class);
	
	@Autowired
	private SessionFactory hibernate4AnnotatedSessionFactory;
	
	public PrescriptionDrugDAOImpl() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public List<PrescriptionDrugRelWebModel> getPrescriptionDetails(String upnNumber){
		logger.info("Entered into getPrescriptionDetails()");
		
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		String hsqlQuery = "select a.presDrugRelId, a.presDrugRelDosage, a.presDrugRelFrequency, a.presDrugRelStatus,"
				+ " a.presDrugRelUpdatedby,"+
			"b.drugName, b.drugType, a.presDrugRelUpn from PrescriptionDrugRel a, Drug b"
			+ " where a.presDrugRelDrugId = b.drugId"+
       		" and a.presDrugRelUpn = '"+upnNumber+"'";
		Query query = session.createQuery(hsqlQuery);
		List<Object[]> prescriptionData = query.list();
		
		List<PrescriptionDrugRelWebModel> result = new ArrayList<PrescriptionDrugRelWebModel>();
		for (Object[] prescription : prescriptionData){
			PrescriptionDrugRelWebModel model = new PrescriptionDrugRelWebModel();
			model.setPresDrugRelId((Integer)prescription[0]);
			model.setDosage((String)prescription[1]);
			model.setFrequency((String)prescription[2]);
			model.setStatus((String)prescription[3]);
			model.setLastUpdatedUser((Integer)prescription[4]);
			model.setDrugName((String)prescription[5]+"-"+(String)prescription[6]);
			model.setUpn((String)prescription[7]);
			result.add(model);
		}
		logger.info("Exiting from getPrescriptionDetails(), no of drugs in "
				+ "prescription "+upnNumber+" is "+result.size());
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public List<PrescriptionDrugRel> getPrescriptionDetailsByPatient(Integer patientId) throws DataAccessException {
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("FindPrescriptionByPatientId");
		query.setInteger("id", patientId);
		System.out.println("The query is :"+query.toString());
		List<PrescriptionDrugRel> patientPrescriptions = query.list();
		return patientPrescriptions;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public List<PrescriptionDrugRel> getPrescriptionDetailsByDoctor(Integer doctorId) throws DataAccessException {
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("FindPrescriptionByDoctorId");
		query.setInteger("id", doctorId);
		System.out.println("The query is :"+query.toString()+ " doctor id "+doctorId);
		@SuppressWarnings("unchecked")
		List<PrescriptionDrugRel> patientPrescriptions = query.list();
		System.out.println("THe size is "+patientPrescriptions.size());
		return patientPrescriptions;

	}
	
	@SuppressWarnings("unchecked")
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public List<PrescriptionDrugRelWebModel> getPrescriptionDetailsByUPNandAUID(String upnNumber,String auid){
		logger.info("Entered into getPrescriptionDetails()");
		
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		String hsqlQuery = "select a.presDrugRelId, a.presDrugRelDosage, a.presDrugRelFrequency, a.presDrugRelStatus,"
				+ " a.presDrugRelUpdatedby,"+
			"b.drugName, b.drugType, a.presDrugRelUpn from PrescriptionDrugRel a, Drug b, Prescription c , Patient d "
			+ "where a.presDrugRelUpn = c.upn and d.patientId = c.patientId and  "
			+ "a.presDrugRelDrugId = b.drugId"+
       		" and a.presDrugRelUpn = '"+upnNumber+"' and d.aa360id = '"+auid+"'";
		Query query = session.createQuery(hsqlQuery);
		List<Object[]> prescriptionData = query.list();
		
		List<PrescriptionDrugRelWebModel> result = new ArrayList<PrescriptionDrugRelWebModel>();
		for (Object[] prescription : prescriptionData){
			PrescriptionDrugRelWebModel model = new PrescriptionDrugRelWebModel();
			model.setPresDrugRelId((Integer)prescription[0]);
			model.setDosage((String)prescription[1]);
			model.setFrequency((String)prescription[2]);
			model.setStatus((String)prescription[3]);
			model.setLastUpdatedUser((Integer)prescription[4]);
			model.setDrugName((String)prescription[5]+"-"+(String)prescription[6]);
			model.setUpn((String)prescription[7]);
			result.add(model);
		}
		logger.info("Exiting from getPrescriptionDetails(), no of drugs in "
				+ "prescription "+upnNumber+" is "+result.size());
		System.out.println("Exiting from getPrescriptionDetails(), no of drugs in "
				+ "prescription "+upnNumber+" is "+result.size());
		return result;
		
	}
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public int getNoOfPresprectionsCount(){
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("FindAllPrescriptionsCount");
		Long i = (Long)query.uniqueResult();
		
		return i.intValue();
	}
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Prescription savePrescriptionDetails(Prescription prescription){
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Prescription pres = new Prescription();
		session.merge(prescription);
		session.flush();
		pres = prescription;
		return pres;
	}
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public PrescriptionDrugRel savePrescriptionDrugDetails(PrescriptionDrugRel prescription){
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		PrescriptionDrugRel pres = new PrescriptionDrugRel();
		session.merge(prescription);
		session.flush();
		pres=prescription;
		return pres;
	}
	
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public PrescriptionDrugRel getPrescriptionDrugDetailsById(String presDrugId){
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("FindPrescriptionDrugRelByPrimaryKey");
		query.setInteger("id", Integer.parseInt(presDrugId));
		System.out.println("The query is :"+query.toString()+ "  id "+presDrugId);
		PrescriptionDrugRel patientPrescriptions = (PrescriptionDrugRel) query.uniqueResult();
		return patientPrescriptions;
	}
	
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public int getNoOfPresprectionsDrugCount(){
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("FindAllPrescriptionDrugRelsCount");
		Long i = (Long)query.uniqueResult();
		
		return i.intValue();
	}
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Prescription getPrescriptionDetailsByUpn(String upnNumber){
		Session session = hibernate4AnnotatedSessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("FindPrescriptionByUpn");
		query.setString("upn", upnNumber);
		System.out.println("The query is :"+query.toString()+ "  id "+upnNumber);
		Prescription patientPrescriptions = (Prescription) query.uniqueResult();
		return patientPrescriptions;
	}

}
