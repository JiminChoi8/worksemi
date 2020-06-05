package kr.co.ikosmo.mvc.vo;

import org.springframework.web.multipart.MultipartFile;

//규칙: form의 name과 데이터베이스의 테이블의 컬럼과 가급적 동일하게 만든다.
public class TBoardVO {
	
	private int num;
	
	

	private String sub,writer,content,pwd,imgfile;//변경파일 
	

	private MultipartFile mfile;//원본
	
	
public MultipartFile getMfile() {
		return mfile;
	}

	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}

	public String getImgfile() {
		return imgfile;
	}

	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}
	
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	
}
