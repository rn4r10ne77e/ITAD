<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table class=infobox style="padding-top:2px; padding-bottom:2px">
<tr>
<th> 자산 사진</th>
</tr>
<tr>
<% 
	String LoadPath = "C:/ASSETPICTURES";
	String idx = request.getParameter("idx");
	String imgnumber;
	
	EQP eqp = new EQP();

	if( eqp.LoadEQPdata(Integer.parseInt(idx)) )
	{
	
		if( eqp.getPictarget().length() != 0 && eqp.getPictarget() != null) imgnumber = eqp.getPictarget();
		else imgnumber = "noimage";
	}
	else 
		imgnumber = "noimage";

	File openFolder = new File( LoadPath + "/" , idx );
	
	if( !imgnumber.equals("noimage") && openFolder.exists() )
	{
		File []fileList = openFolder.listFiles();
		for(File tempFile : fileList)
    	{
    		if(tempFile.isFile() && ( tempFile.getName().lastIndexOf("_") > 0) ) 
    		{
    			String frontfilename = tempFile.getName().substring(0, tempFile.getName().lastIndexOf("_"));
    			if( frontfilename.equals( String.valueOf( imgnumber )) )
    			{
    				out.print("<td><img src='/eqpic/"+idx+"/"+tempFile.getName()+"' style='width:200px;height:200px'></td>");
    			}
    		}
    	}
	}
	else out.print("<td><img src='images/noimg.png' style='width:120px; height:120px'></td>");
%>
</tr>


</table>


