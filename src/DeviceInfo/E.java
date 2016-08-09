package DeviceInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import ITAD.COMast;
import ITAD.EQP;
import ITAD.History;
import ITAD.User;
import ITAD.DataStructure.HISTORYDETAIL;

/**
 * Servlet implementation class E
 */
@WebServlet("/E")
public class E extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E() {
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
		COMast cst = new COMast();

		JSONObject json = new JSONObject();
		int flag=1;

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String reqUser = request.getParameter("owner");
		String reqIDX = request.getParameter("ID");
		String reqMemo = request.getParameter("remark");
		String reqModel = request.getParameter("model");
		int reqLocation = Integer.parseInt(request.getParameter("location"));
		int reqDept = Integer.parseInt(request.getParameter("dept"));

		String reqPhone;
		int reqUidx = 0;
		int reqStatus = 0;

		if( request.getParameter("pnumber") != null ) 
		{
			reqPhone = request.getParameter("pnumber");
			if( reqPhone.substring(0, 1).equals("+") ) reqPhone = reqPhone.replace("+82", "0");
			reqUidx = Integer.parseInt(user.CodeLookup("USERINFO", reqPhone, "MOBILE", "IDX"));
		}

		if( request.getParameter("status") != null) reqStatus = Integer.parseInt(request.getParameter("status"));

		eqp.LoadEQPdataByMobile(reqIDX);
		
		if( user.LoadUserDataName(reqUser) ) eqp.setUseridx( user.getIdx() );
		else 
		{
			user.setName(reqUser);
			eqp.setUseridx(user.InsertUserDataByMobile());
		}

		cst.load( eqp.getEqpidx() );
		cst.setModel(reqModel);
		cst.setMemo(reqMemo);
		
		eqp.setLocation(reqLocation);
		eqp.setMNDept(reqDept);
		eqp.setStatus(reqStatus);

		eqp.UpdateEQPdataByMobile();
		cst.updateBYmobile();
		
		json.put("success", flag );
		json.put("idx", reqIDX );
		json.put("owner", reqUser );
		json.put("uidx", user.getIdx() );

		PrintWriter out = response.getWriter();

		out.print(json);
		out.flush();

		// history
		
		History hstr = new History();
		
		List<HISTORYDETAIL> EQPhistoryList = new ArrayList<HISTORYDETAIL>();
		List<HISTORYDETAIL> CSThistoryList = new ArrayList<HISTORYDETAIL>();
		
		EQPhistoryList = eqp.history();
		CSThistoryList = cst.history();

		int cnt=0;
		if( EQPhistoryList.size() != 0 || CSThistoryList.size() != 0 ) cnt++;
		int history_header_index=0;

		if( cnt != 0 ) // 변경 사항이 하나라도 있을 때
		{
			List<HISTORYDETAIL> tmplist = new ArrayList<HISTORYDETAIL>(); // 자산 이동에 대한 히스토리만 따로 담는다.

			for(int i=0 ; i<EQPhistoryList.size() ; i++ ) // 변경 사항들을 뒤진다
			{
				if( EQPhistoryList.get(i).getItem().equals("DEPT") || EQPhistoryList.get(i).getItem().equals("LOCATION") ) 
				{
					tmplist.add(EQPhistoryList.get(i));// 임시 리스트로 위치값과 소속값을 옮긴다.
					EQPhistoryList.remove(i); // 옮기고 나면 자동으로 다시 인덱싱이 되기 때문에
					i=-1; // 카운터 값을 초기화 시켜준다 -1로 하는 이유는 for문 1회 종료 시점에 i++가 되기 때문
				}
			}

			if( tmplist.size() != 0 )// 자산 이동 항목이 있으면
			{
				String cntt="", beforeLOC="", afterLOC="", beforeDEPT="", afterDEPT="";
				for( int i=0 ; i<tmplist.size() ; i++ )
				{
					if( tmplist.get(i).getItem().equals("LOCATION") )
					{
						beforeLOC = hstr.CodeLookup("LOCXDEPT",tmplist.get(i).getValuefrom(),"CODE","DESCR");
						afterLOC = hstr.CodeLookup("LOCXDEPT",tmplist.get(i).getValueto(),"CODE","DESCR");
					}
					if( tmplist.get(i).getItem().equals("DEPT") )
					{
						beforeDEPT = hstr.CodeLookup("LOCXDEPT",tmplist.get(i).getValuefrom(),"CODE","DESCR");
						afterDEPT = hstr.CodeLookup("LOCXDEPT",tmplist.get(i).getValueto(),"CODE","DESCR");
					}
				}
				cntt =" "+beforeLOC+" "+beforeDEPT+"에서 "+afterLOC+" "+afterDEPT+" 으로 이동";
				history_header_index = hstr.insertHeader(eqp.getIdx(), hstr.getDate(), 2, "자산 이동", cntt, reqUidx ); // 그리고 헤더를 추가 한다.
				hstr.insertDetail( tmplist, history_header_index ); // 자산 이동에 대한 헤더에 
			}

			if( EQPhistoryList.size() != 0 ) 
			{
				history_header_index = hstr.insertHeader(eqp.getIdx(), hstr.getDate(), 3, "정보 수정", "상세 참조", reqUidx );
				hstr.insertDetail( EQPhistoryList, history_header_index );
			}

			if( CSThistoryList.size() != 0 ) 
			{
				history_header_index = hstr.insertHeader(eqp.getIdx(), hstr.getDate(), 3, "정보 수정", "상세 참조", reqUidx );
				hstr.insertDetail( CSThistoryList, history_header_index );
			}
		}
	}
}
