package tommy.spring.web.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tommy.spring.web.BoardVO;
import tommy.spring.web.board.impl.BoardDAO;
import tommy.spring.web.user.UserVO;
import tommy.spring.web.user.impl.UserDAO;

//get방식, post방식 - 어떤 방식으로 요청하든 processRequest() 메서드를 통해 처리하도록 구현하였다.
//☆☆☆Controller에서 가장 중요한 DispatcherServlet 클래스는 유지보수 과정에서 기존의 기능을
// 수정하거나 새로운 기능을 추가한다 하여도 절대 수정되지 않는다
//.do로 끝나는 url은 action이라는 이름의 디스패쳐 서블릿으로 보내겠다는 의미
@WebServlet(name="action", urlPatterns= {"*.do"})
public class DispatcherServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping2 handlerMapping;
	private ViewResolver2 viewResolver;
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping2();
		viewResolver = new ViewResolver2();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)throws IOException{
		// 1. 클라이언트 정보를 추출한다.
		// RequestURI() 함수 = 프로젝트 + 파일경로 =>/myBoard/login.do
		String uri = request.getRequestURI();
		//substiring()은 특정값을 골라내는,,(start, end) 값을 넣어주지만, end값이 없으면 start부터 마지막까지 문자열을 가져옴
		String path = uri.substring(uri.lastIndexOf("/"));
		//추출된 path는 URI 문자열에서 마지막 “/XXX.do” 문자열이다.
		System.out.println(path);
		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다.
		Controller2 controller = handlerMapping.getController(path);
		// 3. 검색된 Controller를 실행한다.
		String viewName = controller.handleRequest(request, response);
		// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
		String view=null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		}else {
			view=viewName;
		}
		// 5. 검색된 화면으로 이동한다.
		response.sendRedirect(view);
		
		/*
		1. 클라이언트가 로그인 버튼을 클릭하여 "/login.do" 요청을 전송하면 DispatcherServlet이 요청을 받는다.
		2. DispatcherServlet은 HandlerMapping 객체를 통해 로그인 요청을 처리할 LoginController를 검색하고,
		3. 검색된 LoginController의 handelRequest() 메소드를 호출하면 로그인 로직이 처리된다.
		4. 로그인 처리 후에 이동할 화면 정보가 리턴되면
		5. DispatcherServlet은 ViewResolver를 통해 접두사와 접미사가 부튼 JSP 파일의 이름과 경로를 리턴받는다*/
	}
}
