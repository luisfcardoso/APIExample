package com.luis.apiexample.repository;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class EntryFilter {

	private String description;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dueDateFrom;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dueDateTo;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getdueDateFrom() {
		return dueDateFrom;
	}

	public void setdueDateFrom(LocalDate dueDateFrom) {
		this.dueDateFrom = dueDateFrom;
	}

	public LocalDate getdueDateTo() {
		return dueDateTo;
	}

	public void setdueDateTo(LocalDate dueDateTo) {
		this.dueDateTo = dueDateTo;
	}

}