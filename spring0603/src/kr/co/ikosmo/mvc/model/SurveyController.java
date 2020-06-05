package kr.co.ikosmo.mvc.model;


import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import kr.co.ikosmo.mvc.dao.SurveyDao;
import kr.co.ikosmo.mvc.service.SurveyService;
import kr.co.ikosmo.mvc.vo.SubveyContentVO;
import kr.co.ikosmo.mvc.vo.SubveyView2VO;
import kr.co.ikosmo.mvc.vo.SurveyVO;

@Controller
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private SurveyDao surveyDao;
	
	
	 @RequestMapping(value="/surveyForm")
	 public String surform() {
	  return "survey/surveyAddform";
	 }
	 
	 @RequestMapping(value="/addsurvey", method = RequestMethod.POST)
	 public ModelAndView addsurvey(SurveyVO vo, HttpServletRequest request) {
		 System.out.println(vo.getSub());
		 String[] surveytitle = request.getParameterValues("surveytitle");
		 //parameter값이 배열로 전송되고, 그것을 실제 값이 존재할 때 List 저장한다.
		 List<SubveyContentVO> list = new ArrayList();
		 int i =0;
		 char stype='A';//A지정
		 for(String e : surveytitle) {
			 if(i<vo.getCode()) {
				 SubveyContentVO sv = new SubveyContentVO();
				sv.setSurveytype(String.valueOf(stype)); //A값 세팅
				 System.out.println(stype);
				 sv.setSurveytitel(e);
				 list.add(sv);
			 }else {
				 break;
			 }
			 stype++;
			 i++; 
		 }
		  System.out.println("확인:" +list.size());
		  surveyService.addSurvey(vo, list);
		 ModelAndView mav = new ModelAndView("redirect:surveylist");
		 return mav;
		 
	 }
	 //관리자 list
	 @RequestMapping(value="/surveylist")
	 public ModelAndView surveyList() {
		ModelAndView mav = new ModelAndView("survey/surveyList");
		List<SurveyVO> list = surveyDao.adminList();
		mav.addObject("list", list);
		return mav;
	}
	 
	 //관리자 detail 페이지 구현
	 @RequestMapping(value="/surveyDetail")
	 public ModelAndView surveyDetail(int num) {
		 ModelAndView mav = new ModelAndView("survey/surveyDetail");
		 List<SubveyView2VO> list = surveyDao.adminDetail(num);
		 mav.addObject("list", list);
		return mav;
	 }
	 
//	 //update + 투표기능
//	 @RequestMapping(value="/surveyUpdate", method=RequestMethod.POST)
//	 public ModelAndView surveyUpdate(SubveyView2VO vo) {
//		surveyDao.surveyClientUpdate3(vo);
//		System.out.println("동작!"+vo.getSubcode()+":"+vo.getSurveytype());
//		 ModelAndView mav = new ModelAndView("redirect:surveylist");
//		 return mav;
//	}
 
	 @RequestMapping(value="/delete")
	 public ModelAndView deletList(int num) {
		 ModelAndView mav = new ModelAndView("redirect:surveylist");
		 surveyService.deleteSurvey(num);
		 return mav;
	 }
	 
	 
	
	 
	 
}
