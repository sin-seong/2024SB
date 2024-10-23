package com.sin.sb1011.dto;

import lombok.Data;

@Data
public class BoardDto {
	
	private long boardIdx;
	
	private String title;
	
	private String contents;
	
	private int hitCnt;
	
	private String creatorId;
	
	private String createdDatetime;
	
	private String updaterId;
	
	private String updatedDatetime;

	private String imagePath;
}
