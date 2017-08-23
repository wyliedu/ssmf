/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.common.dto;

/**
 * @author Kevin GUO
 * Aug 30, 2016
 */
public class IdData {

	/**
	 * Id
	 */
	private Long id;
	
	/**
	 * 
	 * @param id
	 */
	public IdData(Long id){
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
