package ITAD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ITAD.DataStructure.*;

public class History extends DBConn {	
	
	List<HISTORYHEADER> headerList = new ArrayList<HISTORYHEADER>();
	
	HISTORYHEADER header = new HISTORYHEADER();
	HISTORYDETAIL detail = new HISTORYDETAIL();

	public String msg;
	public int insertHeader( int eqpidx, int addwho )
	{
		String qry = "insert into HISTORYHEADER( CATEGORY, TITLE, CONTENTS, EQPIDX, ADDWHO ) values("
				+header.getHiscateg()+",'"+toUTF8(header.getTitle())+"','"+toUTF8(header.getContent())+"',"+eqpidx+","+addwho+")";		
		
		return Insert(qry);
	}
	public int insertHeader( int eqpidx, String date, int category, String title, String contents, int addwho )
	{
		String qry = "insert into HISTORYHEADER( CATEGORY, TITLE, CONTENTS, EQPIDX, ADDWHO ) values("
				+category+",'"+title+"','"+contents+"',"+eqpidx+","+addwho+")";

		return Insert(qry);
	}
	public int insertDetail( List<HISTORYDETAIL> detaillist, int headeridx )
	{
		String qry = "";
		for( int i=0 ; i<detaillist.size() ; i++ )
		{

			qry = "insert into HISTORYDETAIL(HEADERIDX, ITEM, VALUEFROM, VALUETO) values("
					+ "'"+headeridx
					+"','"+detaillist.get(i).getItem()
					+"','"+detaillist.get(i).getValuefrom()
					+"','"+detaillist.get(i).getValueto()
					+"')";

			Insert(qry);
		}
		return 1;
	}
	public List<HISTORYHEADER> LoadHistoryList(int eqpIDX)
	{
		String qry="select *, "
				+ "(SELECT NAME FROM USERINFO WHERE HISTORYHEADER.ADDWHO=USERINFO.IDX) AS STRaddwho, "
				+ "convert(char(19), [DATE], 20 ) AS CONVERTDATE"
				+ " from HISTORYHEADER where EQPIDX = " + eqpIDX + " order by IDX desc" ;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			HISTORYHEADER HistoryObj = new HISTORYHEADER();
			
			HistoryObj.setIdx((int)rsetList.get(i).get("IDX"));
			HistoryObj.setEqpidx((int)rsetList.get(i).get("EQPIDX"));
			HistoryObj.setDate((String)rsetList.get(i).get("CONVERTDATE"));
			HistoryObj.setHiscateg((int)rsetList.get(i).get("CATEGORY"));
			HistoryObj.setTitle((String)rsetList.get(i).get("TITLE"));
			HistoryObj.setContent((String)rsetList.get(i).get("CONTENTS"));
			HistoryObj.setSTRaddwho((String)rsetList.get(i).get("STRaddwho"));

			headerList.add(HistoryObj);
		}

		return headerList;
	}
	public List<HISTORYDETAIL> LoadHistoryDetail( int historyIDX )
	{
		List<HISTORYDETAIL> list = new ArrayList<HISTORYDETAIL>();
		String qry = "select * from HISTORYDETAIL where HEADERIDX="+historyIDX;

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			HISTORYDETAIL tmp = new HISTORYDETAIL();

			tmp.setIdx((int)rsetList.get(i).get("IDX"));
			tmp.setItem((String)rsetList.get(i).get("ITEM"));
			tmp.setValuefrom((String)rsetList.get(i).get("VALUEFROM"));
			tmp.setValueto((String)rsetList.get(i).get("VALUETO"));
			tmp.setHeaderidx((int)rsetList.get(i).get("HEADERIDX"));

			list.add(tmp);
		}
		return list;
	}

	// Getter and Setter

	public int getIdx() {
		return header.getIdx();
	}
	public void setIdx(int idx) {
		header.setIdx(idx);
	}
	public int getEqpidx() {
		return header.getEqpidx();
	}
	public void setEqpidx(int eqpidx) {
		header.setEqpidx(eqpidx);
	}
	public String getDate() {
		return header.getDate();
	}
	public void setDate(String date) {
		header.setDate(date);
	}
	public String getTitle() {
		return header.getTitle();
	}
	public void setTitle(String title) {
		header.setTitle(title);
	}
	public String getContent() {
		return header.getContent();
	}
	public void setContent(String content) {
		header.setContent(content);
	}
	public int getHiscateg() {
		return header.getHiscateg();
	}
	public void setHiscateg(int category) {
		header.setHiscateg(category);
	}
}
