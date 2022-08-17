package com.perfectnkosi;

public class EmptyAliasException extends Exception {

	private static final long serialVersionUID = -699265432525316028L;

	public EmptyAliasException() {
		super("Cannot process empty alias");
	}

	public EmptyAliasException(String message) {
		super(message);
	}
	
}

