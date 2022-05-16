/**
 * 
 */
package com.khadrias.api.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author mkhadria
 *
 */
@Data
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
}