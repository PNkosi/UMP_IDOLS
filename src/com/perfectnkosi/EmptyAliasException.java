package com.perfectnkosi;

/**
* @author Perfect NKosi__Codingd-dude
*/

public class EmptyAliasException extends Exception {

	private static final long serialVersionUID = -699265432525316028L;

	public EmptyAliasException() {
		super("Cannot process empty alias");
	}

	public EmptyAliasException(String message) {
		super(message);
	}
	
}

