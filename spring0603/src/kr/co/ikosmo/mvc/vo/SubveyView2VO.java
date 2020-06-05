package kr.co.ikosmo.mvc.vo;

import java.sql.Date;

public class SubveyView2VO {

	private int num;
	private String sub;
	private int code;
	private Date sdate;
	private int total;
	
	
	
	private String surveytype;
	private int subcode;
	private String surveytitel;
	private int surveycnt;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getSurveytype() {
		return surveytype;
	}
	public void setSurveytype(String surveytype) {
		this.surveytype = surveytype;
	}
	public int getSubcode() {
		return subcode;
	}
	public void setSubcode(int subcode) {
		this.subcode = subcode;
	}
	public String getSurveytitel() {
		return surveytitel;
	}
	public void setSurveytitel(String surveytitel) {
		this.surveytitel = surveytitel;
	}
	public int getSurveycnt() {
		return surveycnt;
	}
	public void setSurveycnt(int surveycnt) {
		this.surveycnt = surveycnt;
	}
	
	
}
