package DeviceInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import ITAD.EQP;

/**
 * Servlet implementation class P
 */
@WebServlet("/P")
public class P extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public P() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String getStrIMG = request.getParameter("image");
		String tag = request.getParameter("tag");
		String no = request.getParameter("no");
		
		EQP eqp = new EQP();
		eqp.LoadEQPdataByMobile(no);
		
		
		int idx = eqp.getIdx();
		
		String SavePath = "D:/ASSETPICTURES";
		
		String FolderName = "ASSETPICTURES";
    	String DriverChar = "D:/";
    	
    try
    {
    	String TempSavePath = DriverChar + FolderName; 
    	File dir = new File( DriverChar, FolderName );
        if( !dir.exists() ) dir.mkdir();


        String savePath = "D:/ASSETPICTURES/"+idx;
        String newFileName = "";
        
        
        File savept = new File("D:/"+dir.getName(),String.valueOf(idx));
        if( !savept.exists() ) savept.mkdir();
        
    	File []fileList = savept.listFiles();
    	
    	byte[] imageByteArray = Base64.decode(getStrIMG);

		// Write a image byte array into file system
		FileOutputStream imageOutFile = new FileOutputStream(TempSavePath +"/"+ "tmp.jpg");

		imageOutFile.write(imageByteArray);

		imageOutFile.close();

    	
        // 파일업로드

        // 실제 저장할 파일명(ex : 20140819151221.zip)
        newFileName = no + "_" + new Date().getTime() + "."+ "jpg";
        
        // 업로드된 파일 객체 생성
        File oldFile = new File(TempSavePath +"/"+ "tmp.jpg");

        // 실제 저장될 파일 객체 생성
        File newFile = new File(savePath +"/"+ newFileName);
                
    	for(File tempFile : fileList)
    	{
    		if(tempFile.isFile()) 
    		{
    			String tempFileName = tempFile.getName();
    			
				String onlyname = tempFileName.substring(0, tempFileName.lastIndexOf(".") );
				onlyname = onlyname.substring(0, onlyname.lastIndexOf("_"));
				
				String onlynameNew = newFileName.substring(0, newFileName.lastIndexOf(".") );
				onlynameNew = onlynameNew.substring(0,  onlynameNew.lastIndexOf("_"));
				
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
	
	}
	catch(Exception e)
	{
		System.out.println("Exception Error : "+e.getMessage());
	    e.printStackTrace();
	}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String getStrIMG = request.getParameter("image");
		String tag = request.getParameter("ID");
		String no = request.getParameter("ID2");
		
		System.out.println(" image : "+getStrIMG);
	
		
		JSONObject json = new JSONObject();
		EQP eqp = new EQP();
		eqp.LoadEQPdataByMobile(tag);
		
		
		int idx = eqp.getIdx();
		
		String SavePath = "C:/ASSETPICTURES";
		
		String FolderName = "ASSETPICTURES";
    	String DriverChar = "C:/";
    	
	    try
	    {
	    	String TempSavePath = DriverChar + FolderName; 
	    	File dir = new File( DriverChar, FolderName );
	        if( !dir.exists() ) dir.mkdir();
	
	
	        String savePath = "C:/ASSETPICTURES/"+idx;
	        String newFileName = "";
	        
	        
	        File savept = new File("C:/"+dir.getName(),String.valueOf(idx));
	        if( !savept.exists() ) savept.mkdir();
	        
	    	File []fileList = savept.listFiles();
	    	
	    	byte[] imageByteArray = Base64.decode(getStrIMG);
	
			// Write a image byte array into file system
			FileOutputStream imageOutFile = new FileOutputStream(TempSavePath +"/"+ "tmp.jpg");
	
			imageOutFile.write(imageByteArray);
	
			imageOutFile.close();
	
	    	
	        // 파일업로드
	
	        // 실제 저장할 파일명(ex : 20140819151221.zip)
	        newFileName = no +"."+ "jpg";
	        
			
	        // 업로드된 파일 객체 생성
	        File oldFile = new File(TempSavePath +"/"+ "tmp.jpg");
	
	        // 실제 저장될 파일 객체 생성
	        File newFile = new File(savePath +"/"+ newFileName);
	                
	    	for(File tempFile : fileList)
	    	{
	    		if(tempFile.isFile()) 
	    		{
	    			String tempFileName = tempFile.getName();
	    			
					String onlyname = tempFileName.substring(0, tempFileName.lastIndexOf(".") );
					String onlynameNew = newFileName.substring(0, newFileName.lastIndexOf(".") );
					
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
		    
		    if( newFile.exists() ) json.put("success", 1) ;
			else json.put("success", 0);
			
			PrintWriter out = response.getWriter();

			out.print(json);
			out.flush();
		
		}
		catch(Exception e)
		{
			System.out.println("Exception Error : "+e.getMessage());
		    e.printStackTrace();
		    
		    json.put("success", 0);
			
			PrintWriter out = response.getWriter();

			out.print(json);
			out.flush();
		}
	    
	   // eqp.setPictarget(no);
      //	eqp.UpdateEQPdata();
		
		/*
		try {			

			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.decode(getStrIMG);

			// Write a image byte array into file system
			FileOutputStream imageOutFile = new FileOutputStream(SavePath+"/");

			imageOutFile.write(imageByteArray);

			imageOutFile.close();

			System.out.println("Image Successfully Manipulated!");
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		catch( Exception ee ){ System.out.println(ee.getMessage()); }
		 */
	    
		
		
	}
}
