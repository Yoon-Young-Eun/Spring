package tommy.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.BoardVO;
import tommy.spring.web.board.impl.BoardDAO;

@Controller
public class InsertBoardController {
//	 Controller 어노테이션을 이용하여 Controller 객체로 인식하게 할 수 있지만 클라이언트의 요청에 
//	 insertBoard() 메서드가 실행되게 할 수는 없다. 
//	 클라이언트의 insertBoard.do 요청에 대해서 insertBoard() 메서드가 수행되게 하려고 앞에서는 
//	 HandlerMapping을 이용하였다. 
//	 스프링에서는 @RequestMapping을 이용하여 HandlerMapping을 대체한다.
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDao) {
					System.out.println("글 등록 처리");
					// 1. 사용자 입력 정보 추출 : 커맨드 객체가 자동으로 처리해 줌
					// 2. 데이터베이스 연동 처리
					boardDao.insertBoard(vo);
					return "getBoardList.do";		
    //Controller 메서드가 실행되고 View 경로를 리턴하면 기본적으로 포워딩 방식으로 처리한다. 만약 
	//리다이렉트 방식을 원할 때는 "redirect:"라는 접두어를 붙여야 한다
	}
}



/*
public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
					System.out.println("글 등록 처리");
					// 1. 사용자 입력 정보 추출
					//request.setCharacterEncoding("utf-8");
					String title=request.getParameter("title");
					String writer=request.getParameter("writer");
					String content = request.getParameter("content");
					
					// 2. 데이터베이스 연동 처리
					BoardVO vo = new BoardVO();
					vo.setTitle(title);
					vo.setWriter(writer);
					vo.setContent(content);
					
					BoardDAO boardDao = new BoardDAO();
					boardDao.insertBoard(vo);
					
					// 3. 화면 네비게이션
					ModelAndView mav = new ModelAndView();
					mav.setViewName("redirect:getBoardList.do");
					return mav;
	} */

