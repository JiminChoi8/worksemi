package kr.co.ikosmo.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//@Controller ������̼��� ���� scanning ����� �𵨷� ��ϵǵ��� �����Ѵ�. 
@Controller
public class DefaultController {
	//�ش� ���� ������ HandlerMapping�̴�. 
	//��û��, ��û��� 
	
	@RequestMapping(value= {"/","index"})
	public String indexPage() {
		//���� �ѱ� �ʿ䰡 ���� �� String��ȯ���� viewName
		return "main/index";
		
	}
	
}
