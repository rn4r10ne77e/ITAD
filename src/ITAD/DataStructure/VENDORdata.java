package ITAD.DataStructure;

public class VENDORdata
{
	int idx, code, type=1;
	String descr="", corpno="", addr="", manager="";
		
	public int getIdx() {
		return idx;
	}
	public int getCode() {
		return code;
	}
	public int getType() {
		return type;
	}
	public String getDescr() {
		return descr;
	}
	public String getCorpno() {
		return corpno;
	}
	public String getAddr() {
		return addr;
	}
	public String getManager() {
		return manager;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public void setCorpno(String corpno) {
		this.corpno = corpno;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
}
