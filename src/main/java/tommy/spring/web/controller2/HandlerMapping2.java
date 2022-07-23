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

//HandlerMapping은 모든 Controller 객체를 저장하고 있다가 클라이언트 요청이 들어오면 요청을 처리할 특정 Controller를 검색하는 기능을 제공
public class HandlerMapping2 {
//HandlerMapping은 DispatcherServlet이 사용하는 객체이다. DispatcherServlet이 생성되고 init() 메서드가 호출될 때 한 번 생성된다.
// 게시판 프로그램에 필요한 모든 Controller 객체를 등록하고 관리한다.
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
//		//나중에 이부분에 명령어 (path)와 Controller 객체가 추가됨.
	}
	public Controller2 getController(String path) {
		return mappings.get(path);
	}
}
