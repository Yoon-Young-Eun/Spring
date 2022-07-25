package tommy.spring.web.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tommy.spring.web.BoardVO;
import tommy.spring.web.board.impl.BoardDAO;

@Controller
public class GetBoardListController{
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDao, 
	ModelAndView mav) {
	System.out.println("글 목록 검색 처리");
	mav.addObject("boardList", boardDao.getBoardList(vo)); // Model 정보저당
	mav.setViewName("getBoardList.jsp"); // View 정보저장
	return mav;	
		
	}
}
		/*
		///1. 사용자 입력 정보 추출 : 검색 기능은 나중에 구현
		//2. 데이터베이스 연동 처리
		    BoardVO vo = new BoardVO();
			BoardDAO boardDao = new BoardDAO();
			List<BoardVO> boardList = boardDao.getBoardList(vo);
		//3. 응답화면 구성
        // ModelAndView는 클래스 이름에서 알 수 있듯이 Model과 View정보를 모두 저장하여 리턴할 때 사용
			ModelAndView mav = new ModelAndView(); //데이터를 보낼때 addObject("변수이름","데이터값")메소드를 이용
			mav.addObject("boardList", boardList); //Model 정보 저장
			mav.setViewName("getBoardList");   //view 정보 저장);
			return mav;
			
//			 - 클라이언트로부터 “/getBoardList.do” 요청을 전송하면 DispatcherServlet이 요청을 받고
//			 - SimpleUrlHandlerMapping을 통해 요청을 처리할 GetBoardListController를 검색한다. 
//			 - DispatcherServlet은 검색된 GetBoardListController를 실행하여 요청을 처리한다. 
//			 - GetBoardListController는 검색결과인 List<BoardVO>와 getBoardList.jsp 이름을 ModelAndView 객체에 저장하여 리턴한다. 
//			 - DispatcherServlet은 ModelAndView로부터 View정보를 추출하고 ViewResolver를 이용하며 응답으로 
//			   사용할 getBoardList.jsp를 검색한다. 
//			 - DispatcherServlet은 getBoardList.jsp를 실행하여 글 목록 화면을 전송한다
	}
	*/


