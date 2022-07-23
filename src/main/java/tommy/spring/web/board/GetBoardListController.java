package tommy.spring.web.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import tommy.spring.web.BoardVO;
import tommy.spring.web.board.impl.BoardDAO;


public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �˻� ó��");
		
		//1. ����� �Է� ���� ���� : �˻� ����� ���߿� ����
		//2. �����ͺ��̽� ���� ó��
		    BoardVO vo = new BoardVO();
			BoardDAO boardDao = new BoardDAO();
			List<BoardVO> boardList = boardDao.getBoardList(vo);
		//3. ����ȭ�� ����
        // ModelAndView�� Ŭ���� �̸����� �� �� �ֵ��� Model�� View������ ��� �����Ͽ� ������ �� ���
			ModelAndView mav = new ModelAndView(); //�����͸� ������ addObject("�����̸�","�����Ͱ�")�޼ҵ带 �̿�
			mav.addObject("boardList", boardList); //Model ���� ����
			mav.setViewName("getBoardList");   //view ���� ����);
			return mav;
			
//			 - Ŭ���̾�Ʈ�κ��� ��/getBoardList.do�� ��û�� �����ϸ� DispatcherServlet�� ��û�� �ް�
//			 - SimpleUrlHandlerMapping�� ���� ��û�� ó���� GetBoardListController�� �˻��Ѵ�. 
//			 - DispatcherServlet�� �˻��� GetBoardListController�� �����Ͽ� ��û�� ó���Ѵ�. 
//			 - GetBoardListController�� �˻������ List<BoardVO>�� getBoardList.jsp �̸��� ModelAndView ��ü�� �����Ͽ� �����Ѵ�. 
//			 - DispatcherServlet�� ModelAndView�κ��� View������ �����ϰ� ViewResolver�� �̿��ϸ� �������� 
//			   ����� getBoardList.jsp�� �˻��Ѵ�. 
//			 - DispatcherServlet�� getBoardList.jsp�� �����Ͽ� �� ��� ȭ���� �����Ѵ�
	}
}

