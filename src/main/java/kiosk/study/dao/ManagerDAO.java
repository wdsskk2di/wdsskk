package kiosk.study.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

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
}
