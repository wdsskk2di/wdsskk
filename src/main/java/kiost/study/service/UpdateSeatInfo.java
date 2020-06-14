package kiost.study.service;

import org.springframework.ui.Model;

import kiosk.study.dao.studySeatDAO;

public class UpdateSeatInfo implements KioskService {

	@Override
	public void execute(Model model) {
		studySeatDAO dao = new studySeatDAO();
		dao.updateSeatInfo();
	}

}
