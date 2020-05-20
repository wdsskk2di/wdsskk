package kiosk.study.dto;

public class seatDTO {
	private int seatNum;	//좌석 번호
	private String phoneNum; //핸드폰 번호
	private String endTime; //종료 시간
	
	public int getSeatNum() {return seatNum;}
	public void setSeatNum(int seatNum) {this.seatNum = seatNum;}
	
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	
	public String getEndTime() {return endTime;}
	public void setEndTime(String endTime) {this.endTime = endTime;}
}
