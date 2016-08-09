package ITAD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class dcodedatatype
{
	int code;
	int type;
	int parent;
	String descr;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}

}


public class Dcode extends DBConn {

	String name;
	dcodedatatype data = new dcodedatatype();
	List<dcodedatatype> codelist = new ArrayList<dcodedatatype>();
	
	
	public Dcode(String name)
	{
		super();
		codelist.clear();
		this.name = name;
	}
	
	public boolean CodeLoad(String table_name )
	{
		boolean flag = false;
		String qry = "SELECT * FROM "+table_name;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);		
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			dcodedatatype tmpdata = new dcodedatatype();
			
			tmpdata.setCode((int)rsetList.get(i).get("CODE"));
			tmpdata.setDescr((String)rsetList.get(i).get("DESCR"));
			tmpdata.setType((int)rsetList.get(i).get("TYPE"));
			tmpdata.setParent((int)rsetList.get(i).get("PARENT"));
			
			codelist.add(tmpdata);
		}
		/*
		try
		{
			
			rset = stmt.executeQuery(qry);
			
			while(rset.next())
			{
				dcodedatatype tmpdata = new dcodedatatype();
				
				tmpdata.setCode(rset.getInt("VALUE"));
				tmpdata.setDescr(rset.getString("DESCR"));
				
				codelist.add(tmpdata);
			}
			flag = true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			flag = false;
		}
		*/
		return flag;
	}
	public boolean CodeLoad(String table_name, int type )
	{
		boolean flag = false;
		String qry = "SELECT * FROM "+table_name+" where TYPE="+type;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);		
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			dcodedatatype tmpdata = new dcodedatatype();
			
			tmpdata.setCode((int)rsetList.get(i).get("CODE"));
			tmpdata.setDescr((String)rsetList.get(i).get("DESCR"));
			tmpdata.setType((int)rsetList.get(i).get("TYPE"));
			tmpdata.setParent((int)rsetList.get(i).get("PARENT"));
			
			codelist.add(tmpdata);
		}
		/*
		try
		{
			
			rset = stmt.executeQuery(qry);
			
			while(rset.next())
			{
				dcodedatatype tmpdata = new dcodedatatype();
				
				tmpdata.setCode(rset.getInt("CODE"));
				tmpdata.setDescr(rset.getString("DESCR"));
				tmpdata.setType(rset.getInt("TYPE"));
				tmpdata.setParent(rset.getInt("PARENT"));
				
				codelist.add(tmpdata);
			}
			flag = true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			flag = false;
		}
		*/
		return flag;
	}
	public boolean CodeLoad(String table_name, int type, int parent )
	{
		boolean flag = false;
		
		if( table_name == null ) return flag;
		String qry = "SELECT * FROM "+table_name+" where TYPE="+type+" and PARENT="+parent;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);		
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			dcodedatatype tmpdata = new dcodedatatype();
			
			tmpdata.setCode((int)rsetList.get(i).get("CODE"));
			tmpdata.setDescr((String)rsetList.get(i).get("DESCR"));
			tmpdata.setType((int)rsetList.get(i).get("TYPE"));
			tmpdata.setParent((int)rsetList.get(i).get("PARENT"));
			
			codelist.add(tmpdata);
		}
		/*
		try
		{
			
			rset = stmt.executeQuery(qry);
			
			while(rset.next())
			{
				dcodedatatype tmpdata = new dcodedatatype();
				
				tmpdata.setCode(rset.getInt("CODE"));
				tmpdata.setDescr(rset.getString("DESCR"));
				tmpdata.setType(rset.getInt("TYPE"));
				tmpdata.setParent(rset.getInt("PARENT"));
				
				codelist.add(tmpdata);
			}
			flag = true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			flag = false;
		}
		*/
		return flag;
	}

	public void setTAGselect()
	{
		
	}
	public String getTAGselect()
	{

		String tag;
		int maxsize = codelist.size() + 1;
		
		tag = "<option value=0 ><b>선택 하세요</b></option>";
		for(int i=0 ; i<codelist.size() ; i++)
		{
			tag = tag + "<option value="+codelist.get(i).getCode()+">"+codelist.get(i).getDescr()+"</option>";
		}
			
		return tag;
	}
}
