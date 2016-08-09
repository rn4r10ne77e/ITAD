package ITAD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ITAD.DataStructure.HISTORYDETAIL;
import ITAD.DataStructure.NameTable;
import ITAD.DataStructure.Userdata;

public class User extends DBConn
{
	public List<Userdata> UserList = new ArrayList<Userdata>();
	public List<NameTable> MatchingTable = new ArrayList<NameTable>();
	List<HISTORYDETAIL> hstrList = new ArrayList<HISTORYDETAIL>();
	public Userdata data = new Userdata();

	String msg="";

	public User()
	{
		super();

		data.setTAGusrPosition(DrawSelectTag("usrPosition","POSITION"));
		data.setTAGusrDept(DrawSelectTag("usrDept","DEPT"));
		data.setTAGstate(DrawSelectTag("state","USERSTATE"));
		data.setTAGpermission(DrawSelectTag("permission","USERPERM"));
	}
	
	public int InsertUserData(String input_name, int input_usrPosition, int input_dept, String input_id, String input_password)
	{
		if(SearchValue("USERINFO",input_id,"ID")){ msg="duplicate ID "; return ReturnIDX("USERINFO", input_id, "ID", "IDX"); }
		else
		{
			Qry = "insert into USERINFO(ID, PASSWORD, NAME, Position, DEPT, PERMISSION, STATE) values("
			+"'"+input_id+"',"
			+"'"+input_password+"',"
			+"'"+toUTF8(input_name)+"',"
			+input_usrPosition+","
			+input_dept+","
			+"0,0)";
			Insert(Qry);

			return ReturnIDX("USERINFO",input_id,"ID","IDX");
		}
	}
	public int InsertUserData()
	{
		if( data.getName() == null) return 0;
		if(SearchValue("USERINFO",toUTF8(data.getName()),"NAME")){ msg="duplicate ID"; return ReturnIDX("USERINFO", toUTF8(data.getName()), "NAME", "IDX"); }
		else
		{	
			
			Qry = "insert into USERINFO(ID, PASSWORD, NAME, Position, DEPT, PERMISSION, STATE) values("
			+"'"+data.getID()+"',"
			+"'"+data.getPassword()+"',"
			+"'"+toUTF8(data.getName())+"',"
			+data.getUsrPosition()+","
			+data.getUsrDept()+","
			+"0,0)";
			Insert(Qry);

			return ReturnIDX("USERINFO",toUTF8(data.getName()),"NAME","IDX");
		}
	}
	public int InsertUserDataByMobile()
	{
		if( data.getPassword() == null ) data.setPassword("schenker");
		
		if(SearchValue("USERINFO",data.getName(),"NAME"))
		{ 
			msg="exsting name"; 
			return ReturnIDX("USERINFO", data.getName(), "NAME", "IDX"); 
		}
		else
		{
			String tmpQry = "insert into USERINFO(NAME) values('" + data.getName() + "')";
			return Insert(tmpQry);
		}
	}

	public boolean LoadUserData(String usrid) // Use to Method of DBConn
	{
		boolean flag=false;
		String qry = "select *," + 
				"(select descr from dept where value=USERINFO.dept) as STRdept," + 
				"(select descr from position where value=USERINFO.position) as STRposition" + 
				" from USERINFO where ID='"+usrid+"'";

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			data.setIdx((int)rsetList.get(i).get("IDX"));
			data.setUsrPosition((int)rsetList.get(i).get("POSITION"));
			data.setUsrDept((int)rsetList.get(i).get("DEPT"));
			data.setID((String)rsetList.get(i).get("ID"));
			data.setName((String)rsetList.get(i).get("NAME"));
			data.setPassword((String)rsetList.get(i).get("PASSWORD"));
			data.setPermission((int)rsetList.get(i).get("PERMISSION"));
			data.setstate((int)rsetList.get(i).get("STATE"));

			data.setSTRusrDept((String)rsetList.get(i).get("STRdept"));
			data.setSTRusrPosition((String)rsetList.get(i).get("STRposition")); 
			
			flag = true;
		}

