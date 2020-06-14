package kiosk.study.CheckService;

import org.springframework.ui.Model;
import kiosk.study.dao.studySeatDAO;

public class UpdateSeatInfo {
	
	public void UpdateSeatInfo(Model model) {
		studySeatDAO dao = new studySeatDAO();
		dao.updateSeatInfo();
	}

}
