<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당일 번호 선택</title>

<style type="text/css">
 .default{background-color: white; height:500px; width:600px; text-align: center; margin-top: 20%;}
 .left_Div{position: absolute; left: 19%; top: 100px; width: 350px; margin-top: 10%;}
 .left_Div img{width: 250px; height: 280px;}
 .right_Div{position: absolute;  left: 60%; top: 150px; width: 250px; margin-top: 10%;}
 
 .checkBtn{color:white; border:1 solid #005766; outline:1; border-radius: 5px; background-color: #005766;
		 padding: 3px 5px; font-size: 15px; font-weight: bold; margin-right: 10px;}
 .cancelBtn{color:#005766; border:1 solid #005766; outline:1; border-radius: 5px; background-color: white;
		 padding: 3px 5px; font-size: 15px; font-weight: bold;}

</style>

<!-- ajax 사용을 위한 연결 -->
<script type="text/javascript" src="resources/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/jquery-1.12.1-ui.js"></script>

</head>
<body>
<c:import url="/WEB-INF/views/default/header.jsp"/>

<div class="default">

<div class="left_Div">
<img alt="배치도" src="resources/images/blockPlan.jpg"><br>
<c:import url="/WEB-INF/views/showSeatTable.jsp"/>
</div>

<div class="right_Div">
<h3>좌석 번호 선택</h3>

<c:choose>
<c:when test="${title == 'p' }">
	<h4>당일 좌석: 1~20번</h4>
</c:when>

<c:when test="${title == 's' }">
	<h4>스터디룸: 41~43번</h4>
</c:when>
</c:choose>

<form action="payment" method="get">
	<input type="hidden" name="title" value="${title }">
	<input type="text" id="Num" name="seatNum" readonly="readonly" style="text-align: right; width: 80px;">번<br>
	<c:import url="/WEB-INF/views/keypad/timeKeypad.jsp"/>
	<br>
	<input type="submit" value="확인" class="checkBtn">
	<button type="button" onclick="location.href='main'" class="cancelBtn">취소</button>
</form>
</div>

</div>

<c:import url="/WEB-INF/views/default/footer.jsp"/>
</body>
</html>