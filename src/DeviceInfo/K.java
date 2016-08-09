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

import ITAD.EQP;

/**
 * Servlet implementation class K
 */
@WebServlet("/K")
public class K extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public K() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		EQP eqp = new EQP();

		JSONObject json_result = new JSONObject();
		
		PrintWriter out = response.getWriter();
		out.flush();
		
		json_result.put("newkey", eqp.ncount("TAGKEY") );
		json_result.put("success", 1);
		
		out.print(json_result);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		
		EQP eqp = new EQP();

		JSONObject json_result = new JSONObject();
		
		PrintWriter out = response.getWriter();
		out.flush();
		
		json_result.put("newkey", eqp.ncount("TAGKEY") );
		json_result.put("success", 1);
		
		out.print(json_result);
		out.flush();
		
	}

}
