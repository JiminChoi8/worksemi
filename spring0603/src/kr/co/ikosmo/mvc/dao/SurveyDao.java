package kr.co.ikosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ikosmo.mvc.vo.SubveyContentVO;
import kr.co.ikosmo.mvc.vo.SubveyView2VO;
import kr.co.ikosmo.mvc.vo.SurveyVO;

@Repository
public class SurveyDao {

	@Autowired
	private SqlSessionTemplate ss;
	
	public void addSurvey(SurveyVO vo) {
		ss.insert("survey.add", vo);
	}
	
	public void addSurveyContent(List<SubveyContentVO> list) {
		ss.insert("survey.addcontent",list);
	}
	
	public List<SurveyVO> adminList() {
		return ss.selectList("survey.adminList");
	}
	
	public List<SubveyView2VO> adminDetail(int num){
		return ss.selectList("survey.adminDetail",num);
	}
	
	// surveyClientform :설문지 폼에 출력될 데이터 값
	public List<SubveyView2VO> surveyView2(){
		return ss.selectList("survey.surveyclient");
	}
	
	//update 투표기능
	//mybatis에 정의한  update구문을 실행
	public void surveyClientUpdate3(SubveyView2VO vo) {
		int res = ss.update("survey.update1",vo);
		System.out.println("res:"+res);
	}
	
	public void delet1(int num) {
		ss.delete("survey.delet1",num);
	}
	
	public void delet2(int num) {
		ss.delete("survey.delet2", num);
	}

	
}

