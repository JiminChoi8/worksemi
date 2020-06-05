package kr.co.ikosmo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ikosmo.mvc.dao.SurveyDao;
import kr.co.ikosmo.mvc.vo.SubveyContentVO;
import kr.co.ikosmo.mvc.vo.SurveyVO;

@Service
@Transactional//트랜잭션 처리를 실행해주는 어노테이션 <aop :관점지향>
public class SurveyService {

	@Autowired
	private SurveyDao surveyDao;
	
	public void addSurvey(SurveyVO vo, List<SubveyContentVO> list) {
		surveyDao.addSurvey(vo);
		surveyDao.addSurveyContent(list);
	}

	public void deleteSurvey(int num) {
		surveyDao.delet1(num);
		surveyDao.delet2(num);
	}
	
}
