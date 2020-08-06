package com.grange.board.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grange.board.test.dao.TestDao;

@Service
public class TestService {
	//@Autowired
	private TestDao testDao;
	
	public String hellowWorld() {
		return "Hello World";
	}
}
