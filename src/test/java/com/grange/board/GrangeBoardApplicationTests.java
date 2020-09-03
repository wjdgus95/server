package com.grange.board;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grange.board.board.vo.BoardVO;

@SpringBootTest
class GrangeBoardApplicationTests {

//	@Autowired
//	private BoardService boardService;
	
	@Test
	void contextLoads() {
//		BoardVO board=new BoardVO();
//		board.setTitle(title);
		
		String pw="wjdguswjdal";
		System.out.println("origin"+pw);
		
		pw=DigestUtils.sha256Hex(pw);
		System.out.println(pw);
	}
	

}
