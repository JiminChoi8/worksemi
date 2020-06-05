package kr.co.ikosmo.mvc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ikosmo.mvc.dao.TvoDao;
import kr.co.ikosmo.mvc.vo.TBoardVO;

@RestController
public class TestRestController {

	@Autowired
	private TvoDao tvoDao;
	
	@RequestMapping(value="/helloView")
	public String viewMessage() {
		return "Hello";
	}
	
	@RequestMapping(value="/tboardJsonObj")
	public TBoardVO viewDetail(int num) {
		return tvoDao.detailTvo(num);
	}
	
	@RequestMapping(value="/tboardJson")
	public List<TBoardVO> getList(){
		List<TBoardVO> list = tvoDao.listTvo();
		return list;
	}
	
}
