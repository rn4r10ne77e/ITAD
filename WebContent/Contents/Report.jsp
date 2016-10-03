<%@ include file="../toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%
	int PageCapa, MaxPage, StartRecord, EndRecord, CurrentPage;

	EQP eqp = new EQP();

	List<Map<String, Object>> SearchList = new ArrayList<Map<String, Object>>();
	Map<String, Object> map = null;
	
	if( request.getParameter("Line") != null )		 PageCapa 	 = Integer.parseInt(request.getParameter("Line")); 			else PageCapa = 15;
	if( request.getParameter("selectpage") != null ) CurrentPage = Integer.parseInt(request.getParameter("selectpage"));	else CurrentPage = 1;
	
	map = new HashMap<String, Object>();	map.put("NAME", "e.status");		map.put("VALUE", "1" );	map.put("TYPE", "int");		SearchList.add(map);
	
	List<EQPdata> EQPlist = new ArrayList<EQPdata>();
	EQPlist = eqp.LoadExpansionEQPlist( SearchList );
	
	MaxPage = (EQPlist.size()-1)/PageCapa + 1;
	StartRecord = (CurrentPage-1) * PageCapa;
	EndRecord = StartRecord + PageCapa - 1;
%>

<table class="infobox" style="width:100%; table-layout:inherit;">
<tr>
<td colspan=6>폐기 예정 자산 목록(<%=EQPlist.size() %>)</td> <td colspan=1 align=right>Line : <input type=text name="Line" value=<%=PageCapa%> style="width:20px"onKeydown="javascript:if(event.keyCode == 13) Move(this, 'PCList.jsp');" ></td>
</tr>

<tr>
<th><input type="checkbox" name="SelectAll" value="false" ></th>
<th>제품군</th>
<th>구분</th>
<th>사용부서</th>
<th>관리번호</th>
<th>구매일자</th>
<th>가격</th>
<th>수량</th>
</tr>

<c:forEach var="index" items="<%=EQPlist %>" begin="<%=StartRecord %>" end="<%=EndRecord %>">
<tr style="cursor:pointer;" onmouseover="showProp(this, this.cells)" onclick="">
<td class="lrow">

	<input type="checkbox" name="SelectedItems" value="${index.idx}" >

</td>
<td class="lrow">${index.strCategory}</td>
<td class="lrow">${index.strSubcategory}</td>
<td class="lrow">${index.strMNDept}</td>
<td class="lrow">${index.MN}</td>
<td class="lrow">${index.genedate}</td>
<td class="price" align=right>${index.price}</td>
<td class="lrow" align=center>${index.qty}</td>
</tr>
</c:forEach>

<tr><td colspan=8><hr></td></tr><!--			  페이지 번호를 출력 하는 부분 입니다. 						-->

<tr><td align=center colspan=8> 
	<c:set var="page" value="<%=CurrentPage%>" />
	<c:set var="maxpage" value="<%=MaxPage %>" />
	<table><tr>
	<c:forEach var="no" begin="1" end="5">
	<td name="pagenumber">
	
	<c:if test="${page+no-3 > 0 && page+no-3 <= maxpage}">
		<input type="button" onclick = "MovePage(this, 'PCList.jsp')" value="${page+no-3}">
	</c:if>
	
	</td>
	</c:forEach>
	<c:if test="${maxpage > 1}">
	<td> ... </td><td><input type="button" onclick = "MovePage(this, 'PCList.jsp')" value="${maxpage}"></td>
	</c:if>
	</tr>
</table>
</td></tr>

</table>
<br>
<input type="hidden" name="selectpage" value="1">
<input type="button" value="Confirm" onclick="Move(this, 'Report_OK.jsp')">

<%@ include file="../bottompage.jsp" %>