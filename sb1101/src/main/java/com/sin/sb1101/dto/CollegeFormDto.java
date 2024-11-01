package com.sin.sb1101.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
/**
 * 
 * @author
 *
 */
@Data
public class CollegeFormDto {
	@NotBlank
	private String name;
}
