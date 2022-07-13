package tommy.spring.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
   public static void main(String[] args) {
	   // 1. Spring  컨테이너를 구동한다.
	   //
	   AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
	   // 2. Spring 컨테이너 부터 필요한 객체를 요청(lookup) 한다.
	   // 3. 설정파일 applicationContext.xml에 <bean> 등록된 SamsungTV 객체를 생성
	   // 4. getBean()메서드로 이름이 "tv"인 객체를 요청(Lookup)  = <bean id="tv",,,,
	   
	   // 2. Spring 컨테이너 부터 필요한 객체를 요청(lookup) 한다.
//	   TV tv1=(TV)factory.getBean("tv");
//	   TV tv2=(TV)factory.getBean("tv");
//	   TV tv3=(TV)factory.getBean("tv");
	   
  //getBean("tv") Object가 반환되서 형변환(TV) 해야함 = TV tv = (TV)factory.getBean("tv",TV.class);
  //getBean("tv", TV.class); <<- 이리하면 형변환 안해도됨 (TV)삭제
	   TV tv = factory.getBean("tv",TV.class);
	   tv.powerOn();
	   tv.volumeUp();
	   tv.volumeDown();
	   tv.powerOff();
	   //3. Spring 컨테이너를 종료한다.
	   factory.close();
   }//기존의 방법은 LG로 바꾸려면 모드것 다 바꿔야함,, 결합도가 높다는 의미,,
} //인터페이스 TV를 추가하여 상속 및 다형성을 통해 생성자만 변경해서 출력값을 바꿀 수있따.     
//new 생성하지 않게하기 위해  BeanFactory에서 if을 통해 arg[]값에 따라 출력값을 변경해줄 수있따.
//최종적으로 TV를 변경할때 applicationContext.xml 파일만 수정하면 된다.