<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<img alt="로고" src=""><br>
<img alt="가격표" src="">

<table>
	<tr>
		<th><button onclick="location.href='chooseSeatNum?title=p'">당일 좌석</button></th>
		<th><button onclick="location.href='reserve?title=r'">예약 좌석</button></th>
	</tr>
	<tr>
		<th><button onclick="location.href='studyRoom'">스터디룸</button></th>
		<th><button onclick="location.href='checkReserve?title=c'">예약확인</button></th>
	</tr>
</table>

</div>

</body>
</html>