package kiost.study.service;

import java.util.Map;


import org.springframework.ui.Model;

import kiosk.study.dao.studyDAO;
import kiosk.study.dto.studyDTO;

public class daySeatManage implements KioskService{
// #2 당일 시간제 결제 정보 저장
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		studyDTO dto = (studyDTO)map.get("dto");
		// model 값 받아오기 위해서 두줄 사용
		
		studyDAO dao = new studyDAO();
		// DAO 생성자 사용		
		/*
		dao.daySelectUser(dto.getSeatNum());*/
		// 저장된  DB를 dto에 저장하고 그 값을 출력
		model.addAttribute("dto",dao.daySelectUser(dto.getSeatNum()));
		
		System.out.println("dto.title :" +dto.getTitle());
		System.out.println("dto.seatNum :" +dto.getSeatNum());
		System.out.println("dto.TimeNum :" +dto.getTimeNum());
		System.out.println("dto.PeopleNum :" +dto.getPeopleNum());
		System.out.println("dto.TotalMoney :" +dto.getTotalMoney());
		System.out.println("dto.PhoneNum :" +dto.getPhoneNum());
		System.out.println("dto.StartTime :" +dto.getStartTime());
		System.out.println("dto.EndTime :" +dto.getEndTime());
		
		
	}

}