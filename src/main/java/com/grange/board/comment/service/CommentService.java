package com.grange.board.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grange.board.board.dao.BoardDao;
import com.grange.board.board.vo.BoardVO;
import com.grange.board.comment.dao.CommentDao;
import com.grange.board.comment.vo.CommentVO;

@Service
public class CommentService {

	 @Autowired
	   private CommentDao commentDao;
	 
	 public List<CommentVO> getComments(int boardId){
		 return this.commentDao.getComments(boardId);
	 }
	 
	 public int insertComment(CommentVO comment) {
		 return this.commentDao.insertComment(comment);
	 }
	 
	 public int updateComment(CommentVO comment) {
		   return this.commentDao.updateComment(comment);
	 }
	 
	 public int deleteComment(int commentId) {
		   return this.commentDao.deleteComment(commentId);
	 }
}
