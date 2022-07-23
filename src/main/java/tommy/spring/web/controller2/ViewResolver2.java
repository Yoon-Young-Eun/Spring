package tommy.spring.web.controller2;

//Controller�� ������ View �̸��� ���λ�(prefix)�� ���̻�(suffix)�� �����Ͽ� ���������� ����� View ��ο� ���ϸ��� �ϼ��Ѵ�.
public class ViewResolver2 {
//DispatcherServlet�� �����ǰ� init() �޼��尡 ȣ��� �� �����ȴ�.
	
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
