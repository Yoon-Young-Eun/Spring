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
@SessionAttributes("board") //��(Model)������ Http ���ǿ� �������ִ� ������̼�/"board"��� �Ҹ���� �� Ű���� ���ǿ� ������
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println("searchConditionMap()");
	Map<String, String> conditionMap = new HashMap<String, String>();
	conditionMap.put("����", "TITLE");
	conditionMap.put("����", "CONTENT");
	return conditionMap;
	}

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
					System.out.println("�� ��� ó��");
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
	System.out.println("�� ���� ��� ó��");
	boardService.updateBoard(vo);
	return "getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�� ���� ó��");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("�� �� ���� ó��");
		// boardDAO ��ü�� "board"��� �̸����� Model�� ����ǰ�
		// �̶� @SessionAttributes("board") ������ ���� Model�� "board"��� �̸����� ����Ǵ� ������
		// �� �ִٸ� �� �����͸� ���ǿ��� �ڵ����� �����ϴ� ���̴�. 
		model.addAttribute("board", boardService.getBoard(vo));  
		return "getBoard.jsp";
					 /*     ModelAndView Ÿ���϶�
					mav.addObject("board", boardDao.getBoard(vo));
					mav.setViewName("getBoard.jsp");
					return mav;   */
	}
					 
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("�� ��� �˻� ó��");
		//null
		if(vo.getSearchCondition() == null)vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null)vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";

	/* @RequestParam �����
	   public String getBoardList(
			@RequestParam(value="searchCondition", defaultValue ="TITLE", required = false)String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false)String keyword, BoardDAO boardDao, Model model) {
			System.out.println("�� ��� �˻� ó��");
			System.out.println("�˻� ���� : "+condition);
			System.out.println("�˻� �ܾ� : "+keyword);
			//model.addAttribute("boardList", boardDao.getBoardList(vo)); //Model ��������
			return "getBoardList.jsp"; */
			
			/*  ModelAndView Ÿ���϶�   
			mav.addObject("boardList", boardDao.getBoardList(vo)); // Model ��������
			mav.setViewName("getBoardList.jsp"); // View ��������
			return mav;	
			*/	
	}
//	  @ModelAttribute�� �� �ٸ� ����� View(JSP)���� ����� �����͸� �����ϴ� �뵵�� ����� �� �ִ�. 
//	  @ModelAttribute�� ������ �޼���� @RequestMapping ������̼��� ����� �޼��庸�� ���� ȣ��ȴ�. 
//	  ���� @ModelAttribute �޼��� �������� ���ϵ� ��ü�� �ڵ����� Model�� ����ȴ�.

}