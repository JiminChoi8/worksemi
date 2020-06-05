package kr.co.ikosmo.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParameterDemo {
	//params�� �Ӽ��� �Ķ���Ͱ��� �м��� �Ӽ��̴�. param1?code=A�� ��û�Ǿ�� ��
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
	
	//��û �Ķ���Ͱ� test�� �ƴ� �͸� �ش����
	//params="mycode!=teset"--->���ܻ���
	//param2?mycod=A,B,C or test (tes�ϰ�� ���ܻ�Ȳ���� ���۾ȵ�)
	@RequestMapping(value="/param2", params="mycode!=test")
	public ModelAndView appamDemo3(String mycode) {
		ModelAndView m = new ModelAndView();
		
		try {
			m.setViewName("template/templateC");
			String code="�⺻������";
			if(mycode.equals("A")) {
				code="A�������Դϴ�.";
			}else if(mycode.equals("B")) {
				code="B�������Դϴ�.";
			}
			m.addObject("code", code);
		} catch (Exception e) {
			m.setViewName("error");
			System.out.println("���۾ȵ�?");
		}
		return m;
	}
	
	
	
	//RequsetParam(value="id") �Ķ���Ͱ��� ������ �� �ִ� ���
	// �⺻���� required = true�̱� ������ �Ķ���Ͱ� ���� ���
	// MissingServletRequsetParameterException�� �߻��Ѵ�.
	// required=false: �Ķ���Ͱ��� ���� ���ܸ� �߻����� �ʴ´�.
	// defaultValue="" �Ķ���Ͱ��� ���� ��, �⺻������ ����
	
	
	//--���� :code, @RequsestParam�� ����ؼ� id�缳�� 
	@RequestMapping(value="/param3")
	public ModelAndView paramDemo3(@RequestParam(
	value="id", required=true) String code){
		System.out.println("code:"+code);
		ModelAndView m = new ModelAndView();
		m.setViewName("msg");
		m.addObject("msg", code);
		return m;
	}
	
	//���� ���ٸ�, default�� 
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
