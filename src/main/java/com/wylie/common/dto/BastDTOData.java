/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.common.dto;

/**
 * @author Joe
 *
 */
public class BastDTOData {
	private String msg;
	private String msgCode;
	private boolean success = true;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
