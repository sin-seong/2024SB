package com.sin.sb1101.dto;

import lombok.Data;

@Data
public class NoticePageFormDto {
	
	
	// 페이징 처리
	private Integer page;
	private String keyword;
	private String type;
}
