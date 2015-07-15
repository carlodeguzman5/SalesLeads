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
	
	
	
}
