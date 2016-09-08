<%@ include file="../toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%
	int PageCapa, MaxPage, StartRecord, EndRecord, CurrentPage;
	Object location=0, dept=0, category=0, subcategory=0, MN, uname, cmodel, ini=0;

	EQP eqp = new EQP();

	List<Map<String, Object>> SearchList = new ArrayList<Map<String, Object>>();
	Map<String, Object> map = null;
	
	ini = request.getParameter("initialize");
	
	location 	= request.getParameter("location");
	dept 		= request.getParameter("MNDept");
	category 	= request.getParameter("eqpcateg");
	subcategory = request.getParameter("subcate");
	
	MN 	   = DBConn.toUTF8(request.getParameter("MN"));				
	uname  = DBConn.toUTF8(request.getParameter("uname"));		
	cmodel = DBConn.toUTF8(request.getParameter("cmodel"));		

	if( request.getParameter("Line") != null )		 PageCapa 	 = Integer.parseInt(request.getParameter("Line")); 			else PageCapa = 15;
	if( request.getParameter("selectpage") != null ) CurrentPage = Integer.parseInt(request.getParameter("selectpage"));	else CurrentPage = 1;
	
	if( ini != null && Integer.valueOf((String)ini) == 1 ) // 검색 조건 초기화 옵션일 경우 
	{
		location = dept = category = subcategory = 0;
		MN = uname = cmodel = "";
		SearchList.clear();
	}

	map = new HashMap<String, Object>();	map.put("NAME", "e.location");		map.put("VALUE", location );	map.put("TYPE", "int");		SearchList.add(map);
	map = new HashMap<String, Object>();	map.put("NAME", "e.dept"    );		map.put("VALUE", dept );		map.put("TYPE", "int");		SearchList.add(map);
	map = new HashMap<String, Object>();	map.put("NAME", "e.category");		map.put("VALUE", category );	map.put("TYPE", "int");		SearchList.add(map);
	map = new HashMap<String, Object>();	map.put("NAME", "e.subcategory");	map.put("VALUE", subcategory );	map.put("TYPE", "int");		SearchList.add(map);
	map = new HashMap<String, Object>();	map.put("NAME", "e.MN");			map.put("VALUE", MN );			map.put("TYPE", "String");	SearchList.add(map);
	map = new HashMap<String, Object>();	map.put("NAME", "u.name");			map.put("VALUE", uname);		map.put("TYPE", "String");	SearchList.add(map);
	map = new HashMap<String, Object>();	map.put("NAME", "c.model");			map.put("VALUE", cmodel);		map.put("TYPE", "String");	SearchList.add(map);

	List<EQPdata> EQPlist = new ArrayList<EQPdata>();
	EQPlist = eqp.LoadExpansionEQPlist( SearchList );
	
	MaxPage = (EQPlist.size()-1)/PageCapa + 1;
	StartRecord = (CurrentPage-1) * PageCapa;
	EndRecord = StartRecord + PageCapa - 1;
%>

<script src="${root}/js/PCList.js"></script>
<script src="${root}/js/deviceInfo.js"></script>

<c:set var="MN" value="<%=MN%>" />
<c:set var="uname" value="<%=uname%>" />
<c:set var="cmodel" value="<%=cmodel%>" />

<input type=hidden name="hi_location" value="<%=location%>">
<input type=hidden name="hi_dept"	  value="<%=dept%>">
<input type=hidden name="hi_category" value="<%=category%>">
<input type=hidden name="hi_subcate"  value="<%=subcategory%>">

<table class="infobox" style="padding:1px;width:100%;border-spacing: 10px 4px;">
<tr><td align=left style="border-bottom:1px solid grey;">검색 조건</td></tr>

<tr>
	<td align=left style="border-bottom:1px solid grey;">

	<table style="border:1px;"><tr>
	<c:set value="<%=eqp%>" var="eqp" scope="page" />
	<td align=right style="width:50px;"><b>지역 :</b></td><td align=left style="width:150px;">${eqp.TAGlocation}</td>
	<td align=right style="width:50px;"><b>부서 :</b></td><td align=left style="width:150px;">${eqp.TAGMNDept}</td>
	<td align=right style="width:50px;"><b>제품군 :</b></td><td align=left style="width:150px;">${eqp.TAGeqpcateg}</td>
	<td align=right style="width:50px;"><b>구분 :</b></td><td align=left style="width:150px;"><select name="subcate" id="subcate" style="width:100%"></select></td>
	</tr></table>

	</td>
</tr>
<tr>
	<td align=right style="width:70px;" colspan=7>
		<b>모델명 :</b>	<input type="text" name="cmodel" value="${cmodel}" onKeydown="javascript:if(event.keyCode == 13) Move(this, 'PCList.jsp');">  
		<b>사용자 :</b>	<input type="text" name="uname" value="${uname}" onKeydown="javascript:if(event.keyCode == 13) Move(this, 'PCList.jsp');">  
		<b>관리번호 :</b>	<input type="text" name="MN" value="${MN}" onKeydown="javascript:if(event.keyCode == 13) Move(this, 'PCList.jsp');">
		<input type="button" value="검색" onclick="Move(this, 'PCList.jsp')">
	</td>
</tr>
</table>

<br>

<table class="infobox" style="width:100%; table-layout:inherit;">
<tr>
<td colspan=6>자산 목록(<%=EQPlist.size() %>)</td> <td colspan=1 align=right>Line : <input type=text name="Line" value=<%=PageCapa%> style="width:20px"onKeydown="javascript:if(event.keyCode == 13) Move(this, 'PCList.jsp');" ></td>
</tr>

<tr>
<th style="display:none"></th>
<th>제품군</th>
<th>구분</th>
<th>사용부서</th>
<th>관리번호</th>
<th>구매일자</th>
<th>가격</th>
<th>수량</th>
</tr>

<c:forEach var="index" items="<%=EQPlist %>" begin="<%=StartRecord %>" end="<%=EndRecord %>">
<tr style="cursor:pointer;" onmouseover="showProp(this, this.cells)" onclick="Move(this,'PCEdit.jsp')">
<td class="lrow" style="display:none" ><input type="radio" name="SelectValue" value="${index.idx}" style="display:none" ></td>
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


<%@ include file="../bottompage.jsp" %>