<%@ include file="../toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<%
	EQP eqp = new EQP();
	User user = new User(); 
	COMast ast = new COMast();

	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
%>

<c:set value="<%=ast%>" var="ast" scope="page" />
<c:set value="<%=user%>" var="user" scope="page" />
<c:set value="<%=eqp%>" var="eqp" scope="page" />

<script>
window.onload = function()
{
	var param = "parent="+document.main.eqpcateg.value;
	innerajax( "subcate", "../subcate.jsp?TableName=EQPCATEG", param );

	document.main.eqpcateg.onchange = function()
	{
		var param = "parent="+document.main.eqpcateg.value;
		innerajax( "subcate", "../subcate.jsp?TableName=EQPCATEG", param );
	}
	
	var param2 = "parent="+document.main.location.value;
	innerajax( "MNDept", "../subcate.jsp?TableName=LOCXDEPT", param2 );

	document.main.location.onchange = function()
	{
		var param2 = "parent="+document.main.location.value;
		innerajax( "MNDept", "../subcate.jsp?TableName=LOCXDEPT", param2 );
	}

	var obj = document.getElementsByClassName('price');
	for( var i=0 ; i<obj.length ; i++ )
	{
		obj[i].innerHTML = comma(obj[i].innerHTML);
	}
	innerajax( "photoframe", "../ppPicture.jsp","idx=0" );
}
</script>


<table style="width:99%" class=infobox ><tr><td>
구매 번호(혹은 SAP 번호)와 장비 등록에 필요한 정보를 입력 해 주세요. <br><br>
<font color=gray >구매 번호 : </font><input type="text" name="MN" id="MN"value="<%= (request.getParameter("MN")!=null)?request.getParameter("MN"):"" %>" >
</td>
<td>

</td>
</tr>
</table>
<br>

<table style="width:99%">
<tr><td valign="top">

	<table class="infobox" style="width:100%;">
		<tr>
			<td colspan=3>기본 정보 (자산번호 : ${eqp.MN})<input type=hidden name="idx" value="${eqp.idx}"></td>
			<td rowspan=6 style="border:1px;" align=right><a onclick="popup('pop', '../ppPictures.jsp','idx=${eqp.idx}' )" id="photoframe"></a></td>
		</tr>
		
		<tr>
			<td>지역 ${eqp.TAGlocation}</td>
			<td> 부서 ${eqp.TAGMNDept}</td>
			<td> 제품 ${eqp.TAGeqpcateg} 구분 <select name="subcate" id="subcate" style="width:130px"></select></td>
		</tr>
		
		<tr>
			<td> 구매일자 <input type="text" name="genedate" style="width:90px" value="${eqp.genedate}">	</td>
			<td> 금액 <input type="text" name="price" style="width:115px" value="${eqp.price}" onkeyup="inputNumberFormat(this)"> </td>
			<td rowspan=4 align=left>	메모 <textarea cols=45 rows=6></textarea></td>
		</tr>
		
		<tr>
			<td> 사용자 <input type="text" name="name"  style="width:100px" value="${user.name}"> </td>
			<td> 수량 <input type="text" name="qty" style="width:25px" value="${eqp.qty}"> 태그 <input type=text name="mark" style="width:45px" value="${eqp.mark}">	</td>
		</tr>
		
		<tr>
			<td> SAP 번호 <input type="text" name="sapno" style="width:90px" value="${eqp.sapno}"> </td>
			<td> 거래처 ${eqp.TAGvendor} </td>
		</tr>
		
		<tr>
			<td> 관리자 1 <input type=text name="admin1" style="width:90px" value="${eqp.admin1}"> </td>
			<td> 관리자 2 <input type=text name="admin2" style="width:90px" value="${eqp.admin2}"> </td>
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

</table>


<input type="button" value="등록" onclick="document.main.price.value = uncomma(document.main.price.value); Move(this, '../Enrollment_OK.jsp')">

<%@ include file="../bottompage.jsp"%>