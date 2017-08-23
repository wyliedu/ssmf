/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.common.enums;


/**
 * @author Kevin GUO
 * Sep 8, 2016
 */
public enum Gender  {
	
	M("Male"),
	F("Female");
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private Gender(String value) {
		this.value = value;
	}

}
