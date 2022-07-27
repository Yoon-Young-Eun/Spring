package tommy.spring.web.board.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tommy.spring.web.board.BoardVO;


@Repository  
public class BoardDAOMybatis{

// ---------  spring-mybatis������� ----------
// public class BoardDAOMybatis extends SqlSessionDaoSupport{ 

//	SqlSessionDaoSupport Ŭ������ ����� �Ŀ� ���� ���� �� �۾��� setSqlSessionFactory() �޼��带 ������ �� ���̴�.
//	�������� setSqlSessionFactory()�޼��� ���� @Autowired�� �ٿ��µ� �̷��� �ϸ� ������ �����̳ʰ�
//	setSqlSessionFactory() �޼��带 �ڵ����� ȣ���Ѵ�. 
//	- �̶� ������ �������Ͽ� <bean> ��ϵ� SqlSessionFactoryBean ��ü�� ���ڷ� �޾� �θ��� 
//	 SqlSessionDaoSupport�� setSqlSessionFactory() �޼���� ������ �ش�. 
//	- ���� ���� �۾��� �ؾ� SqlSessionDaoSupport Ŭ�����κ��� ��ӵ� getSqlSession() �޼��带 ȣ���Ͽ� SqlSession ��ü�� ���Ϲ��� �� �ִ�
//		@Autowired
//		public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//			super.setSqlSessionFactory(sqlSessionFactory);
//			}
	
	/* SqlSessionTemplate Ŭ������ �̿��� mybatis ����  */ 
	   @Autowired
	   private SqlSessionTemplate sqlSessionTemplate;
			public void insertBoard(BoardVO vo) {
			System.out.println("---> MyBatis�� insertBoard() ��� ó��");
			sqlSessionTemplate.insert("BoardDAO.insertBoard", vo);
			}
			public void updateBoard(BoardVO vo) {
			System.out.println("---> MyBatis�� updateBoard() ��� ó��");
			sqlSessionTemplate.update("BoardDAO.updateBoard", vo);
			}
			public void deleteBoard(BoardVO vo) {
			System.out.println("---> MyBatis�� deleteBoard() ��� ó��");
			sqlSessionTemplate.delete("BoardDAO.deleteBoard", vo);
			}
			public BoardVO getBoard(BoardVO vo) {
			System.out.println("---> MyBatis�� getBoard() ��� ó��");
			return (BoardVO) sqlSessionTemplate.selectOne("BoardDAO.getBoard", vo);
			}
			
		    //���� sql����
			public List<BoardVO> getBoardList(BoardVO vo) {
			System.out.println("---> MyBatis�� getBoardList() ��� ó��");
			return sqlSessionTemplate.selectList("BoardDAO.getBoardList", vo);
			}
}
