package sales.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sales.domain.model.Inquiry;
import sales.domain.service.SalesService;

@Controller
public class SalesController {
	
	private SalesService service;
	
	@Autowired
	public SalesController (SalesService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	@RequestMapping("/index.html")
	public String showIndexAlternate() {
		return "index";
	}
	@RequestMapping("/Charts.html")
	public String showCharts(){
		return "charts";
	}
	@RequestMapping("/LeadPage.html")
	public String showLeadPage(){
		return "leadPage";
	}
	@RequestMapping("/Manual-Input.html")
	public String showInputPage(Model model){
//		List<String> inquiryTypes = new ArrayList<String>(); //= service.getInquiryTypes();
//		
//		inquiryTypes.add("Training");
//		inquiryTypes.add("Development");
		
		List<String> inquiryTypes = service.getInquiryTypes();
		
		model.addAttribute("inquiryTypes", inquiryTypes);
		return "manualInput";
	}

	@RequestMapping("/Manual-Input-Report.html")
	public String showInputReportPage(){
		return "manualInputReport";
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String entityNotFound() {
		return "errors/notFound";
	}
	
}
