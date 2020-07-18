package com.cg.bookStore.exceptions;

public class RecordAlreadyPresentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RecordAlreadyPresentException(String str){
		super(str);
	}

}
