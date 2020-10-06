package com.grange.board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grange.board.board.dao.BoardDao;
import com.grange.board.board.vo.BoardVO;
import com.grange.board.test.dao.TestDao;

@Service
public class BoardService {
   
   @Autowired
   private BoardDao boardDao;
   
   public BoardVO getBoard(int id) {
	   return this.boardDao.getBoard(id);
   }
   
   public List<BoardVO> getBoards(int page,int rows){
	   return this.boardDao.getBoards(page,rows);
   }
   
   public int insertBoard(BoardVO board) {
	   return this.boardDao.insertBoard(board);
   }
   
   public int updateBoard(BoardVO board) {
	   return this.boardDao.updateBoard(board);
   }
   
   public int deleteBoard(int id) {
	   return this.boardDao.deleteBoard(id);
   }
}