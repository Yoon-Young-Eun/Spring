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

//get���, post��� - � ������� ��û�ϵ� processRequest() �޼��带 ���� ó���ϵ��� �����Ͽ���.
//�١١�Controller���� ���� �߿��� DispatcherServlet Ŭ������ �������� �������� ������ �����
// �����ϰų� ���ο� ����� �߰��Ѵ� �Ͽ��� ���� �������� �ʴ´�
//.do�� ������ url�� action�̶�� �̸��� ������ �������� �����ڴٴ� �ǹ�
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
		// 1. Ŭ���̾�Ʈ ������ �����Ѵ�.
		// RequestURI() �Լ� = ������Ʈ + ���ϰ�� =>/myBoard/login.do
		String uri = request.getRequestURI();
		//substiring()�� Ư������ ��󳻴�,,(start, end) ���� �־�������, end���� ������ start���� ���������� ���ڿ��� ������
		String path = uri.substring(uri.lastIndexOf("/"));
		//����� path�� URI ���ڿ����� ������ ��/XXX.do�� ���ڿ��̴�.
		System.out.println(path);
		// 2. HandlerMapping�� ���� path�� �ش��ϴ� Controller�� �˻��Ѵ�.
		Controller2 controller = handlerMapping.getController(path);
		// 3. �˻��� Controller�� �����Ѵ�.
		String viewName = controller.handleRequest(request, response);
		// 4. ViewResolver�� ���� viewName�� �ش��ϴ� ȭ���� �˻��Ѵ�.
		String view=null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		}else {
			view=viewName;
		}
		// 5. �˻��� ȭ������ �̵��Ѵ�.
		response.sendRedirect(view);
		
		/*
		1. Ŭ���̾�Ʈ�� �α��� ��ư�� Ŭ���Ͽ� "/login.do" ��û�� �����ϸ� DispatcherServlet�� ��û�� �޴´�.
		2. DispatcherServlet�� HandlerMapping ��ü�� ���� �α��� ��û�� ó���� LoginController�� �˻��ϰ�,
		3. �˻��� LoginController�� handelRequest() �޼ҵ带 ȣ���ϸ� �α��� ������ ó���ȴ�.
		4. �α��� ó�� �Ŀ� �̵��� ȭ�� ������ ���ϵǸ�
		5. DispatcherServlet�� ViewResolver�� ���� ���λ�� ���̻簡 ��ư JSP ������ �̸��� ��θ� ���Ϲ޴´�*/
	}
}
