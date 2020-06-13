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
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">

$( document ).ready( function() {  
	document.getElementById('ScurrentDate').value = new Date().toISOString().substring(0, 10);

});

//특정날짜 타임테이블 보여주기
function get_StoDate() {
	var selectSDate = document.getElementById('ScurrentDate').value;
	try {		
			$.ajax({
				url:"select_studyTable",
				type: "GET",	//방식
				data: {
					searchDate: selectSDate
				}				
			})
			.done(function(data){	//성공시				
				$("#timeTable3").html(data);
				document.getElementById('ScurrentDate').value = selectSDate;
			})
			.fail(function(){	//실패시
				console.log("실패")
			});		
	} catch (e) {}	
}

</script>
</head>
<body>
	<table id="timeTable3" style="margin-left: 20px;">
		<caption id="reserveDate">
		<input type="date" id='ScurrentDate'><button type="button" onclick="get_StoDate()" style="margin-left: 10px;">검색</button> 
		</caption>
		<tr> <th></th><th>17:00</th><th>18:00</th><th>19:00</th><th>20:00</th><th>21:00</th><th>22:00</th> </tr>
	<c:forEach var="reSDate" items="${reSDate }">
		<tr>
		<th>${reSDate.seatNum }번</th>
			<th><c:choose>
				<c:when test="${reSDate.p17 == null }"><button id="17" name="startBtn" type="button" value="17">예약 가능</button></c:when>
				<c:otherwise><span id="17">예약 완료</span></c:otherwise>
			</c:choose></th>
			<th><c:choose>
				<c:when test="${reSDate.p18 == null }"><button id="18" name="startBtn" type="button" value="18">예약 가능</button></c:when>
				<c:otherwise><span id="18">예약 완료</span></c:otherwise>
			</c:choose></th>
			<th><c:choose>
				<c:when test="${reSDate.p19 == null }"><button id="19" name="startBtn" type="button" value="19">예약 가능</button></c:when>
				<c:otherwise><span id="19">예약 완료</span></c:otherwise>
			</c:choose></th>
			<th><c:choose>
				<c:when test="${reSDate.p20 == null }"><button id="20" name="startBtn" type="button" value="20">예약 가능</button></c:when>
				<c:otherwise><span id="20">예약 완료</span></c:otherwise>
			</c:choose></th>
			<th><c:choose>
				<c:when test="${reSDate.p21 == null }"><button id="21" name="startBtn" type="button" value="21">예약 가능</button></c:when>
				<c:otherwise><span id="21">예약 완료</span></c:otherwise>
			</c:choose></th>
			<th><c:choose>
				<c:when test="${reSDate.p22 == null }"><button id="22" name="startBtn" type="button" value="22">예약 가능</button></c:when>
				<c:otherwise><span id="22">예약 완료</span></c:otherwise>
			</c:choose></th>
		</tr>
	</c:forEach>
	</table>
</body>
</html>