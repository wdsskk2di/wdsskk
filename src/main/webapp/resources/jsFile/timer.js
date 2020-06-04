window.onload = function() {
	var cnt = 600;
	var timer = setInterval(function() {
		window.onclick = function() {cnt = 600;}    	
		
		if( cnt == 0 ) {
			clearInterval(timer);
			location.href="main";
		}else {cnt--;}
		console.log(cnt);
	}, 1000);        
                
}