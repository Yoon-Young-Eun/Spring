package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.BoardVO;
import tommy.spring.web.board.impl.BoardDAO;

@Controller
public class UpdateBoardController {
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDao) {
	System.out.println("글 수정 기능 처리");
	boardDao.updateBoard(vo);
	return "getBoardList.do";
	}

}
