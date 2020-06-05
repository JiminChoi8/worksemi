package kr.co.ikosmo.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParameterDemo {
	//params란 속성은 파라미터값을 분석한 속성이다. param1?code=A로 요청되어야 함
	@RequestMapping(value="/param1",params="code=A")
	public ModelAndView paramDemo1(String code) {
		ModelAndView m = new ModelAndView();
		m.setViewName("template/templateA");
		m.addObject("code", code);
		return m;
	}
	@RequestMapping(value="/param1",params="code=B")
	public ModelAndView paramDemo2(String code) {
		ModelAndView m = new ModelAndView();
		m.setViewName("template/templateB");
		m.addObject("code", code);
		return m;
	}
	
	//요청 파라미터가 test가 아닌 것만 해당사항
	//params="mycode!=teset"--->예외사항
	//param2?mycod=A,B,C or test (tes일경우 예외상황으로 동작안됨)
	@RequestMapping(value="/param2", params="mycode!=test")
	public ModelAndView appamDemo3(String mycode) {
		ModelAndView m = new ModelAndView();
		
		try {
			m.setViewName("template/templateC");
			String code="기본페이지";
			if(mycode.equals("A")) {
				code="A페이지입니다.";
			}else if(mycode.equals("B")) {
				code="B페이지입니다.";
			}
			m.addObject("code", code);
		} catch (Exception e) {
			m.setViewName("error");
			System.out.println("동작안됨?");
		}
		return m;
	}
	
	
	
	//RequsetParam(value="id") 파라미터값을 지정할 수 있는 기능
	// 기본값은 required = true이기 때문에 파라미터가 없을 경우
	// MissingServletRequsetParameterException이 발생한다.
	// required=false: 파라미터값에 대한 예외를 발생하지 않는다.
	// defaultValue="" 파라미터값이 없을 때, 기본값으로 설정
	
	
	//--원래 :code, @RequsestParam을 사용해서 id재설정 
	@RequestMapping(value="/param3")
	public ModelAndView paramDemo3(@RequestParam(
	value="id", required=true) String code){
		System.out.println("code:"+code);
		ModelAndView m = new ModelAndView();
		m.setViewName("msg");
		m.addObject("msg", code);
		return m;
	}
	
	//값이 없다면, default값 
	@RequestMapping(value="/param5")
	public ModelAndView paramDem5(@RequestParam(
	value="id", required=false, defaultValue="defaultTest") String code){
		System.out.println("code:"+code);
		ModelAndView m = new ModelAndView();
		m.setViewName("msg");
		m.addObject("msg", code);
		return m;
	}
	
	
}
