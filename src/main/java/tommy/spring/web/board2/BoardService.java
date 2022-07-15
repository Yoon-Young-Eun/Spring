package tommy.spring.web.board2;
import java.util.List;
import tommy.spring.web.BoardVO;

public interface BoardService {
   void insertBoard(BoardVO vo);
   void updateBoard(BoardVO vo);
   void deleteBoard(BoardVO vo);
   BoardVO getBoard(BoardVO vo);
   List<BoardVO> getBoardList(BoardVO vo);
   
}
