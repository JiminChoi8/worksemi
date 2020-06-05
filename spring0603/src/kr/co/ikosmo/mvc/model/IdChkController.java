package kr.co.ikosmo.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ikosmo.mvc.dao.MemberDao;
import kr.co.ikosmo.mvc.vo.MemberDemoVO;

//JSON OR 커스텀 뷰를 만들 때 사용 가능
@RestController
public class IdChkController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value="/idChk")
	public int idChk(String id) {//파라미터 
		int cnt = memberDao.memberIdChk(id); 
		return cnt;
	}
	
	
	

}
