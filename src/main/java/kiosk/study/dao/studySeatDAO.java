package kiosk.study.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

public class studySeatDAO {
	private JdbcTemplate template;

	public studySeatDAO() {
		this.template = Constant.template;
	}

	// 당일 좌석 카테고리 선택 시(배치도 보여줄때마다 작동)
	//// sql문 수정. 기존 sql은 좌석번호 기준으로 partition되어 날짜가 다양하면 값을 가지고 오지 못했음. PARTITION BY
	// seatNum => PARTITION BY todate
	public void updateSeatInfo() {
		// todaytotalSeat에 기록된 목록에서 오늘 날짜로 좌석의 가장 최근 시간값을 가져와서 showtodaystudyseat에
		// update.
		String updateSeatInfo = "update SHOWTODAYSTUDYSEAT set showtodaystudyseat.endtime =( "
				+ "SELECT  TS.endtime FROM( "
				+ "SELECT ROW_NUMBER() OVER(PARTITION BY todaytotalSeat.seatNum ORDER BY todaytotalSeat.ENDTIME DESC ) AS RNUM, todaytotalSeat.* "
				+ "FROM todaytotalSeat ) TS WHERE RNUM = 1 and todate=(to_char(sysdate,'yyyy/mm/dd')) and seatNum = showtodaystudyseat.seatnum)";

		// 만일 showtodaystudyseat의 endtime이 사용자가 페이지에 접속한 시간보다 전이라면 사용이 끝난 것이므로 null로
		// 바꿔준다
		String resetSeatInfo = "update SHOWTODAYSTUDYSEAT set endtime = null where endtime<to_char(sysdate,'hh24:mi:ss')";

		template.update(updateSeatInfo);
		template.update(resetSeatInfo);
	}

}
