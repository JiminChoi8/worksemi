package kr.co.ikosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ikosmo.mvc.vo.MemberDemoVO;
import kr.co.ikosmo.mvc.vo.PageVO;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	//insertc처리 ( 입력처리가 되면 1, 안되면 0 ) 
	public int memberAdd(MemberDemoVO vo) {
		return ss.insert("member.add",vo);
	}
	
	
	//id중복확인   id="idchk"  resultType="int" parameterType="String"
	public int memberIdChk(String id) {//파라미터 
		return ss.selectOne("member.idchk", id);
	}
	
	// 페이지 처리
	public List<MemberDemoVO> getList(PageVO svo){//nowPage등으로 연산이 된 start,end
		return ss.selectList("member.list",svo);
	}
	
	//전체 데이터를 기준으로 페이지를 나눌 것이 때문에
	public int getTotalCount() {
		return ss.selectOne("member.totalCount");
	}	
	
	
	//검색기능 
		public List<MemberDemoVO> getSearchList(PageVO svo){
			return ss.selectList("member.serachlist",svo);
		}
	
}
