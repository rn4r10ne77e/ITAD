<%@ include file="../toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<% pageContext.setAttribute("newLineChar",  "\n"); %>
<%
	EQP eqp = new EQP();
	User user = new User(); 
	PC pc = new PC();
	COMast ast = new COMast();
	History hstr = new History();

	String message=null; String today; int currentEQPidx;
	//List<Historydata> hstrList = new ArrayList<Historydata>();
	
	if( request.getParameter("SelectValue") == null ) currentEQPidx = (int)session.getAttribute("CurrentEQPidx");
	else
	{
		currentEQPidx = Integer.parseInt(request.getParameter("SelectValue"));
		session.setAttribute("CurrentEQPidx",currentEQPidx);
	}

	eqp.LoadEQPdata(currentEQPidx);
	user.LoadUserData(eqp.getUseridx());
	ast.load(eqp.getEqpidx());

	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
	hstr.setDate(formatter.format(new java.util.Date()));
%>

<c:set value="<%=pc%>" var="pc" scope="page" />
<c:set value="<%=ast%>" var="ast" scope="page" />
<c:set value="<%=user%>" var="user" scope="page" />
<c:set value="<%=eqp%>" var="eqp"  scope="page" />
<c:set value="<%=hstr%>" var="hstr"  scope="page" />

<script>
window.onload = function()
{	
	 obj = document.getElementById('price');
	 obj.innerHTML = comma(obj.innerHTML);
}
</script>

<table>
<tr><td valign="top">
<table>
<tr><td width=70>기본 정보 </td><td><input type=hidden name="idx" value="${eqp.idx}"></td></tr>
<tr><td>자산번호 : </td><td>${eqp.MN}</td></tr>
<tr><td>위치 : </td><td>${eqp.STRlocation}</td></tr>
<tr><td>제품군 : </td><td>${eqp.STReqpcateg}</td></tr>
<tr><td>구분 : </td><td>${eqp.STRsubcate}</td></tr>
<tr><td colspan=2 ><hr></td></tr>

<tr><td>사용부서 : </td><td>${eqp.STRMNDept}</td></tr>
<tr><td>사용자 : </td><td>${user.name}</td></tr>
<tr><td colspan=2 ><hr></td></tr>

<tr><td>구입일자 : </td><td>${eqp.genedate}</td></tr>
<tr><td>거래처 : </td><td>${eqp.STRvendor}<td></tr>
<tr><td>구입금액 : </td><td id="price">${eqp.price}</td></tr>
<tr><td>구매 수량 : </td><td>${eqp.qty}</td></tr>
<tr><td colspan=2 ><hr></td></tr>

<tr><td>SAP 번호 : </td><td>${eqp.sapno}</td></tr>
<tr><td>태그 번호 : </td><td>${eqp.mark}</td></tr>
<tr><td>관리자 1 : </td><td>${eqp.admin1}</td></tr>
<tr><td>관리자 2 : </td><td>${eqp.admin2}</td></tr>

</table>

<td  valign="top">
<table>
<tr><td width=80> 상세 정보 </td><td></td></tr>
<tr><td>모델명 : </td><td>${ast.model}</td></tr>
<tr><td>제조사 : </td><td>${ast.manufacturer}</td></tr>
<tr><td>비 고 : </td><td><pre>${ast.memo}</pre></td></tr>
</table>
</td>
</tr>
<tr><td colspan=2 align=right><input type="button" value="확인" onclick="Move(this, 'PCList.jsp')"></td>
</table>

<%@ include file="bottompage.jsp"%>