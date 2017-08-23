/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.exception;

/**
 * @author Joe
 *
 */
abstract class AbstractException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = -4020625169423429750L;
	private String msgCode;
	private String msg;

	/**
	 * @param msgCode
	 * @param msg
	 */
	public AbstractException(final String msgCode, final String msg) {
		super();
		this.msgCode = msgCode;
		this.msg = msg;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(final String msgCode) {
		this.msgCode = msgCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(final String msg) {
		this.msg = msg;
	}



}
