package tommy.spring.web.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// XML문서는 반드시 단 하나의 루트 엘리먼트를 가져야 한다. BoardVO는 하나의 게시 글 정보를 저장하려고 사용하는 객체이다. 
// 하지만 우리는 여러 게시 글 목록을 XML로 표현해야 하므로 BoardVO 
// 객체 여러 개를 포함하면서 루트 엘리먼트로 사용할 또 다른 자바 클래스가 필요하다.
@XmlRootElement(name="boardList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
	
//	@XmlElement(name="board")를 추가하였는데 만약 이 설정이 없다면 변수 이름인 boardList가 엘리먼트 이름으로 사용된다.
	@XmlElement(name="board")
	private List<BoardVO> boardList;
	public List<BoardVO> getBoardList(){
		return boardList;
	}
	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
}
