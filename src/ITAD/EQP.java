package ITAD;

import java.util.*;

import ITAD.DataStructure.EQPdata;
import ITAD.DataStructure.HISTORYDETAIL;
import ITAD.DataStructure.NameTable;

public class EQP extends DBConn {

	public List<EQPdata> EQPlist = new ArrayList<EQPdata>();
	public List<NameTable> MatchingTable = new ArrayList<NameTable>();
	public List<HISTORYDETAIL> hstrList = new ArrayList<HISTORYDETAIL>();
	
	public EQPdata data = new EQPdata();
	public String msg;

	public EQP()
	{
		super();

		data.setTAGeqpcateg(DrawSelectTag("eqpcateg","EQPCATEG", 1));
		data.setTAGlocation(DrawSelectTag("location", "LOCXDEPT", 1));
		data.setTAGMNDept(DrawSelectTag("MNDept", "LOCXDEPT", 2));
		data.setTAGvendor(DrawSelectTag("vendor","VENDORS"));
	}
	public int InsertEQPdata(int USRidx, int PCidx, int addwho )
	{
		String qry, number;
		
		number = String.format("%02d", data.getLocation())+"-"+String.format("%02d", data.getEqpcateg())+"-"+String.format("%02d", data.getSubcate())+"-";
		number = number + String.format("%04d", (ncount(CreatMN())));
		data.setMN(number);
		
		qry="insert into EQP(USRIDX, PCIDX, DEPT, MN, CATEGORY, SUBCATEGORY,"
				+ " GENERATIONDATE, LOCATION, MARK, PRICE, VENDOR, SAPNO, SERIAL, QTY, STATUS, ADMIN1, ADMIN2 )values("
		+USRidx+","
		+PCidx+","
		+data.getMNDept()+",'"
		+data.getMN()+"',"
		+data.getEqpcateg()+","
		+data.getSubcate()+",'"
		+data.getGenedate()+"',"
		+data.getLocation()+",'"
		+data.getMark()+"',"
		+data.getPrice()+","
		+data.getVendor()+",'"
		+data.getSapno()+"',"
		+data.getSerial()+","
		+data.getQty()+","
		+data.getStatus()+",'"
		+toUTF8(data.getAdmin1())+"','"
		+toUTF8(data.getAdmin2())+"')";

		int index = Insert(qry);
		
		HISTORYDETAIL hstrDetail;
		
		if( data.getMNDept() != 0 ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("DEPT");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(String.valueOf(data.getMNDept()));
			hstrList.add(hstrDetail);
		}
		if( data.getMN() != null ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("MN");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(data.getMN());
			hstrList.add(hstrDetail);
		}
		if( data.getEqpcateg() != 0 ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("CATEGORY");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(String.valueOf(data.getEqpcateg()));
			hstrList.add(hstrDetail);
		}
		if( data.getSubcate() != 0 ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("SUBCATEGORY");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(String.valueOf(data.getSubcate()));
			hstrList.add(hstrDetail);
		}
		if( data.getGenedate() != null ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("GENERATIONDATE");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(data.getGenedate());
			hstrList.add(hstrDetail);
		}
		if( data.getLocation() != 0 ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("LOCATION");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(String.valueOf(data.getLocation()));
			hstrList.add(hstrDetail);
		}
		if( data.getMark() != null ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("MARK");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(data.getMark());
			hstrList.add(hstrDetail);
		}
		if( data.getPrice() != 0 ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("PRICE");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(String.valueOf(data.getPrice()));
			hstrList.add(hstrDetail);
		}
		if( data.getVendor() != 0 ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("VENDOR");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(String.valueOf(data.getVendor()));
			hstrList.add(hstrDetail);
		}
		if( data.getSapno() != null ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("SAPNO");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(data.getSapno());
			hstrList.add(hstrDetail);
		}
		if( data.getSerial() != 0 ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("SERIAL");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(String.valueOf(data.getSerial()));
			hstrList.add(hstrDetail);
		}
		if( data.getQty() != 0 ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("QTY");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(String.valueOf(data.getQty()));
			hstrList.add(hstrDetail);
		}
		if( data.getStatus() != 0 ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("STATUS");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(String.valueOf(data.getStatus()));
			hstrList.add(hstrDetail);
		}
		if( data.getAdmin1() != null ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("ADMIN1");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(toUTF8(data.getAdmin1()));
			hstrList.add(hstrDetail);
		}
		if( data.getAdmin2() != null ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("ADMIN2");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(toUTF8(data.getAdmin2()));
			hstrList.add(hstrDetail);
		}
		if( data.getPictarget() != null ) 
		{
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("PICTARGET");
			hstrDetail.setValuefrom("none");
			hstrDetail.setValueto(toUTF8(data.getPictarget()));
			hstrList.add(hstrDetail);
		}

		History history = new History();
		int headeridx = 0;

		headeridx = history.insertHeader(index, data.getGenedate(), 1, "�뜝�럥六욕윜諭꾩삕 �뜝�럥苡삣슖�댙�삕" , "�뜝�럩�겱�뜝�럡�뀰 �뵓怨뺣쐡占쎄퉰 : "+data.getMN(), addwho );

		history.insertDetail(hstrList, headeridx);

		msg = "";
		msg = qry;

		return index;
	}
	public int InsertEQPdataByMobile( int USRidx, int PCidx, int addwho )
	{
		data.setGenedate(data.getGenedate().replaceAll("�뜝�럥占쏙옙", "-"));
		data.setGenedate(data.getGenedate().replaceAll("�뜝�럩�쐾", "-"));
		data.setGenedate(data.getGenedate().replaceAll("�뜝�럩逾�", ""));
		data.setGenedate(data.getGenedate().replaceAll(" ", ""));

		return InsertEQPdata(USRidx, PCidx, addwho );
	}

