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
  <button type="button" class="buttonSN" onclick="location.href='seatManage'" style="background-color: #fff; color: #225ea7;">좌석 관리</button>
  <button type="button" class="buttonSN" onclick="location.href='reserveManage'">예약 관리</button>
  <button type="button" class="buttonSN" onclick="location.href='totalManage'">매출 관리</button>
</div>

<!-- Page content -->
<div class="main">
  좌석 관리 페이지
</div>
</body>
</html>