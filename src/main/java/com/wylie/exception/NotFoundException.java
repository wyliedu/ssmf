package com.wylie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * This should be a reusable exception for all Not found exception.
 *
 * @author Joe
 *
 */
public class NotFoundException extends AbstractException {

	/**
	 * @param msgCode
	 * @param msg
	 */
	public NotFoundException(final String msgCode, final String msg) {
		super(msgCode, msg);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 5375667880388728853L;

}
