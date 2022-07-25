package tommy.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		session.invalidate();
		return "login.jsp";
	}
}
		
		
		
		/* // 1. 브라우저와 연결된 세션 객체를 종료
		// getSession(false): HttpSession이 존재하면 현재 HttpSession을 반환하고 
		// 존재하지 않으면 새로이 생성하지 않고 그냥 null을 반환합니다.
		HttpSession session =request.getSession(false);
		session.invalidate();//invalidate 함수는 세션을 없애고 세션에 속해있는 값들을 모두 없앤다.

		// 2. 세션 종류 후 메인 화면으로 이동
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav;
	}*/

