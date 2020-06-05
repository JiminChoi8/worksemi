package kr.co.ikosmo.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ikosmo.mvc.dao.MemberDao;
import kr.co.ikosmo.mvc.vo.MemberDemoVO;
import kr.co.ikosmo.mvc.vo.PageVO;

@Controller
public class MemberController {

	
	@Autowired
	private MemberDao memberDao;
	
	
	@RequestMapping(value="/memberForm")
	public String meberForm(){
		return "member/memberForm";
	}
	
	// 회원가입 
	@PostMapping("memberIn")
	public ModelAndView addMeber(MemberDemoVO vo) {
		ModelAndView mav = new ModelAndView();
		int res= memberDao.memberAdd(vo);
		if(res==1) {
			mav.setViewName("member/success");
			mav.addObject("mid", vo.getId());
		}else {
			mav.setViewName("member/error");
			mav.addObject("mid",vo.getId());
		}
		return mav;
	}
	
//	
//	// id중복확인 
//	@RequestMapping(value="/idChk")//요청이름 
//	public String idchk(Model m) {
//		return "member/idChk";//view이름
//	}
//	
	
	//페이지값이 있으면 기본값/ 없으면 cntpage()
	@RequestMapping(value="/memlist")
	public String listSearch(PageVO vo, Model model,
			@RequestParam(value="nowPage", required = false,defaultValue = "1") String nowPage,
			@RequestParam(value="cntPerPage", required = false,defaultValue = "5") String cntPerPage) {
		int total =memberDao.getTotalCount();
		vo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		System.out.println("Start:"+vo.getStart());
		System.out.println("End:"+vo.getEnd());
		model.addAttribute("paging",vo );
		model.addAttribute("list",memberDao.getList(vo) );
		return "member/memberlist";
	}
				
	//검색기능
	@RequestMapping(value="/memberserachlist")
	public String memberserachList(Model model, PageVO vo) {
		model.addAttribute("list", memberDao.getSearchList(vo));
		return "member/memberserachlist";
	}
	
}
