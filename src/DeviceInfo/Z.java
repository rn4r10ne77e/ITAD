package DeviceInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * Servlet implementation class Z
 */
@WebServlet("/Z")
public class Z extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Z() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String getStrIMG = request.getParameter("image");
		System.out.println(getStrIMG);
		System.out.println("Length : "+getStrIMG.length());
		
		
		String FolderName = "";
    	String DriverChar = "C:/";
		 try
		    {
		    	String TempSavePath = DriverChar + FolderName; 
		    	File dir = new File( DriverChar, FolderName );
		        if( !dir.exists() ) dir.mkdir();

		        String savePath = "C:/";
		        String newFileName = "";
		        
		        
		        File savept = new File("C:/");
		        if( !savept.exists() ) savept.mkdir();
		        
		    	File []fileList = savept.listFiles();
		    	
		    	byte[] imageByteArray = Base64.decode(getStrIMG);
		
				// Write a image byte array into file system
				FileOutputStream imageOutFile = new FileOutputStream(TempSavePath +"/"+ "tmp.jpg");
		
				imageOutFile.write(imageByteArray);
				imageOutFile.close();
		
		    	
		        // 파일업로드
		
		        // 실제 저장할 파일명(ex : 20140819151221.zip)
		        newFileName =  "test."+ "jpg";
		        
				
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
			}
			catch(Exception e)
			{
				System.out.println("Exception Error : "+e.getMessage());
			    e.printStackTrace();
			}
	}

}
