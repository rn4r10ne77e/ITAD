<%@ page language="java" contentType="text/html; charset=UTF-8" %>
 
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="ITAD.EQP" %>


<%
    request.setCharacterEncoding("UTF-8");
	EQP eqp = new EQP();
	String FolderName = "ASSETPICTURES";
	String DriverChar = "C:/";
	String TempSavePath = DriverChar + FolderName; 
	int maxSize  = 1024*1024*10;    
    
    String uploadFile = "";
    String newFileName = "";

    try
    {
    	MultipartRequest multi = new MultipartRequest(request, TempSavePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
    	String idx = multi.getParameter("idx");
    	int imgnumber = Integer.parseInt(multi.getParameter("imgnumber").toString());
    	    	
    	String savePath = "C:/ASSETPICTURES/"+idx;
    	

    	File dir = new File( DriverChar, FolderName );
        if( !dir.exists() ) dir.mkdir();
        
        File savept = new File("C:/"+dir.getName(),idx);
        if( !savept.exists() ) savept.mkdir();
        
    	File []fileList = savept.listFiles();

        // 파일업로드
        uploadFile = multi.getFilesystemName("uploadFile");

        // 실제 저장할 파일명(ex : 20140819151221.zip)
        newFileName = imgnumber+ "_"+ new Date().getTime() +"."+ uploadFile.substring(uploadFile.lastIndexOf(".")+1);

        // 업로드된 파일 객체 생성
        File oldFile = new File(TempSavePath +"/"+ uploadFile);

        // 실제 저장될 파일 객체 생성
        File newFile = new File(savePath +"/"+ newFileName);

    	for(File tempFile : fileList)
    	{
    		if(tempFile.isFile()) 
    		{
    			String tempFileName = tempFile.getName();
				String tempFilepath = tempFile.getPath();
    			
				String onlyname = tempFileName.substring(0, tempFileName.lastIndexOf(".") );
				onlyname = onlyname.substring(0, onlyname.lastIndexOf("_"));
				
				String onlynameNew = newFileName.substring(0, newFileName.lastIndexOf(".") );
				onlynameNew = onlynameNew.substring(0, onlynameNew.lastIndexOf("_"));

    	        if( onlyname.equals(onlynameNew) )
    	        {
    	        	tempFile.delete();
    	        }
    		}
    	}


		int read = 0;
		byte[] buf = new byte[1024];
		FileInputStream fin = null;
		FileOutputStream fout = null; 
	    	 
	    if(!oldFile.renameTo(newFile) )
	    {
	
	        // rename이 되지 않을경우 강제로 파일을 복사하고 기존파일은 삭제
	
	        buf = new byte[1024];
	        fin = new FileInputStream(oldFile);
	        fout = new FileOutputStream(newFile);
	        read = 0;
	        while((read=fin.read(buf,0,buf.length))!=-1){
	            fout.write(buf, 0, read);
	        }
	         
	        fin.close();
	        fout.close();
	        oldFile.delete();
	    }
	    
      //	eqp.LoadEQPdata(Integer.parseInt(idx));
      //	eqp.setPictarget(String.valueOf(imgnumber));
      //	eqp.UpdateEQPdata();
      

	}
	catch(Exception e)
	{
		System.out.println("Exception Error : "+e.getMessage());
	    e.printStackTrace();
	}
 
%>