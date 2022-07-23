package tommy.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import tommy.spring.web.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α��� ó��");
		//1. ����� �Է� ���� ����
		String id=request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. �����ͺ��̽� ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		UserDAO userDao = new UserDAO();
		UserVO user = userDao.getUser(vo);
		
		//3. ȭ�� �׺���̼�
		ModelAndView mav= new ModelAndView();
		if(user != null) { //���̸�
			mav.setViewName("redirect:getBoardList.do"); //setViewName("���� ���")�� ���� �̸��� ����
		}else {
			mav.setViewName("redirect:login.jsp"); //view �̸� �տ� redirect: �� �پ� �ִٸ� ViewResolver�� �����Ǿ� �ִ���
			                                       //�̸� �����ϰ� �����̷�Ʈ �Ѵ�.
		}
		return mav;
	}
}
