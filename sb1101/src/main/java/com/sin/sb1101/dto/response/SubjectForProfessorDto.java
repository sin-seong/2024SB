package com.sin.sb1101.dto.response;

import lombok.Data;

@Data
public class SubjectForProfessorDto {

	private Integer id;
	private String name;
	private String subDay;
	private Integer startTime;
	private Integer endTime;
	private String roomId;
	
}
