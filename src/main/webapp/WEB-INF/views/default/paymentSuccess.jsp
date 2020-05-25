<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
 .payment_success{background-color: white; height:500px; width:600px; text-align: center; text-align: center; margin: 0 auto;}
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

	좌석: ${dto.getSeatNum() }<br>
	사용 시간: ${dto.getStartTime() } ~ ${dto.getEndTime() }<br>
	(총 ${dto.getTimeNum() } 시간)<br>
		<c:choose>
		<c:when test="${dto.getTitle() == 's' }">
		사용 인원: ${dto.getPeopleNum() }명<br>
		</c:when>
		</c:choose>
	결제 금액: ${dto.getTotalMoney() }<br>
	<button type="button" onclick="location.href='main'">확인</button>

</c:otherwise>
</c:choose>
</div>

</body>
</html>