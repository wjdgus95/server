package com.grange.board.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grange.board.board.service.BoardService;
import com.grange.board.comment.service.CommentService;
import com.grange.board.comment.vo.CommentVO;

@RestController
@RequestMapping(value="/api/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping(value="/board/{boardId}")
	public List<CommentVO> getComments(
		@PathVariable(name="boardId",required=true)int boardId){
		return this.commentService.getComments(boardId);
	}
	
	@PostMapping(value="")
	public int insertComment(@RequestBody CommentVO comment) {
		return this.commentService.insertComment(comment);
	}
	
	@DeleteMapping(value="/{commentId}")
	public int deleteComment(@PathVariable(name="commentId",required = true)int commentId) {
		return this.commentService.deleteComment(commentId);
		
	}
	
	@PutMapping(value="")
	public int updateComment(@RequestBody CommentVO comment) {
		return this.commentService.updateComment(comment);
	}
	
}
