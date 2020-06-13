package kiosk.study.home;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.template.Constant;

import kiost.study.service.manageService.Manager;
import kiost.study.service.manageService.ManagerLogin;
import kiost.study.service.manageService.ReserveManager;
import kiost.study.service.manageService.SeatManager;
import kiost.study.service.manageService.TotalManager;

@Controller
public class ManagerController {
	
	private Manager mn;
	
	public ManagerController() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		try {
			JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
			Constant.template = template;
		}finally {
			ctx.close();
		}
	}
	
	@RequestMapping("seatManage")
	public String seatManage(HttpSession session, Model model) {
		String LoginID = (String) session.getAttribute("LoginID");
		
		if(LoginID != null) {
			mn = new SeatManager();
			mn.execute(model);
		}
		
		return "manage/seatManage";
	}
	
	@RequestMapping("reserveManage")
	public String reserveManage(HttpSession session, Model model) {
		String LoginID = (String) session.getAttribute("LoginID");
		
		
		if(LoginID != null) {
			Date date = new Date();
			SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd");	
			String reDate = sdfTime.format(date);
			
			model.addAttribute("reDate", reDate);
			model.addAttribute("Contact", 1);

			mn = new ReserveManager();
			mn.execute(model);
		}
		
		return "manage/reserveManage";
	}
	
	@RequestMapping(value="select_reserveTable", produces = "application/json;charset=utf8")
	public String select_reserveTable(@RequestParam("searchDate") String searchDate, Model model) {
		
		String date = searchDate.replace("-", "/");
		model.addAttribute("reDate", date);
		model.addAttribute("Contact", 2);
		
		mn = new ReserveManager();
		mn.execute(model);

		return "manage/showReserveTable";
	}
	
	@RequestMapping(value="select_studyTable", produces = "application/json;charset=utf8")
	public String select_study(@RequestParam("searchDate") String searchDate, Model model) {
		
		String date = searchDate.replace("-", "/");
		model.addAttribute("reDate", date);
		model.addAttribute("Contact", 3);
		
		mn = new ReserveManager();
		mn.execute(model);

		return "manage/showStudyRTable";
	}
	
	@RequestMapping("totalManage")
	public String totalManage(HttpSession session, Model model) {
		String LoginID = (String) session.getAttribute("LoginID");
		
		if(LoginID != null) {
			mn = new TotalManager();
			mn.execute(model);
		}
		
		return "manage/totalManage";
	}
	
	//로그인
	@PostMapping("ManagerLoginResult")
	public String ManagerLoginResult(@RequestParam("mID") String mID, @RequestParam("mPW") String mPW, Model model) {
		model.addAttribute("mID", mID);
		model.addAttribute("mPW", mPW);
		
		mn = new ManagerLogin();
		mn.execute(model);
		
		return "manage/ManagerLoginResult";
	}
	
	//로그아웃
	@RequestMapping("ManagerLogoutResult")
	public String ManagerLogoutResult() {
		return "manage/ManagerLogoutResult";
	}

}
