package kiosk.study.home;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.template.Constant;

import kiost.study.service.KioskService;
import kiost.study.service.ReserveState;
import kiost.study.service.ReserveState2;

@Controller
public class TimeTableController {
	
	private KioskService ks;
	
	public TimeTableController() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		Constant.template = template;
	}

	@GetMapping(value="reserveTomorrow", produces = "application/json;charset=utf8")
	public String reserveTomorrow(@RequestParam("seatNum") String seatNum, Model model) {		
		model.addAttribute("seatNum", seatNum);
		//스터디룸의 타임테이블
		ks = new ReserveState2();
		ks.execute(model);	
	
		return "showTimeTable";
	}
	
	@GetMapping(value="reserveToday", produces = "application/json;charset=utf8")
	public String reserveToday(@RequestParam("seatNum") String seatNum, Model model) {
		model.addAttribute("seatNum", seatNum);

		//스터디룸의 타임테이블
		ks = new ReserveState();
		ks.execute(model);	
	
		return "showTimeTable";
	}
}
