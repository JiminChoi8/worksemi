package kr.co.ikosmo.mvc.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.ikosmo.mvc.dao.SurveyDao;
import kr.co.ikosmo.mvc.vo.SubveyView2VO;
import kr.co.ikosmo.mvc.vo.SurveyVO;

@RestController
public class SurveyRestController {

	@Autowired
	private SurveyDao surveydao;

	@RequestMapping(value = "/surveyClientJson")
	public List<SubveyView2VO> viewDetail(int num) {
		return surveydao.adminDetail(num);
	}

	@RequestMapping(value = "/surveyClientJson2", produces = "application/json; charset=euc-kr")
	public String surveyDetail2() throws JsonGenerationException {
		int num = surveydao.surveyView2().get(0).getNum();
		List<SubveyView2VO> list = surveydao.adminDetail(num);
		Map<String, Integer> map = new HashMap<>();
		for (SubveyView2VO e : list) {
			map.put(e.getSurveytitel(), e.getSurveycnt());
		}
		System.out.println("SIZE:" + list.size());
		String result = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			result = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
}
