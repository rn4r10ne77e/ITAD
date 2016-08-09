<%@ page pageEncoding="UTF-8" %>
<%@ include file="/toppage.jsp" %>
<%!
	int PageCapa=10, MaxPage, StartRecord, EndRecord, CurrentPage=1;
	String SearchColumn, SearchKeyword;
%>
<% 
	User user = new User();
	user.LoadUserData(Integer.parseInt(request.getParameter("SelectValue").toString()));
		
	int userseqpidx = user.ReturnIDX("EQP", String.valueOf(user.getIdx()), "USRIDX", "IDX");
	
	EQP eqp = new EQP();
	List<EQPdata> EQPlist = new ArrayList<EQPdata>();
	EQPlist = null;

	EQPlist = eqp.LoadExpansionEQPlist("e.IDX",String.valueOf(userseqpidx));
		
	MaxPage = EQPlist.size()/PageCapa + 1;
	StartRecord = (CurrentPage-1) * PageCapa;
	EndRecord = StartRecord + PageCapa - 1;	
%>
<c:set value="<%=user%>" var="user" scope="page" />
<script>
window.onload=function()
{
	document.main.usrPosition.value = ${user.usrPosition}
	document.main.usrDept.value = ${user.usrDept}
	document.main.permission.value = ${user.permission}
	document.main.state.value = ${user.state}
}
</script>
<table>
	<tr>
		<td valign=top>
			
			<table>

			<tr><td>사용자 정보 <input type=hidden name="idx" value="${user.idx}"></td></tr>
			<tr><td align=right>이름 : <input type=text name="name" value="${user.name}"></td></tr>
			<tr><td align=right>사번 : <input type=text name="ID"value="${user.ID}" ></td></tr>
			<tr><td align=right>직책 : ${user.TAGusrPosition}</td></tr>
			<tr><td align=right>소속 : ${user.TAGusrDept}</td></tr>
			<tr><td align=center> -------------  Ex  -------------</td></tr>
			<tr><td align=right>패스워드 : <input type=text name="password" value="${user.password}"></td></tr>
			<tr><td align=right>계정 사용 상태 : ${user.TAGstate}</td></tr>
			<tr><td align=right>권한 : ${user.TAGpermission}</td></tr>
			</table>
		
		</td>
		<td valign=top>
			사용자 이름으로 등록된 장비들 목록
			<table>
				<th style="display:none"></th>
				<th>구분</th>
				<th>관리부서</th>
				<th>관리번호</th>
				<th>사용자</th>
				<th>장비 모델</th>
				<th>제조사</th>
				<th>시리얼</th>
				</tr>
					
				<c:forEach var="index" items="<%=EQPlist %>" begin="<%=StartRecord %>" end="<%=EndRecord %>">
			
				<tr style="cursor:pointer;"  onmouseover="showProp(this, this.cells)" onclick="Move(this,'PCEdit.jsp')">
				<td class="lrow" style="display:none" ><input type="radio" name="SelectValue" value="${index.idx}" style="display:none" ></td>
				<td class="lrow">${index.strCategory}</td>
				<td class="lrow">${index.strMNDept}</td>
				<td class="lrow">${index.MN}</td>
				<td class="lrow">${index.usrname }</td>
				<td class="lrow">${index.objmodel}</td>
				<td class="lrow">${index.objmanufacture}</td>
				<td class="lrow">${index.objserial}</td>
				</tr>
				
				</c:forEach>
			
			</table>
		
		</td>
	</tr>
</table>


<input type=button value="수정" onclick="Move(this, 'UserEdit_OK.jsp')">&nbsp;&nbsp;&nbsp;
<input type=button value="삭제" onclick="">

<%@ include file="/bottompage.jsp" %>