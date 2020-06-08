package kiost.study.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import kiosk.study.dao.ShowSeatTableDAO;
import kiosk.study.dto.ShowSeatTableDTO;

public class UserSeatSelectService{

	// 당일시간제 좌석 사용 확인
	public void seatPState(Model model){
		ShowSeatTableDAO dao = new ShowSeatTableDAO();
		ArrayList<ShowSeatTableDTO> listResult = dao.seatPState();
		model.addAttribute("seatState", listResult);
		
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
