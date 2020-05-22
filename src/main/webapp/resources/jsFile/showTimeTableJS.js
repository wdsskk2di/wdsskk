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

	function compareDate() {
		var date = new Date();
		date = getFormatDate(date);
		
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
	
	//내일날짜 타임테이블 보여주기
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
	
	//오늘날짜 타임테이블 보여주기
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