		return flag;
	}
	public boolean LoadUserDataName(String usrname) // Use to Method of DBConn
	{
		boolean flag=false;
		String qry = "SELECT IDX FROM USERINFO WHERE NAME='"+usrname+"'";
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			data.setIdx((int)rsetList.get(i).get("IDX"));
			flag = true;
		}
				
		return flag;
	}
	public boolean LoadUserDataByMobile(String phonenumber) // Use to Method of DBConn
	{
		boolean flag=false;
		String qry = "select *," + 
				"(select descr from dept where value=USERINFO.dept) as STRdept," + 
				"(select descr from position where value=USERINFO.position) as STRposition" + 
				" from USERINFO where Mobile='"+phonenumber+"' " ;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			data.setIdx((int)rsetList.get(i).get("IDX"));
			data.setUsrPosition((int)rsetList.get(i).get("POSITION"));
			data.setUsrDept((int)rsetList.get(i).get("DEPT"));
			data.setID((String)rsetList.get(i).get("ID"));
			data.setName((String)rsetList.get(i).get("NAME"));
			data.setPassword((String)rsetList.get(i).get("PASSWORD"));
			data.setPermission((int)rsetList.get(i).get("PERMISSION"));
			data.setstate((int)rsetList.get(i).get("STATE"));
			
			data.setSTRusrDept((String)rsetList.get(i).get("STRdept"));
			data.setSTRusrPosition((String)rsetList.get(i).get("STRposition"));
			
			flag = true;
		}
		
		return flag;
	}
	public boolean LoadUserDataByMobile(int usridx ) // Use to Method of DBConn
	{
		boolean flag=false;
		String qry = "SELECT NAME FROM USERINFO WHERE IDX="+usridx;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			data.setName((String)rsetList.get(i).get("NAME"));
			flag = true;
		}

		return flag;
	}
	public boolean LoadUserData(int IDX) // Use to Method of DBConn
	{
		boolean flag=false;
		String qry = "select *," + 
				"ISNULL((select descr from dept where value=USERINFO.dept),'') as STRdept," + 
				"ISNULL((select descr from position where value=USERINFO.position),'') as STRposition" + 
				" from USERINFO where IDX="+IDX;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			data.setIdx((int)rsetList.get(i).get("IDX"));
			data.setUsrPosition((int)rsetList.get(i).get("POSITION"));
			data.setUsrDept((int)rsetList.get(i).get("DEPT"));
			data.setID((String)rsetList.get(i).get("ID"));
			data.setName((String)rsetList.get(i).get("NAME"));
			data.setPassword((String)rsetList.get(i).get("PASSWORD"));
			data.setPermission((int)rsetList.get(i).get("PERMISSION"));
			data.setstate((int)rsetList.get(i).get("STATE"));

			data.setSTRusrDept((String)rsetList.get(i).get("STRdept"));
			data.setSTRusrPosition((String)rsetList.get(i).get("STRposition")); 
			
			flag = true;
		}
				
		return flag;
	}	
	
	public List<Userdata> LoadUserList()
	{
		String qry = "select u.* ,"+
					 "ISNULL(d.descr,'')as STRdept, "+
					 "ISNULL(p.descr,'')as STRposition, "+
					 "ISNULL(t.descr,'')as STRstate "+
					 " from USERINFO u "+
					 "left outer join DEPT d on u.dept=d.value "+ 
					 "left outer join POSITION p on u.position=p.value "+
					 "left outer join USERSTATE t on u.STATE = t.VALUE ";
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			Userdata UserObj = new Userdata(); 

			UserObj.setIdx((int)rsetList.get(i).get("IDX"));
			UserObj.setID((String)rsetList.get(i).get("ID"));
			UserObj.setPassword((String)rsetList.get(i).get("PASSWORD"));
			UserObj.setName((String)rsetList.get(i).get("NAME"));
			UserObj.setUsrPosition((int)rsetList.get(i).get("POSITION"));
			UserObj.setUsrDept((int)rsetList.get(i).get("DEPT"));
			UserObj.setstate((int)rsetList.get(i).get("STATE"));

			UserObj.setSTRusrDept((String)rsetList.get(i).get("STRdept"));
			UserObj.setSTRusrPosition((String)rsetList.get(i).get("STRposition"));
			UserObj.setSTRstate((String)rsetList.get(i).get("STRstate"));

			UserList.add(UserObj);
		}
		
		return UserList;
	}
	public List<Userdata> LoadUserList(String Column, String value)
	{
		String qry = "SELECT u.* ,"+
					 "ISNULL(d.descr,'')as STRdept, "+
					 "ISNULL(p.descr,'')as STRposition, "+
					 "ISNULL(t.descr,'')as STRstate "+
					 "FROM USERINFO u "+
					 "left outer join DEPT d on u.dept=d.value "+ 
					 "left outer join POSITION p on u.position=p.value "+
					 "left outer join USERSTATE t on u.STATE = t.VALUE "+
					 "WHERE "+Column+" like '%"+toUTF8(value)+"%'";
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{		
			Userdata UserObj = new Userdata();
			
			UserObj.setIdx((int)rsetList.get(i).get("IDX"));
			UserObj.setID((String)rsetList.get(i).get("ID"));
			UserObj.setPassword((String)rsetList.get(i).get("PASSWORD"));
			UserObj.setName((String)rsetList.get(i).get("NAME"));
			UserObj.setUsrPosition((int)rsetList.get(i).get("POSITION"));
			UserObj.setUsrDept((int)rsetList.get(i).get("DEPT"));
			UserObj.setstate((int)rsetList.get(i).get("STATE"));
			
			UserObj.setSTRusrDept((String)rsetList.get(i).get("STRdept"));
			UserObj.setSTRusrPosition((String)rsetList.get(i).get("STRposition"));
			UserObj.setSTRstate((String)rsetList.get(i).get("STRstate"));
			
			UserList.add(UserObj);
		}
				
		return UserList;
	}
	
	public String UpdateUSERdata(int idx)
	{
	
		data.setIdx(idx);
		
		Update(Datacompare());
		return this.GetErrMsg();
	}
	public String Datacompare()
	{
		Userdata tmpdata = new Userdata();

		String qry = "select * from USERINFO where IDX="+data.getIdx();
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			tmpdata.setIdx((int)rsetList.get(i).get("IDX"));
			
			tmpdata.setID((String)rsetList.get(i).get("ID"));
			tmpdata.setPassword((String)rsetList.get(i).get("PASSWORD"));

			tmpdata.setName((String)rsetList.get(i).get("NAME"));
			tmpdata.setUsrPosition((int)rsetList.get(i).get("POSITION"));
			tmpdata.setUsrDept((int)rsetList.get(i).get("DEPT"));
			tmpdata.setstate((int)rsetList.get(i).get("STATE"));
			tmpdata.setPermission((int)rsetList.get(i).get("PERMISSION"));
		}
		
	
		
		
		qry ="update USERINFO set";
		
		int cnt=0;

		HISTORYDETAIL hstrDetail = new HISTORYDETAIL();
		
		if( data.getID()!=null && !tmpdata.getID().equals(toUTF8(data.getID())) ) // null �씪�븣 泥섎━
		{
			
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " ID='"+toUTF8(data.getID())+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("ID");
			hstrDetail.setValuefrom(toUTF8(tmpdata.getID()));
			hstrDetail.setValueto(toUTF8(data.getID()));

			hstrList.add(hstrDetail);
		}
		if( data.getPassword()!=null && !tmpdata.getPassword().equals(toUTF8(data.getPassword())) )  // null �씪�븣 泥섎━
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " PASSWORD='"+toUTF8(data.getPassword())+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("PASSWORD");
			hstrDetail.setValuefrom(toUTF8(tmpdata.getPassword()));
			hstrDetail.setValueto(toUTF8(data.getPassword()));

			hstrList.add(hstrDetail);
		}
		if( !tmpdata.getName().equals(toUTF8(data.getName())) )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " NAME='"+toUTF8(data.getName())+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("NAME");
			hstrDetail.setValuefrom(tmpdata.getName());
			hstrDetail.setValueto(toUTF8(data.getName()));
			
			hstrList.add(hstrDetail);
		}
		if( data.getUsrPosition()!=0 && tmpdata.getUsrPosition() != data.getUsrPosition() )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " POSITION="+data.getUsrPosition();

			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("POSITION");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getUsrPosition()));
			hstrDetail.setValueto(String.valueOf(data.getUsrPosition()));
			
			hstrList.add(hstrDetail);
		}
		if( data.getUsrDept()!=0 && tmpdata.getUsrDept() != data.getUsrDept() )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " DEPT="+data.getUsrDept();

			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("DEPT");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getUsrDept()));
			hstrDetail.setValueto(String.valueOf(data.getUsrDept()));
			
			hstrList.add(hstrDetail);
		}
		if( data.getPermission()!=0 && tmpdata.getPermission() != data.getPermission() )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " PERMISSION="+data.getPermission();

			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("PERMISSION");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getPermission()));
			hstrDetail.setValueto(String.valueOf(data.getPermission()));
			
			hstrList.add(hstrDetail);
		}
		if( data.getstate()!=0 && tmpdata.getstate() != data.getstate() )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " STATE="+data.getstate();

			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("STATE");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getstate()));
			hstrDetail.setValueto(String.valueOf(data.getstate()));

			hstrList.add(hstrDetail);
		}
		
		if( cnt == 0 ) qry = "";		
		else
		{
			qry = qry + " where IDX="+data.getIdx();
		}
	
		return qry;
	}

	public String DrawSelectTag(String Name, String DBname)
	{
		String tag=null;
		String qry="select * from "+DBname;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );
		
		MatchingTable.clear();
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			NameTable rvVal = new NameTable();
			
			rvVal.setValue((int)rsetList.get(i).get("VALUE"));
			rvVal.setDescription((String)rsetList.get(i).get("DESCR"));
			
			MatchingTable.add(rvVal);
		}

		tag = "<select name="+Name+" style='width:60px' >";
		for(int i=0 ; i<MatchingTable.size() ; i++)
		{
			tag = tag + "<option value="+MatchingTable.get(i).getValue()+">"+MatchingTable.get(i).getDescription()+"</option>";
		}
		tag = tag+"</select>";
		return tag;
	}
	public boolean Matching_IDPW(String input_id, String input_pw)
	{
		boolean flag = false;
		if(LoadUserData(input_id))
		{
			if(input_pw.equals(data.getPassword())) flag = true;
			else{ flag = false; msg="Wrong Password. Plz Retry after check";}
		}
		else{ flag = false; msg="ID Not Found or SQL Error";}
		return flag;
	}

	public String getMessage()
	{
		return msg;
	}
	public void setMessage(String message)
	{
		msg = message;
	}

	
	public List<HISTORYDETAIL> history()
	{
		return hstrList;
	}	
	

	// Getter and Setter

	public int getUsrDept() {
		return data.getUsrDept();
	}
	public void setUsrDept(int usrDept) {
		data.setUsrDept(usrDept);
	}
	public String getID() {
		return data.getID();
	}
	public void setID(String riD) {
		data.setID(riD);
	}
	public String getPassword() {
		return data.getPassword();
	}
	public void setPassword(String password) {
		data.setPassword(password);
	}
	public int getPermission() {
		return data.getPermission();
	}
	public void setPermission(int permission) {
		data.setPermission(permission);;
	}
	public int getstate() {
		return data.getstate();
	}
	public void setstate(int state) {
		data.setstate(state);
	}
	public String getName() {
		return data.getName();
	}
	public void setName(String name) {
		data.setName(name);
	}
	public String getTAGusrPosition() {
		return data.getTAGusrPosition();
	}
	public void setTAGusrPosition(String tAGusrPosition) {
		data.setTAGusrPosition(tAGusrPosition);
	}
	public String getTAGusrDept() {
		return data.getTAGusrDept();
	}
	public void setTAGusrDept(String tAGusrDept) {
		data.setTAGusrDept(tAGusrDept);
	}
	public int getIdx() {
		return data.getIdx();
	}
	public void setIdx(int idx) {
		data.setIdx(idx);
	}
	public int getUsrPosition() {
		return data.getUsrPosition();
	}
	public void setUsrPosition(int usrPosition) {
		data.setUsrPosition(usrPosition);
	}
	public String getSTRusrPosition() {
		return data.getSTRusrPosition();
	}
	public void setSTRusrPosition(String sTRusrPosition) {
		data.setSTRusrPosition(sTRusrPosition);
	}
	public String getSTRusrDept() {
		return data.getSTRusrDept();
	}
	public void setSTRusrDept(String sTRuserDept) {
		data.setSTRusrDept(sTRuserDept);
	}
	public String getSTRstate() {
		return data.getSTRstate();
	}
	public void setSTRstate(String sTRstate) {
		data.setSTRstate(sTRstate);
	}
	public String getTAGstate() {
		return data.getTAGstate();
	}
	public void setTAGstate(String tAGstate) {
		data.setTAGstate(tAGstate);
	}
	public String getSTRpermission() {
		return data.getSTRpermission();
	}
	public void setSTRpermission(String sTRpermission) {
		data.setSTRpermission(sTRpermission);
	}
	public String getTAGpermission() {
		return data.getTAGpermission();
	}
	public void setTAGpermission(String tAGpermission) {
		data.setTAGpermission(tAGpermission);
	}
	public String getMobile() {
		return data.getMobile();
	}
	public void setMobile(String mobile) {
		data.setMobile(mobile);
	}
}
