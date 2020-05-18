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
<script type="text/javascript">

</script>

</head>
<body>

<div>

<img alt="배치도" src="">

<h3>좌석 번호</h3>
<c:import url="/WEB-INF/views/keypad.jsp"/>
<form action="payment">
	<input type="text" id="Num" readonly="readonly"><br>
	<input type="submit" value="확인">
	<button type="button" onclick="location.href='main'">취소</button>
</form>

</div>

</body>
</html>