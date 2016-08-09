package ITAD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ITAD.DataStructure.EQPdata;
import ITAD.DataStructure.HISTORYDETAIL;

class COMASTdata
{
	int idx;
	String Model, Manufacturer, Memo;

	public String getModel() {
		return (Model!=null)?Model:"";
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getManufacturer() {
		return (Manufacturer!=null)?Manufacturer:"";
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public String getMemo() {
		return (Memo!=null)?Memo:"";
	}
	public void setMemo(String memo) {
		Memo = memo;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
}

public class COMast extends DBConn
{
	COMASTdata data = new COMASTdata();
	List<HISTORYDETAIL> hstrList = new ArrayList<HISTORYDETAIL>();
	
	public COMast()
	{
		super();
	}
	public int insert()
	{
		return Insert("insert into COMASSET(MODEL, MANUFACTURER, MEMO)"
				+ "values('"+ toUTF8(data.getModel()) +"','"+ toUTF8(data.getManufacturer()) +"','"+ toUTF8(data.getMemo()) + "')");
	}
	public int insertByMobile() /// 모바일용을 따로 만든 이유는 !!!!! 한글 입력시 웹은 utf8을 넣어야 안 깨지고 모바일용 서블릿은 안넣어야 안 깨진다.
	{
		return Insert("insert into COMASSET(MODEL, MANUFACTURER, MEMO)"
				+ "values('"+ data.getModel() +"','"+ data.getManufacturer() +"','"+ data.getMemo() + "')");
	}
	
	public boolean load(int IDX) // Use to Method of DBConn
	{
		boolean flag=false;
		String qry="select * from COMASSET where IDX ="+IDX;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			data.setIdx((int)rsetList.get(i).get("IDX"));
			data.setModel((String)rsetList.get(i).get("MODEL"));
			data.setManufacturer((String)rsetList.get(i).get("MANUFACTURER"));
			data.setMemo((String)rsetList.get(i).get("MEMO"));
		}

		return flag;
	}
	public String update(int idx)
	{
		data.setIdx(idx);
		Update(Datacompare());
		return this.GetErrMsg();
	}
	public String updateBYmobile()
	{
		Update(DatacompareMOBILE());
		return this.GetErrMsg();
	}
	
	public String Datacompare()
	{
		COMASTdata tmpdata = new COMASTdata();
		String qry = "select * from COMASSET where IDX="+data.getIdx();
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			tmpdata.setIdx((int)rsetList.get(i).get("IDX"));
			tmpdata.setModel((String)rsetList.get(i).get("MODEL"));
			tmpdata.setManufacturer((String)rsetList.get(i).get("MANUFACTURER"));
			tmpdata.setMemo((String)rsetList.get(i).get("MEMO"));
		}
		
		qry ="update COMASSET set";
		int cnt=0;
		HISTORYDETAIL hstrDetail = new HISTORYDETAIL();

		if( !tmpdata.getModel().equals(toUTF8(data.getModel())) )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " MODEL='"+toUTF8(data.getModel())+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("MODEL");
			hstrDetail.setValuefrom(tmpdata.getModel());
			hstrDetail.setValueto(toUTF8(data.getModel()));
			
			hstrList.add(hstrDetail);
			
		}
		if( !tmpdata.getManufacturer().equals(toUTF8(data.getManufacturer())) )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " MANUFACTURER='"+toUTF8(data.getManufacturer())+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("MANUFACTURER");
			hstrDetail.setValuefrom(tmpdata.getManufacturer());
			hstrDetail.setValueto(toUTF8(data.getManufacturer()));
			
			hstrList.add(hstrDetail);
		}
		if( !tmpdata.getMemo().equals(toUTF8(data.getMemo())) )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " MEMO='"+toUTF8(data.getMemo())+"'";

			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("MEMO");
			hstrDetail.setValuefrom(tmpdata.getMemo());
			hstrDetail.setValueto(toUTF8(data.getMemo()));

			hstrList.add(hstrDetail);
		}
		
		if( cnt == 0 ) qry = "";		
		else
		{
			qry = qry + " where IDX="+data.getIdx();
		}

		return qry;
	}
	public String DatacompareMOBILE()
	{
		COMASTdata tmpdata = new COMASTdata();
		String qry = "select * from COMASSET where IDX="+data.getIdx();

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);

		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			tmpdata.setIdx((int)rsetList.get(i).get("IDX"));
			tmpdata.setModel((String)rsetList.get(i).get("MODEL"));
			tmpdata.setManufacturer((String)rsetList.get(i).get("MANUFACTURER"));
			tmpdata.setMemo((String)rsetList.get(i).get("MEMO"));
		}

		qry ="update COMASSET set";
		int cnt=0;
		HISTORYDETAIL hstrDetail = new HISTORYDETAIL();

		if( !tmpdata.getModel().equals(data.getModel()) )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " MODEL='"+data.getModel()+"'";

			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("MODEL");
			hstrDetail.setValuefrom(tmpdata.getModel());
			hstrDetail.setValueto(data.getModel());

			hstrList.add(hstrDetail);

		}
		if( !tmpdata.getManufacturer().equals(data.getManufacturer()) )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " MANUFACTURER='"+data.getManufacturer()+"'";
			
			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("MANUFACTURER");
			hstrDetail.setValuefrom(tmpdata.getManufacturer());
			hstrDetail.setValueto(data.getManufacturer());
			
			hstrList.add(hstrDetail);
		}
		if( !tmpdata.getMemo().equals(data.getMemo()) )
		{
			if( cnt != 0) qry = qry +","; cnt++;
			qry = qry + " MEMO='"+data.getMemo()+"'";

			hstrDetail = new HISTORYDETAIL();
			hstrDetail.setItem("MEMO");
			hstrDetail.setValuefrom(tmpdata.getMemo());
			hstrDetail.setValueto(data.getMemo());

			hstrList.add(hstrDetail);
		}
		
		if( cnt == 0 ) qry = "";		
		else
		{
			qry = qry + " where IDX=" + data.getIdx();
		}

		return qry;
	}
	
	public List<HISTORYDETAIL> history()
	{
		return hstrList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Getter and Setter
	
	public String getModel() {
		return data.getModel();
	}
	public void setModel(String model) {
		data.setModel(model);
	}
	public String getManufacturer() {
		return data.getManufacturer();
	}
	public void setManufacturer(String manufacturer) {
		data.setManufacturer(manufacturer);
	}
	public String getMemo() {
		return data.getMemo();
	}
	public void setMemo(String memo) {
		data.setMemo(memo);
	}
}
