package kiost.study.service;

import java.util.Map;


import org.springframework.ui.Model;

import kiosk.study.dao.studyDAO;
import kiosk.study.dto.studyDTO;

public class daySeatSelect implements KioskService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		studyDTO dto = (studyDTO)map.get("dto");
		// model 값 받아오기 위해서 두줄 사용
		
		studyDAO dao = new studyDAO();
		// DAO 생성자 사용		
		
		// dto(좌석번호, 시간, 가격, 핸드폰)을 DB에 저장
		dao.daySeatSelect(dto);
		
		
	}

}
