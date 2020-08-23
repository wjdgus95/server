package com.grange.board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping(value="/board/{id}")
	//@RequestMapping(value = "/board",method = RequestMethod.GET)
	public BoardVO getBoard(@PathVariable(name="id",required=true)int id){
		return this.boardService.getBoard(id);
	}
	
	//@RequestMapping(value = "/boards")
	@GetMapping(value = "/boards")
	public List<BoardVO> getBoards(){
		return this.boardService.getBoards();
	}
	
	@PostMapping(value="/board")
	public int insertBoard(BoardVO board) {
		return this.boardService.insertBoard(board);
	}
	
	@PutMapping(value="/board")
	public int updateBoard(BoardVO board) {
		return this.boardService.updateBoard(board);
	}
	
	@DeleteMapping(value="/board/{id}")
	public int deleteBoard(
			@PathVariable(name="id",required=true)int id) {
			return this.boardService.deleteBoard(id);
	}
	
}
