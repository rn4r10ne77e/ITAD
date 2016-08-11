<%@ include file="toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<%

	EQP eqp = new EQP();
	User user = new User(); 
	COMast ast = new COMast();
	History hstr = new History();

	String message = null; String today; int currentEQPidx;

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

<c:set value="<%=ast%>" var="ast" scope="page" />
<c:set value="<%=user%>" var="user" scope="page" />
<c:set value="<%=eqp%>" var="eqp" scope="page" />
<c:set value="<%=hstr%>" var="hstr"  scope="page" />

<script>
window.onload = function()
{
	document.main.price.value = comma(document.main.price.value);
	document.main.eqpcateg.onchange = function()
	{
		var param = "parent="+document.main.eqpcateg.value;
		innerajax( "subcate", "subcate.jsp", param );
	}

	document.main.eqpcateg.value = ${eqp.eqpcateg}
	document.main.subcate.value = ${eqp.subcate}
	
	document.main.location.value = ${eqp.location}
	document.main.MNDept.value = ${eqp.MNDept}

	document.main.vendor.value = ${eqp.vendor}
	document.main.hiscateg.value = ${hstr.hiscateg}

	
	
	SetValuetoRadio("status","${eqp.status}")
	innerajax( "photoframe", "ppPicture.jsp", "idx=${eqp.idx}" );
}
</script>

<table style="width:99%">
<tr><td valign="top">

	<table class="infobox" style="width:100%;">
		<tr>
			<td colspan=3 >기본 정보 (자산번호 : ${eqp.MN})<input type=hidden name="idx" value="${eqp.idx}"></td>
			<td rowspan=6 style="border:1px;" align=right><a onclick="popup('pop', 'ppPictures.jsp','idx=${eqp.idx}' )" id="photoframe"></a></td>
		</tr>
		
		<tr>
			<td>지역 ${eqp.TAGlocation}</td><td> 부서 ${eqp.TAGMNDept}</td><td> 제품 ${eqp.TAGeqpcateg} 구분 ${eqp.TAGsubcate} </td>
		</tr>
		
		<tr>
			<td>
				구매일자 <input type="text" name="genedate" style="width:90px" value="${eqp.genedate}">
			</td>
			<td>
				금액 <input type="text" name="price" style="width:115px" value="${eqp.price}" onkeyup="inputNumberFormat(this)">
			 </td>
			 <td rowspan=4 align=left>
				메모 <textarea cols=45 rows=6></textarea>
			</td>
		</tr>
		
		<tr>
			<td>
				사용자 <input type="text" name="name"  style="width:100px" value="${user.name}">
			</td>
			<td>
				수량 <input type="text" name="qty" style="width:25px" value="${eqp.qty}">
				태그 <input type=text name="mark" style="width:45px" value="${eqp.mark}">
			</td>
		</tr>
		
		<tr>
			<td>
			SAP 번호 <input type="text" name="sapno" style="width:90px" value="${eqp.sapno}">
			</td>
			<td>
			거래처 ${eqp.TAGvendor} 
			</td>
		</tr>
		<tr>
			<td>
				관리자 1 <input type=text name="admin1" style="width:90px" value="${eqp.admin1}">
			</td>
			<td>
				관리자 2 <input type=text name="admin2" style="width:90px" value="${eqp.admin2}">
			</td>
		</tr>
	</table>
	
</td>
</tr>

<tr>
<td  valign="top">

	<table class="infobox" style="width:100%;">
	<tr><td colspan=3> 제품 정보 </td></tr>
	<tr>
		<td>모델명 <input type="text" name="model" value="${ast.model}"></td>
		<td rowspan=2 align=right> &nbsp;&nbsp;비 고</td>
		<td rowspan=2 align=right><textarea name=memo rows="3" cols="95">${ast.memo}</textarea></td>
	</tr>
	<tr><td>제조사 <input type="text" name="manufacturer" value="${ast.manufacturer}"></td><tr>
	
	</table>

</td>
</tr>


<tr><td valign="bottom">

	<table class="infobox" style="width:100%;">
	<tr><td colspan=2> 이력 등록 </td></tr>
	<tr>
		<td align=left>제 목</td><td> <input type="text" name="title" value="${hstr.title}" onfocus="">
		구 분 <select name="hiscateg"><option value=0 selected>선택 없음</option><option value=4>유지 보수</option></select>
		날 짜 <input type="text" name="date" value="${hstr.date}" size=10></td>
	</tr>
	<tr>
		<td align=left>내 용</td>
		<td><textarea name="content" rows=8 cols=127 >${hstr.content}</textarea>
		</td>
	</tr>
	</table>

<input type="hidden" name="eqpidx" value="${eqp.eqpidx}" >
<input type="hidden" name="useridx" value="${eqp.useridx}" >

</td></tr>

<tr><td colspan=2 ><hr></td></tr>
<tr>
<td colspan=2 >

	<table style="width:100%;" >
	<tr>
	<td>
	자산 상태 : 
	<input type=radio name="status" value=1 ><a style="cursor:pointer;"onclick="SetValuetoRadio('status','1')">사용</a>
	<input type=radio name="status" value=2 ><a style="cursor:pointer;"onclick="SetValuetoRadio('status','2')">미사용</a>
	<input type=radio name="status" value=3 ><a style="cursor:pointer;"onclick="SetValuetoRadio('status','3')">폐기</a>
	</td>
	<td align="right" ><input type="button" value="저장" onclick="document.main.price.value = uncomma(document.main.price.value); Move(this, 'PCEdit_OK.jsp')"></td>
	</tr>
	</table>

</td>
</table>

<br>
<br>

<table class="infobox" style="width:100%; table-layout:inherit;">
<tr><td colspan=5><p> 장비 이력 목록 </p></td></tr>

<tr><th style="width:150px;">날짜 </th><th>구분 </th><th>제목 </th><th style="width:350px;">내용</th><th>수정자</th></tr>
<c:forEach var="index" items="<%=hstr.LoadHistoryList(currentEQPidx) %>">

<tr style="cursor:pointer;"  onmouseover="showProp(this, this.cells)" onclick="ViewDetail(this, this.cells)">
<td id="hstridx"style="display:none">${index.idx}</td>
<td>${index.date}</td>
<td>${index.hiscateg}</td>
<td>${index.title}</td>
<td>${fn:replace(index.content, newLineChar, "<br/>")}</td>
<td>${index.STRaddwho}</td>
</tr>
<tr id="${index.idx}detail"></tr>

</c:forEach>
</table>

<!-- --------------------------------------------------------------------------------------------------------------------------------------------- -->

<%@ include file="bottompage.jsp"%>