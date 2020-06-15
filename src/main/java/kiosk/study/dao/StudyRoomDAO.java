package kiosk.study.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

public class StudyRoomDAO {
	private JdbcTemplate template;
	public StudyRoomDAO() {this.template = Constant.template;}
	
	
}
