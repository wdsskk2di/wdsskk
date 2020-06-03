window.onload = function() {
	var cnt = 60;
	var timer = setInterval(function() {
		window.onclick = function() {cnt = 60;}    	

		if( cnt == 0 ) {
			clearInterval(timer);
			location.href="main";
		}else {cnt--;}
		
	}, 1000);        
                
}