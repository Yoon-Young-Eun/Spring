package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tommy.spring.web.BoardVO;
import tommy.spring.web.board.impl.BoardDAO;

@Controller
public class GetBoardController {

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDao, ModelAndView mav) {
					System.out.println("글 상세 보기 처리");
					mav.addObject("board", boardDao.getBoard(vo));
					mav.setViewName("getBoard.jsp");
					return mav;
	}
}
