package tommy.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.BoardVO;
import tommy.spring.web.board.impl.BoardDAO;

@Controller
public class InsertBoardController {
//	 Controller ������̼��� �̿��Ͽ� Controller ��ü�� �ν��ϰ� �� �� ������ Ŭ���̾�Ʈ�� ��û�� 
//	 insertBoard() �޼��尡 ����ǰ� �� ���� ����. 
//	 Ŭ���̾�Ʈ�� insertBoard.do ��û�� ���ؼ� insertBoard() �޼��尡 ����ǰ� �Ϸ��� �տ����� 
//	 HandlerMapping�� �̿��Ͽ���. 
//	 ������������ @RequestMapping�� �̿��Ͽ� HandlerMapping�� ��ü�Ѵ�.
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDao) {
					System.out.println("�� ��� ó��");
					// 1. ����� �Է� ���� ���� : Ŀ�ǵ� ��ü�� �ڵ����� ó���� ��
					// 2. �����ͺ��̽� ���� ó��
					boardDao.insertBoard(vo);
					return "getBoardList.do";		
    //Controller �޼��尡 ����ǰ� View ��θ� �����ϸ� �⺻������ ������ ������� ó���Ѵ�. ���� 
	//�����̷�Ʈ ����� ���� ���� "redirect:"��� ���ξ �ٿ��� �Ѵ�
	}
}



/*
public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
					System.out.println("�� ��� ó��");
					// 1. ����� �Է� ���� ����
					//request.setCharacterEncoding("utf-8");
					String title=request.getParameter("title");
					String writer=request.getParameter("writer");
					String content = request.getParameter("content");
					
					// 2. �����ͺ��̽� ���� ó��
					BoardVO vo = new BoardVO();
					vo.setTitle(title);
					vo.setWriter(writer);
					vo.setContent(content);
					
					BoardDAO boardDao = new BoardDAO();
					boardDao.insertBoard(vo);
					
					// 3. ȭ�� �׺���̼�
					ModelAndView mav = new ModelAndView();
					mav.setViewName("redirect:getBoardList.do");
					return mav;
	} */

