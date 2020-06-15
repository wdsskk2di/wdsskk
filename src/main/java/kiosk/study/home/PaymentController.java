package kiosk.study.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.template.Constant;

import kiosk.study.dto.studyDTO;
import kiosk.study.service.dayTime.DayStudyPay;
import kiosk.study.service.dayTime.StudySeat;
import kiost.study.service.KioskService;
import kiost.study.service.ReserveStateService;
import kiost.study.service.reservePayUser.ReservePayUser;

@Controller
public class PaymentController {

	private KioskService ks;
	public DayStudyPay dsp = new DayStudyPay();
	public ReserveStateService rs = new ReserveStateService();
	public StudySeat ss = new StudySeat();
	
	public PaymentController() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		try {
			JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
			Constant.template = template;
		}finally {
			ctx.close();
		}
	}
	 
	//당일 (좌석,스터디룸) 사용자 정보 입력 페이지 
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
			model.addAttribute("seatNum", request.getParameter("seatNum"));

			//사용중인 좌석 확인
			if(num <= 20) {
				// 좌석 번호가 1~20 : 당일 시간제
				ss.seatEmptyCheck(model);
			}else {
				// 이외의 경우(당일 시간제와 스터디 룸으로 구분되어 있으므로)
				ss.seatEmptyCheckR(model);
			}
			
	
			if(title.equals("p") && num > 0 && num < 21) {  //당일 좌석 + 입력값이 1~20 사이				
				
				model.addAttribute("seatNum", num);
				
				// 좌석 선택시 값을  DB저장 
				dsp.daySeat_common(model);
				
				return "payment";	//결제 페이지로
				
			}else if(title.equals("s") && num > 40 && num < 44){ // 스터디룸 + 입력값이 41~43 사이				
				//스터디룸의 타임테이블				
				rs.reserveToday(model);		
				
				// 스터디룸과 예약제 시간 나눔 변경 수정중 
				
				
				
				
				
				
				
				
				
				
				
				
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

	/*
	 else if(title.equals("r") && num > 20 && num < 41){  //예약 좌석 + 입력값이21~40 사이				
		//이미 누군가 있다면 입력되지 않게 돌려야..
		ss.seatEmptyCheck(model);	
				
		model.addAttribute("seatNum", num);
		return "payment";	//결제 페이지로
				
	}
	 */
	
	//당일 좌석, 당일 스터디룸 결제
	@PostMapping("paymentCheck")
	public String paymenyCheck(Model model, studyDTO dto) {
		model.addAttribute("dto", dto);
		
		// 당일시간제 #2 사용자 입력값 처리 function
		dsp.daySeatSelect(model);
		
		// 당일시간제 #3 사용자 결제 고유값 생성 및 테이블 처리
		dsp.dayUser_unique(model);
		
		// 당일시간제 #4 사용자 결제창 확인용 + 좌석상태값 처리
		dsp.dayUser_final(model);
		
		
		// : 사용자 결제 내역 출력
		
		
		return "default/paymentSuccess";
	}
	
	//예약좌석, 예약 스터디룸 사용자 정보 입력 페이지
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
				rs.reserveToday(model);
				
				//좌석 번호
				model.addAttribute("seatNum", num);
				return "reservePayment";	//결제 페이지로
				
			}else if(title.equals("s") && num > 40 && num < 44){ // 스터디룸 + 입력값이 41~43 사이						
				//스터디룸의 타임테이블
				rs.reserveToday(model);		

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

	//예약, 스터디룸 사용자가 결정한 값을 test_reserve DB 연결해서 사용 시간값 update
	@PostMapping("reservePaymentChk")
	public String reservePaymentChk(studyDTO dto, Model model) {
		model.addAttribute("dto", dto);
		
		//타임 테이블 저장 -> 결제 담당 ReservePayUser 안으로 옮김
		//ks = new ReserveInfoUpdate();
		//ks.execute(model);
		
		////ReservePayUser: 예약 사용자 결제 값 저장
		ks = new ReservePayUser();
		ks.execute(model);
				
		return "default/paymentSuccess";
	}
}
