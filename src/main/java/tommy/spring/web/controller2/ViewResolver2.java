package tommy.spring.web.controller2;

//Controller가 리턴한 View 이름에 접두사(prefix)와 접미사(suffix)를 결합하여 최종적으로 실행될 View 경로와 파일명을 완성한다.
public class ViewResolver2 {
//DispatcherServlet이 생성되고 init() 메서드가 호출될 때 생성된다.
	
	private String prefix;
	private String suffix;
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
