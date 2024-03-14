package com.student.exception;

public class MyException extends Exception {

	public MyException(String message) {
		super(message);
	}
/*when extedns Exception 
This is a checked exception and Spring will not
automatically rollback a transaction if this exception is
thrown in the transaction scope. */
}
