package com.grange.board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grange.board.board.service.BoardService;
import com.grange.board.board.vo.BoardVO;
import com.grange.board.test.service.TestService;

@RestController
@RequestMapping(value ="/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board")
	public BoardVO getBoard(@RequestParam(name="id", required=true) int id){
		return this.boardService.getBoard(id);
	}
	
	@RequestMapping(value = "/boards")
	public List<BoardVO> getBoards(){
		return this.boardService.getBoards();
	}
}
