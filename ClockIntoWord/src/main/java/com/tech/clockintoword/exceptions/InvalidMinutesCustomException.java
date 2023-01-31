package com.tech.clockintoword.exceptions;

public class InvalidMinutesCustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String code;
	String description;

	public InvalidMinutesCustomException(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	@Override
	public String toString() {
		return "InvalidMinutesCustomException [code=" + code + ", description=" + description + "]";
	}

}
