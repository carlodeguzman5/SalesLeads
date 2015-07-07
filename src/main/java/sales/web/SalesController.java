package sales.web;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SalesController {
	
	//private SalesApplicationService rewardService;

	/*@Autowired
	public RewardController(RewardsApplicationService rewardService) {
		this.rewardService = rewardService;
	}*/

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String entityNotFound() {
		return "errors/notFound";
	}
	
}
