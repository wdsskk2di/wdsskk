package kiost.study.service.manageService;

import java.util.ArrayList;

import org.springframework.ui.Model;

import kiosk.study.dao.ManagerDAO;

public class TotalManager implements Manager {

	@Override
	public void execute(Model model) {
		ManagerDAO dao = new ManagerDAO();
		//일간 매출
		ArrayList<String> day =  dao.day_total();
		int day_R = Integer.parseInt(day.get(1));
		int day_S = Integer.parseInt(day.get(2));
		
		model.addAttribute("day_D", day.get(0));
		model.addAttribute("day_R", day_R);
		model.addAttribute("day_S", day_S);
		model.addAttribute("day_T", day_R+day_S);
		
		//월간 매출
		ArrayList<String> month_day = dao.month_total_D();
		model.addAttribute("month_D", month_day);
		
		ArrayList<String> month_reserve = dao.month_total_R();
		model.addAttribute("month_R", month_reserve);
		
		ArrayList<Integer>  month_total = new ArrayList<Integer>();
 		
		for(int i = 0 ;i<month_day.size() ; i++) {
			int a = Integer.parseInt(month_day.get(i));
			int b = Integer.parseInt(month_reserve.get(i));
			
			month_total.add(a+b);
		}
		
		model.addAttribute("month_total", month_total);

	}

}
