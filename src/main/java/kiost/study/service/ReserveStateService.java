package kiost.study.service;

import java.util.Map;

import org.springframework.ui.Model;

import kiosk.study.dao.ReserveDAO;
import kiosk.study.dao.StudyRoomDAO;

public class ReserveStateService {
	
	// 예약 당일 좌석값
	public void reserveToday(Model model) {
		Map<String, Object> map = model.asMap();
		String seatNum = (String) map.get("seatNum");
		String title = (String) map.get("title");
		
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
