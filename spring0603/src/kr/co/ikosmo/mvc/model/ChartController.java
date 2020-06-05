package kr.co.ikosmo.mvc.model;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ChartController {

	
	@RequestMapping(value="/chart1")
	public String chart1() {
		return "member/chart1";
	}
	
	@RequestMapping(value="/piechart")
	public String piechart() {
		return "member/piechart";
	}
	
	
}
