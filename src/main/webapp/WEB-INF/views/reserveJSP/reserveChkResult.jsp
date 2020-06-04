<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 완료</title>

<style type="text/css">
 .payment_success{background-color: white; height:500px; width:600px; text-align: center; text-align: center; margin:0 auto; margin-top: 20%;}
 .payment_success table{margin: 0 auto; width: 270px;}
 .payment_success table td{padding-bottom: 20px;}
 
 .checkBtn{color:white; border:1 solid #005766; outline:1; border-radius: 5px; background-color: #005766;
		 padding: 3px 5px; font-size: 15px; font-weight: bold;}
 .cancelBtn{color:#005766; border:1 solid #005766; outline:1; border-radius: 5px; background-color: white;
		padding: 3px 5px; font-size: 15px; font-weight: bold; margin-left: 10px;}
</style>

</head>
<body>
<c:import url="/WEB-INF/views/default/header.jsp"/>

<div class="payment_success">

	<h3>예약 확인창</h3>
	
	<table>
	<tr><td>선택 번호: </td><td>${dto.getSeatNum() }</td></tr>
	<tr><td>시작 시간: </td><td>${dto.getStartTime() }</td></tr>
	<tr><td>종료 시간: </td><td>${dto.getEndTime() }</td></tr>
	<tr><td colspan="2">(총 ${dto.getTimeNum() } 시간)</td></tr>
	
	<c:choose>		
	<c:when test="${dto.getTitle() == 's' }">
		<tr><td>사용 인원: </td><td>${dto.getPeopleNum() }명</td></tr>
	</c:when>		
	</c:choose>

	<tr>
		<td><button type="button" onclick="location.href='main'" class="checkBtn">메인으로</button></td>
		<td><button type="button"onclick="location.href='javascript:history.go(-1)'" class="cancelBtn">뒤로가기</button></td>
	</tr>	
	</table>

</div>

<c:import url="/WEB-INF/views/default/footer.jsp"/>
</body>
</html>