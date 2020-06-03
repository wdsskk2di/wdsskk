<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당일 일정 선택</title>

<style type="text/css">
 .default{background-color: white; height:500px; width:600px; max-width:600px; min-width:600px; text-align: center;
 	text-align: center; margin: 0 auto; margin-top: 15%; margin-bottom: 5%;}
 table{margin: 0 auto;}
 .inputBorder{border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;}
 
 .checkBtn{color:white; border:1 solid #005766; outline:1; border-radius: 5px; background-color: #005766;
 	padding: 3px 5px; font-size: 15px; font-weight: bold; margin-right: 10px; width: 80px;}
 .cancelBtn{color:#005766; border:1 solid #005766; outline:1; border-radius: 5px; background-color: white;
 	padding: 3px 5px; font-size: 15px; font-weight: bold; margin-left: 10px; width: 80px;}
</style>

<!-- ajax 사용을 위한 연결 -->
<script type="text/javascript" src="resources/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/jquery-1.12.1-ui.js"></script>
<!-- 타이머(이벤트 미발생시 main화면 이동) -->
<script type="text/javascript" src="resources/jsFile/timer.js"></script>
<script type="text/javascript">
$( document ).ready( function() {     
	
});

//form submit시 미입력값 있으면 전송 막기
function formCheck() {
	if($("#Num").val().length < 8) {
		alert("휴대폰 번호를 확인해주세요");
		return false;
	}else{
		return true;
	}	
}

</script>

</head>
<body>
<c:import url="/WEB-INF/views/default/header.jsp"/>

<div class="default">

	<h3>예약 확인</h3>
	<form id="target" action="reserveChkResult" method="post" onsubmit="return formCheck()">
	<input type="hidden" name="title" value="${title }">
	<table>
		<tr>
		<td style="text-align: left; padding-bottom: 40px;">휴대폰 번호: 010 - <input type="text" id="Num" name="phoneNum" readonly="readonly"  style="width: 80px;"></td>		
		</tr>
		
		<tr><td><c:import url="/WEB-INF/views/keypad/phoneKeypad.jsp"/></td></tr>
		
		<tr>
			<td style="padding-top: 20px;"><input type="submit" value="확  인" class="checkBtn">
			<button type="button" onclick="location.href='main'" class="cancelBtn">취 소</button>
			</td>
		</tr>
	</table>
	
	</form>

</div>

<c:import url="/WEB-INF/views/default/footer.jsp"/>
</body>
</html>