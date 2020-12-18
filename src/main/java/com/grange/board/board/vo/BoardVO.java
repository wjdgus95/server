package com.grange.board.board.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//식판
public class BoardVO {
	
	private int id;
	private String title;
	private String content;
	private Date regDtt;
	private String regId;
	
}
