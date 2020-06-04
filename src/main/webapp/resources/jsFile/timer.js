window.onload = function() {
	var cnt = 300;
	var timer = setInterval(function() {
		window.onclick = function() {cnt = 300;}    	
		
		if( cnt == 0 ) {
			clearInterval(timer);
			location.href="main";
		}else {cnt--;}

	}, 1000);        
                
}