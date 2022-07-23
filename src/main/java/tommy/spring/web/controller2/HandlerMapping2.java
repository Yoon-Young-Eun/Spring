package tommy.spring.web.controller2;

import java.util.HashMap;
import java.util.Map;

import tommy.spring.web.board.DeleteBoardController;
import tommy.spring.web.board.GetBoardController;
import tommy.spring.web.board.GetBoardListController;
import tommy.spring.web.board.InsertBoardController;
import tommy.spring.web.board.UpdateBoardController;
import tommy.spring.web.user.LoginController;
import tommy.spring.web.user.LogoutController;

//HandlerMapping�� ��� Controller ��ü�� �����ϰ� �ִٰ� Ŭ���̾�Ʈ ��û�� ������ ��û�� ó���� Ư�� Controller�� �˻��ϴ� ����� ����
public class HandlerMapping2 {
//HandlerMapping�� DispatcherServlet�� ����ϴ� ��ü�̴�. DispatcherServlet�� �����ǰ� init() �޼��尡 ȣ��� �� �� �� �����ȴ�.
// �Խ��� ���α׷��� �ʿ��� ��� Controller ��ü�� ����ϰ� �����Ѵ�.
	private Map<String, Controller2> mappings;
	public HandlerMapping2() {
//		mappings = new HashMap<String, Controller2>();
//		mappings.put("/login.do", new LoginController());
//		mappings.put("/getBoardList.do", new GetBoardListController());
//		mappings.put("/getBoard.do", new GetBoardController());
//		mappings.put("/insertBoard.do", new InsertBoardController());
//		mappings.put("/updateBoard.do", new UpdateBoardController());
//		mappings.put("/deleteBoard.do", new DeleteBoardController());
//		mappings.put("/logout.do", new LogoutController());
//		//���߿� �̺κп� ��ɾ� (path)�� Controller ��ü�� �߰���.
	}
	public Controller2 getController(String path) {
		return mappings.get(path);
	}
}
