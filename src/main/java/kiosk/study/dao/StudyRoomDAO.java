package kiosk.study.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.template.Constant;

import kiosk.study.dto.ShowReserveDTO;
import kiosk.study.dto.studyDTO;

public class StudyRoomDAO {
	private JdbcTemplate template;
	public StudyRoomDAO() {this.template = Constant.template;}
	
	// 사용자가 선택한 자리 오늘 스터디룸 정보 확인
	public ShowReserveDTO checkStudyRoomInfo(String seatNum) {
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			String sql = "select * from test_studyroom where seatNum='" + seatNum + "' and reDate='" + sdf.format(date)+ "'";
			System.out.println("StudyRoomDAO : 당일 스터디룸 좌석 예약 #2");
			
			return template.queryForObject(sql, new BeanPropertyRowMapper<ShowReserveDTO>(ShowReserveDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("StudyRoomDAO: 오늘 날짜 타임 테이블 연결 실패 #2");
			return null;
		}

	}

	// 사용자가 선택한 자리 내일 스터디룸 정보 확인
	public ShowReserveDTO checkTmrStudyRoomInfo(String seatNum) {
		try {
			DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
			final Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			String tDate = dtf.format(cal.getTime());

			String sql = "select * from test_studyroom where seatNum='" + seatNum + "' and reDate='" + tDate + "'";

			return template.queryForObject(sql, new BeanPropertyRowMapper<ShowReserveDTO>(ShowReserveDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ReserveDAO: 내일 날짜 타임 테이블 연결 실패");
			return null;
		}
	}

//////////////////////////////////사용자 결제 정보 저장 -> 화면 출력	///////////////////////////////////////////
//사용자 입력값 + 고유코드값 추가
	public void reservePayUser(final studyDTO dto) {
		try {
			String sql = "insert into STUDY_RESULTSET(seatNum, timeNum, totalMoney, peopleNum, phoneNum, uniqueUser)"
					+ "values (" + dto.getSeatNum() + ", " + dto.getTimeNum() + ", " + dto.getTotalMoney() + ", "
					+ dto.getPeopleNum() + ", " + dto.getPhoneNum() + ", (to_char(sysdate,'yymmddhh24miss')))";

			template.update(sql);
			System.out.println("STUDY_RESULTSET에 사용자 결제 값 저장 성공 #3");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("STUDY_RESULTSET에 사용자 결제 값 저장 실패 #3");
		}
	}

	// study_resultSet >> RESERVE_TIMESET 으로 내용값 복사하고 시간 값 추가
	public void manageCopy(final studyDTO dto) {
		try {
			String sql = "insert into RESERVE_TIMESET(seatNum, timeNum, TotalMoney, phoneNum, uniqueUser, toDate, reDate, startTime, endTime, PeopleNum) "
					+ "select seatNum, timeNum, TotalMoney, phoneNum, uniqueUser, to_char(sysdate,'yyyy/mm/dd'), '"
					+ dto.getReDate() + "', '" + dto.getStartTime() + ":00:00', '" + dto.getEndTime()
					+ ":00:00', peopleNum " + "from study_resultSet";
			template.update(sql);
			System.out.println("RESERVE_TIMESET에 시간 복사 성공 #4");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("RESERVE_TIMESET에 시간 복사 실패 #4");
		}
	}

	// study_resultSet에서 결제코드값 가져옴
	public String getUniqueUser() {
		try {
			String sql = "select uniqueUser from study_resultSet";
			System.out.println("STUDY_RESULTSET에 uniqueUser값 추출 성공 #5");

			return template.queryForObject(sql, String.class);

		} catch (final DataAccessException e) {
			e.printStackTrace();
			System.out.println("STUDY_RESULTSET에 uniqueUser값 추출 실패 #5");
			return "-1";
		}
	}

////스터디룸 타임 테이블에 update 
	public void studyInfoUpdate(studyDTO dto, String getUniqueUser) {
		int timeNum = dto.getTimeNum(); // 사용시간
		int startTime = Integer.parseInt(dto.getStartTime()); // 시작 시간
		int endTime = Integer.parseInt(dto.getEndTime()); // 종료 시간
		String sql=null;

		try {
			if (timeNum == 1) {
				if (endTime == 22) {
					sql = "update test_studyroom set p" + startTime + "=" + dto.getStartTime() + " where seatNum="
							+ dto.getSeatNum() + " and reDate='" + dto.getReDate() + "'";
				} else {
					sql = "update test_studyroom set p" + startTime + "=" + dto.getStartTime() + ", p" + endTime + "="
							+ getUniqueUser + " where seatNum=" + dto.getSeatNum() + " and reDate='" + dto.getReDate()
							+ "'";
				}
			} else if (timeNum == 2) {
				if (endTime == 22) {
					sql = "update test_studyroom set p" + startTime + "=" + getUniqueUser + ", p" + (startTime + 1)
							+ "=" + getUniqueUser + " where seatNum=" + dto.getSeatNum() + " and reDate='"
							+ dto.getReDate() + "'";
				} else {
					sql = "update test_studyroom set p" + startTime + "=" + getUniqueUser + ", p" + (startTime + 1)
							+ "=" + getUniqueUser + ", p" + endTime + "=" + getUniqueUser + " where seatNum="
							+ dto.getSeatNum() + " and reDate='" + dto.getReDate() + "'";
				}
			} else if (timeNum == 3) {
				if (endTime == 22) {
					sql = "update test_studyroom set p" + startTime + "=" + getUniqueUser + ", p" + (startTime + 1)
							+ "=" + getUniqueUser + ", p" + (startTime + 2) + "=" + getUniqueUser + " where seatNum="
							+ dto.getSeatNum() + " and reDate='" + dto.getReDate() + "'";
				} else {
					sql = "update test_studyroom set p" + startTime + "=" + getUniqueUser + ", p" + (startTime + 1)
							+ "=" + getUniqueUser + ", p" + (startTime + 2) + "=" + getUniqueUser + ", p" + endTime
							+ "=" + getUniqueUser + " where seatNum=" + dto.getSeatNum() + " and reDate='"
							+ dto.getReDate() + "'";
				}
			} else if (timeNum == 4) {
				if (endTime == 22) {
					sql = "update test_studyroom set p" + startTime + "=" + startTime + ", p" + (startTime + 1) + "="
							+ getUniqueUser + ", p" + (startTime + 2) + "=" + getUniqueUser + ", p" + (startTime + 3)
							+ "=" + getUniqueUser + " where seatNum=" + dto.getSeatNum() + " and reDate='"
							+ dto.getReDate() + "'";
				} else {
					sql = "update test_studyroom set p" + startTime + "=" + startTime + ", p" + (startTime + 1) + "="
							+ getUniqueUser + ", p" + (startTime + 2) + "=" + getUniqueUser + ", p" + (startTime + 3)
							+ "=" + getUniqueUser + ", p" + endTime + "=" + getUniqueUser + " where seatNum="
							+ dto.getSeatNum() + " and reDate='" + dto.getReDate() + "'";
				}
			}

			template.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// STUDY_RESULTSET의 내용 삭제
	public void deleteBeforeInfo2() {
		try {
			String sql = "delete study_resultSet";
			template.update(sql);
			System.out.println("STUDY_RESULTSET내용 삭제 성공 #7");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("STUDY_RESULTSET내용 삭제 실패 #7");
		}
	}
	
	// 당일 시간제 결제 정보 DTO에 저장하고 화면에 출력하기
	public studyDTO daySelectUser(String getUniqueUser) {
		try {
			String sql = "select * from RESERVE_TIMESET where uniqueUser=" + getUniqueUser;
			System.out.println("사용자의 결제 정보 DTO에 저장 성공 #8");
			return template.queryForObject(sql, new BeanPropertyRowMapper<studyDTO>(studyDTO.class));

		} catch (final DataAccessException e) {
			e.printStackTrace();
			System.out.println("사용자의 결제 정보 DTO에 저장 실패 #8");
			return null;
		}
	}
}
