package DeviceInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import ITAD.*;



/**
 * Servlet implementation class V
 */
@WebServlet("/V")
public class V extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String tag = request.getParameter("id");
		String phone = request.getParameter("pnumber");
		
		EQP eqp = new EQP();
		User user = new User();
		History hstr = new History();
		int idx = 0, useridx = 0;
		
		JSONObject json = new JSONObject();

		if( eqp.LoadEQPdataByMobile(tag) ) idx = eqp.getIdx();
		if( user.LoadUserDataByMobile(phone) ) useridx = user.getIdx(); 

		if( idx > 0 && useridx > 0 )
		{
			String today = DBConn.toToday("yyyyMMdd");
			String todaystr = today.substring(0, 4) + "년 " + today.substring(4, 6) + "월 " + today.substring(6, 8) + "일" ;

			hstr.insertHeader(idx, today, 99, "자산 실사", todaystr+"에 실사 완료", useridx);
			json.put("success", 1);
		}
		else 
			json.put("success", 0);

		PrintWriter out = response.getWriter();

		out.print(json);
		out.flush();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tag = request.getParameter("id");
		String phone = request.getParameter("pnumber");
		
		EQP eqp = new EQP();
		User user = new User();
		History hstr = new History();
		int idx = 0, useridx = 0;
		
		JSONObject json = new JSONObject();

		if( eqp.LoadEQPdataByMobile(tag) ) idx = eqp.getIdx();
		if( user.LoadUserDataByMobile(phone) ) useridx = user.getIdx(); 

		if( idx > 0 && useridx > 0 )
		{
			String today = DBConn.toToday("yyyyMMdd");
			String todaystr = today.substring(0, 4) + "년 " + today.substring(4, 6) + "월 " + today.substring(6, 8) + "일" ;

			hstr.insertHeader(idx, today, 99, "자산 실사", todaystr+"에 실사 완료", useridx);
			json.put("success", 1);
		}
		else 
			json.put("success", 0);

		PrintWriter out = response.getWriter();

		out.print(json);
		out.flush();
	}

}
