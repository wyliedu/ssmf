/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.common.dto;

/**
 * @author Kevin GUO
 * Oct 14, 2016
 */
public class IdResponse<T> {

	private T id;
	
	public IdResponse(T id){
		this.id = id;
	}
	
	public IdResponse(){
	}

	/**
	 * @return the id
	 */
	public T getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(T id) {
		this.id = id;
	}
	
}
