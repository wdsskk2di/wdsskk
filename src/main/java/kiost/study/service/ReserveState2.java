package kiost.study.service;

import java.util.Map;

import org.springframework.ui.Model;

import kiosk.study.dao.ReserveDAO;

public class ReserveState2 implements KioskService {

	@Override
	public void execute(Model model) {		
		Map<String, Object> map = model.asMap();
		String seatNum = (String) map.get("seatNum");

		ReserveDAO dao = new ReserveDAO();
		model.addAttribute("reState", dao.checkTmrReserveInfo(seatNum));
		
	}

}
