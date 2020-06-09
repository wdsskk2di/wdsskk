package kiost.study.service;

import java.util.Map;

import org.springframework.ui.Model;

import kiosk.study.dao.ReserveDAO;
import kiosk.study.dto.studyDTO;

public class ReserveInfoUpdate implements KioskService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		studyDTO dto = (studyDTO) map.get("dto");
		
		//reserve_Payment 정보 기준 타임 테이블 업데이트
		ReserveDAO dao = new ReserveDAO();
		dao.ReserveInfoUpdate(dto);
	}

}
