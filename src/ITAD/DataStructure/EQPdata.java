package ITAD.DataStructure;

import ITAD.*;

public class EQPdata {

	int idx, useridx, eqpidx;
	int qty=1, serial=0;
	String mark;
	
	String pictarget;
	
	
	int eqpcateg;   String STReqpcateg;	String TAGeqpcateg;
	int subcate; 	String STRsubcate;	String TAGsubcate;
	int category;	String STRcategory;	String TAGcategory;
	int MNDept;		String STRMNDept;	String TAGMNDept;
	int location;	String STRlocation;	String TAGlocation;
	int vendor;		String STRvendor; 	String TAGvendor;
	int purpose=0;	String STRpurpose;	String TAGpurpose;
	int status=0;	String STRstatus;	String TAGstatus;
	
	long price;

	String genedate, destdate, MN, sapno;
	String objmodel;
	String objmanufacture;
	String objserial;

	String usrname;
	String usrdept;

	String strMNDept;
	String strSubcategory;
	String strCategory;
	String admin1, admin2;

	// ------------- Expand ----------------- //

	public String getAdmin1() {
		return (admin1!=null)?admin1:"";
	}
	public String getAdmin2() {
		return (admin2!=null)?admin2:"";
	}
	public void setAdmin1(String admin1) {
		this.admin1 = admin1;
	}
	public void setAdmin2(String admin2) {
		this.admin2 = admin2;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getUseridx() {
		return useridx;
	}
	public void setUseridx(int useridx) {
		this.useridx = useridx;
	}
	public int getEqpidx() {
		return eqpidx;
	}
	public void setEqpidx(int eqpidx) {
		this.eqpidx = eqpidx;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getGenedate() {
		return genedate;
	}
	public void setGenedate(String genedate) {
		this.genedate = genedate;
	}
	public int getMNDept() {
		return MNDept;
	}
	public void setMNDept(int mNDept) {
		MNDept = mNDept;
	}
	public String getMN() {
		return (MN!=null)?MN:"";
	}
	public void setMN(String mN) {
		MN = mN;
	}
	public String getDestdate() {
		return destdate;
	}
	public void setDestdate(String destdate) {
		this.destdate = destdate;
	}
	public String getObjmodel() {
		return objmodel;
	}
	public void setObjmodel(String objmodel) {
		this.objmodel = objmodel;
	}
	public String getObjmanufacture() {
		return objmanufacture;
	}
	public void setObjmanufacture(String objmanufacture) {
		this.objmanufacture = objmanufacture;
	}
	public String getObjserial() {
		return objserial;
	}
	public void setObjserial(String objserial) {
		this.objserial = objserial;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getStrMNDept() {
		return strMNDept;
	}
	public void setStrMNDept(String strMNDept) {
		this.strMNDept = strMNDept;
	}
	public String getStrCategory() {
		return strCategory;
	}
	public void setStrCategory(String strCategory) {
		this.strCategory = strCategory;
	}
	public String getUsrdept() {
		return usrdept;
	}
	public void setUsrdept(String usrdept) {
		this.usrdept = usrdept;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getPurpose() {
		return purpose;
	}
	public void setPurpose(int purpose) {
		this.purpose = purpose;
	}
	public String getSTRcategory() {
		return STRcategory;
	}
	public void setSTRcategory(String sTRcategory) {
		STRcategory = sTRcategory;
	}
	public String getSTRMNDept() {
		return STRMNDept;
	}
	public void setSTRMNDept(String sTRMNDept) {
		STRMNDept = sTRMNDept;
	}
	public String getSTRpurpose() {
		return STRpurpose;
	}
	public void setSTRpurpose(String sTRpurpose) {
		STRpurpose = sTRpurpose;
	}
	public String getTAGcategory() {
		return TAGcategory;
	}
	public void setTAGcategory(String tAGcategory) {
		TAGcategory = tAGcategory;
	}
	public String getTAGMNDept() {
		return TAGMNDept;
	}
	public void setTAGMNDept(String tAGMNDept) {
		TAGMNDept = tAGMNDept;
	}
	public String getTAGlocation() {
		return TAGlocation;
	}
	public void setTAGlocation(String tAGlocation) {
		TAGlocation = tAGlocation;
	}
	public String getTAGpurpose() {
		return TAGpurpose;
	}
	public void setTAGpurpose(String tAGpurpose) {
		TAGpurpose = tAGpurpose;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public int getEqpcateg() {
		return eqpcateg;
	}
	public void setEqpcateg(int eqpcateg) {
		this.eqpcateg = eqpcateg;
	}
	public String getSTReqpcateg() {
		return STReqpcateg;
	}
	public void setSTReqpcateg(String sTReqpcateg) {
		STReqpcateg = sTReqpcateg;
	}
	public String getTAGeqpcateg() {
		return TAGeqpcateg;
	}
	public void setTAGeqpcateg(String tAGeqpcateg) {
		TAGeqpcateg = tAGeqpcateg;
	}
	public int getSubcate() {
		return subcate;
	}
	public void setSubcate(int subcate) {
		this.subcate = subcate;
	}
	public String getSTRsubcate() {
		return STRsubcate;
	}
	public void setSTRsubcate(String sTRsubcate) {
		STRsubcate = sTRsubcate;
	}
	public String getTAGsubcate() {
		return TAGsubcate;
	}
	public void setTAGsubcate(String tAGsubcate) {
		TAGsubcate = tAGsubcate;
	}
	public int getVendor() {
		return vendor;
	}
	public void setVendor(int vendor) {
		this.vendor = vendor;
	}
	public String getSTRvendor() {
		return STRvendor;
	}
	public void setSTRvendor(String sTRvendor) {
		STRvendor = sTRvendor;
	}
	public String getTAGvendor() {
		return TAGvendor;
	}
	public void setTAGvendor(String tAGvendor) {
		TAGvendor = tAGvendor;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getSapno() {
		return (sapno!=null)?sapno:"";
	}
	public void setSapno(String sapno) {
		this.sapno = sapno;
	}
	public String getStrSubcategory() {
		return strSubcategory;
	}
	public void setStrSubcategory(String strSubcategory) {
		this.strSubcategory = strSubcategory;
	}
	public String getSTRlocation() {
		return STRlocation;
	}
	public void setSTRlocation(String sTRlocation) {
		STRlocation = sTRlocation;
	}
	public int getStatus() {
		return status;
	}
	public String getSTRstatus() {
		return STRstatus;
	}
	public String getTAGstatus() {
		return TAGstatus;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setSTRstatus(String sTRstatus) {
		STRstatus = sTRstatus;
	}
	public void setTAGstatus(String tAGstatus) {
		TAGstatus = tAGstatus;
	}
	public String getPictarget() {
		return pictarget;
	}
	public void setPictarget(String pictarget) {
		this.pictarget = pictarget;
	}
	
}