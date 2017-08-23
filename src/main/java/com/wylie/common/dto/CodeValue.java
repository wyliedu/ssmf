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
public class CodeValue<C, V> {
	private C code;
	private V value;
	
	/**
	 * @param code
	 * @param value
	 */
	public CodeValue(C code, V value) {
		super();
		this.code = code;
		this.value = value;
	}
	public CodeValue(){
		
	}
	public C getCode() {
		return code;
	}
	public void setCode(C code) {
		this.code = code;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}
