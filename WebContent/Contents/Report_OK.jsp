<%@ include file="../toppage.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%
	Test jr = new Test();
	User loginUser = new User();
	Map<String, Object> parameters = new HashMap<String, Object>();
	String RealRootPath, PDFoutputPath;	
	int uidx = 0;
	

	out.print(request.getRealPath("/"));
	out.print("<br/>");
	
	String Items[] = request.getParameterValues("SelectedItems");
	
	uidx = Integer.parseInt(session.getAttribute("LoginedUser").toString());
	
	loginUser.LoadUserData(uidx);

	parameters.put( "IDX", Items[0] );

	jr.setParameter(parameters);
	jr.setRealRootPath(request.getRealPath("/"));
	jr.setReportName("FixedAssetDesposalForm");
	jr.setUserID(loginUser.getID());
	
	jr.ProgressConvert();
	
	if (request.getParameter("SelectedItems") != null)
	{
		for (String Item : Items)
		{
			out.print(Item + "<br/>");
		}
	}
%>

<%@ include file="../bottompage.jsp" %>