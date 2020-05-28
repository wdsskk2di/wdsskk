<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석 관리</title>
<link rel="stylesheet" href="<c:url value="resources/CSS/ManagerCSS.css" />">
</head>
<body>
<!-- Side navigation -->
<div class="sidenav">

<c:choose>
<c:when test="${loginResult == 'true' }">
<form class="manageForm" action="ManagerLogoutResult">
	<span>'<b>${LoginID}</b>' 관리자님,</span><br><span>로그인 중입니다.</span>
	<input type="submit" value="로그아웃" id="LogoutBtn">
</form>
</c:when>
<c:otherwise>
	<form class="manageForm" name="manageForm" action="ManagerLoginResult" method="post">
	&nbsp;ID &nbsp;&nbsp;<input type="text" name="mID"><br>
	&nbsp;PW <input type="password" name="mPW" id="PW_TF"><br>
	<input type="submit" value="로그인" id="LoginBtn">
	</form>
</c:otherwise>
</c:choose>

  <button type="button" class="buttonSN" onclick="location.href='seatManage'" style="background-color: #fff; color: #225ea7;">좌석 관리</button>
  <button type="button" class="buttonSN" onclick="location.href='reserveManage'">예약 관리</button>
  <button type="button" class="buttonSN" onclick="location.href='totalManage'">매출 관리</button>
</div>

<!-- main  -->
<div class="main">
<c:choose>
<c:when test="${loginResult == 'true' }">
<h2 style="color: #225ea7;">좌석관리 페이지</h2>
<div class="seatDiv">
<h3>>당일 좌석</h3>
<table>
<tr>
<c:forEach var="i" begin="0" end="9">
	<td><b>${seatState[i].seatNum}</b>번<br>
	<c:choose>
		<c:when test="${seatState[i].phoneNum == null}">사용가능<br>--</c:when>
		<c:otherwise><span style="color:white; background-color: red">사용불가</span><br>${seatState[i].endTime }</c:otherwise>
	</c:choose>
	</td>
</c:forEach>
</tr>
<tr>
<c:forEach var="i" begin="10" end="19">
	<td><b>${seatState[i].seatNum}</b>번<br>
	<c:choose>
		<c:when test="${seatState[i].phoneNum == null}">사용가능<br>--</c:when>
		<c:otherwise><span style="color:white; background-color: red;">사용불가</span><br>${seatState[i].endTime }</c:otherwise>
	</c:choose>
	</td>
</c:forEach>
</tr>
</table>
</div>

<div class="seatDiv">
<h3>>예약 좌석</h3>
<table>
<tr>
<c:forEach var="i" begin="0" end="9">
	<td><b>${seatState[i].seatNum}</b>번<br>
	<c:choose>
		<c:when test="${seatState[i].phoneNum == null}">사용가능<br>--</c:when>
		<c:otherwise><span style="color:white; background-color: red">사용불가</span><br>${seatState[i].endTime }</c:otherwise>
	</c:choose>
	</td>
</c:forEach>
</tr>
<tr>
<c:forEach var="i" begin="10" end="19">
	<td><b>${seatState[i].seatNum}</b>번<br>
	<c:choose>
		<c:when test="${seatState[i].phoneNum == null}">사용가능<br>--</c:when>
		<c:otherwise><span style="color:white; background-color: red;">사용불가</span><br>${seatState[i].endTime }</c:otherwise>
	</c:choose>
	</td>
</c:forEach>
</tr>
</table>
</div>

<div class="seatDiv">
<h3>>스터디룸</h3>
<table>
<tr>
<c:forEach var="i" begin="0" end="2">
	<td><a href="#?seatNum='${seatState[i].seatNum}'"><b>${seatState[i].seatNum}</b>번</a><br>
	<c:choose>
		<c:when test="${seatState[i].phoneNum == null}">사용가능<br>--</c:when>
		<c:otherwise><span style="color:white; background-color: red">사용불가</span><br>${seatState[i].endTime }</c:otherwise>
	</c:choose>
	</td>
</c:forEach>
</tr>
</table>
</div>
</c:when>

<c:otherwise>해당 기능은 로그인을 해야 사용 가능합니다.<br>로그인을 해주세요.</c:otherwise>
</c:choose>
</div>

</body>
</html>