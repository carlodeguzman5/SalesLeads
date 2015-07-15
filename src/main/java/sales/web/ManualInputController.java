package sales.web;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.service.SalesService;
import sales.interfaces.SalesServiceFacade;

@Controller
public class ManualInputController {

	protected SalesServiceFacade service;
	
	@Autowired
	public ManualInputController(SalesService service) {
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
	public String addNewManualInput(Model model, String oldInquiryType, String customerName, String customerNameInput, String contactNumber, String contactPerson, 
			String email, String customerClassification, String subject, String text){
		String name = customerName;
		System.out.println("customerClassification" + customerClassification);
		System.out.println("name" + name);
		
		if(!customerName.equals("old")){
			CustomerClassification classification = service.findCustomerClassification(customerClassification);
			service.createCustomer(customerNameInput, contactPerson, email, contactNumber, classification);
			name=customerNameInput;
		}
		service.createCustomerInquiry(service.findCustomer(name), service.findInquiry(oldInquiryType), subject, text);
		return "redirect:/Manual-Input.html";
	}
	
	@RequestMapping(value="/addCustomerClassification", method = RequestMethod.POST)
	public String addCustomerClassification (Model model, String newCustomerClassification){
		service.createCustomerClassification(newCustomerClassification);
		return "redirect:/Manual-Input.html";
	}
	
}
