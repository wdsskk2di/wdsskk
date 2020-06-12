package kiost.study.service.manageService;

import org.springframework.ui.Model;

import kiosk.study.dao.ManagerDAO;

public class TotalManager implements Manager {

	@Override
	public void execute(Model model) {
		ManagerDAO dao = new ManagerDAO();
		model.addAttribute("month_total", dao.month_total());
	}

}
