package kiost.study.service;

import org.springframework.ui.Model;

import kiosk.study.dao.ShowSeatTableDAO;

public class UserSeatSelectService{

	// 당일시간제 좌석 사용 확인
	public void seatPState(Model model){
		ShowSeatTableDAO dao = new ShowSeatTableDAO();
		model.addAttribute("seatState", dao.seatPState());
	}
	// 예약제 좌석 사용 확인
	public void seatRState(Model model){
		ShowSeatTableDAO dao = new ShowSeatTableDAO();
		model.addAttribute("seatState", dao.seatRState());
	}
	// 스터디 룸 좌석 사용 확인
	public void roomPState(Model model){
		ShowSeatTableDAO dao = new ShowSeatTableDAO();
		model.addAttribute("seatState", dao.roomPState());
	}
}
