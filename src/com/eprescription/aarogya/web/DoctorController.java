package com.eprescription.aarogya.web;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.execution.databinding.CustomCalendarEditor;
import org.execution.databinding.EnhancedBooleanEditor;
import org.execution.databinding.NaNHandlingNumberEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.eprescription.aarogya.dao.DoctorDAO;
import com.eprescription.aarogya.domain.Doctor;
import com.eprescription.aarogya.domain.Drug;
import com.eprescription.aarogya.domain.Patient;
import com.eprescription.aarogya.domain.PrescriptionDrugRel;
import com.eprescription.aarogya.service.DoctorService;
import com.eprescription.aarogya.web.model.PrescriptionDrugs;

/**
 * 
 * @author Chinnu
 *
 */
@Scope("singleton")
@Controller("doctorController")
public class DoctorController {
	
	private static final String BIND_PATTERN_SUFFIX = "_datebindpattern";

	
	private transient Logger logger = LoggerFactory.getLogger(getClass());

	
	@Resource(name = "doctorDAO")
	protected DoctorDAO doctorDAO;

	@Resource(name = "doctorService")
	protected DoctorService doctorService;

	
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) {
		// Register static property editors.
		binder.registerCustomEditor(Calendar.class, new CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new EnhancedBooleanEditor(true));
		binder.registerCustomEditor(BigDecimal.class, new NaNHandlingNumberEditor(BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new NaNHandlingNumberEditor(Integer.class, true));

		// Register dynamic property editors for specific fields.
		@SuppressWarnings({ "rawtypes" })
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			if (key.endsWith(BIND_PATTERN_SUFFIX)) {
				String field = key.substring(0, key.indexOf(BIND_PATTERN_SUFFIX));
				String pattern = (String) request.getParameter(key);
				binder.registerCustomEditor(Calendar.class, field, new CustomCalendarEditor(pattern));
			}
		}
	}

	

	@RequestMapping(value = "/indexDoctor.html")
	public ModelAndView listDoctors() throws java.lang.Exception {
		Set<Doctor> doctors = null;
		doctors = doctorService.loadDoctors();
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctors", doctors);
		mav.setViewName("doctor/listDoctors");
		return mav;
	}
	
	

	@RequestMapping(value = "/selectDoctor.html")
	public ModelAndView selectDoctor(@RequestParam("doctorId") String id) throws java.lang.Exception {
		Doctor doctor = null;
		int maxResults;
		Doctor queryResult;
		int startResult;
		queryResult = null;
		startResult = -1;
		maxResults = -1;
		queryResult = doctorDAO.findDoctorByPrimaryKey(id, startResult, maxResults);
		doctor = queryResult;
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/viewDoctor");
		return mav;
	}


	@RequestMapping(value = "/editDoctor.html")
	public ModelAndView editDoctor(@RequestParam("id") String id) throws java.lang.Exception {
		Doctor doctor = null;
		int maxResults;
		Doctor queryResult;
		int startResult;
		queryResult = null;
		startResult = -1;
		maxResults = -1;
		queryResult = doctorDAO.findDoctorByPrimaryKey(id, startResult, maxResults);
		doctor = queryResult;
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/editDoctor");
		return mav;
	}


	@RequestMapping(value = "/saveDoctor.html")
	public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) throws java.lang.Exception {


		doctorService.saveDoctor(doctor);

		return "redirect:/indexDoctor.html";
	}


	@RequestMapping(value = "/newDoctor.html")
	public ModelAndView newDoctor() throws java.lang.Exception {
		Doctor doctor = null;
		doctor = new Doctor();
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/editDoctor");
		return mav;
	}
	
	@RequestMapping(value = "/doctorLogin.html")
	public ModelAndView doctorLogin(HttpSession session) throws java.lang.Exception {
		Doctor doctor = null;
		doctor = new Doctor();
		List<Drug> drugList = doctorDAO.getMedicineList();
		PrescriptionDrugs prescriptionDrug = new PrescriptionDrugs();
		session.setAttribute("drugList", drugList);
		ModelAndView mav = new ModelAndView("prescriptionDrug","command", prescriptionDrug);
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/doctorpres");
		return mav;
	}
	
	
	@RequestMapping(value = "/savePrescription.html")
	public ModelAndView savePrescription(HttpServletRequest request) throws java.lang.Exception {
		System.out.println("Entered here");
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor) session.getAttribute("doctor_details");
		Patient patient = (Patient) session.getAttribute("patient_details");
		int totalNumbers =  Integer.parseInt(request.getParameter("totalNumber"));
		List<PrescriptionDrugRel> prescriptionList = new ArrayList<PrescriptionDrugRel>();
		for (int index = 0 ; index <= totalNumbers; index++){
			PrescriptionDrugRel drugRel = new PrescriptionDrugRel();
			String drugId= request.getParameter("prescriptionDrugRel["+index+"].presDrugRelDrugId");
			String drugName= request.getParameter("prescriptionDrugRel["+index+"].presDrugRelDrugName");
			String dosage= request.getParameter("prescriptionDrugRel["+index+"].presDrugRelDosage");
			String frequency= request.getParameter("prescriptionDrugRel["+index+"].presDrugRelFrequency"); 
			System.out.println(drugId+"  "+drugName+"  "+ dosage+"  " + frequency);
			drugRel.setPresDrugRelDrugId(Integer.parseInt(drugId));
			drugRel.setPresDrugRelDosage(dosage);
			drugRel.setPresDrugRelFrequency(frequency);
			drugRel.setPresDrugRelStatus("To Deliver");
			drugRel.setPresDrugRelUpdatedby(doctor.getDoctorId());
			prescriptionList.add(drugRel);
		}
		doctorService.savePrescription(doctor, prescriptionList, patient);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("doctor/doctorpres");
		return mav;
	}


	@RequestMapping(value = "/deleteDoctor.html")
	public String deleteDoctor(@RequestParam("id") String id) throws java.lang.Exception {
		Doctor doctor = null;
		int maxResults;
		Doctor queryResult;
		int startResult;
		queryResult = null;
		startResult = -1;
		maxResults = -1;
		queryResult = doctorDAO.findDoctorByPrimaryKey(id, startResult, maxResults);
		doctor = queryResult;
		doctorService.deleteDoctor(doctor);
		return "redirect:/indexDoctor.html";
	}


	@RequestMapping(value = "/pages/doctor/index.jsp")
	String pagesdoctorindexjsp() {
		return "redirect:/indexDoctor.html";
	}

	
	

	
	public Logger getLogger() {
		return logger;
	}
}