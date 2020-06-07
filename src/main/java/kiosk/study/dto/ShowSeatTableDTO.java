package kiosk.study.dto;

public class ShowSeatTableDTO {
	//당일 좌석 사용 유무
	private int seatNum;	//좌석 번호
	private String toDate;  //오늘 날짜
	private String endTime; //종료 시간
	
	public int getSeatNum() {return seatNum;}
	public void setSeatNum(int seatNum) {this.seatNum = seatNum;}
	
	public String getToDate() {return toDate;}
	public void setToDate(String toDate) {this.toDate = toDate;}
	
	public String getEndTime() {return endTime;}
	public void setEndTime(String endTime) {this.endTime = endTime;}
}
