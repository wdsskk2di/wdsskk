package kiosk.study.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

import kiosk.study.dto.ShowReserveDTO;
import kiosk.study.dto.studyDTO;

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
	
	public void ReserveInfoUpdate(studyDTO dto) {
		int timeNum = dto.getTimeNum();	//사용시간
		int startTime = Integer.parseInt(dto.getStartTime());	//시작 시간
		int endTime = Integer.parseInt(dto.getEndTime());	//종료 시간
		String sql = null;
		
		if(timeNum==1) {
			sql ="update test_Reserve set p"+startTime+"="+startTime+", p"+endTime+"="+endTime+
					" where seatNum="+dto.getSeatNum()+" and reDate='"+dto.getRoomReserveDate()+"'";
		}else if(timeNum==2) {
			sql ="update test_Reserve set p"+startTime+"="+startTime+", p"+(startTime+1)+"="+(startTime+1)+
					", p"+endTime+"="+endTime+
					" where seatNum="+dto.getSeatNum()+" and reDate='"+dto.getRoomReserveDate()+"'";
		}else if(timeNum==3) {
			sql ="update test_Reserve set p"+startTime+"="+startTime+", p"+(startTime+1)+"="+(startTime+1)+", p"+(startTime+2)+"="+(startTime+2)+
					", p"+endTime+"="+endTime+
					" where seatNum="+dto.getSeatNum()+" and reDate='"+dto.getRoomReserveDate()+"'";
		}else if(timeNum==4) {
			sql ="update test_Reserve set p"+startTime+"="+startTime+", p"+(startTime+1)+"="+(startTime+1)+", p"+(startTime+2)+"="+(startTime+2)+
					", p"+(startTime+3)+"="+(startTime+3)+", p"+endTime+"="+endTime+
					" where seatNum="+dto.getSeatNum()+" and reDate='"+dto.getRoomReserveDate()+"'";
		}
		template.update(sql);
	}

}
