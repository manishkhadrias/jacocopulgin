/**
 * 
 */
package com.khadrias.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.khadrias.api.model.Portfolio;

/**
 * @author mkhadria
 *
 */
@Repository
public class PortfolioRepository {

	private static final List<Portfolio> PORTFOLIOS = new ArrayList<>();

	static {

		PORTFOLIOS.add(new Portfolio("AC-001", 1401));
		PORTFOLIOS.add(new Portfolio("AC-002", 1402));
		PORTFOLIOS.add(new Portfolio("AC-003", 1403));
		PORTFOLIOS.add(new Portfolio("AC-004", 1404));
		PORTFOLIOS.add(new Portfolio("AC-005", 1405));
		PORTFOLIOS.add(new Portfolio("AC-006", 1406));
	}

	public Optional<Portfolio> findByName(String name) {
		return PORTFOLIOS.stream().filter(p -> p.getName().equals(name)).findAny();
	}

}
