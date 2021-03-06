package tommy.spring.polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component("tv")
public class LgTV implements TV {
	
	@Autowired
	private Speaker speaker;
	// 생성자 powerOn() powerOff()메서드 생략
	
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		 speaker.volumeDown();
		
	}
	
	
    public LgTV() {
    	System.out.println("LgTV 객체 생성");
    }
	
	
	@Override
	public void powerOn() {
		 System.out.println("LgTV 전원을 켠다.");		
	}

	@Override
	public void powerOff() {
		 System.out.println("LgTV 전원을 끈다.");
		
	}


}
