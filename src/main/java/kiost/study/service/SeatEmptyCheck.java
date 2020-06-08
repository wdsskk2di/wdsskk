package kiost.study.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kiosk.study.dao.studyDAO;

public class SeatEmptyCheck implements KioskService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String seatNum = request.getParameter("seatNum");
		
		studyDAO dao = new studyDAO();
		
		if(dao.seatEmptyCheck(seatNum)==0) {
			model.addAttribute("result", 0);
		}else {
			model.addAttribute("result", 1);
		} 
		
	}

}
