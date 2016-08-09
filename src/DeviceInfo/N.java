package DeviceInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import ITAD.*;



/**
 * Servlet implementation class N
 */
@WebServlet("/N")
public class N extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public N() {
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

		EQP eqp = new EQP();
		User user = new User();
		COMast ast = new COMast();
		JSONObject json = new JSONObject();
		int flag=1;

	//	request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		//response.setCharacterEncoding("UTF-8");

		String reqIDX = request.getParameter("ID");
		int reqLocation = Integer.parseInt(request.getParameter("location"));
		int reqDept = Integer.parseInt(request.getParameter("dept"));
		int reqCategory = Integer.parseInt(request.getParameter("P"));
		int reqSubCategory = Integer.parseInt(request.getParameter("C"));
		String reqDate = request.getParameter("purcdate");
		String reqUser = request.getParameter("owner");
		String reqModel = request.getParameter("model");
		
		
		String reqPhone = null;
		String reqRemark = "init"; 

		if( request.getParameter("pnumber") != null ) reqPhone = request.getParameter("pnumber");
		

		if( request.getParameter("remark") != null ) reqRemark = request.getParameter("remark");
		else reqRemark = "is null";
		
		reqPhone = reqPhone.replace("+82", "0");

		String reqUidx = user.CodeLookup("USERINFO", reqPhone, "MOBILE", "IDX");
		if( reqUidx.equals("") ) reqUidx = "0";
		

		ast.setModel(reqModel);
		ast.setManufacturer("");
		ast.setMemo(reqRemark);
		int astidx = ast.insertByMobile();

		user.setName(reqUser);
		int useridx = user.InsertUserDataByMobile();

		eqp.setLocation(reqLocation);
		eqp.setMark(reqIDX);
		eqp.setMNDept(reqDept);
		eqp.setEqpcateg(reqCategory);
		eqp.setSubcate(reqSubCategory);
		eqp.setgenedate(reqDate);

		if( eqp.InsertEQPdataByMobile(useridx, astidx, Integer.parseInt(reqUidx)) != 0 ) json.put("success", 1) ;
		else json.put("success", 0);
		
		PrintWriter out = response.getWriter();

		out.print(json);
		out.flush();
	}

}
