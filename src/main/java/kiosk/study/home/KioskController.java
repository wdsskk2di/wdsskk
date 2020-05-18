package kiosk.study.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KioskController {
	
	@RequestMapping("chooseSeatNum")
	public String chooseSeatNum() {
		return "chooseSeatNum";
	}
	
	@RequestMapping("payment")
	public String payment() {
		return "payment";
	}
}
