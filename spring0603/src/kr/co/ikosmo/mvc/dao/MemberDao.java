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
	
	//insertcó�� ( �Է�ó���� �Ǹ� 1, �ȵǸ� 0 ) 
	public int memberAdd(MemberDemoVO vo) {
		return ss.insert("member.add",vo);
	}
	
	
	//id�ߺ�Ȯ��   id="idchk"  resultType="int" parameterType="String"
	public int memberIdChk(String id) {//�Ķ���� 
		return ss.selectOne("member.idchk", id);
	}
	
	// ������ ó��
	public List<MemberDemoVO> getList(PageVO svo){//nowPage������ ������ �� start,end
		return ss.selectList("member.list",svo);
	}
	
	//��ü �����͸� �������� �������� ���� ���� ������
	public int getTotalCount() {
		return ss.selectOne("member.totalCount");
	}	
	
	
	//�˻���� 
		public List<MemberDemoVO> getSearchList(PageVO svo){
			return ss.selectList("member.serachlist",svo);
		}
	
}
