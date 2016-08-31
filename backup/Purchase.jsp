<%@ include file="toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<%
	EQP eqp = new EQP();
	User user = new User(); 
	COMast ast = new COMast();

	Object location, dept, category, subcategory, MN, uname, cmodel, ini=0;
	
	ini = request.getParameter("initialize");
	location = request.getParameter("location");
	dept = request.getParameter("MNDept");
	category = request.getParameter("eqpcateg");
	subcategory = request.getParameter("subcate");
	MN = DBConn.toUTF8(request.getParameter("MN"));
	uname = DBConn.toUTF8(request.getParameter("uname"));
	cmodel = DBConn.toUTF8(request.getParameter("cmodel"));
	
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
%>

<script>
window.onload = function()
{
	document.main.location.value = 	 <%= ( location != null )?location:0 %>;
	document.main.eqpcateg.value = 	 <%= ( category != null )?category:0 %>;

	var param = "parent="+document.main.eqpcateg.value;
	innerajax( "subcate", "subcate.jsp?TableName=EQPCATEG", param );

	document.main.subcate.value = <%= ( subcategory != null )?subcategory:0 %>;

	document.main.eqpcateg.onchange = function()
	{
		var param = "parent="+document.main.eqpcateg.value;
		innerajax( "subcate", "subcate.jsp?TableName=EQPCATEG", param );
	}
	
	var param2 = "parent="+document.main.location.value;
	innerajax( "MNDept", "subcate.jsp?TableName=LOCXDEPT", param2 );

	document.main.MNDept.value = 	 <%= ( dept != null )?dept:0 %>;
	document.main.location.onchange = function()
	{
		var param2 = "parent="+document.main.location.value;
		innerajax( "MNDept", "subcate.jsp?TableName=LOCXDEPT", param2 );
	}

	var obj = document.getElementsByClassName('price');
	for( var i=0 ; i<obj.length ; i++ )
	{
		obj[i].innerHTML = comma(obj[i].innerHTML);
	}
}

</script>


<table style="width:99%" class=infobox><tr><td>
구매 번호(혹은 SAP 번호)와 장비 등록에 필요한 정보를 입력 해 주세요. <br><br>
<font color=gray >구매 번호 : </font><input type="text" name="MN" id="MN"value="<%= (request.getParameter("MN")!=null)?request.getParameter("MN"):"" %>" >
</td>
<td>

</td>
</tr>
</table>
<br>

<c:set value="<%=eqp%>" var="eqp" scope="page" />

<table class="infobox" style="width:99%;">
	<tr>
		<td>구매 정보 ( 구매 번호 : ${eqp.MN} )<input type=hidden name="idx" value="${eqp.idx}"></td>
		
	</tr>
	<tr>
		<td>지역 ${eqp.TAGlocation} 부서 ${eqp.TAGMNDept} 제품 ${eqp.TAGeqpcateg} 구분 ${eqp.TAGsubcate} 
		<select name="subcate" id="subcate" style="width:120px"></select>
		</td>
	</tr>
		
</table>
<br>
<p align=right>
<input type="button" value="등록" onclick="document.main.price.value = uncomma(document.main.price.value); Move(this, 'Enrollment_OK.jsp')">
</p>
<%@ include file="bottompage.jsp"%>