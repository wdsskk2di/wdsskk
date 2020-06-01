package kiosk.study.home;

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

@Controller
public class ManagerController {
	
	private Manager mn;
	
	public ManagerController() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		Constant.template = template;
	}
	
	@RequestMapping("seatManage")
	public String seatManage() {
		return "manage/seatManage";
	}
	
	@RequestMapping("reserveManage")
	public String reserveManage() {
		return "manage/reserveManage";
	}
	
	@RequestMapping("totalManage")
	public String totalManage() {
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
