package kiost.study.service;

import org.springframework.ui.Model;

import kiosk.study.dao.studyDAO;

public class roomPState implements KioskService {

	@Override
	public void execute(Model model) {
		studyDAO dao = new studyDAO();
		model.addAttribute("seatState", dao.roomPState());
	}

}
