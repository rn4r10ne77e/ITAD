package DeviceInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import ITAD.DBConn;
import ITAD.EQP;
import ITAD.DataStructure.NameTable;

/**
 * Servlet implementation class C
 */
@WebServlet("/C")
public class C extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EQP eqp = new EQP();
		
		int flag = 0;
		JSONArray ja = new JSONArray();
		JSONObject json_result = new JSONObject();
		Iterator it;
		List<NameTable> NT = new ArrayList<NameTable>();
		NT.clear();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String reqType = request.getParameter("type");
		int reqID = Integer.parseInt(request.getParameter("ID"));
		
		if( reqType.equals("P") )
		{
			NT = eqp.GetEQPcategory(1, reqID);
			it = NT.iterator();
			while( it.hasNext() )
			{
				JSONObject json = new JSONObject();
				NameTable a;
				a = (NameTable) it.next();
				
				json.put("id",a.getValue());
				json.put("name",a.getDescription());
				ja.put(json);
				json_result.put("category", ja);
			}
			flag = 1;
		}else if( reqType.equals("C"))
		{
			NT = eqp.GetEQPcategory(2, reqID);
			it = NT.iterator();
			while( it.hasNext() )
			{
				JSONObject json = new JSONObject();
				NameTable a;
				a = (NameTable) it.next();
				
				json.put("id",a.getValue());
				json.put("name",a.getDescription());
				ja.put(json);
				json_result.put("category", ja);
			}
			flag = 1;
		}
		else flag = 0;

		json_result.put("success", flag);
		
		PrintWriter out = response.getWriter();

		out.print(json_result);
		out.flush();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EQP eqp = new EQP();
		
		int flag = 0;
		JSONArray ja = new JSONArray();
		JSONObject json_result = new JSONObject();
		Iterator it;
		List<NameTable> NT = new ArrayList<NameTable>();
		NT.clear();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;");
		response.setCharacterEncoding("UTF-8");
		
		String reqType = request.getParameter("type");
		int reqID = Integer.parseInt(request.getParameter("ID"));
		
		if( reqType.equals("P") )
		{
			NT = eqp.GetEQPcategory(1, reqID);
			it = NT.iterator();
			while( it.hasNext() )
			{
				JSONObject json = new JSONObject();
				NameTable a;
				a = (NameTable) it.next();
				
				json.put("id",a.getValue());
				json.put("name",a.getDescription());
				ja.put(json);
				json_result.put("category", ja);
			}
			flag = 1;
		}else if( reqType.equals("C"))
		{
			NT = eqp.GetEQPcategory(2, reqID);
			it = NT.iterator();
			while( it.hasNext() )
			{
				JSONObject json = new JSONObject();
				NameTable a;
				a = (NameTable) it.next();
				
				json.put("id",a.getValue());
				json.put("name",a.getDescription());
				ja.put(json);
				json_result.put("category", ja);
			}
			flag = 1;
		}
		else flag = 0;

		json_result.put("success", flag);
		
		PrintWriter out = response.getWriter();

		out.print(json_result);
		out.flush();
		
	}

}
