package com.khadrias.repos;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mkhadria
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionRepositoryTest {

	@Autowired
	PositionRepository positionRepository;

	@Test
	public void findOpenPositionCusipsByDateAndFundTest() {
		assertEquals("31298WTP0 , 31298WTP1",
				positionRepository.findOpenPositionCusipsByDateAndFund(
						LocalDate.of(2022, 5, 13), 1401));
	}

	@Test
	public void findOpenPositionCusipsByDateAndFundBlankTest() {
		assertEquals("",
				positionRepository.findOpenPositionCusipsByDateAndFund(
						LocalDate.of(2020, 5, 13), 1401));
	}

}
