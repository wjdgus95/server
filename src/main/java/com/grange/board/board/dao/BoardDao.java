package com.grange.board.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.grange.board.board.vo.BoardVO;


@Repository
public class BoardDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	protected SqlSession sqlSession;
	
	public BoardVO getBoard(int id) {
	      
//	      BoardVO board = new BoardVO();
//	      
//	      if(id == 1) {
//	         board.setId(1);
//	         board.setTitle("제목1");
//	         board.setContent("내용1");
//	         board.setRegId("dkdlrja");
//	      }
//	      else if(id == 2) {
//	         board.setId(2);
//	         board.setTitle("제목2");
//	         board.setContent("내용2");
//	         board.setRegId("cmmn1234");
//	      }
//	      else {
//	         board = null;
//	      }
//	      
//	      return board;
		
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
			
			return this.sqlSession.selectOne("board.getBoard",param);
		
	   }
	
	public List<BoardVO> getBoards() {      
	      return this.sqlSession.selectList("board.getBoards");
	   }
	
	public int insertBoard(BoardVO board) {
		return this.sqlSession.insert("board.insertBoard",board);
	}
	
	public int updateBoard(BoardVO board) {
		return this.sqlSession.update("board.updateBoard",board);
	}
	
	public int deleteBoard(int id) { //map
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		
		return this.sqlSession.delete("board.deleteBoard",param);
	}
}
