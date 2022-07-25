package tommy.spring.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
	System.out.println("�α��� ó��");
	if (userDAO.getUser(vo) != null) {
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

