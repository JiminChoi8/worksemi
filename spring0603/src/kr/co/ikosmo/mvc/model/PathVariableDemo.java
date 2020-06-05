package kr.co.ikosmo.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kosmo")
public class PathVariableDemo {
	//path의 값을 파라미터의 인자값으로 받아서 사용이 가능, 블로그
	@GetMapping("/{team:team[A-D]+}")
	//@GetMapping("/{team}")
	public String getTeam1(Model m, @PathVariable String team) {
		m.addAttribute("m",team);
		System.out.println("team:"+team);
		return "teams";
	}
	@GetMapping("/subpath/{team}")
	public String getTeam2(Model m, @PathVariable String team) {
		m.addAttribute("m",team);
		System.out.println("team:"+team);
		return "teams";
	}

}
