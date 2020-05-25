package kiosk.study.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.template.Constant;

import kiosk.study.dto.studyDTO;
import kiost.study.service.KioskService;
import kiost.study.service.PaymentService;
import kiost.study.service.ReserveState;
import kiost.study.service.ReserveState2;
import kiost.study.service.SeatEmptyCheck;
import kiost.study.service.UpdateSeatInfo;
import kiost.study.service.roomPState;
import kiost.study.service.seatRState;

@Controller
public class KioskController {
	
	private KioskService ks;
	
	public KioskController() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		Constant.template = template;
	}
	
	@RequestMapping("main")
	public String main() {
		return "default/main";
	}
	
	@RequestMapping("studyRoom")
	public String studyRoom(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		model.addAttribute("title", title);
		return "default/studyRoom";
	}
	
	@RequestMapping("chooseSeatNum")
	public String chooseSeatNum(HttpServletRequest request, Model model) {
		model.addAttribute("title", request.getParameter("title"));
		ks = new UpdateSeatInfo();
		ks.execute(model);
		
		if(request.getParameter("title").equals("p")) { //당일좌석 사용자 유무
			//ks = new seatPState();
			//ks.execute(model);
		}else {//스터디룸 사용자 유무
			//ks = new roomPState();
			//ks.execute(model);
		}
		
		return "chooseSeatNum";
	}
	
	@RequestMapping("reserve")
	public String reserve(HttpServletRequest request, Model model) {
		model.addAttribute("title", request.getParameter("title"));
		ks = new UpdateSeatInfo();
		ks.execute(model);
		
		if(request.getParameter("title").equals("r")) { //예약좌석 사용자 유무
			ks = new seatRState();
			ks.execute(model);
		}else {//스터디룸 사용자 유무
			ks = new roomPState();
			ks.execute(model);
		}
		
		return "reserve";
	}
	
	@RequestMapping("payment")
	public String payment(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		String title = request.getParameter("title");
		model.addAttribute("title", title);

		//입력값 없을때
		if(request.getParameter("seatNum")=="") {
			return "redirect:chooseSeatNum";
			
		}else {	//입력값이 있고
			int num = Integer.parseInt(request.getParameter("seatNum"));		
			
			if(title.equals("p") && num > 0 && num < 21) {  //당일 좌석 + 입력값이 1~20 사이				
				//이미 누군가 있다면 입력되지 않게 돌려야..
				ks = new SeatEmptyCheck();
				ks.execute(model);		
				
				model.addAttribute("seatNum", num);
				return "payment";	//결제 페이지로
				
			}else if(title.equals("r") && num > 20 && num < 41){  //예약 좌석 + 입력값이21~40 사이				
				//이미 누군가 있다면 입력되지 않게 돌려야..
				ks = new SeatEmptyCheck();
				ks.execute(model);	
				
				model.addAttribute("seatNum", num);
				return "payment";	//결제 페이지로
				
			}else if(title.equals("s") && num > 40 && num < 44){ // 스터디룸 + 입력값이 41~43 사이				
				//이미 누군가 있다면 입력되지 않게 돌려야..
				ks = new SeatEmptyCheck();
				ks.execute(model);	
				
				//스터디룸의 타임테이블
				ks = new ReserveState();
				ks.execute(model);	
				
				model.addAttribute("seatNum", num);
				return "payment";	//결제 페이지로
				
			}else {//입력된 좌석에 문제가 있는 경우
				try {
					//좌석 선택창으로
					return "redirect:chooseSeatNum";
				} catch (Exception e) {return "redirect:chooseSeatNum";}

			}
		}

	}
	
	@PostMapping("paymentCheck")
	public String paymenyCheck(Model model, studyDTO dto) {
		model.addAttribute("dto", dto);
		ks = new PaymentService();
		ks.execute(model);
		
		return "default/paymentSuccess";
	}
	
	@RequestMapping("reservePayment")
	public String reservePayment(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String title = request.getParameter("title");
		model.addAttribute("title", title);

		//입력값 없을때
		if(request.getParameter("seatNum")=="") {
			return "redirect:reserve";
			
		}else {	//입력값이 있고
			int num = Integer.parseInt(request.getParameter("seatNum"));	
			model.addAttribute("seatNum", request.getParameter("seatNum"));
			
			if(title.equals("r") && num > 20 && num < 41){  //예약 좌석 + 입력값이21~40 사이		
				//스터디룸의 타임테이블
				ks = new ReserveState();
				ks.execute(model);	
				
				//좌석 번호
				model.addAttribute("seatNum", num);
				return "reservePayment";	//결제 페이지로
				
			}else if(title.equals("s") && num > 40 && num < 44){ // 스터디룸 + 입력값이 41~43 사이						
				//스터디룸의 타임테이블
				ks = new ReserveState();
				ks.execute(model);			

				model.addAttribute("seatNum", num);
				return "reservePayment";	//결제 페이지로
				
			}else {//입력된 좌석에 문제가 있는 경우
				try {
					//좌석 선택창으로
					return "redirect:reserve";
				} catch (Exception e) {return "redirect:reserve";}
			}
		}
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
