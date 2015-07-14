package sales.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sales.domain.service.SalesService;

@Controller
public class ManualInputController {

	private SalesService service;
	
	@Autowired
	public ManualInputController(SalesService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/addInquiry", method = RequestMethod.POST)
	public String addInquiry(Model model, String newInquiryType) {
		service.createInquiry(newInquiryType);
		System.out.println(newInquiryType);
		return "redirect:/Manual-Input.html";
	}
	
}
