package io.jc.sos.errorHandler;

public class SalesOrderNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SalesOrderNotFoundException(String exception) {
		super(exception);
	}

	public SalesOrderNotFoundException() {
		// TODO Auto-generated constructor stub
		super();
	}
}
