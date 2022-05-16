/**
 * 
 */
package com.khadrias.repos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.khadrias.api.model.Position;

/**
 * @author mkhadria
 *
 */
@Repository
public class PositionRepository {

	private static final List<Position> POSITIONS = new ArrayList<>();

	static {

		POSITIONS.add(new Position(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31), 1401, "31298WTP0"));
		POSITIONS.add(new Position(LocalDate.of(2022, 2, 1), LocalDate.of(2022, 11, 30), 1401, "31298WTP1"));
		POSITIONS.add(new Position(LocalDate.of(2022, 3, 1), LocalDate.of(2022, 3, 31), 1401, "31298WTP2"));
		POSITIONS.add(new Position(LocalDate.of(2022, 4, 1), LocalDate.of(2022, 4, 30), 1402, "31298WTP3"));
		POSITIONS.add(new Position(LocalDate.of(2022, 5, 1), LocalDate.of(2022, 5, 31), 1402, "31298WTP4"));
		POSITIONS.add(new Position(LocalDate.of(2022, 6, 1), LocalDate.of(2022, 6, 30), 1405, "31298WTP5"));
		POSITIONS.add(new Position(LocalDate.of(2022, 7, 1), LocalDate.of(2022, 7, 31), 1405, "31298WTP6"));
		POSITIONS.add(new Position(LocalDate.of(2022, 8, 1), LocalDate.of(2022, 8, 31), 1405, "31298WTP7"));
		POSITIONS.add(new Position(LocalDate.of(2022, 9, 1), LocalDate.of(2022, 12, 31), 1405, "31298WTP8"));
		POSITIONS.add(new Position(LocalDate.of(2022, 10, 1), LocalDate.of(2022, 12, 31), 1404, "31298WTP9"));
	}

	public String findOpenPositionCusipsByDateAndFund(LocalDate localDate, int fund) {

		return POSITIONS.stream().filter(pos -> pos.getFund() == fund)
				.filter(pos -> localDate.compareTo(pos.getStartDate()) >= 0)
				.filter(pos -> localDate.compareTo(pos.getStopDate()) <= 0).map(Position::getCusip).distinct()
				.collect(Collectors.joining(" , "));

	}
}
