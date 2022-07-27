package tommy.spring.web.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// XML������ �ݵ�� �� �ϳ��� ��Ʈ ������Ʈ�� ������ �Ѵ�. BoardVO�� �ϳ��� �Խ� �� ������ �����Ϸ��� ����ϴ� ��ü�̴�. 
// ������ �츮�� ���� �Խ� �� ����� XML�� ǥ���ؾ� �ϹǷ� BoardVO 
// ��ü ���� ���� �����ϸ鼭 ��Ʈ ������Ʈ�� ����� �� �ٸ� �ڹ� Ŭ������ �ʿ��ϴ�.
@XmlRootElement(name="boardList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
	
//	@XmlElement(name="board")�� �߰��Ͽ��µ� ���� �� ������ ���ٸ� ���� �̸��� boardList�� ������Ʈ �̸����� ���ȴ�.
	@XmlElement(name="board")
	private List<BoardVO> boardList;
	public List<BoardVO> getBoardList(){
		return boardList;
	}
	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
}
