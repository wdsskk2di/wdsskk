package kiosk.study.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

import kiosk.study.dto.studyDTO;

public class studyDAO {
	private JdbcTemplate template;
	public studyDAO() {this.template = Constant.template;}
	
	
	
	//사용자가 좌석 선택 ( seatNum) db 저장 #1
	public void statSeat(int seatNum) {
		try {
			String sql = "insert into kiosk_day(seatNum) values ("+seatNum+")";
			template.update(sql);
			System.out.println("정상 저장");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("저장 실패");
		}
	}
	//사용자가 시간선택, 시간가격값, 핸드폰번호  db저장
//	public int
	//사용자 결제 확인 페이지 출력 및 저장
	//관리자 결제확인 내역 저장
	//사용자 선택한 자리 정보 확인
	//사용하는 좌석에 대한 사용불가처리
	//당일사용좌석 사용중/사용완료 처리
	
	
	
	
	
	
	
	
	
	
	
	
	
	//당일 결제시 정보 저장
	public int updateSeat(studyDTO dto) {
		try {
			String sql = "update kiosk set timeNum='"+dto.getTimeNum()+"', peopleNum='"+dto.getPeopleNum()+
					"', totalmoney ='"+dto.getTotalMoney()+"', PhoneNum='"+dto.getPhoneNum()+
					"', startTime=to_char(sysdate, 'yy/MM/dd hh24:mi'), endTime=to_char(sysdate+"+dto.getTimeNum()+"/24, 'yy/mm/dd hh24:mi') "
					+ "where seatNum='"+dto.getSeatNum()+"'";
			template.update(sql);
			
			return 1;
		} catch (Exception e) {return 0;}
		/*
		sql에서 date 넣기. 예시
		create table test_time(stime varchar2(14), etime varchar2(14));

		insert into test_time VALUES(to_char(sysdate, 'yy/MM/dd hh:mi'),
									to_char(sysdate+1/24, 'yy/mm/dd hh:mi'));	+1/24는 1시간을 더한다는 의미
		
		결과 ==> stime=20/05/19 06:31 etime=20/05/19 07:31
		*/
	}
	
	//사용자가 선택한 자리 정보 확인
	public studyDTO checkSeatInfo(int seatNum) {
		String sql = "select * from kiosk where seatNum='"+seatNum+"'";
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<studyDTO>(studyDTO.class));
	}
	
	//당일 좌석 카테고리 선택 시(배치도 보여줄때마다 작동) 좌석 사용중인지 확인해서 시간 지난건 지우고, 시간 지나지 않은건 그대로..
	//select EndTIME from kiosk where EndTIME<to_char(sysdate, 'yy/MM/dd hh:mi');
	public void updateSeatInfo() {
		String sql ="update kiosk set timeNum = null, peopleNum = null, totalMoney = null, phoneNum = null, STARTTIME = null, EndTime = null "
				+ "where EndTIME < to_char(sysdate, 'yy/MM/dd hh:mi')";
		template.update(sql);
	}
	
	//(당일) 좌석에서 만일 사람이 있는 좌석을 선택했다면 결제창으로 넘어가지 못하게 하기 위한 sql문... -> 스터디룸과 예약좌석은 DB를 따로 둘거면 다른 메소드 생성 필요
	public int seatEmptyCheck(String seatNum) {		
		try {
			String sql = "select EndTIME from kiosk where seatNum='"+seatNum+"'";
			String result = template.queryForObject(sql, String.class);		//null이면 비어있는 자리. 값이 있으면 사용자가 있는 자리
			
			if(result.equals("null")) {
				return 0;
			}else {
				return 1;
			}			
		} catch (Exception e) {
			return 0;
		}		
	}
}
