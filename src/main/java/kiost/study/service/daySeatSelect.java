package kiost.study.service;

import java.util.Map;


import org.springframework.ui.Model;

import kiosk.study.dao.studyDAO;
import kiosk.study.dto.studyDTO;

public class daySeatSelect implements KioskService{
// #2 당일 시간제 결제 정보 저장
	
	// DAO 생성자 사용	
	public studyDAO dao = new studyDAO();
	
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		studyDTO dto = (studyDTO)map.get("dto");
		// model 값 받아오기 위해서 두줄 사용

		dao.daySeatSelect(dto);				// dto(좌석번호, 시간, 가격, 핸드폰)을 DB에 저장
	}
	
	public void copyTable() {
		dao.moveTable();
	}

}
