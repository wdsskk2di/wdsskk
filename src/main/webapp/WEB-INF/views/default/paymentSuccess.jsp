<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 완료</title>

<style type="text/css">
 .payment_success{background-color: white; height:500px; width:600px; text-align: center; text-align: center; margin:0 auto; margin-top: 10%;}
 .payment_success table{margin: 0 auto;}
 
 .checkBtn{color:white; border:1 solid #005766; outline:1; border-radius: 5px; background-color: #005766;
		 padding: 3px 5px; font-size: 15px; font-weight: bold;}
</style>

</head>
<body>
<c:import url="/WEB-INF/views/default/header.jsp"/>

<div class="payment_success">
<c:choose>
<c:when test="${result == 'fail' }">
<h4>오류 발생! 관리자에게 문의하세요.</h4>
<button type="button" onclick="location.href='main'">돌아가기</button>
</c:when>

<c:otherwise>
	<h3>결제 확인창</h3>
	
	<table>
	<tr><td>선택 번호: ${dto.getSeatNum() }</td></tr>
	<tr><td>시작 시간: ${dto.getStartTime() }</td></tr>
	<tr><td>종료 시간: ${dto.getEndTime() }</td></tr>
	<tr><td>(총 ${dto.getTimeNum() } 시간)</td></tr>
	
	<c:choose>		
	<c:when test="${dto.getTitle() == 's' }">
		<tr><td>
		사용 인원: ${dto.getPeopleNum() }명
		</td></tr>
	</c:when>		
	</c:choose>
	
	<tr><td style="padding: 10px 0px 10px 0px">결제 금액: ${dto.getTotalMoney() }</td></tr>
	<tr><td><button type="button" onclick="location.href='main'" class="checkBtn">확인</button></td></tr>	
	</table>
</c:otherwise>
</c:choose>
</div>

</body>
</html>