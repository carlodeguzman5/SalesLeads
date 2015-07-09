package sales.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import sales.domain.service.SalesService;

@Controller
public class SalesController {
	
//	private SalesApplicationService rewardService;
//
//	@Autowired
//	public RewardController(RewardsApplicationService rewardService) {
//		this.rewardService = rewardService;
//	}

//	private SalesService service;
//	
//	@Autowired
//	public SalesController (SalesService service) {
//		this.service = service;
//	}
	
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String entityNotFound() {
		return "errors/notFound";
	}
	
}
