package kiosk.study.home;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.care.template.Constant;
import kiost.study.service.KioskService;
import kiost.study.service.UpdateSeatInfo;
//import kiost.study.service.UserSeatSelectService;
// ***   Service 의 간편성을 높이기 위해서  implement받지 않음   *** //
import kiost.study.service.UserSeatSelectService;

@Controller
public class KioskController {

	private KioskService ks;
	public UserSeatSelectService us = new UserSeatSelectService();

	public KioskController() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		Constant.template = template;
	}

	//메인 페이지
	@RequestMapping("/")
	public String home() {
		return "default/main";
	}
	@RequestMapping("main")
	public String main(HttpServletRequest request, Model model) {
		return "default/main";
	}

	//스터디룸 당일, 예약 선택 페이지
	@RequestMapping("studyRoom")
	public String studyRoom(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		model.addAttribute("title", title);
		return "default/studyRoom";
	}

	//당일 좌석, 당일 스터디룸 좌석 번호 선택 페이지
	@RequestMapping("chooseSeatNum")
	public String chooseSeatNum(HttpServletRequest request, Model model) {
		model.addAttribute("title", request.getParameter("title"));
		ks = new UpdateSeatInfo();
		ks.execute(model);
		
		if(request.getParameter("title").equals("p")) {
			//당일좌석 사용자 유무
			us.seatPState(model);
		}else {
			//스터디룸 사용자 유무
			us.roomPState(model);
		}

		return "chooseSeatNum";
	}

	//예약 좌석, 예약 스터디룸 좌석 번호 선택 페이지
	@RequestMapping("reserve")
	public String reserve(HttpServletRequest request, Model model) {
		model.addAttribute("title", request.getParameter("title"));
		ks = new UpdateSeatInfo();
		ks.execute(model);

		if(request.getParameter("title").equals("r")) {
			//예약좌석 사용자 유무
			us.seatRState(model);
		}else {
			//스터디룸 사용자 유무
			us.roomPState(model);
		}

		return "reserve";
	}

	//예약 확인 페이지
	@RequestMapping("reserveChk")
	public String reserveChk(HttpServletRequest request, Model model) {
		model.addAttribute("title", request.getParameter("title"));
		return "reserveJSP/reserveChk";
	}
	
	//예약 내역 DB연동 결과 리스트
	@RequestMapping("reserveChkList")
	public String reserveChkList(HttpServletRequest request, Model model) {
		model.addAttribute("title", request.getParameter("title"));
		return "reserveJSP/reserveChkList";
	}
	
	//예약 내역 자세히
	@RequestMapping("reserveChkResult")
	public String reserveChkResult(HttpServletRequest request, Model model) {
		model.addAttribute("title", request.getParameter("title"));
		return "reserveJSP/reserveChkResult";
	}

}
