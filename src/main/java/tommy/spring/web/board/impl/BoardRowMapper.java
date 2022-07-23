package tommy.spring.web.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import tommy.spring.web.BoardVO;

// RowMapper 인터페이스를 구현한 BoardRowMapper 클래스
public class BoardRowMapper implements RowMapper<BoardVO>{

//RowMapper 객체를 queryForObject()메서드의 매개변수로 넘겨주면 스프링 컨테이너는 SQL 구문을
//수행한 후 자동으로 RowMapper 객체의 mapRow()메서드를 호출한다.
	
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setCnt(rs.getInt("cnt"));
		return board;
	}
}
