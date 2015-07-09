package sales.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String showInputPage(){
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
