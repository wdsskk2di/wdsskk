package kiosk.study.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

import kiosk.study.dto.ShowSeatTableDTO;

public class ShowSeatTableDAO {
	private JdbcTemplate template;
	public ShowSeatTableDAO() {this.template = Constant.template;}
	
	//당일좌석 현재 배치도 확인
	public ArrayList<ShowSeatTableDTO> seatPState() {	
		ArrayList<ShowSeatTableDTO> list = null;
		try {
			String sql = "select seatNum, toDate, endTime from todaytotalSeat where seatNum <21 order by seatNum asc";
//			String sql = "select seatNum, phoneNum, endTime from study_TimeSet where seatNum<21 order by seatNum asc";
			list = (ArrayList<ShowSeatTableDTO>)template.query(sql, new BeanPropertyRowMapper<ShowSeatTableDTO>(ShowSeatTableDTO.class));
		} catch (Exception e) {}	
		
		return list;
	}

	//스터디룸 현재 배치도 확인
	public ArrayList<ShowSeatTableDTO> roomPState() {	
		ArrayList<ShowSeatTableDTO> list = null;
		try {
			String sql = "select seatNum, phoneNum, endTime from kiosk where seatNum>40 order by seatNum asc";
			list = (ArrayList<ShowSeatTableDTO>)template.query(sql, new BeanPropertyRowMapper<ShowSeatTableDTO>(ShowSeatTableDTO.class));
		} catch (Exception e) {}	
		
		return list;
	}

	//예약좌석 현재 배치도 확인
	public ArrayList<ShowSeatTableDTO> seatRState() {	
		ArrayList<ShowSeatTableDTO> list = null;
		try {
			String sql = "select seatNum, phoneNum, endTime from kiosk where seatNum>20 and seatNum<41 order by seatNum asc";
			list = (ArrayList<ShowSeatTableDTO>)template.query(sql, new BeanPropertyRowMapper<ShowSeatTableDTO>(ShowSeatTableDTO.class));
		} catch (Exception e) {}	
		
		return list;
	}

}
