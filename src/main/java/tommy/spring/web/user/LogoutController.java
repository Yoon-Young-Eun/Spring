package tommy.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		session.invalidate();
		return "login.jsp";
	}
}
		
		
		
		/* // 1. �������� ����� ���� ��ü�� ����
		// getSession(false): HttpSession�� �����ϸ� ���� HttpSession�� ��ȯ�ϰ� 
		// �������� ������ ������ �������� �ʰ� �׳� null�� ��ȯ�մϴ�.
		HttpSession session =request.getSession(false);
		session.invalidate();//invalidate �Լ��� ������ ���ְ� ���ǿ� �����ִ� ������ ��� ���ش�.

		// 2. ���� ���� �� ���� ȭ������ �̵�
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav;
	}*/

