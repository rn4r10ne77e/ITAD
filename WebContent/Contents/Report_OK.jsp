<%@ include file="../toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%
	if (request.getParameter("SelectedItems") != null)
	{
		String Items[] = request.getParameterValues("SelectedItems");
		
		for (String Item : Items)
		{
			out.print(Item + "<br/>");
		}
	}
%>

<script>
	windows.print
</script>

<%@ include file="../bottompage.jsp" %>