package kiosk.study.service.dayTime;

import java.util.Map;


import org.springframework.ui.Model;

import kiosk.study.dao.studyDAO;
import kiosk.study.dto.studyDTO;
import kiost.study.service.KioskService;

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

		final String getUniqueUser = dao.getUniqueUser();
		System.out.println("#6 결제된 코드 값 : "+getUniqueUser);

		dao.deleteBeforeInfo2();
//		System.out.println("결제 내역에 대한 모든 입력값들 삭제 완료");

		// dto에 TimeSet 테이블 값들 집어넣어줌
		model.addAttribute("dto",dao.daySelectUser(getUniqueUser));
		
//위치 몰라서 테스트 위해 개인 추가 . KioskController -> dayPayUser -> studyDAO
		dao.todaytotalSeat_Insert();
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
