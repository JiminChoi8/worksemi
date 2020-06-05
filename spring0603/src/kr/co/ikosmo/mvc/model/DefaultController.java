package kr.co.ikosmo.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//@Controller 어노테이션의 역할 scanning 대상이 모델로 등록되도록 설정한다. 
@Controller
public class DefaultController {
	//해당 모델이 응답할 HandlerMapping이다. 
	//요청값, 요청방식 
	
	@RequestMapping(value= {"/","index"})
	public String indexPage() {
		//값을 넘길 필요가 없을 때 String변환형은 viewName
		return "main/index";
		
	}
	
}
