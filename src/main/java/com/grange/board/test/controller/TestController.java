package com.grange.board.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grange.board.test.service.TestService;



@RestController
@RequestMapping(value = "/grange")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value ="/index")
	public String index() {
		return testService.hellowWorld();
	}
	
	
	@RequestMapping(value = "/test123")
	public String test123() {
		return "test123";
	}
	
	@RequestMapping(value = "/param")
	public String paramFromHttpServletRequest(HttpServletRequest req) {
		
		String param1=req.getParameter("param1");
		String param2=req.getParameter("param2");
		
		System.out.println("param1 = "+param1);
		System.out.println("param2 = "+param2);
		return "200 ok";
	}
	
	
	@RequestMapping(value ="/param2")
	public String paramFromRequestParam(@RequestParam(name = "param1",required=true) String param1,@RequestParam(name = "param2",required=true) String param2) {

		System.out.println("param1 = "+param1);
		System.out.println("param2 = "+param2);
		
		return "200 ok";
	}
	
	@RequestMapping(value="/add")
	public int adder(@RequestParam(name="operand1") int operand1,@RequestParam(name="operand2")int operand2) {
		int result=0;
		
		return operand1+operand2;
	}
	
	
}
