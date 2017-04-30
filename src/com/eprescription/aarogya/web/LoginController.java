package com.eprescription.aarogya.web;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Enumeration;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.eprescription.aarogya.dao.DoctorDAO;
import com.eprescription.aarogya.domain.Doctor;
import com.eprescription.aarogya.domain.Patient;
import com.eprescription.aarogya.domain.PharmacyStaff;
import com.eprescription.aarogya.web.model.ChemistSearch;
import com.eprescription.aarogya.web.model.Login;

@Scope("singleton")
@Controller("LoginController")
public class LoginController {
	
	private static final String BIND_PATTERN_SUFFIX = "_datebindpattern";
	private transient Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "doctorDAO")
	protected DoctorDAO doctorDAO;

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


	@RequestMapping(value = "/Login.html")
	public ModelAndView newLogin(HttpServletRequest request) throws java.lang.Exception {
		
		/*HttpSession session  = request.getSession();
		session.setAttribute("loggedIn", "failure");
		//session.invalidate();*/
		Login login = null;
		login = new Login();
		ModelAndView mav = new ModelAndView();
		mav.addObject("login", login);
		mav.setViewName("login/login");
		return mav;
	}
	
	@RequestMapping(value = "/verifyLogin.html")
	public String verifyLogin(@ModelAttribute("login") Login login, HttpServletRequest request, Model model ) throws java.lang.Exception {
		logger.info("Entering into Login for "+login.getAu360Id());
		HttpSession session  = request.getSession();
		session.setAttribute("loggedIn", "success");
		if ("doctor".equalsIgnoreCase(login.getRole())){
			Doctor doctor  = doctorDAO.findDoctorByLoginCredentils(login.getAu360Id(), login.getPassword());
			if ( doctor != null){
				request.getSession().setAttribute("doctor_details", doctor);
				request.getSession().setAttribute("role", "Doctor");
				model.addAttribute("doctorsession", doctor);
				return "redirect:/doctorLogin.html";
			}
		}else if ("patient".equalsIgnoreCase(login.getRole())) {
			Patient patient = doctorDAO.findPatientByLoginCredentils(login.getAu360Id(), login.getPassword());
			if (patient != null){
				request.getSession().setAttribute("patient_details", patient);
				request.getSession().setAttribute("role", "Patient");
				return "redirect:/indexPrescriptionByPatientId.html?patientId="+patient.getPatientId()+"&";
			}
		}else{
			PharmacyStaff pharmacyStaff = doctorDAO.findChemistByLoginCredentils(login.getAu360Id(), login.getPassword());
			if (pharmacyStaff != null){
				request.getSession().setAttribute("chemist_details", pharmacyStaff);
				request.getSession().setAttribute("role", "Chemist");
				return "redirect:/successfulChemistLogin.html";
			}
		}
		model.addAttribute("message", "Invalid Login");
		
		return "redirect:/Login.html";
	}
	
	@RequestMapping(value = "/successfulChemistLogin.html")
	public ModelAndView chemistSearch() throws java.lang.Exception {
		ChemistSearch chemistSearch = null;
		chemistSearch = new ChemistSearch();
		ModelAndView mav = new ModelAndView();
		mav.addObject("chemistSearch", chemistSearch);
		mav.setViewName("chemist/chemistsearch");
		return mav;
	}

}
