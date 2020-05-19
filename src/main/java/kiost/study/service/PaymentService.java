package kiost.study.service;

import java.util.Map;

import org.springframework.ui.Model;

import kiosk.study.dao.studyDAO;
import kiosk.study.dto.studyDTO;

public class PaymentService implements KioskService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	//model.asMap() == model을 map형태로 변환
		studyDTO dto = (studyDTO)map.get("dto");
		
		//정보입력
		studyDAO dao = new studyDAO();
		int result = dao.updateSeat(dto);
		
		//입력된 정보 가져오기
		if(result == 1) {
			dto = dao.checkSeatInfo(dto.getSeatNum());
			model.addAttribute("dto", dto);
		}else {model.addAttribute("result", "fail");}
	}

}
