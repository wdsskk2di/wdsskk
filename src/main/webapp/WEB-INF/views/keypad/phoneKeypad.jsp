<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
	button,
	button::after {	  -webkit-transition: all 0.3s;		-moz-transition: all 0.3s;	  -o-transition: all 0.3s;		transition: all 0.3s;	}
	
	#chooseNum button{color:white; background-color: #005766; border:0; outline:0; padding: 10px; font-size: 15px;}
	#chooseNum button:hover{color:#005766; background-color: white; outline: 1px solid #005766;}
</style>

<!-- ajax 사용을 위한 연결 -->
<script type="text/javascript" src="resources/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/jquery-1.12.1-ui.js"></script>
<script type="text/javascript">

$( document ).ready( function() {    
		$('[name="Nbutton"]').click(function(){		
			//휴대폰 번호 길이 == 텍스트 최대 문자 길이
			var MaxPositionNum = 8;		
			
			//텍스트창에 입력된 문자 길이
			var NumLength = $("#Num").val().length;		
			
			//텍스트 창에 입력되있는 문자
			var Num = $("#Num").val();	
			
			//버튼 이벤트 발생한 숫자
			var Nbutton = $(this).attr('value');
			
			if(Nbutton == "지움"){	//지움 버튼 입력
				if(NumLength == 0){//입력되어 있는 문자 길이 0
					$("#Num").val(Num);
				}else{//입력되어 있는 문자 길이 1 이상
					var cancelNum = Num.substring(0,NumLength-1);
					$("#Num").val(cancelNum);
				}						
			}else{	//숫자 버튼 입력
				if(NumLength == MaxPositionNum){//입력되어 있는 문자 길이 8
					$("#Num").val(Num);
				}else{//입력되어 있는 문자 길이 8 미만				
					$("#Num").val(Num+Nbutton);
				}

			}		
			
		});
	
});

</script>

</head>
<body>

<table id="chooseNum" style="margin:0 auto;">
	<tr><th><button type="button" name="Nbutton" value="7">7</button></th><th><button type="button" name="Nbutton" value="8">8</button></th><th><button type="button" name="Nbutton" value="9">9</button></th></tr>
	<tr><th><button type="button" name="Nbutton" value="4">4</button></th><th><button type="button" name="Nbutton" value="5">5</button></th><th><button type="button" name="Nbutton" value="6">6</button></th></tr>
	<tr><th><button type="button" name="Nbutton" value="1">1</button></th><th><button type="button" name="Nbutton" value="2">2</button></th><th><button type="button" name="Nbutton" value="3">3</button></th></tr>
	<tr><th><button type="button" name="Nbutton" value="0">0</button></th><th colspan="2"><button type="button" name="Nbutton" value="지움" style="width:60px; height: 38px;">지움</button></th></tr>
</table>

</body>
</html>