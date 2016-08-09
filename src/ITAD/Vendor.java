package ITAD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ITAD.DataStructure.VENDORdata;

public class Vendor extends DBConn
{
	ITAD.DataStructure.VENDORdata data = new VENDORdata();
	public List<VENDORdata> List = new ArrayList<VENDORdata>();
	
	public Vendor()
	{
		super();
	}
	public int insert()
	{
		String qry = "insert into VENDORS(CODE, DESCR, CORPNO, ADDR, TYPE, MANAGER) values("+
				data.getCode()+",'"+
				toUTF8(data.getDescr())+"','"+
				toUTF8(data.getCorpno())+"','"+
				toUTF8(data.getAddr())+"',"+
				data.getType()+",'"+
				toUTF8(data.getManager())+"')";
		
		Insert(qry);
				
		return ReturnIDX("VENDORS", String.valueOf(data.getCode()), "CODE", "IDX");
	}
	public int insert( String descr, String corpno, String manager)
	{
		data.setCode(ncount("VendorCode"));
		data.setDescr(descr);
		data.setCorpno(corpno);
		data.setManager(manager);

		return insert();
	}
	public boolean load( int idx )
	{
		String qry = " SELECT * FROM VENDORS WHERE IDX = "+idx;
		boolean flag=false;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );
		
		for( int i=0; i<rsetList.size() ; i++ )
		{
			data.setIdx((int)rsetList.get(i).get("IDX"));
			data.setCode((int)rsetList.get(i).get("CODE"));
			data.setDescr((String)rsetList.get(i).get("DESCR"));
			data.setCorpno((String)rsetList.get(i).get("CORPNO"));
			data.setAddr((String)rsetList.get(i).get("ADDR"));
			data.setType((int)rsetList.get(i).get("TYPE"));
			data.setManager((String)rsetList.get(i).get("MANAGER"));
			
			flag = true;
		}
		
