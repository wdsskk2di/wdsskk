package kiosk.study.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

import kiosk.study.dto.ShowReserveDTO;

public class ReserveDAO {
	private JdbcTemplate template;
	public ReserveDAO() {this.template = Constant.template;}
	
	
	//사용자가 선택한 자리 예약 정보 확인
	public ShowReserveDTO checkReserveInfo(String seatNum) {
		String sql = "select * from test_reserve where seatNum='"+seatNum+"'";
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<ShowReserveDTO>(ShowReserveDTO.class));
	}
}
