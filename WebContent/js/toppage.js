
document.write("<script src='MoveTo.js'></script>");

window.onload = function(){
	
	alert("error")
	
	var LoginUser = getInnerajax( "/ITAD/PeacePages/ppGetSession.jsp","")
	alert("("+LoginUser+")")
	
	
	if( trim(LoginUser) == null )
	{
		alert("is null")
		alert('세션이 만료되었거나 잘못된 접근 입니다. \\n로그인 페이지로 이동 합니다.');
		location.href="../Login.jsp"
	}
	else
	{
		alert("is not null")
	}
}
