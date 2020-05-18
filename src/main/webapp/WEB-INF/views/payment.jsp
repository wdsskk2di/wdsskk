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
<%
int[] list = {1,2,3,4,5,6};
request.setAttribute("list",list);
%>

$( document ).ready( function() {    
		$("#Tbutton").click(function(){			
			//버튼 이벤트 발생한 숫자
			var Tbutton = $(this).val();			

			$("#TotalMoney").val(Tbutton);					
		});	
});
</script>

</head>
<body>

<h3>결제</h3>
<form action="">
	사용 시간: <select id="Tbutton"> <c:forEach var="time" items="${list }"> <option id="selectTime">${time }</option> </c:forEach> </select> <br>
	결제 금액: <input type="text" id="TotalMoney" name="" readonly="readonly"><br>
	<input type="submit" value="결제">
	<button type="button">취소</button>
</form>

</body>
</html>