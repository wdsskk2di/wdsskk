package kiosk.study.service.dayTime;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kiosk.study.dao.studySeatDAO;
import kiosk.study.dto.studyDTO;

public class StudySeat {

	public studySeatDAO dao = new studySeatDAO();
	public Map<String, Object> map;
	public studyDTO dto;
	
	public void seatEmptyCheck(Model model) {
		map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		if(dao.seatEmptyCheck(request.getParameter("seatNum"))==0) {
			model.addAttribute("result", 0);
		}else {
			model.addAttribute("result", 1);
		} 
	}
}
