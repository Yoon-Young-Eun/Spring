package tommy.spring.polymorphism;

public class BeanFactory {
	   public Object getBean(String beanName) {
		   if(beanName.equals("samsung")) {  //�Ｚ�̸� �Ｚ ������
			   return new SamsungTV();
		   }else if(beanName.equals("lg")) { //������ ���� ������
			   return new LgTV();
		   }
		   return null;
	   }
}
