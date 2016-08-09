package DeviceInfo;

import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class IMGVIEW
 */
@WebServlet("/IMGVIEW")
public class IMGVIEW extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMGVIEW() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//parameter을 받는 부분
			String idx = request.getParameter("idx");
			String no = request.getParameter("no");
		 
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			 
			String imagePath = "D:/ASSETPICTURES";
			imagePath = imagePath + "/" + idx + "/" +no;
			 
			File file = new File(imagePath);
			int size = (int)file.length();

			bos = new BufferedOutputStream(response.getOutputStream());
			byte b[] = new byte[2048];
			int read = 0;
			if( size>0 && file.isFile() ) {
			    bis = new BufferedInputStream(new FileInputStream(file));
			    while((read=bis.read(b))!=-1 ) {
			        bos.write(b,0,read);
			    }
			} 
			
			bos.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
