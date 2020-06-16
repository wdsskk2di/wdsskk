package kiost.study.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kiosk.study.dao.ReserveDAO;
import kiosk.study.dao.StudyRoomDAO;

public class ReserveStateService {
	
	/*
	public Map<String, Object> map;
	
	// #1 사용자 좌석 선택 : 통계치
		public void daySeat_common(Model model) {
			map = model.asMap();
			HttpServletRequest request = (HttpServletRequest)map.get("request");
			// model 값 받아오기 위해서 두줄 사용

			int seatNum = Integer.parseInt(request.getParameter("seatNum"));
	 
			// 좌석 선택 값을 DB에 저장
			dao.statSeat(seatNum);
		}
		*/
	
	// 예약 당일 좌석값
	public void reserveToday(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String seatNum = request.getParameter("seatNum");
		String title = request.getParameter("title");
		
		ReserveDAO daoRs = new ReserveDAO();
		StudyRoomDAO daoRo = new StudyRoomDAO();
		if(title.equals("r")) {
			model.addAttribute("reState", daoRs.checkReserveInfo(seatNum));
		}else {
			// 변경사항 수정중 #2 : studyRoom 당일 좌석 예약 하는 경우 
			System.out.println("studyRomm 당일 좌석 예약 #1");
			
			model.addAttribute("reState", daoRo.checkStudyRoomInfo(seatNum));
			
		}
	}
	
	// 예약 다음날 좌석값
	public void reserveNextday(Model model) {		
		Map<String, Object> map = model.asMap();
		String seatNum = (String) map.get("seatNum");
		String title = (String) map.get("title");
 
		ReserveDAO daoRs = new ReserveDAO();
		StudyRoomDAO daoRo = new StudyRoomDAO();
		if(title.equals("r")) {
			model.addAttribute("reState", daoRs.checkTmrReserveInfo(seatNum));
		}else {
			model.addAttribute("reState", daoRo.checkTmrStudyRoomInfo(seatNum));
		}
	}


}