		/*
		try
		{
			rset = stmt.executeQuery(qry);
			while( rset.next() )
			{
				data.setIdx(rset.getInt("IDX"));
				data.setCode(rset.getInt("CODE"));
				data.setDescr(rset.getString("DESCR"));
				data.setCorpno(rset.getString("CORPNO"));
				data.setAddr(rset.getString("ADDR"));
				data.setType(rset.getInt("TYPE"));
				data.setManager(rset.getString("MANAGER"));
			}
			flag = true;
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			flag = false;
		}
		
		*/
		return flag;
	}
	public boolean update( int idx )
	{
		String qry;
		qry = "update VENDORS set CODE=" + data.getCode() 
				+", DESCR='" + toUTF8(data.getDescr())
				+"', CORPNO='" + data.getCorpno()
				+"', ADDR='" + data.getAddr()
				+"', TYPE=" + data.getType()
				+", MANAGER='" + data.getManager()
				+"'"
				+" where IDX="+idx;
		
		return Update(qry);
	}
	public boolean update()
	{
		String qry;
		qry = "update VENDORS set "
				+" DESCR='" + toUTF8(data.getDescr())
				+"', CORPNO='" + toUTF8(data.getCorpno())
				+"', ADDR='" + toUTF8(data.getAddr())
				+"', TYPE=" + data.getType()
				+", MANAGER='" + toUTF8(data.getManager())
				+"'"
				+" where IDX="+data.getIdx();
		
		return Update(qry);
	}

	public List<VENDORdata> list()
	{
		String qry="SELECT * FROM VENDORS ORDER BY CODE DESC";
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		
		rsetList = Load( qry );
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			VENDORdata tmp = new VENDORdata();
			
			tmp.setIdx((int)rsetList.get(i).get("IDX"));
			tmp.setCode((int)rsetList.get(i).get("CODE"));
			tmp.setDescr((String)rsetList.get(i).get("DESCR"));
			tmp.setCorpno((String)rsetList.get(i).get("CORPNO"));
			tmp.setAddr((String)rsetList.get(i).get("ADDR"));
			tmp.setType((int)rsetList.get(i).get("TYPE"));
			tmp.setManager((String)rsetList.get(i).get("MANAGER"));
			
			List.add(tmp);
		}
		
		/*
		try
		{
			rset = stmt.executeQuery(qry);
			while( rset.next() )
			{
				VENDORdata tmp = new VENDORdata();
				
				tmp.setIdx(rset.getInt("IDX"));
				tmp.setCode(rset.getInt("CODE"));
				tmp.setDescr(rset.getString("DESCR"));
				tmp.setCorpno(rset.getString("CORPNO"));
				tmp.setAddr(rset.getString("ADDR"));
				tmp.setType(rset.getInt("TYPE"));
				tmp.setManager(rset.getString("MANAGER"));
				
				List.add(tmp);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		*/
		
		
		return List;
	}
	public List<VENDORdata> list( String culmn, String value )
	{
		String qry="SELECT * FROM VENDORS WHERE "+culmn+" like '%"+toUTF8(value)+"%'";
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		
		rsetList = Load( qry );
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			VENDORdata tmp = new VENDORdata();
			
			tmp.setIdx((int)rsetList.get(i).get("IDX"));
			tmp.setCode((int)rsetList.get(i).get("CODE"));
			tmp.setDescr((String)rsetList.get(i).get("DESCR"));
			tmp.setCorpno((String)rsetList.get(i).get("CORPNO"));
			tmp.setAddr((String)rsetList.get(i).get("ADDR"));
			tmp.setType((int)rsetList.get(i).get("TYPE"));
			tmp.setManager((String)rsetList.get(i).get("MANAGER"));
			
			List.add(tmp);
		}
		
		/*
		try
		{
			rset = stmt.executeQuery(qry);
			while( rset.next() )
			{
				VENDORdata tmp = new VENDORdata();
				
				tmp.setIdx(rset.getInt("IDX"));
				tmp.setCode(rset.getInt("CODE"));
				tmp.setDescr(rset.getString("DESCR"));
				tmp.setCorpno(rset.getString("CORPNO"));
				tmp.setAddr(rset.getString("ADDR"));
				tmp.setType(rset.getInt("TYPE"));
				tmp.setManager(rset.getString("MANAGER"));
				
				List.add(tmp);
			}
		}
		catch(Exception e){	System.out.println(e.getMessage());	}
		
		
		
		*/
		
		
		return List;
	}
	
	public int ncount( String MN ) // DBConnÀ¸·Î »©±â
	{
		int n=1;
		String qry="select * from NCOUNT where CODE='"+MN+"'";
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		
		rsetList = Load(qry);
		
		if( rsetList.size() == 1 ) 
		{
			n = (int)rsetList.get(0).get("COUNT");
			n = n + 1;
			Update("update NCOUNT set COUNT="+n+" where CODE='"+MN+"'");
		}
		else if( rsetList.size() == 0 ) 
			Insert("insert into NCOUNT(CODE, COUNT) values('"+MN+"', 1)");
		else
			n=-1;
	
		return n;
	}
	public int getIdx() {
		return data.getIdx();
	}
	public int getCode() {
		return data.getCode();
	}
	public int getType() {
		return data.getType();
	}
	public String getDescr() {
		return data.getDescr();
	}
	public String getCorpno() {
		return data.getCorpno();
	}
	public String getAddr() {
		return data.getAddr();
	}
	public String getManager() {
		return data.getManager();
	}
	public void setIdx(int idx) {
		data.setIdx(idx);
	}
	public void setCode(int code) {
		data.setCode(code);
	}
	public void setType(int type) {
		data.setType(type);
	}
	public void setDescr(String descr) {
		data.setDescr(descr);
	}
	public void setCorpno(String corpno) {
		data.setCorpno(corpno);
	}
	public void setAddr(String addr) {
		data.setAddr(addr);
	}
	public void setManager(String manager) {
		data.setManager(manager);
	}

}
