package kiosk.study.service.dayTime;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import kiosk.study.dao.studyDAO;
import kiost.study.service.KioskService;

public class StudyStateService implements KioskService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		// model 값 받아오기 위해서 두줄 사용

		studyDAO dao = new studyDAO();
		// DAO 생성자 사용

		int seatNum = Integer.parseInt(request.getParameter("seatNum"));
 
		// 좌석 선택 값을 DB에 저장
		dao.statSeat(seatNum);

	}

}
