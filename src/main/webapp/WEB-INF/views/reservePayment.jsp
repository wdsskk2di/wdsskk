<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- ajax 사용을 위한 연결 -->
<script type="text/javascript" src="resources/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/jquery-1.12.1-ui.js"></script>

<script type="text/javascript">
//사용 시간: <select id="TimeNum" name="TimeNum" disabled="disabled"> <c:forEach var="time" items="${Tlist }"> <option id="selectTime">${time }</option> </c:forEach> </select> <br>	
//시간 1~6
//int[] Tlist = {1, 2, 3, 4};
//request.setAttribute("Tlist",Tlist);
<%
//스터디룸 정원
int[] Plist43 = {1,2,3,4,5,6};
request.setAttribute("Plist43",Plist43);

int[] Plist = {1,2,3,4};
request.setAttribute("Plist",Plist);
%>

//시간 선택시

$( document ).ready( function() { 
	var startTime;	//시작 시간
	var itemTime;	//시간 선택에 따른 사용시간 선택지
	
	//마지막 사용 시간(22= 10시~11시가 마지막 인것)
	var lastUseTime = 22;
	
	//시작시간 선택
	$('[name="startBtn"]').click(function(){			
		//버튼 이벤트 발생
		startTime = $(this).val();					

		$('[name="startTime"]').val(startTime);	//시작 시간 값 넘겨줄 name
		$("#showStartTime").val(startTime+":00시");	//시작 시간 값 보여줄 id
	
		//사용 시간 선택 제한
		$("#TimeNum").removeAttr("disabled") ;
		var oneTime = Number(startTime)+1;
		var twoTime = Number(startTime)+2;
		var threeTime = Number(startTime)+3;
		var fourTime = Number(startTime)+4;

		if($('#'+oneTime).text() == "예약 불가" || oneTime>lastUseTime){
			itemTime = [1];
			$("#TimeNum").empty();
			
			for(var count = 0; count < 1; count++){                
                var option = $("<option>"+itemTime[count]+"</option>");
                $('#TimeNum').append(option);
            }
		}else if($('#'+twoTime).text() == "예약 불가" || twoTime>lastUseTime){
			itemTime = [1,2];
			$("#TimeNum").empty();
			
			for(var count = 0; count < 2; count++){                
                var option = $("<option>"+itemTime[count]+"</option>");
                $('#TimeNum').append(option);
            }
		}else if($('#'+threeTime).text() == "예약 불가" || threeTime>lastUseTime){
			itemTime = [1,2,3];
			$("#TimeNum").empty();
			
			for(var count = 0; count < 3; count++){                
                var option = $("<option>"+itemTime[count]+"</option>");
                $('#TimeNum').append(option);
            }
		}else if($('#'+fourTime).text() == "예약 불가" || fourTime>lastUseTime){
			itemTime = [1,2,3,4];
			$("#TimeNum").empty();
			
			for(var count = 0; count < 4; count++){                
                var option = $("<option>"+itemTime[count]+"</option>");
                $('#TimeNum').append(option);
            }
		}
	});	
	
	//시간 선택
	$("#TimeNum").click(function(){			
		//버튼 이벤트 발생한 숫자
		var TimeNum = $(this).val();					
		
		//총 시간
		var endTime = Number(startTime)+Number(TimeNum);

		if(endTime>24){
			endTime -= 24;
			$("endTime").val(startTime+":00 시 ~ 0"+endTime+":00 시");
		}else{
			$("#endTime").val(startTime+":00 시 ~ "+endTime+":00 시");
		}		
		
		//가격
		if("${title}"=="p"){
			$("#TotalMoney").val(TimeNum*1000);	
		}else if("${title}"=="r"){
			$("#TotalMoney").val(TimeNum*2000);	
		}else if("${title}"=="s"){		
			var PeopleNum = $("#PeopleNum").val();
			$("#TotalMoney").val(TimeNum*3000*PeopleNum);	
		}							
	});	
	
	//인원 선택
	$("#PeopleNum").click(function(){
		var TimeNum = $("#TimeNum").val();
		var PeopleNum = $(this).val();
		
		$("#TotalMoney").val(TimeNum*3000*PeopleNum);	
	});	
});
</script>

</head>
<body>

<h3>예약 결제</h3>
<form action="paymentCheck" method="post">

	<h3>${seatNum }번 타임 테이블</h3>
	<c:import url="/WEB-INF/views/showTimeTable.jsp"/>
	
	<input type="hidden" name="title" value="${title }">
	선택 번호: ${seatNum }번<input type="hidden" name="seatNum" value="${seatNum }"><br>
	<input type="hidden" name="startTime">
	시작 시간: <input type="text" id="showStartTime" readonly="readonly">
	사용 시간: <select id="TimeNum" name="TimeNum" disabled="disabled"> <option id="selectTime">${time }</option> </select> <br>	
	종료 시간: <input type="text" id="endTime" readonly="readonly">
	
	<c:choose>
	<c:when test="${title == 's' }">
		<c:choose>
		<c:when test="${seatNum == 43 }">
		사용 인원: <select id="PeopleNum" name="PeopleNum"> <c:forEach var="people" items="${Plist43 }"> <option id="selectPeople">${people }</option> </c:forEach> </select> <br>
		</c:when>
		<c:otherwise>
		사용 인원: <select id="PeopleNum" name="PeopleNum"> <c:forEach var="people" items="${Plist }"> <option id="selectPeople">${people }</option> </c:forEach> </select> <br>
		</c:otherwise>
		</c:choose>
	</c:when>
	</c:choose>	
	
	결제 금액: <input type="text" id="TotalMoney" name="TotalMoney" readonly="readonly"><br>
	
	휴대폰 번호: 010 - <input type="text" id="Num" name="PhoneNum" readonly="readonly"  style="width: 80px;"><br>
	<c:import url="/WEB-INF/views/keypad/phoneKeypad.jsp"/>
	
	<input type="submit" value="결제">
	<button type="button" onclick="location.href='main'">취소</button>
</form>

</body>
</html>