	public boolean LoadEQPdata(int IDX)
	{
		boolean flag=false;
		String qry="select * from EQP where IDX="+IDX;
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			data.setIdx((int)rsetList.get(i).get("IDX"));
			data.setUseridx((int)rsetList.get(i).get("USRIDX"));
			data.setEqpidx((int)rsetList.get(i).get("PCIDX"));
			data.setMN((String)rsetList.get(i).get("MN"));
			data.setGenedate((String)rsetList.get(i).get("GENERATIONDATE"));
		
			data.setMNDept((int)rsetList.get(i).get("DEPT"));
			data.setEqpcateg((int)rsetList.get(i).get("CATEGORY"));
			data.setSubcate((int)rsetList.get(i).get("SUBCATEGORY"));
			data.setLocation((int)rsetList.get(i).get("LOCATION"));

			data.setPrice((long)rsetList.get(i).get("PRICE"));
			data.setVendor((int)rsetList.get(i).get("VENDOR"));
			data.setQty((int)rsetList.get(i).get("QTY"));
			data.setSapno((String)rsetList.get(i).get("SAPNO"));
			data.setMark((String)rsetList.get(i).get("MARK"));
			
			data.setStatus((int)rsetList.get(i).get("STATUS"));
			data.setAdmin1((String)rsetList.get(i).get("ADMIN1"));
			data.setAdmin2((String)rsetList.get(i).get("ADMIN2"));
			data.setPictarget((String)rsetList.get(i).get("PICTARGET"));
			
			flag = true;
		}

		data.setTAGsubcate(DrawSelectTag("subcate","EQPCATEG", 2, data.getEqpcateg()));

		data.setSTRlocation(ConvertString(data.getLocation(), "LOCXDEPT", 1));
		data.setSTRMNDept(ConvertString(data.getMNDept(), "LOCXDEPT", 2));
		data.setSTReqpcateg(ConvertString(data.getEqpcateg(), "EQPCATEG", 1));
		data.setSTRsubcate(ConvertString(data.getEqpcateg(), "EQPCATEG", 2, data.getEqpcateg()));
		data.setSTRvendor(ConvertString(data.getVendor(), "VENDORS", 1));		

