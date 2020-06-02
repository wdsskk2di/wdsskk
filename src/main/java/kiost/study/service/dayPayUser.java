package kiost.study.service;

import java.util.Map;


import org.springframework.ui.Model;

import kiosk.study.dao.studyDAO;
import kiosk.study.dto.studyDTO;

public class dayPayUser implements KioskService{
// #2 당일 시간제 결제 정보 저장
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		studyDTO dto = (studyDTO)map.get("dto");
		// model 값 받아오기 위해서 두줄 사용
		
		studyDAO dao = new studyDAO();
		// DAO 생성자 사용		
		
		// dto(좌석번호, 시간, 가격, 핸드폰)을 DB에 저장
		dao.daySeatSelect(dto);
//		System.out.println("daySeatSelect[Table] 저장 완료 : 좌석번호, 시간, 가격, 핸드폰");
		
		dao.dayPayUser(dto);
//		System.out.println("uniqueUser값 추가 완료");
		
		dao.deleteBeforeInfo();
//		System.out.println("사용자 1차 입력란 삭제 완료");
		
		dao.manageCopy(dto);
//		System.out.println("시간설정값 추가 및 관리용으로 값을 넘겨줌");
		
		// 삭제 하기 전에  result페이지에서  unique코드값을 불러와서  dto에 저장하고 이것을 비교해서 값 추출후에 삭제해야됨
		
		dao.deleteBeforeInfo2();
//		System.out.println("결제 내역에 대한 모든 입력값들 삭제 완료");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void consol(Model model) {
		Map<String, Object> map = model.asMap();
		studyDTO dto = (studyDTO)map.get("dto");
		// model 값 받아오기 위해서 두줄 사용
		
		studyDAO dao = new studyDAO();
		// DAO 생성자 사용	
		/*
		dao.daySelectUser(dto.getSeatNum());
		// 저장된  DB를 dto에 저장하고 그 값을 출력
		model.addAttribute("dto",dao.daySelectUser(dto.getSeatNum()));
		*/
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
