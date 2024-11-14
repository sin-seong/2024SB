package com.sin.sb1030.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
@Setter
@Getter
@ToString
@AllArgsConstructor
@Data
public class ListCommand {
	
//	@DateTimeFormat(pattern = "yyyyMMddHH")
//	private LocalDateTime from;
//	@DateTimeFormat(pattern = "yyyyMMddHH")
//	private LocalDateTime to;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate from;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate to;

	public ListCommand() {}
}
