package kiosk.study.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

import kiosk.study.dto.ShowReserveDTO;

public class ReserveDAO {
	private JdbcTemplate template;
	public ReserveDAO() {this.template = Constant.template;}
	
	//test_reserve에 내일날짜 DB없을 시 insert하는 sql문
	public void timeTable_Date_Chk() {
		String sql = "select COUNT(*) from test_reserve where redate=(to_char(sysdate+1, 'yyyy/MM/dd'))";
		int result = template.queryForObject(sql, Integer.class);

		if(result == 0) {
			sql = "BEGIN\n" + 
					"  FOR i IN 21..43 LOOP\n" + 
					"       insert into TEST_RESERVE VALUES(i, to_char(sysdate+1, 'yyyy/MM/dd'), null, null, null, null, null, null, null);\n" + 
					"      END LOOP;\n" + 
					"END;";
			template.update(sql);
		}
	}
	
	//사용자가 선택한 자리 오늘 예약 정보 확인
	public ShowReserveDTO checkReserveInfo(String seatNum) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String sql = "select * from test_reserve where seatNum='"+seatNum+"' and reDate='"+sdf.format(date)+"'";
		return template.queryForObject(sql, new BeanPropertyRowMapper<ShowReserveDTO>(ShowReserveDTO.class));
	}
	 
	//사용자가 선택한 자리 내일 예약 정보 확인
	public ShowReserveDTO checkTmrReserveInfo(String seatNum) {
		 DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
	     final Calendar cal = Calendar.getInstance();
	     cal.add(Calendar.DATE, 1);
	     String tDate = dtf.format(cal.getTime());	

		String sql = "select * from test_reserve where seatNum='"+seatNum+"' and reDate='"+tDate+"'";
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<ShowReserveDTO>(ShowReserveDTO.class));
	}

}
