package com.grange.board.web.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grange.board.board.service.BoardService;
import com.grange.board.board.vo.BoardVO;


@Controller(value = "/webBoardController")
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//동작하는지 확인
	@GetMapping(value = "/index")
	public String index() {
		return "pages/index";
	}
	
	@GetMapping(value = "/list")
	public String list(ModelMap model
			, @RequestParam(name = "page",defaultValue = "1")int page
			, @RequestParam(name = "rows", defaultValue = "20")int rows) {
		
		//final int page = 1;
		//final int rows = 20;
		
		List<BoardVO> boards = this.boardService.getBoards(page,rows);
		model.addAttribute("boards",boards);
		model.addAttribute("test","eeeeewewe");//test용
		model.addAttribute("page",page);
		
		/*if(true) {
			return "redirect:/user/login";
		}*/
		
		System.out.println("boardControllerList");
		
		return "pages/board/list_ajax";
	}
	
	@GetMapping(value = "/detail/{id}")
	public ModelAndView detail(@PathVariable(name="id",required=true)int id) {
		
		BoardVO board= this.boardService.getBoard(id);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("pages/board/detail");
		mav.addObject("board",board);
		
		return mav;
	}
	
	@GetMapping(value = "/modify/{id}")
	public String modify(@PathVariable(name="id",required=true)int id,ModelMap model) {
		
		BoardVO board= this.boardService.getBoard(id);
		model.addAttribute("board",board);
		
		return "pages/board/modify";
	}
	
	@PostMapping(value = "/modify")
	public String postModify(BoardVO board) {
		this.boardService.updateBoard(board);
		return "redirect:/board/detail/" + board.getId();
	}
	
	@GetMapping(value = "/write")
	public String write() {
		return "pages/board/write";
	}
	
	@PostMapping(value = "/write")
	public String postWrite(BoardVO board) {
		board.setRegId("wjdguswjdal");
		this.boardService.insertBoard(board);
		
		return "redirect:/board/list";
	}
	

	@GetMapping(value = "/delete/{id}")
	public String delete(
	      @PathVariable(name = "id", required = true) int id) {
		
		this.boardService.deleteBoard(id);
	   
	   return "redirect:/board/list";
	}
	
	
	
	
}
