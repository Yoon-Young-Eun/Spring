package tommy.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect //Aspect = Point + Advice
public class LogAdvice {
	
//	@Pointcut("execution(* tommy.spring.web..*Impl.*(..))")
//	public void allPointcut() {  }   // 포인트 컷
//	
//	@Before("allPointcut()")         //    +
	public void printLog() {         // 어드바이스
		System.out.println("[로그]:비즈니스 로직 수행 전 동작");
	}
}
