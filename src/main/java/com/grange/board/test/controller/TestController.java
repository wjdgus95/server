package com.grange.board.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@RequestMapping(value = "/test123")
	public String test123() {
		return "test123";
	}
	
}
