package tommy.spring.web.board2;

import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import tommy.spring.web.BoardVO;

public class BoardServiceClient {
    public static void main(String[] arg) {
    //1. ������ �����̳� ����
    AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
    //2. ������ �����̳ʷ� ���� BoardServiceImpl ��ü�� lookup �Ѵ�.
    BoardService boardService = (BoardService)container.getBean("boardService");
    
    //3. �� ��� ��� �׽�Ʈ
    BoardVO vo = new BoardVO();
    vo.setTitle("�ӽ�����");
    vo.setWriter("ȫ�浿");
    vo.setContent("1��....");
    boardService.insertBoard(vo);
    //4. �� �˻� ��� �׽�Ʈ
    List<BoardVO> boardList = boardService.getBoardList(vo); 
    for(BoardVO board : boardList) {
    	System.out.println("--->"+board.toString());
    }
    //5. ������ �����̳� ����
    container.close();
    }
}
