package com.khadrias.repos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.khadrias.api.model.Portfolio;

/**
 * @author mkhadria
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PortfolioRepositoryTest {

	@Autowired
	PortfolioRepository portfolioRepository;

	@Test
	public void findByNameTest() {
		Optional<Portfolio> optional = portfolioRepository.findByName("AC-001");
		if (optional.isPresent())
			assertEquals(1401, optional.get().getCode());
	}

	@Test
	public void findByNameBlankTest() {
		Optional<Portfolio> optional = portfolioRepository.findByName("AC-007");
		assertFalse(optional.isPresent());
	}
}
