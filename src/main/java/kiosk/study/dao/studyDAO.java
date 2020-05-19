package kiosk.study.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

public class studyDAO {
	private JdbcTemplate template;
	public studyDAO() {this.template = Constant.template;}
}
