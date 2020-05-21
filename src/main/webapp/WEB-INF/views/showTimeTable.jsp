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
	//날짜 계산
	function getFormatDate(date){
	    var year = date.getFullYear();              //yyyy
	    var month = (1 + date.getMonth());          //M
	    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
	    var day = date.getDate();                   //d
	    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
	    return  year + '/' + month + '/' + day;
	}

	function reDate() {
		var date = new Date();
		date = getFormatDate(date);
		$("#reserveDate").text(date);	
		$('[name="reDate"]').val(date);
	}
</script>

</head>

<body onload="reDate()">
	<table border="1">
		<caption id="reserveDate"></caption>
		<tr> <th>17:00</th><th>18:00</th><th>19:00</th><th>20:00</th><th>21:00</th><th>22:00</th> </tr>
		<tr>
			<th><c:choose>
				<c:when test="${reState.p17 == null }"><button name="startBtn" type="button" value="17">예약 가능</button></c:when>
				<c:otherwise><span id="17">예약 불가</span></c:otherwise>
			</c:choose></th>
			<th><c:choose>
				<c:when test="${reState.p18 == null }"><button name="startBtn" type="button" value="18">예약 가능</button></c:when>
				<c:otherwise><span id="18">예약 불가</span></c:otherwise>
			</c:choose></th>
						<th><c:choose>
				<c:when test="${reState.p19 == null }"><button name="startBtn" type="button" value="19">예약 가능</button></c:when>
				<c:otherwise><span id="19">예약 불가</span></c:otherwise>
			</c:choose></th>
						<th><c:choose>
				<c:when test="${reState.p20 == null }"><button name="startBtn" type="button" value="20">예약 가능</button></c:when>
				<c:otherwise><span id="20">예약 불가</span></c:otherwise>
			</c:choose></th>
						<th><c:choose>
				<c:when test="${reState.p21 == null }"><button name="startBtn" type="button" value="21">예약 가능</button></c:when>
				<c:otherwise><span id="21">예약 불가</span></c:otherwise>
			</c:choose></th>
						<th><c:choose>
				<c:when test="${reState.p22 == null }"><button name="startBtn" type="button" value="22">예약 가능</button></c:when>
				<c:otherwise><span id="22">예약 불가</span></c:otherwise>
			</c:choose></th>
		</tr>
	</table>
	<br>
</body>

</html>