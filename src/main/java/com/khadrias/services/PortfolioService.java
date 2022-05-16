/**
 * 
 */
package com.khadrias.services;

import javax.validation.Valid;

import com.khadrias.api.request.PortfolioRequest;

/**
 * @author mkhadria
 *
 */
public interface PortfolioService {

	String findOpenPositionProtfolioOfPreviousDay(
			@Valid PortfolioRequest portfolioRequest);

}
