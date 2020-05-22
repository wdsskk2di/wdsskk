package kiosk.study.dto;

public class SetReserveDTO {
	//예약 좌석, 예약 스터디룸 DB
	private int seatNum;	//좌석
	private String reDate;	//예약일(yyyy/MM/dd로 하자)
	private String startTime; //시작 시간
	private String TimeNum; //사용 시간
	private int PeopleNum;	//스터디룸 사용 인원
	private int TotalMoney;	//총 금액
	private int PhoneNum; //핸드폰 번호
	
	public int getSeatNum() {return seatNum;}
	public void setSeatNum(int seatNum) {this.seatNum = seatNum;}

	public String getReDate() {return reDate;}
	public void setReDate(String reDate) {this.reDate = reDate;}
	
	public String getStartTime() {return startTime;}
	public void setStartTime(String startTime) {this.startTime = startTime;}
	
	public String getTimeNum() {return TimeNum;}
	public void setTimeNum(String timeNum) {this.TimeNum = timeNum;}
	
	public int getPeopleNum() {return PeopleNum;}
	public void setPeopleNum(int peopleNum) {this.PeopleNum = peopleNum;}
	
	public int getTotalMoney() {return TotalMoney;}
	public void setTotalMoney(int totalMoney) {this.TotalMoney = totalMoney;}
	
	public int getPhoneNum() {return PhoneNum;}
	public void setPhoneNum(int phoneNum) {this.PhoneNum = phoneNum;}
	
}
