package DeviceInfo;

import ITAD.*;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeviceInfo
 */
@WebServlet("/L")
public class L extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public L() {
        super();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int flag = 0;
		String EpqIdx = null;
		
		EQP eqp = new EQP();
		User usr = new User();
		COMast cst = new COMast();
		
		JSONObject json = new JSONObject();
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		if( request.getParameter("id") != null && request.getParameter("id") != "" )
		{
			EpqIdx = request.getParameter("id");
			flag = 1;
		}
		else flag = 0;
		
		if( !eqp.LoadEQPdataByMobile(EpqIdx) )
		{
			flag = 0;
		}
		else
		{
			if( !usr.LoadUserDataByMobile(eqp.getUseridx()) ) usr.setName("NA");
			if( !cst.load(eqp.getEqpidx())) 

			json.put("pid", eqp.getMN());
			json.put("location", eqp.getSTRlocation());
			json.put("dept", eqp.getSTRMNDept());
			json.put("owner", usr.getName());
			json.put("purcdate", eqp.getgenedate());
			json.put("status", eqp.getSTRstatus());
			json.put("model", cst.getModel());
			json.put("remark", cst.getMemo());
			flag = 1;
		}

		JSONArray ja = new JSONArray();
		ja.put(json);

		JSONObject json_result = new JSONObject();
		
		json_result.put("device", ja);
		json_result.put("success", flag);
		
		PrintWriter out = response.getWriter();

		out.print(json_result);
		out.flush();
	}
}
