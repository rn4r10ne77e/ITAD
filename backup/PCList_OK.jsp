<%@ include file="../toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<% 
	session.setAttribute("EQPListCurrentPage", request.getParameter("selectpage"));
	session.setAttribute("EQPListSearchColumn", request.getParameter("searchcolumn"));
	session.setAttribute("EQPListSearchKeyword", request.getParameter("searchkeyword"));

%>

<script>
window.onload=function()
{
	document.main.action="PCList.jsp";
	document.main.submit();
}
</script>

<%@ include file="bottompage.jsp"%>