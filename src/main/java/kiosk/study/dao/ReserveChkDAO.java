package kiosk.study.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

import kiosk.study.dto.ShowSeatTableDTO;

public class ReserveChkDAO {

	private JdbcTemplate template;
	public ReserveChkDAO() {this.template = Constant.template;}
	
	//예약 목록 뽑기
	public ArrayList<ShowSeatTableDTO> reserveChk_list(String phoneNum) {
		ArrayList<ShowSeatTableDTO> list = null;
		
		try {
			String sql = "select seatNum, todate, startTime, endTime, timeNum from STUDY_TIMESET " + 
					"	where PHONENUM='"+phoneNum+"' and todate>=(to_char(sysdate, 'yyyy/mm/dd'))";
			list = (ArrayList<ShowSeatTableDTO>)template.query(sql, new BeanPropertyRowMapper<ShowSeatTableDTO>(ShowSeatTableDTO.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
}
