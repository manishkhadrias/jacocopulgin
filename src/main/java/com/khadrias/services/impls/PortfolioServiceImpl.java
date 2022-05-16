/**
 * 
 */
package com.khadrias.services.impls;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadrias.api.model.Portfolio;
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
	public String findOpenPositionProtfolioOfPreviousDay(PortfolioRequest portfolioRequest) {
		StringBuilder builder = new StringBuilder();
		for (String name : portfolioRequest.getNames()) {
			Optional<Portfolio> optionalPortfolio = portfolioRepository.findByName(name);
			if (optionalPortfolio.isPresent()) {
				String cusips = positionRepository.findOpenPositionCusipsByDateAndFund(LocalDate
						.of(portfolioRequest.getYear(), portfolioRequest.getMonth(), portfolioRequest.getDay()),
						optionalPortfolio.get().getCode());

				if (!cusips.isEmpty()) {
					builder.append(name + " : ");
					builder.append(cusips);
					builder.append(" | ");
				}
			}

		}

		if (builder.length() > 0) {
			return builder.substring(0, builder.length() - 2);
		} else {
			return "";
		}

	}

}
