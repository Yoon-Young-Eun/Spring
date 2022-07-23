package tommy.spring.web.controller2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller2 {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
