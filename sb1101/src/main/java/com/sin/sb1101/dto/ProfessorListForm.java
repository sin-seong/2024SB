package com.sin.sb1101.dto;

import lombok.Data;

/**
 * 교수 리스트 보기 폼
 * @author
 */
@Data
public class ProfessorListForm {

	private Integer deptId;
	private Integer professorId;
	private Integer page;
	
}
