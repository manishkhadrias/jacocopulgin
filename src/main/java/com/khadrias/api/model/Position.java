/**
 * 
 */
package com.khadrias.api.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author mkhadria
 *
 */
@Data
@AllArgsConstructor
public class Position {

	private LocalDate startDate;
	private LocalDate stopDate;
	private Integer fund;
	private String cusip;

}