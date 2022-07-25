package tommy.spring.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
	System.out.println("로그인 처리");
	if (userDAO.getUser(vo) != null) {
	return "getBoardList.do";
	} else {
	return "login.jsp";
	}
  }
}
		/*
		//1. 사용자 입력 정보 추출
		String id=request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. 데이터베이스 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		UserDAO userDao = new UserDAO();
		UserVO user = userDao.getUser(vo);
		
		//3. 화면 네비게이션
		ModelAndView mav= new ModelAndView();  
		if(user != null) { //참이면
			mav.setViewName("redirect:getBoardList.do"); //setViewName("뷰의 경로")로 뷰의 이름을 설정
		}else {
			mav.setViewName("redirect:login.jsp"); //view 이름 앞에 redirect: 이 붙어 있다면 ViewResolver가 설정되어 있더라도
			                                       //이를 무시하고 리다이렉트 한다.
		}
		return mav;
	}*/

