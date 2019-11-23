package io.jc.sos.errorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SalesOrderExceptionHandler {
	@ExceptionHandler(value = { SalesOrderNotFoundException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse itemNotFound(Exception ex) {
		return new ErrorResponse(404, "SalesOrder Not found, " + ex.getMessage());
	}

	@ExceptionHandler(value = { SalesOrderException.class,Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse itemError(Exception ex) {
		return new ErrorResponse(500, "Unable to fulfil the request due to " + ex);
	}

	
}