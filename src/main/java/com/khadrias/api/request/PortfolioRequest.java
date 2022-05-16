/**
 * 
 */
package com.khadrias.api.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author mkhadria
 *
 */
public class PortfolioRequest {
	@NotNull(message = "Portfolio name cannot be null")
	private List<String> names = new ArrayList<>();

	@Max(value = 2100, message = "Year cannot be greater than 2100")
	@Min(value = 2000, message = "Year cannot be less than 2000")
	private int year;

	@Max(value = 12, message = "Month cannot be greater than 12")
	@Min(value = 1, message = "Month cannot be less than 1")
	private int month;

	@Max(value = 31, message = "Day cannot be greater than 31")
	@Min(value = 1, message = "Day cannot be less than 1")
	private int day;

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
