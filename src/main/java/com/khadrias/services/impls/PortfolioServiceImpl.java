/**
 * 
 */
package com.khadrias.services.impls;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadrias.api.request.PortfolioRequest;
import com.khadrias.repos.PortfolioRepository;
import com.khadrias.repos.PositionRepository;
import com.khadrias.services.PortfolioService;

/**
 * @author mkhadria
 *
 */
@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	PortfolioRepository portfolioRepository;

	@Autowired
	PositionRepository positionRepository;

	@Override
	public String findOpenPositionProtfolioOfPreviousDay(
			@Valid PortfolioRequest portfolioRequest) {
		StringBuilder builder = new StringBuilder();
		for (String name : portfolioRequest.getNames()) {
			String cusips = positionRepository
					.findOpenPositionCusipsByDateAndFund(LocalDate.of(
							portfolioRequest.getYear(),
							portfolioRequest.getMonth(),
							portfolioRequest.getDay()), portfolioRepository
							.findByName(name).getCode());
			if (!cusips.isEmpty()) {
				builder.append(name + " : ");
				builder.append(cusips);
				builder.append(" | ");
			}
		}

		return builder.substring(0, builder.length() - 2);
	}

}
