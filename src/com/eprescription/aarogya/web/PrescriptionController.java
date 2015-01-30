package com.eprescription.aarogya.web;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

import com.eprescription.aarogya.dao.PrescriptionDrugDAO;
import com.eprescription.aarogya.domain.PrescriptionDrugRel;
import com.eprescription.aarogya.service.PrescriptionService;
import com.eprescription.aarogya.web.model.ChemistSearch;
import com.eprescription.aarogya.web.model.PrescriptionDrugRelWebModel;


@Scope("singleton")
@Controller("prescriptionController")
public class PrescriptionController {
	
private static final String BIND_PATTERN_SUFFIX = "_datebindpattern";

	
	private transient Logger logger = LoggerFactory.getLogger(getClass());

	
	@Resource(name = "prescriptionDrugDAO")
	protected PrescriptionDrugDAO prescriptionDrugDAO;

	@Resource(name = "prescriptionService")
	protected PrescriptionService prescriptionService;

	
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

	@RequestMapping(value = "/indexPrescriptionDrugRel.html")
	public ModelAndView listPrescriptionDrugRels(@RequestParam("upnNumber") String upnNumber) throws java.lang.Exception {
		List<PrescriptionDrugRelWebModel> prescriptiondrugrels = prescriptionService.getDrugsInPrescription(upnNumber);
		logger.info("Exiting from the service method listPrescriptionDrugRels()");
		ModelAndView mav = new ModelAndView();
		mav.addObject("prescriptiondrugrels", prescriptiondrugrels);
		mav.setViewName("prescriptiondrugrel/listPrescriptionDrugRels");
		return mav;
	}
	
	@RequestMapping(value = "/indexPrescriptionByPatientId.html")
	public ModelAndView listPrescriptionsByPatientId(@RequestParam("patientId") Integer patientId) throws java.lang.Exception {
		List<PrescriptionDrugRel> prescriptions = prescriptionService.getPatientPrescriptions(patientId);
		System.out.println(prescriptions.get(0));
		logger.info("Exiting from the service method listPrescriptionDrugRels()");
		ModelAndView mav = new ModelAndView();
		mav.addObject("prescriptions", prescriptions);
		mav.setViewName("prescriptiondrugrel/listPrescriptions");
		return mav;
	}
	
	@RequestMapping(value = "/indexPrescriptionByDoctorId.html")
	public ModelAndView listPrescriptionsByDoctorId(@RequestParam("doctorId") Integer doctorId) throws java.lang.Exception {
		List<PrescriptionDrugRel> prescriptions = prescriptionService.getDoctorPrescriptions(doctorId);
		logger.info("Exiting from the service method listPrescriptionDrugRels() no of prescriptions "+prescriptions.size());
		System.out.println("Exiting from the service method listPrescriptionDrugRels() no of prescriptions "+prescriptions.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("prescriptions", prescriptions);
		mav.setViewName("prescriptiondrugrel/listPrescriptions");
		return mav;
	}
	
	@RequestMapping(value = "/prescriptionDetails.html")
	public ModelAndView getPrescriptiondetails(@ModelAttribute ChemistSearch chemistSearch,
			            HttpServletRequest request) throws java.lang.Exception {
		String upnNumber = chemistSearch.getUpn();
		String auid = chemistSearch.getAu360id();
		System.out.println("Pawan "+upnNumber+"   "+auid);
		List<PrescriptionDrugRelWebModel> prescriptiondrugrels = prescriptionDrugDAO.
				getPrescriptionDetailsByUPNandAUID(upnNumber, auid);
		logger.info("Exiting from the service method getPrescriptiondetails()");
		ModelAndView mav = new ModelAndView();
		request.setAttribute("upnNumber", upnNumber);
		request.setAttribute("auid", auid);
		mav.addObject("prescriptiondrugrels", prescriptiondrugrels);
		mav.setViewName("prescriptiondrugrel/listPrescriptionDrugRels");
		return mav;
	}
	@RequestMapping(value = "/prescriptionStatusChange.html")
	public ModelAndView prescriptionStatusChange(@RequestParam("drugPresId") String drugPresIdList,
			@RequestParam("upnNumber") String upnNumber,
			@RequestParam("auid") String auid, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		prescriptionService.updatePresDrugDetails(drugPresIdList, upnNumber, auid);
		List<PrescriptionDrugRelWebModel> prescriptiondrugrels = prescriptionDrugDAO.
				getPrescriptionDetailsByUPNandAUID(upnNumber, auid);
		request.setAttribute("upnNumber", upnNumber);
		request.setAttribute("auid", auid);
		mav.addObject("prescriptiondrugrels", prescriptiondrugrels);
		mav.setViewName("prescriptiondrugrel/listPrescriptionDrugRels");
		return mav;
	}

}
