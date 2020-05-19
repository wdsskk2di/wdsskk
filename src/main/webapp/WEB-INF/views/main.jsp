<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
 .div_main{background-color: gray; height:800px; width:600px; text-align: center; text-align: center; margin: 0 auto;}
 .div_main img{margin-top: 100px; margin-bottom: 100px;}
 .div_main table{margin: 0 auto; margin-top: 150px;}
 .div_main button{color:white; background-color: silver; width: 250px; height: 80px; margin: 5px; font-size: 20px; font-weight: bold;}
</style>

</head>
<body class="main_body">

<div class="div_main">

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