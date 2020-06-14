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

	// (당일) 좌석에서 만일 사람이 있는 좌석을 선택했다면 결제창으로 넘어가지 못하게 하기 위한 sql문... -> 스터디룸과 예약좌석은 DB를
	// 따로 둘거면 다른 메소드 생성 필요
	public int seatEmptyCheck(String seatNum) {
		try {
			String sql = "select EndTIME from SHOWTODAYSTUDYSEAT where seatNum='" + seatNum + "'";
			String result = template.queryForObject(sql, String.class); // null이면 비어있는 자리. 값이 있으면 사용자가 있는 자리

			if (result.equals("null")) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

}