		return flag;
	}
	public boolean LoadEQPdataByMobile(String epqIdx)
	{
		boolean flag=false;
		String qry="select * from EQP where MARK='"+epqIdx+"'";
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			data.setIdx((int)rsetList.get(i).get("IDX"));
			data.setUseridx((int)rsetList.get(i).get("USRIDX"));
			data.setEqpidx((int)rsetList.get(i).get("PCIDX"));
			data.setMN((String)rsetList.get(i).get("MN"));
			data.setGenedate((String)rsetList.get(i).get("GENERATIONDATE"));

			data.setStatus((int)rsetList.get(i).get("STATUS"));
			data.setLocation((int)rsetList.get(i).get("LOCATION"));
			data.setMNDept((int)rsetList.get(i).get("DEPT"));
			data.setEqpcateg((int)rsetList.get(i).get("CATEGORY"));

			flag = true;
		}

		data.setSTRstatus(ConvertString(data.getStatus(), "EQPSTATUS", 1));
		data.setSTRlocation(ConvertString(data.getLocation(), "LOCXDEPT", 1));
		data.setSTRMNDept(ConvertString(data.getMNDept(), "LOCXDEPT", 2));
		
		return flag;
	}

	public boolean UpdateEQPdata()
	{
		return Update(Datacompare());
	}	
	public boolean UpdateEQPdataByMobile()
	{
		return Update(Datacompare());
	}	

	public boolean LoadImage(String uri)
	{
		return true;
	}
	
	public String Datacompare()
	{
		EQPdata tmpdata = new EQPdata();

		String qry = "select * from EQP where IDX="+data.getIdx();
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			tmpdata.setIdx((int)rsetList.get(i).get("IDX"));
			tmpdata.setUseridx((int)rsetList.get(i).get("USRIDX"));
			tmpdata.setEqpidx((int)rsetList.get(i).get("PCIDX"));
			tmpdata.setMN((String)rsetList.get(i).get("MN"));
			tmpdata.setGenedate((String)rsetList.get(i).get("GENERATIONDATE"));

			tmpdata.setMNDept((int)rsetList.get(i).get("DEPT"));
			tmpdata.setEqpcateg((int)rsetList.get(i).get("CATEGORY"));
			tmpdata.setSubcate((int)rsetList.get(i).get("SUBCATEGORY"));
			tmpdata.setLocation((int)rsetList.get(i).get("LOCATION"));

			tmpdata.setPrice((long)rsetList.get(i).get("PRICE"));
			tmpdata.setVendor((int)rsetList.get(i).get("VENDOR"));
			tmpdata.setQty((int)rsetList.get(i).get("QTY"));
			tmpdata.setSapno((String)rsetList.get(i).get("SAPNO"));
			tmpdata.setMark((String)rsetList.get(i).get("MARK"));
			
			tmpdata.setStatus((int)rsetList.get(i).get("STATUS"));
			tmpdata.setAdmin1((String)rsetList.get(i).get("ADMIN1"));
			tmpdata.setAdmin2((String)rsetList.get(i).get("ADMIN2"));
		}

		int cnt=0;

		HISTORYDETAIL hstrDetail = new HISTORYDETAIL();
		
		qry ="update EQP set ";

		if( data.getUseridx() != 0 && data.getUseridx() != tmpdata.getUseridx() )
		{ 
			if( cnt != 0 ) qry = qry +","; cnt ++;
			qry = qry + "USRIDX="+data.getUseridx();
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("USRIDX");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getUseridx()));
			hstrDetail.setValueto(String.valueOf(data.getUseridx()));
			
			hstrList.add(hstrDetail);
		}
		if( data.getEqpidx() != 0 && data.getEqpidx() != tmpdata.getEqpidx() )
		{
			if( cnt != 0 ) qry = qry +",";	cnt ++;
			qry = qry + "PCIDX="+data.getEqpidx()+"";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("PCIDX");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getEqpidx()));
			hstrDetail.setValueto(String.valueOf(data.getEqpidx()));

			hstrList.add(hstrDetail);
		}
		if( !tmpdata.getGenedate().equals(data.getGenedate()) )
		{  
			if( cnt != 0 ) qry = qry +",";	cnt ++;
			qry = qry + "GENERATIONDATE='"+data.getGenedate()+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("GENEDATE");
			hstrDetail.setValuefrom(tmpdata.getGenedate());
			hstrDetail.setValueto(data.getGenedate());
			
			hstrList.add(hstrDetail);
		}
		if( tmpdata.getEqpcateg() != data.getEqpcateg() )
		{ 
			if( cnt != 0 ) qry = qry +",";	cnt ++;
			qry = qry + "CATEGORY="+data.getEqpcateg(); 
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("CATEGORY");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getEqpcateg()));
			hstrDetail.setValueto(String.valueOf(tmpdata.getEqpcateg()));
			
			hstrList.add(hstrDetail);
		}
		if( tmpdata.getMNDept() != data.getMNDept() )
		{  
			if( cnt != 0 ) qry = qry +","; 	cnt ++;
			qry = qry + "DEPT="+data.getMNDept(); 
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("DEPT");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getMNDept()));
			hstrDetail.setValueto(String.valueOf(data.getMNDept()));
			
			hstrList.add(hstrDetail);
		}
		if( tmpdata.getLocation() != data.getLocation() )
		{  
			if( cnt != 0 ) qry = qry +","; 	cnt ++;
			qry = qry + "LOCATION="+data.getLocation();
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("LOCATION");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getLocation()));
			hstrDetail.setValueto(String.valueOf(data.getLocation()));
			
			hstrList.add(hstrDetail);
		}
		if( tmpdata.getPurpose() != data.getPurpose() )
		{  
			if( cnt != 0 ) qry = qry +",";	cnt ++;
			qry = qry + "PURPOSE="+data.getPurpose();
			
			
			hstrDetail.setItem("PURPOSE");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getPurpose()));
			hstrDetail.setValueto(String.valueOf(data.getPurpose()));
			
			hstrList.add(hstrDetail);
		}
		if( data.getVendor() != 0 && tmpdata.getVendor() != data.getVendor() )
		{  
			if( cnt != 0 ) qry = qry +","; 	cnt ++; 
			qry = qry + "VENDOR="+data.getVendor();
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("VENDOR");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getVendor()));
			hstrDetail.setValueto(String.valueOf(data.getVendor()));
			
			hstrList.add(hstrDetail);		
		}
		if( data.getPrice() != 0 && tmpdata.getPrice() != data.getPrice() )
		{  
			if( cnt != 0 ) qry = qry +","; 	cnt ++; 
			qry = qry + "PRICE="+data.getPrice(); 
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("PRICE");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getPrice()));
			hstrDetail.setValueto(String.valueOf(data.getPrice()));
			
			hstrList.add(hstrDetail);
		}
		if( data.getMark() != null && !tmpdata.getMark().equals(data.getMark()) )
		{  
			if( cnt != 0 ) qry = qry +","; 	cnt ++;
			qry = qry + "MARK='"+data.getMark()+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("MARK");
			hstrDetail.setValuefrom(tmpdata.getMark());
			hstrDetail.setValueto(data.getMark());
			
			hstrList.add(hstrDetail);
		}
		if( data.getSubcate() != 0 && data.getSubcate() !=  tmpdata.getSubcate())
		{  
			if( cnt != 0 ) qry = qry +",";	cnt ++;
			qry = qry + "SUBCATEGORY="+data.getSubcate();
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("SUBCATEGORY");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getSubcate()));
			hstrDetail.setValueto(String.valueOf(data.getSubcate()));
			
			hstrList.add(hstrDetail);			
		}
		if( tmpdata.getQty() != data.getQty() )
		{
			if( cnt != 0 ) qry = qry +",";	cnt ++;
			qry = qry + "QTY="+data.getQty();
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("QTY");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getQty()));
			hstrDetail.setValueto(String.valueOf(data.getQty()));
			
			hstrList.add(hstrDetail);
		}
		if( !tmpdata.getSapno().equals(data.getSapno()) )
		{  
			if( cnt != 0 ) qry = qry +","; cnt ++;
			qry = qry + "SAPNO='"+data.getSapno()+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("SAPNO");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getSapno()));
			hstrDetail.setValueto(String.valueOf(data.getSapno()));
			
			hstrList.add(hstrDetail);
		}
		if( tmpdata.getSerial() != data.getSerial() )
		{  
			if( cnt != 0 ) qry = qry +",";  cnt ++;
			qry = qry + "SERIAL="+data.getSerial();
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("SERIAL");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getSerial()));
			hstrDetail.setValueto(String.valueOf(data.getSerial()));
			
			hstrList.add(hstrDetail);
		}
		if( tmpdata.getStatus() != data.getStatus() )
		{  
			if( cnt != 0 ) qry = qry +",";	cnt ++;
			qry = qry + "STATUS="+data.getStatus(); 
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("STATUS");
			hstrDetail.setValuefrom(String.valueOf(tmpdata.getStatus()));
			hstrDetail.setValueto(String.valueOf(data.getStatus()));
			
			hstrList.add(hstrDetail);
		}
		if( !tmpdata.getAdmin1().equals(toUTF8(data.getAdmin1())) )
		{  
			if( cnt != 0 ) qry = qry +","; 	cnt ++;
			qry = qry + "ADMIN1='"+toUTF8(data.getAdmin1())+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("ADMIN1");
			hstrDetail.setValuefrom(tmpdata.getAdmin1());
			hstrDetail.setValueto(toUTF8(data.getAdmin1()));
			
			hstrList.add(hstrDetail);
		}
		if( !tmpdata.getAdmin2().equals(toUTF8(data.getAdmin2())) )
		{  
			if( cnt != 0 ) qry = qry +","; 	cnt ++;
			qry = qry + "ADMIN2='"+toUTF8(data.getAdmin2())+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("ADMIN2");
			hstrDetail.setValuefrom(tmpdata.getAdmin2());
			hstrDetail.setValueto(toUTF8(data.getAdmin2()));

			hstrList.add(hstrDetail);
		}
		if( tmpdata.getPictarget() != null && !tmpdata.getPictarget().equals(toUTF8(data.getPictarget())) )
		{  
			if( cnt != 0 ) qry = qry +","; 	cnt ++;
			qry = qry + "PICTARGET='"+toUTF8(data.getPictarget())+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("PICTARGET");
			hstrDetail.setValuefrom(tmpdata.getPictarget());
			hstrDetail.setValueto(toUTF8(data.getPictarget()));

			hstrList.add(hstrDetail);
		}

		if( cnt == 0 ) qry = "";		
		else
		{
			qry = qry + " where IDX="+data.getIdx();

		}

		return qry;
	}
	
	public String CreatMN()
	{
		String number;
		number = String.format("%02d", data.getLocation());
		number = number + String.format("%02d", data.getEqpcateg());
		number = number + String.format("%02d", data.getSubcate());

		return number;
	}
	public int ncount( String MN )
	{
		int n=1, rtn=0;
		String qry="select * from NCOUNT where CODE='"+MN+"'";
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		
		rsetList = Load(qry);
		
		if( rsetList.size() == 1 ) 
		{
			rtn = n = (int)rsetList.get(0).get("COUNT");
			n = n + 1;
			Update("update NCOUNT set COUNT="+n+" where CODE='"+MN+"'");
		}
		else if( rsetList.size() == 0 ) 
			Insert("insert into NCOUNT(CODE, COUNT) values('"+MN+"', 1)");
		else
			n=-1;
	
		return rtn;
	}
	public boolean SearchEQP(String MN)
	{
		if(SearchValue("EQP",MN,"MN")) return true;
		else return false;
	}
	public String DrawSelectTag(String Name, String TableName, int type )
	{
		String tag=null;
		String qry="select * from "+TableName+" where TYPE="+type;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		MatchingTable.clear();
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			NameTable rvVal = new NameTable();
			
			rvVal.setValue((int)rsetList.get(i).get("CODE"));
			rvVal.setDescription((String)rsetList.get(i).get("DESCR"));
			
			MatchingTable.add(rvVal);			
		}


		tag = "<select name="+Name+" id='"+Name+"' style='width:130px'><option value=0 selected><b>선택 하세요</b></option>";
		for(int i=0 ; i<MatchingTable.size() ; i++)
		{
			tag = tag + "<option value="+MatchingTable.get(i).getValue()+">"+MatchingTable.get(i).getDescription()+"</option>";
		}
		tag = tag+"</select>";
		return tag;
	}
	public String DrawSelectTag(String Name, String TableName, int type, int parent )
	{
		String tag=null;
		String qry="select * from "+TableName+" where TYPE="+type+" and PARENT="+parent;

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		MatchingTable.clear();
		for( int i=0 ; i<rsetList.size() ; i++)
		{
			NameTable rvVal = new NameTable();
			
			rvVal.setValue((int)rsetList.get(i).get("CODE"));
			rvVal.setDescription((String)rsetList.get(i).get("DESCR"));

			MatchingTable.add(rvVal);
		}

		tag = "<select name="+Name+" id="+Name+" style='width:130px'><option value=0 selected><b>�꽑�깮 �븯�꽭�슂</b></option>";
		for(int i=0 ; i<MatchingTable.size() ; i++)
		{
			tag = tag + "<option value="+MatchingTable.get(i).getValue()+">"+MatchingTable.get(i).getDescription()+"</option>";
		}
		tag = tag+"</select>";
		return tag;
	}
	public String DrawSelectTag(String Name, String TableName )
	{
		String tag=null;
		String qry="select * from "+TableName;

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);

		MatchingTable.clear();
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			NameTable rvVal = new NameTable();
			
			rvVal.setValue((int)rsetList.get(i).get("CODE"));
			rvVal.setDescription((String)rsetList.get(i).get("DESCR"));
			
			MatchingTable.add(rvVal);			
		}

		tag = "<select name="+Name+" style='width:110px'><option value=0 selected><b>�꽑�깮 �븯�꽭�슂</b></option>";
		for(int i=0 ; i<MatchingTable.size() ; i++)
		{
			tag = tag + "<option value="+MatchingTable.get(i).getValue()+">"+MatchingTable.get(i).getDescription()+"</option>";
		}
		tag = tag+"</select>";
		return tag;
	}
	public String ConvertString(int Value, String TableName, int type )
	{	
		String qry = "select * from "+TableName+" where CODE="+Value+" and TYPE="+type;
		MatchingTable.clear();

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);

		if( rsetList.size() == 1 ) return (String)rsetList.get(0).get("DESCR");
		else return "ConvertString() : result is 0 or 2"; 

	}
	public String ConvertString(int Value, String TableName, int type, int parent )
	{	
		String qry = "select * from "+TableName+" where CODE="+Value+" and TYPE="+type+" and PARENT="+parent;
		MatchingTable.clear();

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);

		if( rsetList.size() == 1 ) return (String)rsetList.get(0).get("DESCR");
		else return "ConvertString() : result is 0 or 2"; 

	}
	public List<NameTable> GetEQPcategory( int type, int pid )
	{
		String qry;

		if( type == 1 )	qry = "SELECT CODE as VALUE, DESCR FROM EQPCATEG WHERE TYPE="+type+" order by CODE";
		else qry = "SELECT CODE as VALUE, DESCR FROM EQPCATEG WHERE PARENT="+pid+" order by CODE";
		MatchingTable.clear();

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			NameTable rvVal = new NameTable();

			rvVal.setValue((int)rsetList.get(i).get("VALUE"));
			rvVal.setDescription((String)rsetList.get(i).get("DESCR"));

			MatchingTable.add(rvVal);
		}

		return MatchingTable;
	}
	public List<NameTable> GetNameTalbe(String TableName , int type )
	{
		String qry="select * from "+TableName+" where TYPE="+type;
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();

		MatchingTable.clear();
		rsetList = Load(qry);

		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			NameTable rvVal = new NameTable();

			rvVal.setValue((int)rsetList.get(i).get("CODE"));
			rvVal.setDescription((String)rsetList.get(i).get("DESCR"));

			MatchingTable.add(rvVal);
		}

		return MatchingTable;
	}
	public List<EQPdata> LoadEQPlist()
	{
		String qry="select *,"
				+ "(select descr from EQPCATEG where EQPCATEG.CODE = EQP.CATEGORY ) as STRcategory,"
				+ "(select descr from DEPT where DEPT.value = EQP.DEPT ) as STRMNdept,"
				+ "(select descr from LOCATION where LOCATION.value = EQP.LOCATION ) as STRlocation,"
				+ "(select descr from PURPOSE where PURPOSE.value = EQP.PURPOSE ) as STRpurpose"
				+ " from EQP order by GENERATIONDATE";

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);

		for( int i=1 ; i<=rsetList.size() ; i++ )
		{
			EQPdata EQPobj = new EQPdata(); 

			EQPobj.setIdx((int)rsetList.get(i).get("IDX"));
			EQPobj.setUseridx((int)rsetList.get(i).get("USRIDX"));
			EQPobj.setEqpidx((int)rsetList.get(i).get("PCIDX"));
			EQPobj.setMN((String)rsetList.get(i).get("MN"));
			EQPobj.setMNDept((int)rsetList.get(i).get("DEPT"));
			EQPobj.setCategory((int)rsetList.get(i).get("CATEGORY"));
			EQPobj.setGenedate((String)rsetList.get(i).get("GENERATIONDATE"));
			EQPobj.setDestdate((String)rsetList.get(i).get("DESTROYDATE"));
			EQPobj.setCategory((int)rsetList.get(i).get("LOCATION"));
			EQPobj.setPurpose((int)rsetList.get(i).get("PURPOSE"));

			EQPobj.setSTRcategory((String)rsetList.get(i).get("STRcategory"));
			EQPobj.setSTRMNDept((String)rsetList.get(i).get("STRMNdept"));
			EQPobj.setSTRlocation((String)rsetList.get(i).get("STRlocation"));
			EQPobj.setSTRpurpose((String)rsetList.get(i).get("STRpurpose"));

			EQPlist.add(EQPobj);
		}

		return EQPlist;
	}
	public List<EQPdata> LoadEQPlist(String Colum, String keyword)
	{
		String qry="select *,"
				+ "(select descr from CATEGORY where CATEGORY.value = EQP.CATEGORY ) as STRcategory,"
				+ "(select descr from DEPT where DEPT.value = EQP.DEPT ) as STRMNdept,"
				+ "(select descr from LOCATION where LOCATION.value = EQP.LOCATION ) as STRlocation,"
				+ "(select descr from PURPOSE where PURPOSE.value = EQP.PURPOSE ) as STRpurpose"
				+ " from EQP where "+Colum+"='"+keyword+"' order by GENERATIONDATE";

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );

		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			EQPdata EQPobj = new EQPdata();

			EQPobj.setIdx((int)rsetList.get(i).get("IDX"));
			EQPobj.setUseridx((int)rsetList.get(i).get("USRIDX"));
			EQPobj.setEqpidx((int)rsetList.get(i).get("PCIDX"));
			EQPobj.setMN((String)rsetList.get(i).get("MN"));
			EQPobj.setMNDept((int)rsetList.get(i).get("DEPT"));
			EQPobj.setCategory((int)rsetList.get(i).get("CATEGORY"));
			EQPobj.setGenedate((String)rsetList.get(i).get("GENERATIONDATE"));
			EQPobj.setDestdate((String)rsetList.get(i).get("DESTROYDATE"));
			EQPobj.setLocation((int)rsetList.get(i).get("LOCATION"));
			EQPobj.setPurpose((int)rsetList.get(i).get("PURPOSE"));

			EQPobj.setSTRcategory((String)rsetList.get(i).get("STRcategory"));
			EQPobj.setSTRMNDept((String)rsetList.get(i).get("STRMNdept"));
			EQPobj.setSTRlocation((String)rsetList.get(i).get("STRlocation"));
			EQPobj.setSTRpurpose((String)rsetList.get(i).get("STRpurpose"));
			
			EQPlist.add(EQPobj);
		}

		return EQPlist;
	}
	public List<EQPdata> LoadExpansionEQPlist()
	{
		String qry="SELECT *, "
				+ "ISNULL((select DESCR from LOCXDEPT where CODE = e.DEPT and TYPE = 2 ),'')as STRDEPT, "
				+ "ISNULL((select DESCR from EQPCATEG where CODE = e.subcategory and PARENT = e.category),'') as STRSUBCATEGORY, "
				+ "ISNULL((select DESCR from EQPCATEG where CODE = e.category and TYPE = 1),'') as STRCATEGORY "
				+ "FROM EQP e";

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			EQPdata EQPobj = new EQPdata();

			EQPobj.setIdx((int)rsetList.get(i).get("IDX"));
			EQPobj.setUseridx((int)rsetList.get(i).get("USRIDX"));
			EQPobj.setEqpidx((int)rsetList.get(i).get("PCIDX"));
			EQPobj.setSubcate((int)rsetList.get(i).get("SUBCATEGORY"));

			EQPobj.setStrCategory((String)rsetList.get(i).get("STRCATEGORY"));
			EQPobj.setStrSubcategory((String)rsetList.get(i).get("STRSUBCATEGORY"));
			EQPobj.setStrMNDept((String)rsetList.get(i).get("STRDEPT"));
			EQPobj.setMN((String)rsetList.get(i).get("MN"));
			EQPobj.setGenedate((String)rsetList.get(i).get("GENERATIONDATE"));
			EQPobj.setPrice((long)rsetList.get(i).get("PRICE"));
			EQPobj.setQty((int)rsetList.get(i).get("QTY"));

			EQPobj.setCategory((int)rsetList.get(i).get("CATEGORY"));
			
			EQPlist.add(EQPobj);
		}

		return EQPlist;
	}
	public List<EQPdata> LoadExpansionEQPlist(String Colum, String keyword)
	{
		String qry="SELECT *, "
				+ "ISNULL((select DESCR from LOCXDEPT where CODE = e.DEPT and TYPE = 2 ),'')as STRDEPT, "
				+ "ISNULL((select DESCR from EQPCATEG where CODE = e.subcategory and PARENT = e.category),'') as STRSUBCATEGORY, "
				+ "ISNULL((select DESCR from EQPCATEG where CODE = e.category and TYPE = 1),'') as STRCATEGORY "
				+ "FROM EQP e WHERE "+Colum+" like '"+toUTF8(keyword)+"%' order by GENERATIONDATE";
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			EQPdata EQPobj = new EQPdata();

			EQPobj.setIdx((int)rsetList.get(i).get("IDX"));
			EQPobj.setUseridx((int)rsetList.get(i).get("USRIDX"));
			EQPobj.setEqpidx((int)rsetList.get(i).get("PCIDX"));
			EQPobj.setSubcate((int)rsetList.get(i).get("SUBCATEGORY"));
			
			EQPobj.setStrCategory((String)rsetList.get(i).get("STRCATEGORY"));
			EQPobj.setStrSubcategory((String)rsetList.get(i).get("STRSUBCATEGORY"));
			EQPobj.setStrMNDept((String)rsetList.get(i).get("STRDEPT"));
			EQPobj.setMN((String)rsetList.get(i).get("MN"));
			EQPobj.setGenedate((String)rsetList.get(i).get("GENERATIONDATE"));
			EQPobj.setPrice((long)rsetList.get(i).get("PRICE"));
			EQPobj.setQty((int)rsetList.get(i).get("QTY"));

			EQPobj.setCategory((int)rsetList.get(i).get("CATEGORY"));
			
			EQPlist.add(EQPobj);
		}

		return EQPlist;
	}
	public List<EQPdata> LoadExpansionEQPlist( List<Map<String, Object>> wherelist )
	{
		EQPlist.clear();
		
		String qry="SELECT *, "
				+ "ISNULL((select DISTINCT DESCR from LOCXDEPT where CODE = e.DEPT and TYPE = 2 ),'')as STRDEPT, "
				+ "ISNULL((select DISTINCT DESCR from EQPCATEG where CODE = e.subcategory and PARENT = e.category),'') as STRSUBCATEGORY, "
				+ "ISNULL((select DISTINCT DESCR from EQPCATEG where CODE = e.category and TYPE = 1),'') as STRCATEGORY "
				+ "FROM EQP e LEFT OUTER JOIN  COMASSET c ON e.PCIDX = c.IDX LEFT OUTER JOIN USERINFO u ON e.USRIDX = u.IDX WHERE 1=1";
		
		
		
		for( int i=0 ; i<wherelist.size() ; i++ )
		{
			if( wherelist.get(i).get("VALUE") == null ) continue;
			
			switch((String)wherelist.get(i).get("TYPE"))
			{
				case "int" :
					if( Integer.parseInt(wherelist.get(i).get("VALUE").toString()) > 0  )
						qry = qry + " and "+(String)wherelist.get(i).get("NAME")+"="+(String)wherelist.get(i).get("VALUE"); 
					break;
				case "String" :  
					if( (String)wherelist.get(i).get("VALUE") != null && wherelist.get(i).get("VALUE").toString().length() > 0 )
						qry = qry + " and "+(String)wherelist.get(i).get("NAME")+" like '%"+(String)wherelist.get(i).get("VALUE")+"%'"; 
					break;
			}
		}

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();

		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			EQPdata EQPobj = new EQPdata();

			EQPobj.setIdx((int)rsetList.get(i).get("IDX"));
			EQPobj.setUseridx((int)rsetList.get(i).get("USRIDX"));
			EQPobj.setEqpidx((int)rsetList.get(i).get("PCIDX"));
			EQPobj.setSubcate((int)rsetList.get(i).get("SUBCATEGORY"));
			
			EQPobj.setStrCategory((String)rsetList.get(i).get("STRCATEGORY"));
			EQPobj.setStrSubcategory((String)rsetList.get(i).get("STRSUBCATEGORY"));
			EQPobj.setStrMNDept((String)rsetList.get(i).get("STRDEPT"));
			EQPobj.setMN((String)rsetList.get(i).get("MN"));
			EQPobj.setGenedate((String)rsetList.get(i).get("GENERATIONDATE"));
			EQPobj.setPrice((long)rsetList.get(i).get("PRICE"));
			EQPobj.setQty((int)rsetList.get(i).get("QTY"));

			EQPobj.setCategory((int)rsetList.get(i).get("CATEGORY"));
			
			EQPlist.add(EQPobj);
		}

		return EQPlist;
	}
	
	
	
	public List<HISTORYDETAIL> history()
	{
		return hstrList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Getter and Setter	
	
	public String getAdmin1() {
		return data.getAdmin1();
	}
	public String getAdmin2() {
		return data.getAdmin2();
	}
	public void setAdmin1(String admin1) {
		data.setAdmin1(admin1);
	}
	public void setAdmin2(String admin2) {
		data.setAdmin2(admin2);
	}
	public int getIdx() {
		return data.getIdx();
	}
	public void setIdx(int idx) {
		data.setIdx(idx);
	}
	public int getcategory() {
		return data.getCategory();
	}
	public void setcategory(int ctgr) {
		data.setCategory(ctgr);
	}
	public int getMNDept() {
		return data.getMNDept();
	}
	public void setMNDept(int dept) {
		data.setMNDept(dept);
	}
	public String getMN() {
		return data.getMN();
	}
	public void setMN(String mN) {
		data.setMN(mN);
	}
	public String getgenedate() {
		return data.getGenedate();
	}
	public void setgenedate(String qinputDate) {
		data.setGenedate(qinputDate);
	}
	public String getdestdate() {
		return data.getDestdate();
	}
	public void setdestdate(String destrDate) {
		data.setDestdate(destrDate);
	}
	public int getUseridx() {
		return data.getUseridx();
	}
	public void setUseridx(int useridx) {
		data.setUseridx(useridx);
	}
	public int getEqpidx() {
		return data.getEqpidx();
	}
	public void setEqpidx(int eqpidx) {
		data.setEqpidx(eqpidx);
	}
	public int getLocation() {
		return data.getLocation();
	}
	public void setLocation(int location) {
		data.setLocation(location);
	}
	public String getTAGMNDept() {
		return data.getTAGMNDept();
	}
	public void setTAGMNDept(String tAGMNDept) {
		data.setTAGMNDept(tAGMNDept);
	}
	public String getTAGcategory() {
		return data.getTAGcategory();
	}
	public void setTAGcategory(String tAGcategory) {
		data.setTAGcategory(tAGcategory);
	}
	public String getTAGlocation() {
		return data.getTAGlocation();
	}
	public void setTAGlocation(String tAGlocation) {
		data.setTAGlocation(tAGlocation);
	}
	public int getPurpose() {
		return data.getPurpose();
	}
	public void setPurpose(int purpose) {
		data.setPurpose(purpose);
	}
	public String getTAGpurpose() {
		return data.getTAGpurpose();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSTRMNDept() {
		return data.getSTRMNDept();
	}
	public String getMark() {
		return data.getMark();
	}
	public void setMark(String mark) {
		data.setMark(mark);
	}
	public int getEqpcateg() {
		return data.getEqpcateg();
	}
	public void setEqpcateg(int eqpcateg) {
		data.setEqpcateg(eqpcateg);
	}
	public String getSTReqpcateg() {
		return data.getSTReqpcateg();
	}
	public void setSTReqpcateg(String sTReqpcateg) {
		data.setSTReqpcateg(sTReqpcateg);
	}
	public String getTAGeqpcateg() {
		return data.getTAGeqpcateg();
	}
	public void setTAGeqpcateg(String tAGeqpcateg) {
		data.setTAGeqpcateg(tAGeqpcateg);
	}
	public int getSubcate() {
		return data.getSubcate();
	}
	public void setSubcate(int subcate) {
		data.setSubcate(subcate);
	}
	public String getSTRsubcate() {
		return data.getSTRsubcate();
	}
	public void setSTRsubcate(String sTRsubcate) {
		data.setSTRsubcate(sTRsubcate);
	}
	public String getTAGsubcate() {
		return data.getTAGsubcate();
	}
	public void setTAGsubcate(String tAGsubcate) {
		data.setTAGsubcate(tAGsubcate);
	}
	public int getVendor() {
		return data.getVendor();
	}
	public void setVendor(int vendor) {
		data.setVendor(vendor);
	}
	public String getSTRvendor() {
		return data.getSTRvendor();
	}
	public void setSTRvendor(String sTRvendor) {
		data.setSTRvendor(sTRvendor);
	}
	public String getTAGvendor() {
		return data.getTAGvendor();
	}
	public void setTAGvendor(String tAGvendor) {
		data.setTAGvendor(tAGvendor);
	}
	public int getQty() {
		return data.getQty();
	}
	public void setQty(int qty) {
		data.setQty(qty);
	}
	public long getPrice() {
		return data.getPrice();
	}
	public void setPrice(long price) {
		data.setPrice(price);
	}
	public int getSerial() {
		return data.getSerial();
	}
	public void setSerial(int serial) {
		data.setSerial(serial);
	}
	public String getSapno() {
		return data.getSapno();
	}
	public void setSapno(String sapno) {
		data.setSapno(sapno);
	}
	public String getSTRlocation() {
		return data.getSTRlocation();
	}
	public void setSTRlocation(String sTRlocation) {
		data.setSTRlocation(sTRlocation);
	}
	public int getStatus() {
		return data.getStatus();
	}
	public String getSTRstatus() {
		return data.getSTRstatus();
	}
	public String getTAGstatus() {
		return data.getTAGstatus();
	}
	public void setStatus(int status) {
		data.setStatus(status);
	}
	public void setSTRstatus(String sTRstatus) {
		data.setSTRstatus(sTRstatus);
	}
	public void setTAGstatus(String tAGstatus) {
		data.setTAGstatus(tAGstatus);
	}
	public String getPictarget() {
		return data.getPictarget();
	}
	public void setPictarget(String pictarget) {
		data.setPictarget(pictarget);
	}
}