package kiosk.study.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

import kiosk.study.dto.ShowReserveDTO;
import kiosk.study.dto.ShowSeatTableDTO;

public class ManagerDAO {
	private JdbcTemplate template;
	public ManagerDAO() {this.template = Constant.template;}
	
	public String managerLogin(String mID, String mPW) {
		try {
			String sql = "select id from KIOSKMANAGERINFO where id='"+mID+"' and pw='"+mPW+"'";
			return template.queryForObject(sql, String.class);
		} catch (Exception e) {
			return "null";
		}

	}
	
	//당일좌석 현재 배치도 확인
	public ArrayList<ShowSeatTableDTO> seatPState() {	
		ArrayList<ShowSeatTableDTO> list = null;
		try {
			String sql = "select seatNum, endTime from showtodaystudyseat order by seatNum asc";
			//String sql = "select seatNum, phoneNum, endTime from kiosk where seatNum<21 order by seatNum asc";
			list = (ArrayList<ShowSeatTableDTO>)template.query(sql, new BeanPropertyRowMapper<ShowSeatTableDTO>(ShowSeatTableDTO.class));
		} catch (Exception e) {}
		return list;
	}
	
	//예약 사용자에게 예약 좌석들의 현재 좌석 사용 상태 보여주기 위한 update
	public void reserveTable_Update() {
		Date date = new Date();
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH");	
		String conTime = sdfTime.format(date);
		
		String sql_notNull = "update TEST_RESERVE set NULLCHK=p"+conTime+" where p"+conTime+" is not null and redate=(to_char(sysdate, 'yyyy/mm/dd'))";
		String sql_Null = "update TEST_RESERVE set NULLCHK=p"+conTime+" where p"+conTime+" is null and redate=(to_char(sysdate, 'yyyy/mm/dd'))";
		template.update(sql_notNull);
		template.update(sql_Null);
	}
	
	//스터디룸 사용자에게 스터디룸 좌석들의 현재 좌석 사용 상태 보여주기 위한 update
	public void studyRoomTable_Update() {
		Date date = new Date();
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH");	
		String conTime = sdfTime.format(date);
		
		String sql_notNull = "update test_studyRoom set NULLCHK=p"+conTime+" where p"+conTime+" is not null and redate=(to_char(sysdate, 'yyyy/mm/dd'))";
		String sql_Null = "update test_studyRoom set NULLCHK=p"+conTime+" where p"+conTime+" is null and redate=(to_char(sysdate, 'yyyy/mm/dd'))";
		template.update(sql_notNull);
		template.update(sql_Null);
	}
	
	public ArrayList<ShowReserveDTO> roomPStateM() {
		ArrayList<ShowReserveDTO> list = null;
		try {
			Date date = new Date();
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH");	
			
			String sql = "select seatNum, p"+sdfTime.format(date)+", (select endtime from RESERVE_TIMESET where UNIQUEUSER = tr.NULLCHK) as endtime " + 
					"from test_studyroom tr where redate=(to_char(sysdate, 'yyyy/mm/dd')) order by seatNum asc";
			list = (ArrayList<ShowReserveDTO>)template.query(sql, new BeanPropertyRowMapper<ShowReserveDTO>(ShowReserveDTO.class));
		} catch (Exception e) {}

		return list;
	}
	
	//예약좌석 현재 배치도 확인
		public ArrayList<ShowReserveDTO> seatRStateM() {
			ArrayList<ShowReserveDTO> list = null;
			try {
				Date date = new Date();
				SimpleDateFormat sdfTime = new SimpleDateFormat("HH");		
				
				String sql =  "select seatNum, p"+sdfTime.format(date)+", (select endtime from RESERVE_TIMESET where UNIQUEUSER = tr.NULLCHK) as endtime " + 
						"from test_reserve tr where redate=(to_char(sysdate, 'yyyy/mm/dd')) order by seatNum asc";
				list = (ArrayList<ShowReserveDTO>)template.query(sql, new BeanPropertyRowMapper<ShowReserveDTO>(ShowReserveDTO.class));
			} catch (Exception e) {}

			return list;
		}
}
