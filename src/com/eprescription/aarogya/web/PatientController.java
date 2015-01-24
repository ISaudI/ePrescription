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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.eprescription.aarogya.domain.Patient;
import com.eprescription.aarogya.service.PatientService;

@Scope("singleton")
@Controller("patientController")
public class PatientController {
	
private static final String BIND_PATTERN_SUFFIX = "_datebindpattern";

	
	private transient Logger logger = LoggerFactory.getLogger(getClass());

	
	@Resource(name = "patientService")
	protected PatientService patientService;

	
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

	
	@RequestMapping(value = "/selectPatient.html")
	public ModelAndView selectPatient(@RequestParam("arogyaId") String arogyaId, HttpSession session) throws java.lang.Exception {
		logger.info("entering into selectPatient()");
		Patient patient = null;
		Patient queryResult;
		queryResult = patientService.getPatientDetailsByArogyaId(arogyaId);
		patient = queryResult;
		ModelAndView mav = new ModelAndView();
		session.setAttribute("patient_details", patient);
		mav.addObject("patient", patient);
		mav.setViewName("patient/ajaxViewPatient");
		return mav;
	}
	

}
