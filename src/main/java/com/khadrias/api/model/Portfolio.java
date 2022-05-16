/**
 * 
 */
package com.khadrias.api.model;

/**
 * @author mkhadria
 *
 */
public class Portfolio {

	private String name;

	private int code;

	public Portfolio(String name, int code) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
