package ITAD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class PCdata {

	int idx;
	String maddr;
	String IPAddress;
	String HName;
	String MBserial;
	String OSname, CPUname, LAMcapa;
	String HDDserial;
	String ADaccnt;
	String PCmodel;
	String PCmanufacturer;

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMaddr() {
		return maddr;
	}
	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}
	public String getHName() {
		return HName;
	}
	public void setHName(String hName) {
		HName = hName;
	}
	public String getMBserial() {
		return MBserial;
	}
	public void setMBserial(String mBserial) {
		MBserial = mBserial;
	}
	public String getOSname() {
		return OSname;
	}
	public void setOSname(String oSname) {
		OSname = oSname;
	}
	public String getCPUname() {
		return CPUname;
	}
	public void setCPUname(String cPUname) {
		CPUname = cPUname;
	}
	public String getLAMcapa() {
		return LAMcapa;
	}
	public void setLAMcapa(String lAMcapa) {
		LAMcapa = lAMcapa;
	}
	public String getHDDserial() {
		return HDDserial;
	}
	public void setHDDserial(String hDDserial) {
		HDDserial = hDDserial;
	}
	public String getADaccnt() {
		return ADaccnt;
	}
	public void setADaccnt(String aDaccnt) {
		ADaccnt = aDaccnt;
	}
	public String getPCmodel() {
		return PCmodel;
	}
	public void setPCmodel(String pCmodel) {
		PCmodel = pCmodel;
	}
	public String getPCmanufacturer() {
		return PCmanufacturer;
	}
	public void setPCmanufacturer(String pCmanufacturer) {
		PCmanufacturer = pCmanufacturer;
	}

}

public class PC extends DBConn{

	public PCdata data =  new PCdata();
	public List<PCdata> PCList = new ArrayList<PCdata>();
	
	public String GetErrMsg;

	public boolean SearchPC(String maddr)
	{
		if(SearchValue("PC",maddr,"MACADDR")) return true;
		else return false;
	}
	public int InsertPCData(String Inputmaddr, 
								String InputIpaddress, 
								String InputHName,
								String MBserial,
								String OSname,
								String CPUname,
								String LAMcapa,
								String HDDserial,
								String ADaccnt,
								String PCmodel,
								String PCmanufacturer
								)
	{
		Insert("insert into PC(MACADDR, IPADDR, HOSTNAME, MBSERIAL, OS, CPU, LAM, HDDSERIAL, ACCOUNT, PCMODEL, PCMANUFACTURER)values('"
		+Inputmaddr+"','"
		+InputIpaddress+"','"
		+InputHName+"','"
		+MBserial+"','"
		+OSname+"','"
		+CPUname+"','"
		+LAMcapa+"','"
		+HDDserial+"','"
		+ADaccnt+"','"
		+PCmodel+"','"
		+PCmanufacturer+"')");
		this.GetErrMsg = GetErrMsg();
		return ReturnIDX("PC",Inputmaddr,"MACADDR","IDX");
	}
	public int InsertPCData()
	{
		Insert("insert into PC(MACADDR, IPADDR, HOSTNAME, MBSERIAL, OS, CPU, LAM, HDDSERIAL, ACCOUNT, PCMODEL, PCMANUFACTURER)values('"
		+data.getMaddr()+"','"
		+data.getIPAddress()+"','"
		+data.getHName()+"','"
		+data.getMBserial()+"','"
		+data.getOSname()+"','"
		+data.getCPUname()+"','"
		+data.getLAMcapa()+"','"
		+data.getHDDserial()+"','"
		+data.getADaccnt()+"','"
		+data.getPCmodel()+"','"
		+data.getPCmanufacturer()+"')");
		
		this.GetErrMsg = GetErrMsg();
		return ReturnIDX("PC",data.getMBserial(),"MBSERIAL","IDX");
	}
	public boolean LoadPCData(int IDX) // Use to Method of DBConn
	{
		boolean flag=false;
		String qry="Select * from PC where IDX ="+IDX;
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			data.setIdx((int)rsetList.get(i).get("IDX"));
			data.setMaddr((String)rsetList.get(i).get("MACADDR"));
			data.setIPAddress((String)rsetList.get(i).get("IPADDR"));
			data.setHName((String)rsetList.get(i).get("HOSTNAME"));
			data.setMBserial((String)rsetList.get(i).get("MBSERIAL"));
			data.setOSname((String)rsetList.get(i).get("OS"));
			data.setCPUname((String)rsetList.get(i).get("CPU"));
			data.setLAMcapa((String)rsetList.get(i).get("LAM"));
			data.setHDDserial((String)rsetList.get(i).get("HDDSERIAL"));
			data.setADaccnt((String)rsetList.get(i).get("ACCOUNT"));
			data.setPCmodel((String)rsetList.get(i).get("PCMODEL"));
			data.setPCmanufacturer((String)rsetList.get(i).get("PCMANUFACTURER"));
			
			flag = true;
		}
		
