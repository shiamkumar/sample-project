package com.tech.clockintoword.service;

public class InvalidHoursCustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String code;
	String description;

	public InvalidHoursCustomException(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	@Override
	public String toString() {
		return "InvalidHoursCustomException [code=" + code + ", description=" + description + "]";
	}

}
