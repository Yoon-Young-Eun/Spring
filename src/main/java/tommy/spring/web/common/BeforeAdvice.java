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
		//Ŭ���̾�Ʈ ȣ���� �޼����� �ñ״�ó(����Ÿ�̺� �̸� �Ű�����)�� Signature�� ����ȴ�, getName Ŭ���̾�Ʈ�� ȣ���� �޼��� �̸��� ����
		String method = jointPoint.getSignature().getName();
		Object[] args = jointPoint.getArgs(); //Ŭ���̾�Ʈ�� �޼��带 ȣ���Ҷ� �Ѱ��� ���ڸ���� object �迭�� ����
		System.out.println("[����ó��] : "+method+"()�޼����� args���� : "+args[0].toString());
	}
	
}
