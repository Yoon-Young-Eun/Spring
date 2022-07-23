package tommy.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import tommy.spring.web.BoardVO;
import tommy.spring.web.board.impl.BoardDAO;


public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ���� ó��");
		
		// 1. ����� �Է� ���� ����
		String seq=request.getParameter("seq");

	 	// 2. �����ͺ��̽� ���� ó��
	 	BoardVO vo = new BoardVO();
	 	vo.setSeq(Integer.parseInt(seq));
	 	
	 	BoardDAO boardDao = new BoardDAO();
	 	boardDao.deleteBoard(vo);
		
	 	// 3. ȭ�� �׺���̼�
	 	ModelAndView mav = new ModelAndView();
	 	mav.setViewName("redirect:getBoardList.do");
		return mav;
	}
}