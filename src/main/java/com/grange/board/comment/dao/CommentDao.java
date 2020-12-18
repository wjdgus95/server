package com.grange.board.comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.grange.board.comment.vo.CommentVO;

@Repository
public class CommentDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate") //core->DataSourceConfig->Bean에 이름있음 (이름 : "sqlSessionTemplate")
	protected SqlSession sqlSession;
	
	public List<CommentVO> getComments(int boardId){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("boardId", boardId);
		
		return this.sqlSession.selectList("comment.getComments",param);
		
	}
	
	public int insertComment(CommentVO comment) {
		return this.sqlSession.insert("comment.insertComment",comment);
	}
	
	public int deleteComment(int commentId) {
	
		return this.sqlSession.delete("comment.deleteComment",commentId);
	}
	
	public int updateComment(CommentVO comment) {
		return this.sqlSession.update("comment.updateComment",comment);
	}
	
}
