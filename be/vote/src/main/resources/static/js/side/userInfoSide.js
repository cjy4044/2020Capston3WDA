	   window.onload = function(){
		
		var newSS=document.createElement('link');
		newSS.rel='stylesheet';
		newSS.href='/css/style.css'
		document.getElementsByTagName("head")[0].appendChild(newSS);


		//사이드바 필요할시 스타일활성해주는 것
		 $(".sideon").attr('class','glyphicon glyphicon-menu-hamburger');
		 $(".btn2").attr('class','btn'); 
	
		//개인정보
	    $("#side").append("<li><a href='/userInfo'>개인정보</a></li>");
		$("#side").append("<li><a href='#'>나의투표</a></li>");
		
		//회원관리
		$("#side").append("<li><a href='/userInfo/allUser'>회원관리</a></li>");
		$("#side").append("<li><a href='/userInfo/allCompany'>서비스신청관리</a></li>");
	    
	    //오디션관리
	    $("#side").append("<li><a href='#'>오디션개설</a></li>");
	    $("#side").append("<li><a href='#'>예선심사</a></li>");
	    $("#side").append("<li><a href='#'>심사결과</a></li>");
	    
	    //투표관리
	    $("#side").append("<li><a href='#'>투표개설</a></li>");	 
	    $("#side").append("<li><a href='#'>투표관리</a></li>");
	    
   	    //커뮤니티관리
	    $("#side").append("<li><a href='#'>핫클립관리</a></li>");	 
	    $("#side").append("<li><a href='#'>방첨권추첨</a></li>");	 
	    $("#side").append("<li><a href='#'>팬클럽관리</a></li>");
	    
	    //굿즈샵관리
	    $("#side").append("<li><a href='#'>상품관리</a></li>");	 
	    $("#side").append("<li><a href='#'>상품등록</a></li>");	 
	    $("#side").append("<li><a href='#'>주문관리</a></li>");	 
	    $("#side").append("<li><a href='#'>판매추이</a></li>");	
	    
	    //채팅관리
	    $("#side").append("<li><a href='#'>채팅방관리</a></li>");	 
	    
	}

