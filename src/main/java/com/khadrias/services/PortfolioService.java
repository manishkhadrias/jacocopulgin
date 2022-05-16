/**
 * 
 */
package com.khadrias.services;

import com.khadrias.api.request.PortfolioRequest;

/**
 * @author mkhadria
 *
 */
public interface PortfolioService {

	String findOpenPositionProtfolioOfPreviousDay(PortfolioRequest portfolioRequest);

}
