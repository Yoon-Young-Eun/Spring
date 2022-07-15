package tommy.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect //Aspect = Point + Advice
public class LogAdvice {
	
//	@Pointcut("execution(* tommy.spring.web..*Impl.*(..))")
//	public void allPointcut() {  }   // ����Ʈ ��
//	
//	@Before("allPointcut()")         //    +
	public void printLog() {         // �����̽�
		System.out.println("[�α�]:����Ͻ� ���� ���� �� ����");
	}
}
