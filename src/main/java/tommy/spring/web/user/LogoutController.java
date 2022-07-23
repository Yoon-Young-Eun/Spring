package tommy.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α׾ƿ� ó��");
		// 1. �������� ����� ���� ��ü�� ����
		// getSession(false): HttpSession�� �����ϸ� ���� HttpSession�� ��ȯ�ϰ� 
		// �������� ������ ������ �������� �ʰ� �׳� null�� ��ȯ�մϴ�.
		HttpSession session =request.getSession(false);
		session.invalidate();//invalidate �Լ��� ������ ���ְ� ���ǿ� �����ִ� ������ ��� ���ش�.

		// 2. ���� ���� �� ���� ȭ������ �̵�
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav;
	}
}