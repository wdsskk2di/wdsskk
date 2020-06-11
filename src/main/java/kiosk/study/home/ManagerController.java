package kiosk.study.home;

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
			mn = new ReserveManager();
			mn.execute(model);
		}
		
		return "manage/reserveManage";
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
