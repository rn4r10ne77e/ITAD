document.write("<script src='MoveTo.js'></script>");

window.onload = function(){

	Secure(); // 이건 아래 정의 되어 있고 페이지를 이동하기 전에 현재 세션을 먼저 확인해서 있으면 이동하고 없으면 로그인 페이지로 이동한다.
	Ready(); // Contents 쪽에 정의하고 여기서 호출해서 쓴다 내용 페이지가 로드될때 실행되어야할 코드들을 Ready()에 담아두면 여기서 실행
	
	document.main.condev.value = check_device(); // 페이지 로딩 할때  할 때 접속하는 장비의 이름을 찾아서 넣는다 이건 submit 할 때 toppage.jsp 에서 처리하게 된다.

}







function check_device(){
	
	var mobileKeyWords = new Array('iPhone', 'iPod', 'BlackBerry', 'Android', 'Windows CE', 'LG', 'MOT', 'SAMSUNG', 'SonyEricsson');
	var device_name = '';
	
	for (var word in mobileKeyWords){
		if (navigator.userAgent.match(mobileKeyWords[word]) != null){
			device_name = mobileKeyWords[word];
			break;
		}
	}
	return device_name
}




function Secure(){
	
	var LoginUser = getInnerajax( "/ITAD/PeacePages/ppGetSession.jsp","")

	if( LoginUser.indexOf('in') == -1 )
	{
		alert('세션이 만료되었거나 잘못된 접근 입니다.\n로그인 페이지로 이동 합니다.');
		location.href="../Login.jsp"
	}
}


