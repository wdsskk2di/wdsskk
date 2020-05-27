package kiosk.study.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {
	
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
}
