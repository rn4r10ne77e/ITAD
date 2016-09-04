<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table>

<tr>
<th>이미지 1</th>
<th>이미지 2</th>
<th>이미지 3</th>
<th>이미지 4</th>
</tr>

<% 
	String LoadPath = "C:/ASSETPICTURES";

	String idx = request.getParameter("idx");

	File openFolder = new File( LoadPath + "/" , idx );

	out.print("<tr>");
	for( int i=1 ; i<=4 ; i++ )
	{
		boolean flag = false;
		if( openFolder.exists() )
		{
			File []fileList = openFolder.listFiles();
			for(File tempFile : fileList)
	    	{
	    		if(tempFile.isFile() && ( tempFile.getName().lastIndexOf("_") > 0 )) 
	    		{
	    			String frontfilename = tempFile.getName().substring(0, tempFile.getName().lastIndexOf("."));
	    			frontfilename = frontfilename.substring(0, frontfilename.lastIndexOf("_"));

	    			if( frontfilename.equals( String.valueOf(i)) ) 
	    			{
	    				out.print("<td><img src='/eqpic/"+idx+"/"+tempFile.getName()+"' class='imggal'><br>");

	    				flag = true;
	    				break;
	    			}
				}
			}
		}

		if( !flag ) out.print("<td><img src='"+request.getContextPath()+"/images/noimg.png' class='imggal'>");
		out.print("<input type='file' name='uploadfile"+i+"' id='uploadfile"+i+"' onchange=\"uploadajax('upload_ok.jsp','uploadfile"+i+"','"+idx+"','"+i+"');popup2('pop', 'ppPictures.jsp','idx="+idx+"' );\" > <br> ");
	}

	out.print("</tr>");
%>
</table>



