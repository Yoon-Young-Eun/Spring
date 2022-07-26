package tommy.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tommy.spring.web.board.BoardService;
import tommy.spring.web.board.BoardVO;
import tommy.spring.web.common.Log4jAdvice;
import tommy.spring.web.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO; //BoardServiceImpl 클래스에서 사용하는 DAO 클래스가 변경되어도 클라이언트에 
	                           //해당하는 BoardController는 수정할 필요가 없다는 점이다.
	
	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getSeq()==0) {
//			throw new IllegalArgumentException("0번 글을 등록할 수 없습니다.");
//		}	
		boardDAO.insertBoard(vo); //1000번 글 등록 성공
		// 트랜잭션	boardDAO.insertBoard(vo); //Exception 발생
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
