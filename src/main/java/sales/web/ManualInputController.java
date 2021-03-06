package sales.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.Inquiry;
import sales.domain.service.SalesServiceImpl;
import sales.infrastructure.jpa.NoExistingInquiryException;
import sales.interfaces.SalesService;

@Controller
public class ManualInputController {

	protected SalesService service;
	
	@Autowired
	public ManualInputController(SalesServiceImpl service) {
		this.service = service;
	}
	
	@RequestMapping(value="/addInquiry", method = RequestMethod.POST)
	public String addInquiry(Model model, String newInquiryType) {
		service.createInquiry(newInquiryType);
		return "redirect:/Manual-Input.html";
	}
	
	@RequestMapping(value="/findCustomer", method = RequestMethod.POST)
	public String findCustomer(Model model, String name){
		if(service.findCustomer(name)!=null){
			model.addAttribute("isExisting", true);
		}
		else {
			model.addAttribute("isExisting", false);
		}
		return "redirect:/Manual-Input.html";
	}
	
	@RequestMapping(value="/addNewManualInput", method = RequestMethod.POST)
	public String addNewManualInput(Model model, String oldInquiryType, String customerName, String subject, String text) throws NoExistingInquiryException{
		Customer customer = service.findCustomer(customerName);
		Inquiry inquiry = service.findInquiry(oldInquiryType);
		service.createCustomerInquiry(customer, inquiry, subject, text);
		return "redirect:/LeadPage.html";
	}
	
	@RequestMapping(value="/addCustomerClassification", method = RequestMethod.POST)
	public String addCustomerClassification (Model model, String newCustomerClassification){
		service.createCustomerClassification(newCustomerClassification);
		return "redirect:/Manual-Input.html";
	}
	
	@RequestMapping(value="/addCustomer", method = RequestMethod.POST)
	public String addCustomer(String customerName, String contactNumber, String contactPerson, String email, String customerClassification){
		CustomerClassification cc = service.findCustomerClassification(customerClassification);
		try{
			service.createCustomer(customerName, contactPerson, email, contactNumber, cc );
		}
		catch(NullPointerException e){
			return "errors/notFound";
		}
		
		return "redirect:/showCustomers";
	}
	
	@RequestMapping(value="/editContact", method=RequestMethod.POST)
	public String editContactPerson(String editContactPersonName, String customerName, String editEmail, String contactEmail, String editContactNumber, String oldContactNumber){
		service.editContactPerson(customerName, editContactPersonName, contactEmail, oldContactNumber, editEmail, editContactNumber);
		return "redirect:/showCustomers";
	}
}
