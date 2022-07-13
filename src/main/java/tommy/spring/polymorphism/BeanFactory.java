package tommy.spring.polymorphism;

public class BeanFactory {
	   public Object getBean(String beanName) {
		   if(beanName.equals("samsung")) {  //伙己捞搁 伙己 积己磊
			   return new SamsungTV();
		   }else if(beanName.equals("lg")) { //郡瘤搁 郡瘤 积己磊
			   return new LgTV();
		   }
		   return null;
	   }
}
