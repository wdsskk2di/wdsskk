<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		.left_Div_in{position:absolute; top:20px; width: 400px;}
		.left_Div_in table{margin: 0 auto;}
	</style>
</head>
<body>

<div class="left_Div_in">
<table>
<tr><th style="border-right: 1px solid;">좌석 번호</th><th style="border-right: 1px solid;">현재 사용자</th><th>종료 시간</th></tr>
<tr><td>체크:<c:out value="${seatState[0].seatNum}"/> </td></tr>
<c:forEach var="seatState" items="${seatState }">
<tr><th colspan="3"  style="border-bottom: 1px solid;"></th></tr>
<tr><th style="border-right: 1px solid;"><a>${seatState.seatNum }</a></th>
	<c:choose>
		<c:when test="${seatState.phoneNum == null}"><th style="border-right: 1px solid;">없음</th><th>--</th></c:when>
		<c:otherwise><th style="border-right: 1px solid; background-color: red">있음</th><th>${seatState.endTime }</th></c:otherwise>
	</c:choose>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>