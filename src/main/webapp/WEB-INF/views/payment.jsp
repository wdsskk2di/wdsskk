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

<%
//시간 1~6
int[] Tlist = {1,2,3,4,5,6};
request.setAttribute("Tlist",Tlist);

//스터디룸 정원
int[] Plist43 = {1,2,3,4,5,6};
request.setAttribute("Plist43",Plist43);

int[] Plist = {1,2,3,4};
request.setAttribute("Plist",Plist);
%>

//시간 선택시
$( document ).ready( function() { 
	
	$("#TimeNum").click(function(){			
		//버튼 이벤트 발생한 숫자
		var TimeNum = $(this).val();					
				
		if("${title}"=="p"){
			$("#TotalMoney").val(TimeNum*1000);	
		}else if("${title}"=="r"){
			$("#TotalMoney").val(TimeNum*2000);	
		}else if("${title}"=="s"){		
			var PeopleNum = $("#PeopleNum").val();
			$("#TotalMoney").val(TimeNum*3000*PeopleNum);	
		}							
	});	
	
	$("#PeopleNum").click(function(){
		var TimeNum = $("#TimeNum").val();
		var PeopleNum = $(this).val();
		
		$("#TotalMoney").val(TimeNum*3000*PeopleNum);	
	});	
});

function IsStudyRoom() {
	if(${title =='s'}){
		//타이틀 변경
		$("#studyRoomTitle").html("스터디룸 결제");
		//버튼 값 변경
		$('[name="startBtn"]').html("사용 가능");
		
		//span값 변경
		for(var i = 8; i<25;i++){
			$('#'+i).text("사용 불가");
		}
		
		//현재 시간보다 전 시간대면 클릭 못하게 막기
		var todate = new Date();
		var chkTime = todate.getHours();
		
		//현재 시간보다 전 시간대면 클릭 못하게 막기
		for(var i = 8; i<Number(chkTime); i++){
			if(i<Number(chkTime)){
				$('#'+i).html("사용 불가");
				$('#'+i).attr("disabled",true);
			}
		}
	}
}

</script>

</head>
<body onload="IsStudyRoom()">
<c:import url="/WEB-INF/views/default/header.jsp"/>

<div class="default">
<c:choose>
<c:when test="${result == 0 }">
	<c:choose>
		<c:when test="${title == 'p' }">
		<h3>당일 좌석 결제</h3>
		<form action="paymentCheck" method="post">
			<input type="hidden" name="title" value="${title }">
			선택 번호: ${seatNum }번<input type="hidden" name="seatNum" value="${seatNum }"><br>
			사용 시간: <select id="TimeNum" name="TimeNum"> <c:forEach var="time" items="${Tlist }"> <option id="selectTime">${time }</option> </c:forEach> </select> <br>	
			
			결제 금액: <input type="text" id="TotalMoney" name="TotalMoney" readonly="readonly"><br>
			휴대폰 번호: 010 - <input type="text" id="Num" name="PhoneNum" readonly="readonly"  style="width: 80px;"><br>
			<c:import url="/WEB-INF/views/keypad/phoneKeypad.jsp"/>
			<input type="submit" value="결제">
			<button type="button" onclick="location.href='javascript:history.go(1-)'">뒤로가기</button>
		</form>
		</c:when>
		
		<c:otherwise>
		<c:import url="/WEB-INF/views/reservePayment.jsp"/>
		</c:otherwise>
	</c:choose>
</c:when>

<c:otherwise>
<script type="text/javascript">location.href="chooseSeatNum?title=${title}"</script>
</c:otherwise>

</c:choose>
</div>

<c:import url="/WEB-INF/views/default/footer.jsp"/>
</body>
</html>