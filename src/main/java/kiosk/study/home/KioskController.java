package kiosk.study.home;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KioskController {
	
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("chooseSeatNum")
	public String chooseSeatNum() {
		return "chooseSeatNum";
	}
	
	@RequestMapping("payment")
	public String payment(HttpServletRequest request, HttpServletResponse response){
		//입력값 없을때
		if(request.getParameter("setNum")=="") {
			return "redirect:chooseSeatNum";
			
		}else {	//입력값이 있고
			int num = Integer.parseInt(request.getParameter("setNum"));		
			
			if(num > 0 && num < 44) {  //입력값이 1~43 사이
				return "payment";	//결제 페이지로
				
			}else {//입력값이 0이거나 43보다 큰 경우
				try {
					//알림창
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('좌석 번호는 1 ~ 43번까지 입니다.');</script>");
					
					//좌석 선택창으로
					return "redirect:chooseSeatNum";
				} catch (Exception e) {return "redirect:chooseSeatNum";}

			}
		}


	}
}
