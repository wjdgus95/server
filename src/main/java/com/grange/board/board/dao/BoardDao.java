package com.grange.board.board.dao;

import java.util.ArrayList;
import java.util.List;

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
	      
	      BoardVO board = new BoardVO();
	      
	      if(id == 1) {
	         board.setId(1);
	         board.setTitle("제목1");
	         board.setContent("내용1");
	         board.setRegId("dkdlrja");
	      }
	      else if(id == 2) {
	         board.setId(2);
	         board.setTitle("제목2");
	         board.setContent("내용2");
	         board.setRegId("cmmn1234");
	      }
	      else {
	         board = null;
	      }
	      
	      return board;
	   }
	
	public List<BoardVO> getBoards() {      
	      return this.sqlSession.selectList("board.getBoards");
	   }
}
