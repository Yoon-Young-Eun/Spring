package tommy.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tommy.spring.web.user.impl.UserDAO;

@Controller
public class LoginController {
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) { 
		// Command 객체의 이름은 클래스 이름의 첫 글자를 소문자로 변경한 이름으로 변경가능하다
		// 이럴때 @ModelAttribute를 사용한다.   ↑ UserVO 개체를  "user"라고 부른다.
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	//Controller메서드에서 사용자가 입력한 정보를 추출하기 위해서 HttpServletRequest 대신 Command 객체를 사용(VO=Command))
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
	System.out.println("로그인 인증처리");
	
	if (vo.getId()== null || vo.getId().equals("")) {
		throw new IllegalAccessError("아이디는 반드시 입력해야 합니다.");
	}
	UserVO user = userDAO.getUser(vo);
	if(user != null) {
		session.setAttribute("userName", user.getName());
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

