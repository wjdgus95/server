package com.grange.board.user.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grange.board.board.vo.BoardVO;
import com.grange.board.user.dao.UserDao;
import com.grange.board.user.vo.UserVO;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public UserVO getUser(String id, String pw) {
		pw=DigestUtils.sha256Hex(pw);
		return this.userDao.getUser(id, pw);
	}
	
	public int insertUser(UserVO user) {
		String pw=DigestUtils.sha256Hex(user.getPw());
		user.setPw(pw);
		return this.userDao.insertUser(user);
	}
}
