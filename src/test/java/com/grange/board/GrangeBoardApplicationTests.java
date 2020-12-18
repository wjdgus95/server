package com.grange.board;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grange.board.board.dao.BoardDao;
import com.grange.board.board.service.BoardService;
import com.grange.board.board.vo.BoardVO;
import com.grange.board.comment.dao.CommentDao;
import com.grange.board.comment.vo.CommentVO;



@SpringBootTest
class GrangeBoardApplicationTests {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Test
	void contextLoads() {
//		BoardVO board=new BoardVO();
//		board.setTitle(title);
		
		/*String pw="wjdguswjdal";
		System.out.println("origin"+pw);
		
		pw=DigestUtils.sha256Hex(pw);
		System.out.println(pw);*/
		
		int boardId = 65598;
		
		List<CommentVO> comments = this.commentDao.getComments(boardId);
		System.out.println(comments.toString());
		
	}
	

}
