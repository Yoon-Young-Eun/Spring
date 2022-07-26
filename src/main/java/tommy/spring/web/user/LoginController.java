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
		// Command ��ü�� �̸��� Ŭ���� �̸��� ù ���ڸ� �ҹ��ڷ� ������ �̸����� ���氡���ϴ�
		// �̷��� @ModelAttribute�� ����Ѵ�.   �� UserVO ��ü��  "user"��� �θ���.
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	//Controller�޼��忡�� ����ڰ� �Է��� ������ �����ϱ� ���ؼ� HttpServletRequest ��� Command ��ü�� ���(VO=Command))
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
	System.out.println("�α��� ����ó��");
	
	if (vo.getId()== null || vo.getId().equals("")) {
		throw new IllegalAccessError("���̵�� �ݵ�� �Է��ؾ� �մϴ�.");
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
	}*/

