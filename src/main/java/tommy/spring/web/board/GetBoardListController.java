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
	System.out.println("�� ��� �˻� ó��");
	mav.addObject("boardList", boardDao.getBoardList(vo)); // Model ��������
	mav.setViewName("getBoardList.jsp"); // View ��������
	return mav;	
		
	}
}
		/*
		///1. ����� �Է� ���� ���� : �˻� ����� ���߿� ����
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
	*/


