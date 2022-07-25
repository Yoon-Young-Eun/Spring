package tommy.spring.web.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.BoardVO;
import tommy.spring.web.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDao) {
		System.out.println("글 삭제 처리");
		boardDao.deleteBoard(vo);
		return "getBoardList.do";
	}
}
