package tommy.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	 private Set<String> addressList;

	public Set<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<String> addressList) {
		this.addressList = addressList;
	}
	 
}


//List
//private List<String> addressList;
//public List<String> getAddressList() {
//	 return addressList;
//}
//public void setAddressList(List<String> addressList) {
//	 this.addressList= addressList;
//}

//Map
//public class CollectionBean {
//private Map<String, String> addressList;
//// getter, setter �߰�
//}

//Properties
//public class CollectionBean {
//	 private Properties addressList;
//	public Properties getAddressList() {
//		return addressList;
//	}
//	public void setAddressList(Properties addressList) {
//		this.addressList = addressList;
//	}
