package sales.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import sales.domain.model.ContactPerson;
import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.Event;
import sales.domain.model.Inquiry;
import sales.domain.model.Notification;
import sales.domain.service.SalesServiceImpl;
import sales.interfaces.SalesService;

@Controller
public class SalesController {
	
	private SalesService service;
	
	@Autowired
	public SalesController (SalesServiceImpl service) {
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
			List<Notification> notifs = service.getNotifications();
			if(notifs!=null){
				model.addAttribute("notifs", notifs);
				request.getSession().setAttribute("notifs", notifs);
				request.getSession().setAttribute("notifSize", notifs.size());
			}
			else{
				request.getSession().setAttribute("notifSize", 0);
			}
			return "index";
		}
		
		return "login";
	}
	
	@RequestMapping("/signIn")
	public String signIn(HttpServletRequest request, Model model){
		request.getSession().setAttribute("userid", "username");
		List<Notification> notifs = service.getNotifications();
		if(notifs!=null){
			model.addAttribute("notifs", notifs);
			request.getSession().setAttribute("notifs", notifs);
			request.getSession().setAttribute("notifSize", notifs.size());
		}
		else{
			request.getSession().setAttribute("notifSize", 0);
		}
		return "index";
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
				List<Notification> notifs = service.getNotifications();
				request.getSession().setAttribute("notifs", notifs);
				request.getSession().setAttribute("notifSize", notifs.size());
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
	public String showCharts(Model model){
		int ongoing = service.getLeadsByStatus("ONGOING").size();
		int success = service.getLeadsByStatus("SUCCESS").size();
		int discontinued = service.getLeadsByStatus("DISCONTINUED").size();
		int pending = service.getLeadsByStatus("PENDING").size();
		
		model.addAttribute("ongoing", ongoing);
		model.addAttribute("success", success);
		model.addAttribute("discontinued", discontinued);
		model.addAttribute("pending", pending);
		
		return "charts";
	}
	@RequestMapping("/LeadPage.html")
	public String showLeadPage(Model model){
		Collection<CustomerInquiry> ci = service.getAllCustomerInquiries();
		Collection<String> name = new ArrayList<String>();
		Collection<String> companyName = new ArrayList<String>();
		Collection<String> inquiry = new ArrayList<String>();
		Collection<String> subject = new ArrayList<String>();
		Collection<String> content = new ArrayList<String>();
		Collection<String> date = new ArrayList<String>();
		
		
		
		for(CustomerInquiry c : ci){

			companyName.add(c.getCustomer().getName());
			inquiry.add(c.getInquiry().getType());
			subject.add(c.getSubject());
			content.add(c.getMessage());
			date.add(new SimpleDateFormat("dd/MM/yyyy, HH:mm").format(c.getDate()));
		}
		
		model.addAttribute("size", date.size()-1);
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
		Collection<String> customerContactNumber = new ArrayList<String>();
		Collection<String> customerContactPerson = new ArrayList<String>();
		Collection<String> customerContactEmail = new ArrayList<String>();
		
		for(Customer c : customers){
			customerStrings.add(c.getName());
			
			StringBuilder emailStrings = new StringBuilder();
			StringBuilder numberStrings = new StringBuilder();
			StringBuilder nameStrings = new StringBuilder();
			
			Collection<ContactPerson> cp = service.getContactPersonsOf(c);
			
			for(ContactPerson person : cp){
				numberStrings.append("=" + person.getContactNumber());
				emailStrings.append("=" + person.getEmail());
				nameStrings.append("=" + person.getName());
			}
			
			customerContactNumber.add(numberStrings.toString());
			customerContactEmail.add(emailStrings.toString());
			customerContactPerson.add(nameStrings.toString());
		}
		
		
		Collection<CustomerClassification> customerClassifications = service.getAllCustomerClassifications();
		Collection<String> customerClassificationStrings = new ArrayList<String>();
		
		for(CustomerClassification c : customerClassifications){
			customerClassificationStrings.add(c.getName());
		}
		
		model.addAttribute("inquiryTypes", inquiryStrings);
		
		model.addAttribute("companyNames", customerStrings);
		//model.addAttribute("company", customers);
		
		model.addAttribute("customerClassifications", customerClassificationStrings);
		
		model.addAttribute("contactNumbers", customerContactNumber);
		model.addAttribute("contactPersons", customerContactPerson);
		model.addAttribute("contactEmails", customerContactEmail);
		model.addAttribute("size", customerStrings.size()-1);
		
		System.out.println(customerStrings.size()-1);
		return "manualInput";
	}

	@RequestMapping("/Manual-Input-Report.html")
	public String showInputReportPage(){
		return "manualInputReport";
	}
	
	@RequestMapping("/updateCustomer")
	public String updateCustomer(Model model, String editCustomerName, String editContactNumber, String editContactPerson, String editEmail, String editCustomerClassification){
		service.updateCustomer(editCustomerName, editContactNumber, editContactPerson, editEmail, editCustomerClassification);
		return "redirect:/showCustomers";
	}
		
	@RequestMapping("/projectTimeline")
	public String getTimeline(Model model, String date, String companyName, String inquiry, String subject, String content){
		CustomerInquiry customerInquiry = service.getCustomerInquiry(companyName, inquiry, subject, content);
		
		Collection<Event> events = service.getAllEventsOf(customerInquiry);
		
		String status = customerInquiry.getStatus().toString();
		model.addAttribute("status", status);
		
		
		ArrayList<String> contentList = new ArrayList<String>();
		ArrayList<String> titleList = new ArrayList<String>();
		ArrayList<String> dateList = new ArrayList<String>();
		for(Event e : events){
			contentList.add(e.getContent());
			titleList.add(e.getTitle());
			dateList.add(new SimpleDateFormat("dd/MM/yyyy").format(e.getDate()));
		}
		model.addAttribute("startDate", new SimpleDateFormat("dd/MM/yyyy").format(customerInquiry.getDate()));
		model.addAttribute("companyName", companyName);
		model.addAttribute("inquiry", inquiry);
		model.addAttribute("subject", subject);
		model.addAttribute("titles", titleList);
		model.addAttribute("contents", contentList);
		model.addAttribute("dates", dateList);
		model.addAttribute("size", events.size()-1);
		
		
		return "projectTimeline";
	}
	
	@RequestMapping("/createEvent")
	public String createEvent(Model model, String date, String companyName, String inquiry, String subject, String title, String update) throws ParseException{
		CustomerInquiry customerInquiry = service.getCustomerInquiry(companyName, inquiry, subject, "");
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date parsedDate = format.parse(date); 
		
		Event event = service.createEvent(title, update, parsedDate);
		service.appendEvent(customerInquiry, event);
		service.updateNotification(customerInquiry);
		/*
		Collection<Event> events = service.getAllEventsOf(customerInquiry);
		
		ArrayList<String> contentList = new ArrayList<String>();
		ArrayList<String> titleList = new ArrayList<String>();
		ArrayList<String> dateList = new ArrayList<String>();
		for(Event e : events){
			contentList.add(e.getContent());
			titleList.add(e.getTitle());
			dateList.add(new SimpleDateFormat("dd/MM/yyyy").format(e.getDate()));
		}
		
		model.addAttribute("startDate", new SimpleDateFormat("dd/MM/yyyy").format(customerInquiry.getDate()));
		model.addAttribute("companyName", companyName);
		model.addAttribute("inquiry", inquiry);
		model.addAttribute("subject", subject);
		model.addAttribute("titles", titleList);
		model.addAttribute("contents", contentList);
		model.addAttribute("dates", dateList);
		model.addAttribute("size", events.size()-1);*/
		
		String status = customerInquiry.getStatus().toString();
		model.addAttribute("status", status);
		
		return getTimeline(model, update, companyName, inquiry, subject, update); 
	}
	
	@RequestMapping("/customizeNotification")
	public String customizeNotification(Model model, String amount, String unit, String companyName, String inquiry, String subject){
		CustomerInquiry customerInquiry = service.getCustomerInquiry(companyName, inquiry, subject, "");
		service.customizeNotification(customerInquiry, amount, unit);
		
		Collection<Event> events = service.getAllEventsOf(customerInquiry);
		
		ArrayList<String> contentList = new ArrayList<String>();
		ArrayList<String> titleList = new ArrayList<String>();
		ArrayList<String> dateList = new ArrayList<String>();
		for(Event e : events){
			contentList.add(e.getContent());
			titleList.add(e.getTitle());
			dateList.add(new SimpleDateFormat("dd/MM/yyyy").format(e.getDate()));
		}
		model.addAttribute("startDate", new SimpleDateFormat("dd/MM/yyyy").format(customerInquiry.getDate()));
		model.addAttribute("companyName", companyName);
		model.addAttribute("inquiry", inquiry);
		model.addAttribute("subject", subject);
		model.addAttribute("titles", titleList);
		model.addAttribute("contents", contentList);
		model.addAttribute("dates", dateList);
		model.addAttribute("size", events.size()-1);
		
		String status = customerInquiry.getStatus().toString();
		model.addAttribute("status", status);
		
		return "projectTimeline";
	}
	
	@RequestMapping("/updateStatus")
	public String updateStatus(Model model, String status, String companyName, String inquiry, String subject){
		CustomerInquiry customerInquiry = service.getCustomerInquiry(companyName, inquiry, subject, "");
	
		service.updateLeadStatus(customerInquiry, status);
		
		Collection<Event> events = service.getAllEventsOf(customerInquiry);
		
		ArrayList<String> contentList = new ArrayList<String>();
		ArrayList<String> titleList = new ArrayList<String>();
		ArrayList<String> dateList = new ArrayList<String>();
		for(Event e : events){
			contentList.add(e.getContent());
			titleList.add(e.getTitle());
			dateList.add(new SimpleDateFormat("dd/MM/yyyy").format(e.getDate()));
		}
		model.addAttribute("startDate", new SimpleDateFormat("dd/MM/yyyy").format(customerInquiry.getDate()));
		model.addAttribute("companyName", companyName);
		model.addAttribute("inquiry", inquiry);
		model.addAttribute("subject", subject);
		model.addAttribute("titles", titleList);
		model.addAttribute("contents", contentList);
		model.addAttribute("dates", dateList);
		model.addAttribute("size", events.size()-1);
		
		model.addAttribute("status", status);
		
		return "projectTimeline";
	}
	
	@RequestMapping("/showCustomers")
	public String showCustomers(Model model){
		Collection<Customer> customers = service.getAllCustomers();
		
		ArrayList<String> customerNames = new ArrayList<String>();
		ArrayList<String> contactNames = new ArrayList<String>();
		ArrayList<String> emails = new ArrayList<String>();
		ArrayList<String> contactNumbers = new ArrayList<String>();
		ArrayList<String> companyTypes = new ArrayList<String>();
		
		for(Customer customer : customers){
			Collection<ContactPerson> contactPersons = service.getContactPersonsOf(customer);
			StringBuilder emailStrings = new StringBuilder();
			StringBuilder contactStrings = new StringBuilder();
			StringBuilder contactNumberStrings = new StringBuilder();
			for(ContactPerson cp : contactPersons){
				contactStrings.append(cp.getName()+"<br>");
				emailStrings.append(cp.getEmail()+"<br>");
				contactNumberStrings.append(cp.getContactNumber()+"<br>");
			}
			contactNumbers.add(contactNumberStrings.toString());
			contactNames.add(contactStrings.toString());
			emails.add(emailStrings.toString());
			customerNames.add(customer.getName());
			companyTypes.add(customer.getCustomerClassification().getName());
		}
		
		model.addAttribute("size", customers.size()-1);
		model.addAttribute("customers", customerNames);
		model.addAttribute("contactPersons", contactNames);
		model.addAttribute("emails", emails);
		model.addAttribute("contactNumbers", contactNumbers);
		model.addAttribute("companyTypes", companyTypes);
		
		return "customers";
	}

	@RequestMapping("/showCustomerHistory")
	public String showCustomerHistory(Model model, String company){
		Collection<CustomerInquiry> inquiries = service.getInquiriesByCustomer(company);
		
		Collection<String> inquiryType = new ArrayList<String>();
		Collection<String> date = new ArrayList<String>();
		Collection<String> subject = new ArrayList<String>();
		Collection<String> message = new ArrayList<String>();
		Collection<String> budget = new ArrayList<String>();
		Collection<String> rating = new ArrayList<String>();
		Collection<String> status = new ArrayList<String>();
		
		for(CustomerInquiry ci : inquiries){
			inquiryType.add(ci.getInquiry().getType());
			date.add(ci.getDate().toString());
			subject.add(ci.getSubject());
			message.add(ci.getMessage());
			budget.add(String.valueOf(ci.getBudget()));
			rating.add(String.valueOf(ci.getRating()));
			status.add(ci.getStatus().toString());
		}
		
		model.addAttribute("inquiryType", inquiryType);
		model.addAttribute("date", date);
		model.addAttribute("subject", subject);
		model.addAttribute("message", message);
		model.addAttribute("budget", budget);
		model.addAttribute("rating", rating);
		model.addAttribute("status", status);
		model.addAttribute("size", inquiryType.size()-1);
		
		return "customerDetails";
	}
	
	@RequestMapping("/addContact")
	public String addContact(Model model, String contactPersonName, String email, String contactNumber, String customer){
		service.addContactPersonToCustomer(service.findCustomer(customer), contactPersonName, email, contactNumber);
		return showCustomers(model);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String entityNotFound() {
		return "errors/notFound";
	}
}
