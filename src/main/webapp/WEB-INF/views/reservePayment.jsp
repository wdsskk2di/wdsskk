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
<script type="text/javascript" src="resources/jsFile/reservePaymentJS.js"></script>

<script type="text/javascript">
<%
//스터디룸 정원
int[] Plist43 = {1,2,3,4,5,6};
request.setAttribute("Plist43",Plist43);

int[] Plist = {1,2,3,4};
request.setAttribute("Plist",Plist);
%>
</script>

</head>
<body>

<h3 id="studyRoomTitle">스터디룸 예약</h3>
<form action="paymentCheck" method="post">

	<h3>${seatNum }번 타임 테이블</h3>
	<c:import url="/WEB-INF/views/showTimeTable.jsp"/>
	
	<input type="hidden" name="title" value="${title }">
	선택 번호: ${seatNum }번<input type="hidden" name="seatNum" value="${seatNum }"><br>
	<input type="hidden" name="startTime"> <input type="hidden" name="endTime">	<input type="hidden" name="reDate">
	시작 시간: <input type="text" id="showStartTime" readonly="readonly">
	사용 시간: <select id="TimeNum" name="TimeNum" disabled="disabled"> <option id="selectTime">${time }</option> </select> <br>	
	종료 시간: <input type="text" id="showEndTime" readonly="readonly">
	
	<c:if test="${title == 's' }">
		<c:choose>
		<c:when test="${seatNum == 43 }">
		사용 인원: <select id="PeopleNum" name="PeopleNum"> <c:forEach var="people" items="${Plist43 }"> <option id="selectPeople">${people }</option> </c:forEach> </select> <br>
		</c:when>
		<c:otherwise>
		사용 인원: <select id="PeopleNum" name="PeopleNum"> <c:forEach var="people" items="${Plist }"> <option id="selectPeople">${people }</option> </c:forEach> </select> <br>
		</c:otherwise>
		</c:choose>
	</c:if>
	
	결제 금액: <input type="text" id="TotalMoney" name="TotalMoney" readonly="readonly"><br>
	
	휴대폰 번호: 010 - <input type="text" id="Num" name="PhoneNum" readonly="readonly"  style="width: 80px;"><br>
	<c:import url="/WEB-INF/views/keypad/phoneKeypad.jsp"/>
	
	<input type="submit" value="결제">
	<button type="button" onclick="location.href='main'">취소</button>
</form>

</body>
</html>