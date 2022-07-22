package tommy.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tommy.spring.web.BoardVO;
import tommy.spring.web.board2.BoardService;
import tommy.spring.web.common.Log4jAdvice;
import tommy.spring.web.common.LogAdvice;


@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOSpring boardDAO;
	//private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getSeq()==0) {
//			throw new IllegalArgumentException("0번 글을 등록할 수 없습니다.");
//		}	
		// 트랜잭션	boardDAO.insertBoard(vo); //1000번 글 등록 성공
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
