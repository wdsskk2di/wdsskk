//시간 선택시

$( document ).ready( function() { 
	var startTime;	//시작 시간
	var itemTime;	//시간 선택에 따른 사용시간 선택지
	
	//마지막 사용 시간(22= 10시~11시가 마지막 인것)
	var lastUseTime = 22;
	
	//시작시간 선택
	$('[name="startBtn"]').click(function(){			
		//버튼 이벤트 발생
		startTime = $(this).val();					

		$('[name="startTime"]').val(startTime);	//시작 시간 값 넘겨줄 name
		$("#showStartTime").val(startTime+":00시");	//시작 시간 값 보여줄 id
	
		//사용 시간 선택 제한
		$("#TimeNum").removeAttr("disabled") ;
		var oneTime = Number(startTime)+1;
		var twoTime = Number(startTime)+2;
		var threeTime = Number(startTime)+3;
		var fourTime = Number(startTime)+4;

		if($('#'+oneTime).text() == "예약 불가" || oneTime>lastUseTime){
			itemTime = [1];
			$("#TimeNum").empty();
			
			for(var count = 0; count < 1; count++){                
                var option = $("<option>"+itemTime[count]+"</option>");
                $('#TimeNum').append(option);
            }
		}else if($('#'+twoTime).text() == "예약 불가" || twoTime>lastUseTime){
			itemTime = [1,2];
			$("#TimeNum").empty();
			
			for(var count = 0; count < 2; count++){                
                var option = $("<option>"+itemTime[count]+"</option>");
                $('#TimeNum').append(option);
            }
		}else if($('#'+threeTime).text() == "예약 불가" || threeTime>lastUseTime){
			itemTime = [1,2,3];
			$("#TimeNum").empty();
			
			for(var count = 0; count < 3; count++){                
                var option = $("<option>"+itemTime[count]+"</option>");
                $('#TimeNum').append(option);
            }
		}else if($('#'+fourTime).text() == "예약 불가" || fourTime>lastUseTime){
			itemTime = [1,2,3,4];
			$("#TimeNum").empty();
			
			for(var count = 0; count < 4; count++){                
                var option = $("<option>"+itemTime[count]+"</option>");
                $('#TimeNum').append(option);
            }
		}else{
			itemTime = [1,2,3,4];
			$("#TimeNum").empty();
			
			for(var count = 0; count < 4; count++){                
                var option = $("<option>"+itemTime[count]+"</option>");
                $('#TimeNum').append(option);
            }
		}
	});	
	
	//시간 선택
	$("#TimeNum").click(function(){			
		//버튼 이벤트 발생한 숫자
		var TimeNum = $(this).val();					
		
		//총 시간
		var endTime = Number(startTime)+Number(TimeNum);
		
		$('[name="endTime"]').val(endTime);	//시작 시간 값 넘겨줄 name
		$("#shoEndTime").val(EndTime+":00시");	//시작 시간 값 보여줄 id
		
		if(endTime>24){
			endTime -= 24;
			$("#endTime").val(startTime+":00 시 ~ 0"+endTime+":00 시");
		}else{
			$("#endTime").val(startTime+":00 시 ~ "+endTime+":00 시");
		}		
		
		//가격
		if("${title}"=="p"){
			$("#TotalMoney").val(TimeNum*1000);	
		}else if("${title}"=="r"){
			$("#TotalMoney").val(TimeNum*2000);	
		}else if("${title}"=="s"){		
			var PeopleNum = $("#PeopleNum").val();
			$("#TotalMoney").val(TimeNum*3000*PeopleNum);	
		}							
	});	
	
	//인원 선택
	$("#PeopleNum").click(function(){
		var TimeNum = $("#TimeNum").val();
		var PeopleNum = $(this).val();
		
		$("#TotalMoney").val(TimeNum*3000*PeopleNum);	
	});	
});