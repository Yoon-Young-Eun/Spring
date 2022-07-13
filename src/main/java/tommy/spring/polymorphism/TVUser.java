package tommy.spring.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
   public static void main(String[] args) {
	   // 1. Spring  �����̳ʸ� �����Ѵ�.
	   //
	   AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
	   // 2. Spring �����̳� ���� �ʿ��� ��ü�� ��û(lookup) �Ѵ�.
	   // 3. �������� applicationContext.xml�� <bean> ��ϵ� SamsungTV ��ü�� ����
	   // 4. getBean()�޼���� �̸��� "tv"�� ��ü�� ��û(Lookup)  = <bean id="tv",,,,
	   
	   // 2. Spring �����̳� ���� �ʿ��� ��ü�� ��û(lookup) �Ѵ�.
//	   TV tv1=(TV)factory.getBean("tv");
//	   TV tv2=(TV)factory.getBean("tv");
//	   TV tv3=(TV)factory.getBean("tv");
	   
  //getBean("tv") Object�� ��ȯ�Ǽ� ����ȯ(TV) �ؾ��� = TV tv = (TV)factory.getBean("tv",TV.class);
  //getBean("tv", TV.class); <<- �̸��ϸ� ����ȯ ���ص��� (TV)����
	   TV tv = factory.getBean("tv",TV.class);
	   tv.powerOn();
	   tv.volumeUp();
	   tv.volumeDown();
	   tv.powerOff();
	   //3. Spring �����̳ʸ� �����Ѵ�.
	   factory.close();
   }//������ ����� LG�� �ٲٷ��� ���� �� �ٲ����,, ���յ��� ���ٴ� �ǹ�,,
} //�������̽� TV�� �߰��Ͽ� ��� �� �������� ���� �����ڸ� �����ؼ� ��°��� �ٲ� ���ֵ�.     
//new �������� �ʰ��ϱ� ����  BeanFactory���� if�� ���� arg[]���� ���� ��°��� �������� ���ֵ�.
//���������� TV�� �����Ҷ� applicationContext.xml ���ϸ� �����ϸ� �ȴ�.