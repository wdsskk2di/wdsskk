package kiosk.study.dto;

public class studyDTO {
	//당일 좌석 DB
	private String title;	//카테고리. p=당일, r=예약, s=스터디룸
	private int seatNum;	//좌석번호	
	private int TimeNum;	//사용 시간
	private int PeopleNum;	//스터디룸 사용 인원
	private int TotalMoney;	//총 금액
	private int PhoneNum; //핸드폰 번호
	private String StartTime; //시작 시간
	private String EndTime; //종료 시간
	private String uniqueUser; //유저 결제코드값
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	
	public int getSeatNum() {return seatNum;}
	public void setSeatNum(int seatNum) {this.seatNum = seatNum;}
	
	public int getTimeNum() {return TimeNum;}
	public void setTimeNum(int timeNum) {this.TimeNum = timeNum;}
	
	public int getPeopleNum() {return PeopleNum;}
	public void setPeopleNum(int peopleNum) {this.PeopleNum = peopleNum;}
	
	public int getTotalMoney() {return TotalMoney;}
	public void setTotalMoney(int totalMoney) {this.TotalMoney = totalMoney;}
	
	public int getPhoneNum() {return PhoneNum;}
	public void setPhoneNum(int phoneNum) {this.PhoneNum = phoneNum;}
	
	//사용시간
	public String getStartTime() {return StartTime;}
	public void setStartTime(String StartTime) {this.StartTime = StartTime;}
	
	public String getEndTime() {return EndTime;	}
	public void setEndTime(String EndTime) {this.EndTime = EndTime;}
	

	//유저 결제 코드값
	public String getUniqueUser() { return uniqueUser;	}
	public void setUniqueUser(String uniqueUser) {	this.uniqueUser = uniqueUser; }
}
/*
kiosk 테이블
create table kiosk(title char(1) NOT NULL,seatNum number NOT NULL, timeNum number,
peopleNum number, totalmoney integer, phoneNum integer,
startTime varchar2(14), endTime varchar2(14));

 insert into kiosk VALUES('s', 41, null, null, null, null, null, null);

*/
/* 새로운 DB 생성
 create table dayUse(title char(1) NOT NULL,seatNum number NOT NULL,
phoneNum integer, toDate varchar2(10), startTime varchar2(14), endTime varchar2(14),
timeNum number, PRIMARY KEY(seatNum));

값 넣을때
 insert into dayUse VALUES('p', 1, null, to_char(sysdate,'yyyyMMdd'), null, null, null);
 
일자 바뀔때 날짜를 갱신하거나 == update dayUse set toDate=to_char(sysdate,'yyyyMMdd'); 
또는 insert로 새로 넣어줘야할것.
 */
