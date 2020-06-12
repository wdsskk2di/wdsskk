package kiost.study.service.manageService;

import java.util.ArrayList;

import org.springframework.ui.Model;

import kiosk.study.dao.ManagerDAO;

public class TotalManager implements Manager {

	@Override
	public void execute(Model model) {
		ManagerDAO dao = new ManagerDAO();
		ArrayList<String> day = dao.month_total_D();
		ArrayList<String> reserve = dao.month_total_R();
		
		ArrayList<Integer>  month_total = new ArrayList<Integer>();
 		
		for(int i = 0 ;i<day.size() ; i++) {
			int a = Integer.parseInt(day.get(i));
			int b = Integer.parseInt(reserve.get(i));
			
			month_total.add(a+b);
		}
		
		model.addAttribute("month_total", month_total);

	}

}
