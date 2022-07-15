package tommy.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {


		
	
	
	@Pointcut("execution(* tommy.spring.web..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	//@Before("allPointcut()")
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jointPoint) {
		//클라이언트 호출한 메서드의 시그니처(리턴타이브 이름 매개변수)가 Signature에 저장된다, getName 클라이언트가 호출한 메서드 이름을 리턴
		String method = jointPoint.getSignature().getName();
		Object[] args = jointPoint.getArgs(); //클라이언트가 메서드를 호출할때 넘겨준 인자목록을 object 배열로 리턴
		System.out.println("[사전처리] : "+method+"()메서드의 args정보 : "+args[0].toString());
	}
	
}
