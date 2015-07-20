package sales.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
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
	public String showIndex(Model model) {
		model.addAttribute("result", "valid");
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model, String username, String password){
		String validate = service.validateUser(username, password);
		
		model.addAttribute("result", validate);
		
		if(validate.equals("valid")){
			request.getSession().setAttribute("userid", username);
			return "index";
		}
		
		return "login";
	}
	
	@RequestMapping("/signup.html")
	public String signUp(Model model){
		model.addAttribute("result", "valid");
		return "signup";
	}
	
	@RequestMapping("/processSignUp")
	public String processSignUp(HttpServletRequest request, Model model, String username, String password, String confirm_password){
		String result;
		if(!password.equals(confirm_password)){
			result = "Password does not match. Try again.";
		}
		else{
			if(service.validateUser(username, password).equals("Username does not exist!")){
				service.createUser(username, password);
				request.getSession().setAttribute("userid", username);
				return "index";
			}
			else{
				result = "Username already exists";
			}
		}
		model.addAttribute("result", result);
		return "signup";	
	}
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request){
		model.addAttribute("result", "valid");
		request.getSession().removeAttribute("userid");
		return "login";
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
	public String showLeadPage(Model model){
		;
		
		Collection<CustomerInquiry> ci = service.getAllCustomerInquiries();
		Collection<String> name = new ArrayList<String>();
		Collection<String> companyName = new ArrayList<String>();
		Collection<String> inquiry = new ArrayList<String>();
		Collection<String> subject = new ArrayList<String>();
		Collection<String> content = new ArrayList<String>();
		Collection<String> date = new ArrayList<String>();
		
		for(CustomerInquiry c : ci){
			name.add(c.getCustomer().getContactPerson());
			companyName.add(c.getCustomer().getName());
			inquiry.add(c.getInquiry().getType());
			subject.add(c.getSubject());
			content.add(c.getMessage());
			date.add(new SimpleDateFormat("dd/MM/yyyy, HH:mm").format(c.getDate()));
		}
		
		model.addAttribute("size", name.size()-1);
		model.addAttribute("names", name);
		model.addAttribute("companyNames", companyName);
		model.addAttribute("inquiries", inquiry);
		model.addAttribute("subjects", subject);
		model.addAttribute("contents", content);
		model.addAttribute("dates", date);
		
		return "leadPage";
		
	}
	@RequestMapping("/Manual-Input.html")
	public String showInputPage(Model model){
		Collection<Inquiry> inquiryTypes = service.getAllInquiries();
		Collection<String> inquiryStrings = new ArrayList<String>();
		for(Inquiry i : inquiryTypes){
			inquiryStrings.add(i.getType());
		}
		
		Collection<Customer> customers = service.getAllCustomers();
		Collection<String> customerStrings = new ArrayList<String>();
		
		for(Customer c : customers){
			customerStrings.add(c.getName());
		}
		
		Collection<CustomerClassification> customerClassifications = service.getAllCustomerClassifications();
		Collection<String> customerClassificationStrings = new ArrayList<String>();
		
		for(CustomerClassification c : customerClassifications){
			customerClassificationStrings.add(c.getName());
		}
		
		model.addAttribute("inquiryTypes", inquiryStrings);
		
		model.addAttribute("companyNames", customerStrings);
		
		model.addAttribute("customerClassifications", customerClassificationStrings);
		
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
