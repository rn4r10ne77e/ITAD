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

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.JSONArray;
import org.json.JSONObject;

import ITAD.EQP;
import ITAD.PC;
import ITAD.User;
import ITAD.DataStructure.NameTable;

/**
 * Servlet implementation class T
 */
@WebServlet("/T")
public class T extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int flag = 0;
		EQP eqp = new EQP();
		
		JSONArray ja = new JSONArray();
		JSONObject json_result = new JSONObject();
		Iterator it;
		List<NameTable> NT = new ArrayList<NameTable>();
		NT.clear();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;");
		response.setCharacterEncoding("UTF-8");
		
		String reqType = request.getParameter("type");
		
		if( reqType.equals("dept") )
		{
			NT = eqp.GetNameTalbe("LOCXDEPT", 2);
			it = NT.iterator();
			while( it.hasNext() )
			{
				JSONObject json = new JSONObject();
				NameTable a;
				a = (NameTable) it.next();
				
				json.put("id",a.getValue());
				json.put("name",a.getDescription());
				ja.put(json);
				json_result.put(reqType, ja);

			}
			flag = 1;
		}
		else if( reqType.equals("location"))
		{
			NT = eqp.GetNameTalbe("LOCXDEPT", 1);
			it = NT.iterator();
			while( it.hasNext() )
			{
				JSONObject json = new JSONObject();
				NameTable a;
				a = (NameTable) it.next();
				
				json.put("id",a.getValue());
				json.put("name",a.getDescription());
				ja.put(json);
				json_result.put(reqType, ja);

			}
			flag = 1;
		}
		else if( reqType.equals("status"))
		{
			NT = eqp.GetNameTalbe("EQPSTATUS", 1);
			it = NT.iterator();
			while( it.hasNext() )
			{
				JSONObject json = new JSONObject();
				NameTable a;
				a = (NameTable) it.next();
				
				json.put("id",a.getValue());
				json.put("name",a.getDescription());
				ja.put(json);
				json_result.put(reqType, ja);

			}
			flag = 1;
		}
		else flag = 0;

		json_result.put("success", flag);
		
		PrintWriter out = response.getWriter();

		out.print(json_result);
		out.flush();
		
		response.getWriter().append("served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int flag = 0;
		EQP eqp = new EQP();
		
		JSONArray ja = new JSONArray();
		JSONObject json_result = new JSONObject();
		Iterator it;
		List<NameTable> NT = new ArrayList<NameTable>();
		NT.clear();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String reqType = request.getParameter("type");

		if( reqType.equals("dept") )
		{
			NT = eqp.GetNameTalbe("LOCXDEPT", 2);
			
			it = NT.iterator();
			while( it.hasNext() )
			{
				JSONObject json = new JSONObject();
				NameTable a;
				a = (NameTable) it.next();
				
				json.put("id",a.getValue());
				json.put("name",a.getDescription());
				ja.put(json);
				json_result.put(reqType, ja);
			}
			flag = 1;
		}else if( reqType.equals("location"))
		{
			NT = eqp.GetNameTalbe("LOCXDEPT", 1);
			it = NT.iterator();
			while( it.hasNext() )
			{
				JSONObject json = new JSONObject();
				NameTable a;
				a = (NameTable) it.next();
				
				json.put("id",a.getValue());
				json.put("name",a.getDescription());
				ja.put(json);
				json_result.put(reqType, ja);
			} 
			flag = 1;
		}
		else if( reqType.equals("status"))
		{
			NT = eqp.GetNameTalbe("EQPSTATUS", 1);
			it = NT.iterator();
			while( it.hasNext() )
			{
				JSONObject json = new JSONObject();
				NameTable a;
				a = (NameTable) it.next();
				
				json.put("id",a.getValue());
				json.put("name",a.getDescription());
				ja.put(json);
				json_result.put(reqType, ja);
			}
			flag = 1;
		}
		else flag = 0;

		json_result.put("success", flag);
		
		PrintWriter out = response.getWriter();

		out.print(json_result);
		out.flush();
		
		doGet(request, response);
	}

}
