package ITAD.DataStructure;

public class HISTORYHEADER {
	int idx;
	String date;
	int hiscateg;
	String title;
	String content;
	int type;
	int eqpidx;
	int addwho;
	String STRaddwho;

	// Getter and Setter
	
	public int getIdx() {
		return idx;
	}
	public String getDate() {
		return date;
	}
	public int getHiscateg() {
		return hiscateg;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getType() {
		return type;
	}
	public int getEqpidx() {
		return eqpidx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setHiscateg(int category) {
		this.hiscateg = category;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setEqpidx(int eqpidx) {
		this.eqpidx = eqpidx;
	}
	public int getAddwho() {
		return addwho;
	}
	public void setAddwho(int addwho) {
		this.addwho = addwho;
	}
	public String getSTRaddwho() {
		return STRaddwho;
	}
	public void setSTRaddwho(String sTRaddwho) {
		STRaddwho = sTRaddwho;
	}
}
