package kiosk.study.service.dayTime;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kiosk.study.dao.studySeatDAO;
import kiosk.study.dto.studyDTO;

public class StudySeat {
	// 좌석은 sql문이 update되므로, pulblic으로 빼면 오류 발생하고 메소드를 부를때마다 새로 생성해 줘야 오류가 발생하지 않음.

	public Map<String, Object> map;
	public studyDTO dto;
	
	public void seatEmptyCheck(Model model) {
		map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		studySeatDAO dao = new studySeatDAO();
		
		if(dao.seatEmptyCheck(request.getParameter("seatNum"))==0) {
			model.addAttribute("result", 0);
		}else {
			model.addAttribute("result", 1);
		} 
	}
	public void UpdateSeatInfo(Model model) {
		// 당일 좌석 좌석 확인 구현하기
		studySeatDAO dao = new studySeatDAO();
		dao.updateSeatInfo();
	}
}
