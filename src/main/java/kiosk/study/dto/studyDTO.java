package kiosk.study.dto;

public class studyDTO {
	
	private String title;	//카테고리. p=당일, r=예약, s=스터디룸
	private int seatNum;	//좌석번호	
	private int TimeNum;	//사용 시간
	private int PeopleNum;	//스터디룸 사용 인원
	private int TotalMoney;	//총 금액
	private String PhoneNum; //핸드폰 번호
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	
	public int getSeatNum() {return seatNum;}
	public void setSeatNum(int seatNum) {this.seatNum = seatNum;}
	
	public int getTimeNum() {return TimeNum;}
	public void setTimeNum(int timeNum) {TimeNum = timeNum;}
	
	public int getPeopleNum() {return PeopleNum;}
	public void setPeopleNum(int peopleNum) {PeopleNum = peopleNum;}
	
	public int getTotalMoney() {return TotalMoney;}
	public void setTotalMoney(int totalMoney) {TotalMoney = totalMoney;}
	
	public String getPhoneNum() {return PhoneNum;}
	public void setPhoneNum(String phoneNum) {PhoneNum = phoneNum;}	
	
}
