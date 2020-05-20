<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
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
		$("#reDate").text(date);	
	}
</script>

</head>

<body onload="reDate()">
	<table border="1">
		<caption id="reDate"></caption>
		<tr> <th>17:00</th><th>18:00</th><th>19:00</th><th>20:00</th><th>21:00</th><th>22:00</th> </tr>
		<tr>
			<th><c:choose>
				<c:when test="${reState.p17 == null }"><button>예약 가능</button></c:when>
				<c:otherwise>예약 불가</c:otherwise>
			</c:choose></th>
			<th><c:choose>
				<c:when test="${reState.p18 == null }"><button>예약 가능</button></c:when>
				<c:otherwise>예약 불가</c:otherwise>
			</c:choose></th>
						<th><c:choose>
				<c:when test="${reState.p19 == '' }"><button>예약 가능</button></c:when>
				<c:otherwise>예약 불가</c:otherwise>
			</c:choose></th>
						<th><c:choose>
				<c:when test="${reState.p20 == 'null' }"><button>예약 가능</button></c:when>
				<c:otherwise>예약 불가</c:otherwise>
			</c:choose></th>
						<th><c:choose>
				<c:when test="${reState.p21 == '' }"><button>예약 가능</button></c:when>
				<c:otherwise>예약 불가</c:otherwise>
			</c:choose></th>
						<th><c:choose>
				<c:when test="${reState.p22 == '' }"><button>예약 가능</button></c:when>
				<c:otherwise>예약 불가</c:otherwise>
			</c:choose></th>
		</tr>
	</table>
	<br>
</body>

</html>