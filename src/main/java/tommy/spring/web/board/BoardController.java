package tommy.spring.web.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tommy.spring.web.board.impl.BoardDAO;


@Controller
@SessionAttributes("board") //모델(Model)정보를 Http 세션에 저장해주는 어노테이션/"board"라고 불리우는 모델 키값을 세션에 저장함
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println("searchConditionMap()");
	Map<String, String> conditionMap = new HashMap<String, String>();
	conditionMap.put("제목", "TITLE");
	conditionMap.put("내용", "CONTENT");
	return conditionMap;
	}

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
					System.out.println("글 등록 처리");
					MultipartFile uploadFile = vo.getUploadFile();
					if(!uploadFile.isEmpty()) {
					String fileName = uploadFile.getOriginalFilename();
							uploadFile.transferTo(new File("C:/myProject/" + fileName));
					}
					boardService.insertBoard(vo);
					return "getBoardList.do";	
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board")BoardVO vo) {
	System.out.println("글 수정 기능 처리");
	boardService.updateBoard(vo);
	return "getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 보기 처리");
		// boardDAO 객체를 "board"라는 이름으로 Model에 저장되고
		// 이때 @SessionAttributes("board") 설정에 의해 Model에 "board"라는 이름으로 저장되는 데이터
		// 가 있다면 그 데이터를 세션에도 자동으로 저장하는 것이다. 
		model.addAttribute("board", boardService.getBoard(vo));  
		return "getBoard.jsp";
					 /*     ModelAndView 타입일때
					mav.addObject("board", boardDao.getBoard(vo));
					mav.setViewName("getBoard.jsp");
					return mav;   */
	}
					 
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");
		//null
		if(vo.getSearchCondition() == null)vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null)vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";

	/* @RequestParam 사용방법
	   public String getBoardList(
			@RequestParam(value="searchCondition", defaultValue ="TITLE", required = false)String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false)String keyword, BoardDAO boardDao, Model model) {
			System.out.println("글 목록 검색 처리");
			System.out.println("검색 조건 : "+condition);
			System.out.println("검색 단어 : "+keyword);
			//model.addAttribute("boardList", boardDao.getBoardList(vo)); //Model 정보저장
			return "getBoardList.jsp"; */
			
			/*  ModelAndView 타입일때   
			mav.addObject("boardList", boardDao.getBoardList(vo)); // Model 정보저장
			mav.setViewName("getBoardList.jsp"); // View 정보저장
			return mav;	
			*/	
	}
//	  @ModelAttribute의 또 다른 기능은 View(JSP)에서 사용할 데이터를 설정하는 용도로 사용할 수 있다. 
//	  @ModelAttribute가 설정된 메서드는 @RequestMapping 어노테이션이 적용된 메서드보다 먼저 호출된다. 
//	  또한 @ModelAttribute 메서드 실행결과로 리턴된 객체는 자동으로 Model에 저장된다.

}