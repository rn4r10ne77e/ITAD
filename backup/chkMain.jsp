<%
	request.setCharacterEncoding("UTF-8");

	String dir;
	
	if( request.getParameter("DIR") != null ) dir = request.getParameter("DIR");
	else dir = getServletContext().getRealPath("/");
	
	//request.getParameter("var");
	//타겟 디렉토리
	//out.print(dir);

	java.io.File f = new java.io.File(dir);
	
	if(f.exists())
	{
		String[] filelist = f.list();
		for (int i = 0; i < filelist.length; i++) 
		{
			java.io.File subF = new java.io.File(dir + "/" + filelist[i]);
		                         //디렉토리인경우 (이페이지 다시 호출)
			if (subF.isDirectory()) 
			{
				String subdir = dir + "/" + subF .getName();
				out.println("<a href='chkMain.jsp?DIR=" + subdir + "'>" + subF.getName() + "</a><BR>");
			}
	                         //파일인경우 (파일뷰처리 서블렛으로 )
			if (subF.isFile())
			{
				String file = dir + "/" + subF .getName();
				out.println("<a href='chk-charge?FILE=" + file + "'>" + subF.getName() + "</a><BR>");
			}
		}
	}
%>