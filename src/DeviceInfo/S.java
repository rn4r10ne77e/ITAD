package DeviceInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import ITAD.User;

/**
 * Servlet implementation class CheckPhoneNumber
 */
@WebServlet("/S")
public class S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		User usr = new User();
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		if( usr.LoadUserDataByMobile(request.getParameter("pnumber")) ) json.put("success", 1);
		else json.put("success", 0);
			
		PrintWriter out = response.getWriter();

		out.print(json);
		out.flush();	

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JSONObject json = new JSONObject();
		User usr = new User();
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String reqPhone="";
		
		if( request.getParameter("pnumber") != null ) reqPhone = request.getParameter("pnumber");
		
		if( reqPhone.substring(0, 1).equals("+") ) reqPhone = reqPhone.replace("+82", "0");
		
		
		System.out.println(reqPhone);

		if( usr.LoadUserDataByMobile(reqPhone) ) json.put("success", 1);
		else json.put("success", 0);
		
		
		
	
		PrintWriter out = response.getWriter();

		out.print(json);
		out.flush();	
		
		doGet(request, response);
	}

}
