package tommy.spring.web.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
// 주의할 점은 등록날짜를 지정하는 regDate 변수는 이전까지는 java.sql.Date를 사용하였는데  
// 이 객체는 기본 생성자가 없는 객체이다. 특정 자바 객체를 XML로 변환하려면 반드시 해당 클래스의 
// 기본 생성자가 있어야 한다. 따라서 regDate 변수를 기본 생성자가 있는 java.util.Date 타입의 변수로 변경한 것이다
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;

// @XmlAccessorType은 BoardVO 객체를 XML로 변환할 수 있다는 의미이다.
// XmlAccessType.FIELD 때문에 이 객체가 가진 필드 즉 변수들은 자동적으로 자식 엘리먼트로 표현된다.
// seq 변수에만 @XmlAttribute가 붙었는데 이는 seq를 속성으로 표현하라는 의미이다.
// @XmlTransient는 XML 변환에서 제외하라는 의미다.
@XmlAccessorType(XmlAccessType.FIELD)

@Entity
@Table(name="myboard")
public class BoardVO {
	
	@Id
	@GeneratedValue
	private int seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date regDate;
	private int cnt;
	@Transient
	private String searchCondition;
	@Transient
	private String searchKeyword;
	@Transient
	private MultipartFile uploadFile;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	
}
