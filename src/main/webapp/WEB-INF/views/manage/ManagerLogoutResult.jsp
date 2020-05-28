<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="resources/CSS/ManagerCSS.css" />">
</head>
<body>
<!-- Side navigation -->
<div class="sidenav">
<c:remove var="LoginID" scope="session"/>
<c:remove var="loginResult" scope="session"/>

<form class="manageForm" name="manageForm" action="ManagerLoginResult" method="post">
&nbsp;ID &nbsp;&nbsp;<input type="text" name="mID"><br>
&nbsp;PW <input type="password" name="mPW" id="PW_TF"><br>
<input type="submit" value="로그인" id="LoginBtn">
</form>

  <button type="button" class="buttonSN" onclick="location.href='seatManage'">좌석 관리</button>
  <button type="button" class="buttonSN" onclick="location.href='reserveManage'">예약 관리</button>
  <button type="button" class="buttonSN" onclick="location.href='totalManage'">매출 관리</button>
</div>

<div class="main">
<c:choose>
<c:when test="${loginResult == null }">
로그아웃 성공!
</c:when>
<c:otherwise>
로그아웃 실패!
</c:otherwise>
</c:choose>
</div>

</body>
</html>