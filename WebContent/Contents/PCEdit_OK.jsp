<%@ include file="../toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>


<!-------------------------------------------------------------------------------------------------------------------------------------->

<jsp:useBean id="eqp" class="ITAD.EQP"/> <jsp:setProperty property="*" name="eqp" />
<jsp:useBean id="user" class="ITAD.User"/> <jsp:setProperty property="*" name="user" />
<jsp:useBean id="pc" class="ITAD.PC"/> <jsp:setProperty property="*" name="pc" />
<jsp:useBean id="ast" class="ITAD.COMast"/> <jsp:setProperty property="*" name="ast" />
<jsp:useBean id="hstr" class="ITAD.History"/> <jsp:setProperty property="*" name="hstr" />

<%
	int loginidx=0;
	if( session.getAttribute("LoginedUser") != null ) loginidx = Integer.parseInt(session.getAttribute("LoginedUser").toString());
	else loginidx=999;

	List<HISTORYDETAIL> EQPhistoryList = new ArrayList<HISTORYDETAIL>();
	List<HISTORYDETAIL> USERhistoryList = new ArrayList<HISTORYDETAIL>();
	List<HISTORYDETAIL> ASThistoryList = new ArrayList<HISTORYDETAIL>();
		
	if( eqp.getUseridx() == 0 ) eqp.setUseridx(user.InsertUserData()); // 사용자가 등록 되어 있지 않는 상태면 사용자를 만들고 붙인다
	else
	{
		user.UpdateUSERdata(eqp.getUseridx()); // 있으면 사용자의 이름을 수정한다.
	}

	ast.update(eqp.getEqpidx());
	eqp.UpdateEQPdata();

	// History 

	EQPhistoryList = eqp.history();
	USERhistoryList = user.history();
	ASThistoryList = ast.history();

	int cnt=0;
	
	if( EQPhistoryList.size() != 0 ) cnt++;
	if( USERhistoryList.size() != 0 ) cnt++;
	if( ASThistoryList.size() != 0 ) cnt++;

	int history_header_index=0;

	if( cnt != 0 ) // 변경 사항이 하나라도 있을 때
	{
		List<HISTORYDETAIL> tmplist = new ArrayList<HISTORYDETAIL>(); // 자산 이동에 대한 히스토리만 따로 담는다.
		
		for(int i=0 ; i<EQPhistoryList.size() ; i++ ) // 변경 사항들을 뒤진다
		{

			if( EQPhistoryList.get(i).getItem().equals("DEPT") || EQPhistoryList.get(i).getItem().equals("LOCATION") ) 
			{
				tmplist.add(EQPhistoryList.get(i));// 임시 리스트로 위치값과 소속값을 옮긴다.
				EQPhistoryList.remove(i); // 옮기고 나면 자동으로 다시 인덱싱이 되기 때문에
				i=-1; // 카운터 값을 초기화 시켜준다 -1로 하는 이유는 for문 1회 종료 시점에 i++가 되기 때문
			}
		}

		if( tmplist.size() != 0 )// 자산 이동 항목이 있으면
		{
			String cntt="", beforeLOC="", afterLOC="", beforeDEPT="", afterDEPT="";
			for( int i=0 ; i<tmplist.size() ; i++ )
			{
				if( tmplist.get(i).getItem().equals("LOCATION") )
				{
					beforeLOC = hstr.CodeLookup("LOCXDEPT",tmplist.get(i).getValuefrom(),"CODE","DESCR");
					afterLOC = hstr.CodeLookup("LOCXDEPT",tmplist.get(i).getValueto(),"CODE","DESCR");
				}
				if( tmplist.get(i).getItem().equals("DEPT") )
				{
					beforeDEPT = hstr.CodeLookup("LOCXDEPT",tmplist.get(i).getValuefrom(),"CODE","DESCR");
					afterDEPT = hstr.CodeLookup("LOCXDEPT",tmplist.get(i).getValueto(),"CODE","DESCR");
				}
			}
			cntt =" "+beforeLOC+" "+beforeDEPT+"에서 "+afterLOC+" "+afterDEPT+" 으로 이동";
			history_header_index = hstr.insertHeader(eqp.getIdx(), hstr.getDate(), 2, "자산 이동", cntt, loginidx ); // 그리고 헤더를 추가 한다.
			hstr.insertDetail( tmplist, history_header_index ); // 자산 이동에 대한 헤더에 
		}

		if( EQPhistoryList.size() != 0 || USERhistoryList.size() != 0 || ASThistoryList.size() != 0 ) 
		{
			history_header_index = hstr.insertHeader(eqp.getIdx(), hstr.getDate(), 3, "정보 수정", "상세 참조", loginidx );
			hstr.insertDetail( EQPhistoryList, history_header_index );
			hstr.insertDetail( USERhistoryList, history_header_index );
			hstr.insertDetail( ASThistoryList, history_header_index );
		}
	}

	if( hstr.getHiscateg() != 0 && hstr.getTitle() != null && hstr.getContent() != null ) 
	{
		hstr.insertHeader(eqp.getIdx(), loginidx);
	}
%>

<script>
window.onload = function()
{ 
	document.main.action = "PCEdit.jsp";
	document.main.submit();
}
</script>


<!-------------------------------------------------------------------------------------------------------------------------------------->
<%@ include file="../bottompage.jsp"%>

