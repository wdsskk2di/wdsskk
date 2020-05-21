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
	var contDateBtn = 0;

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
//		var date = new Date();
//		date = getFormatDate(date);
//		$("#reserveDate").text(date);	
//		$('[name="reDate"]').val(date);
		
		var todate = new Date();
		var chkTime = todate.getHours();
		
		//현재 시간보다 전 시간대면 클릭 못하게 막기
		for(var i = 8; i<Number(chkTime); i++){
			if(i<Number(chkTime)){
				$('#'+i).html("예약 불가");
				$('#'+i).attr("disabled",true);
			}
		}
	}
	
	function get_tomoDate() {
		if(contDateBtn == 0){
			$.ajax({
				url:"reserveTomorrow?seatNum="+${seatNum },
				type: "GET",	//방식
				success: function(data){	//성공시
					$("#timeTable1").html(data);
				},
				error:function(){	//실패시
					console.log("실패")
				}
			});
		
		contDateBtn += 1;
		}else{}
	}
	
	function get_toDate() {
		if(contDateBtn == 1){
			$.ajax({
				url:"reserveToday?seatNum="+${seatNum },
				type: "GET",	//방식
				success: function(data){	//성공시
					$("#timeTable1").html(data);
				},
				error:function(){	//실패시
					console.log("실패")
				}
			});

		contDateBtn -= 1;
		}else{}
	}
</script>

</head>

<body onload="reDate()">
	<table border="1" id="timeTable1">
		<caption id="reserveDate"><button type="button" onclick="get_toDate()"><</button>${reState.reDate }<button type="button" onclick="get_tomoDate()">></button></caption>
		<tr> <th>17:00</th><th>18:00</th><th>19:00</th><th>20:00</th><th>21:00</th><th>22:00</th> </tr>
		<tr>
			<th><c:choose>
				<c:when test="${reState.p17 == null }"><button id="17" name="startBtn" type="button" value="17">예약 가능</button></c:when>
				<c:otherwise><span id="17">예약 불가</span></c:otherwise>
			</c:choose></th>
			<th><c:choose>
				<c:when test="${reState.p18 == null }"><button id="18" name="startBtn" type="button" value="18">예약 가능</button></c:when>
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