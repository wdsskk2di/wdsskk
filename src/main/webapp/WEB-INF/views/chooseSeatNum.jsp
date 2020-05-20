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

</head>
<body>

<div>

<img alt="배치도" src="">
<c:import url="/WEB-INF/views/showSeatTable.jsp"/>

<h3>좌석 번호</h3>

<c:choose>
<c:when test="${title == 'p' }">
	<h4>당일 좌석은 1~20번 입니다</h4>
</c:when>

<c:when test="${title == 'r' }">
	<h4>예약 좌석은 21~40번 입니다</h4>
</c:when>

<c:when test="${title == 's' }">
	<h4>스터디룸은 41~43번 입니다</h4>
</c:when>
</c:choose>

<form action="payment" method="get">
	<input type="hidden" name="title" value="${title }">
	<input type="text" id="Num" name="seatNum" readonly="readonly" style="text-align: right; width: 80px;">번<br>
	<c:import url="/WEB-INF/views/keypad/timeKeypad.jsp"/>
	<input type="submit" value="확인">
	<button type="button" onclick="location.href='/main'">취소</button>
</form>

</div>

</body>
</html>