		/*
		try
		{
			rset = stmt.executeQuery("Select * from PC where IDX ="+IDX);
			if(GetRecordCnt()!=0)
			{
				flag = true;
				while(rset.next())
				{
				(String)rsetList.get(i).get((rset.getInt("IDX"));
					data.setMaddr(rset.getString("MACADDR").trim());
					data.setIPAddress(rset.getString("IPADDR").trim());
					data.setHName(rset.getString("HOSTNAME").trim());
					data.setMBserial(rset.getString("MBSERIAL").trim());
					data.setOSname(rset.getString("OS").trim());
					data.setCPUname(rset.getString("CPU").trim());
					data.setLAMcapa(rset.getString("LAM").trim());
					data.setHDDserial(rset.getString("HDDSERIAL").trim());
					data.setADaccnt(rset.getString("ACCOUNT").trim());
					data.setPCmodel(rset.getString("PCMODEL").trim());
					data.setPCmanufacturer(rset.getString("PCMANUFACTURER").trim());
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		*/
		return flag;
	}
	public boolean PCdataDuplicate(String mbserial) // Use to Method of DBConn
	{
		if( SearchValue("PC",mbserial, "MBSERIAL") ) return true ;
		else return false;
	}
	public String UpdatePCdata(int idx)
	{
		String qry;
		qry = "update PC set MACADDR='"	+ data.getMaddr() 
				+"', IPADDR='" + data.getIPAddress() 
				+"', HOSTNAME='" + data.getHName()
				+"', OS='" + data.getOSname()
				+"', CPU='" + data.getCPUname()
				+"', LAM='" + data.getLAMcapa()
				+"', HDDSERIAL='" + data.getHDDserial()
				+"', ACCOUNT='" + data.getADaccnt()
				+"', PCMODEL='" + data.getPCmodel()
				+"', PCMANUFACTURER='" + data.getPCmanufacturer()
				+"' " +" where IDX="+idx;
		
		Update(qry);
		return this.GetErrMsg();
	}

	public List<PCdata> LoadPCList()
	{
		String qry = "select * from PC";
		
		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load(qry);
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			PCdata PCObj = new PCdata();

			PCObj.setIdx((int)rsetList.get(i).get("IDX"));
			PCObj.setMaddr((String)rsetList.get(i).get("MACADDR"));
			PCObj.setIPAddress((String)rsetList.get(i).get("IPADDR"));
			PCObj.setHName((String)rsetList.get(i).get("HOSTNAME"));
			PCObj.setOSname((String)rsetList.get(i).get("OS"));
			PCObj.setCPUname((String)rsetList.get(i).get("CPU"));
			PCObj.setLAMcapa((String)rsetList.get(i).get("LAM"));
			PCObj.setHDDserial((String)rsetList.get(i).get("HDDSERIAL"));
			PCObj.setADaccnt((String)rsetList.get(i).get("ACCOUNT"));
			PCObj.setPCmodel((String)rsetList.get(i).get("PCMODEL"));
			PCObj.setPCmanufacturer((String)rsetList.get(i).get("PCMANUFACTURER"));

			PCList.add(PCObj);
		}
		/*
		try
		{
			rset = stmt.executeQuery(qry);
			while(rset.next())
			{
				PCdata PCObj = new PCdata();

				PCObj.setIdx(rset.getInt("IDX"));
				PCObj.setMaddr(rset.getString("MACADDR"));
				PCObj.setIPAddress(rset.getString("IPADDR"));
				PCObj.setHName(rset.getString("HOSTNAME"));
				PCObj.setOSname(rset.getString("OS"));
				PCObj.setCPUname(rset.getString("CPU"));
				PCObj.setLAMcapa(rset.getString("LAM"));
				PCObj.setHDDserial(rset.getString("HDDSERIAL"));
				PCObj.setADaccnt(rset.getString("ACCOUNT"));
				PCObj.setPCmodel(rset.getString("PCMODEL"));
				PCObj.setPCmanufacturer(rset.getString("PCMANUFACTURER"));

				PCList.add(PCObj);
			}
		}
		catch(Exception ex){}
		*/
		
		return PCList;
	}
	public List<PCdata> LoadUserList(String Column, String value)
	{
		String qry = "select * from pc where "+Column+" Like '%"+toUTF8(value)+"%'";

		List<Map<String, Object>> rsetList = new ArrayList<Map<String, Object>>();
		rsetList = Load( qry );
		
		for( int i=0 ; i<rsetList.size() ; i++ )
		{
			PCdata PCObj = new PCdata();

			PCObj.setIdx((int)rsetList.get(i).get("IDX"));
			PCObj.setMaddr((String)rsetList.get(i).get("MACADDR"));
			PCObj.setIPAddress((String)rsetList.get(i).get("IPADDR"));
			PCObj.setHName((String)rsetList.get(i).get("HOSTNAME"));
			PCObj.setOSname((String)rsetList.get(i).get("OS"));
			PCObj.setCPUname((String)rsetList.get(i).get("CPU"));
			PCObj.setLAMcapa((String)rsetList.get(i).get("LAM"));
			PCObj.setHDDserial((String)rsetList.get(i).get("HDDSERIAL"));
			PCObj.setADaccnt((String)rsetList.get(i).get("ACCOUNT"));
			PCObj.setPCmodel((String)rsetList.get(i).get("PCMODEL"));
			PCObj.setPCmanufacturer((String)rsetList.get(i).get("PCMANUFACTURER"));

			PCList.add(PCObj);
		}
		
		/*
		try
		{
			rset = stmt.executeQuery(qry);
			while(rset.next())
			{
				PCdata PCObj = new PCdata();

				PCObj.setIdx(rset.getInt("IDX"));
				PCObj.setMaddr(rset.getString("MACADDR"));
				PCObj.setIPAddress(rset.getString("IPADDR"));
				PCObj.setHName(rset.getString("HOSTNAME"));
				PCObj.setOSname(rset.getString("OS"));
				PCObj.setCPUname(rset.getString("CPU"));
				PCObj.setLAMcapa(rset.getString("LAM"));
				PCObj.setHDDserial(rset.getString("HDDSERIAL"));
				PCObj.setADaccnt(rset.getString("ACCOUNT"));
				PCObj.setPCmodel(rset.getString("PCMODEL"));
				PCObj.setPCmanufacturer(rset.getString("PCMANUFACTURER"));

				PCList.add(PCObj);
			}
		}
		catch(Exception ex){}
		*/
		
		return PCList;
	}
	
	public int GetPCdataIdx(String key)
	{
		 return ReturnIDX("PC", key, "MBSERIAL", "IDX");
	}
	
	public int getIdx() {
		return data.getIdx();
	}
	public void setIdx(int idx) {
		data.setIdx(idx);
	}
	public String getmaddr() {
		return data.getMaddr();
	}
	public void setmaddr(String rmaddr) {
		data.setMaddr(rmaddr);
	}
	public String getIPAddress() {
		return data.getIPAddress();
	}
	public void setIPAddress(String iPAddress) {
		data.setIPAddress(iPAddress);
	}
	public String getHName() {
		return data.getHName();
	}
	public void setHName(String rHName) {
		data.setHName(rHName);
	}
	public String getMBserial() {
		return data.getMBserial();
	}
	public void setMBserial(String mBserial) {
		data.setMBserial(mBserial);
	}
	public String getOSname() {
		return data.getOSname();
	}
	public void setOSname(String rOSname) {
		data.setOSname(rOSname);
	}
	public String getCPUname() {
		return data.getCPUname();
	}
	public void setCPUname(String rCPUname) {
		data.setCPUname(rCPUname);
	}
	public String getLAMcapa() {
		return data.getLAMcapa();
	}
	public void setLAMcapa(String rLAMcapa) {
		data.setLAMcapa(rLAMcapa);
	}
	public String getHDDserial() {
		return data.getHDDserial();
	}
	public void setHDDserial(String hDDserial) {
		data.setHDDserial(hDDserial);
	}
	public String getADaccnt() {
		return data.getADaccnt();
	}
	public void setADaccnt(String rADaccnt) {
		data.setADaccnt(rADaccnt);
	}
	public String getPCmodel() {
		return data.getPCmodel();
	}
	public void setPCmodel(String pCmodel) {
		data.setPCmodel(pCmodel);
	}
	public String getPCmanufacturer() {
		return data.getPCmanufacturer();
	}
	public void setPCmanufacturer(String pCmanufacturer) {
		data.setPCmanufacturer(pCmanufacturer);
	}

}
