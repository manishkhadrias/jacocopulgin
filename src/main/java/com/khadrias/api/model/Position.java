/**
 * 
 */
package com.khadrias.api.model;

import java.time.LocalDate;

/**
 * @author mkhadria
 *
 */
public class Position {

	private LocalDate startDate;
	private LocalDate stopDate;
	private Integer fund;
	private String cusip;

	public Position(LocalDate startDate, LocalDate stopDate, Integer fund,
			String cusip) {
		super();
		this.startDate = startDate;
		this.stopDate = stopDate;
		this.fund = fund;
		this.cusip = cusip;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getStopDate() {
		return stopDate;
	}

	public void setStopDate(LocalDate stopDate) {
		this.stopDate = stopDate;
	}

	public Integer getFund() {
		return fund;
	}

	public void setFund(Integer fund) {
		this.fund = fund;
	}

	public String getCusip() {
		return cusip;
	}

	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	@Override
	public int hashCode() {
		return cusip.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return cusip.equals(other.getCusip());
	}

	@Override
	public String toString() {
		return "Position [startDate=" + startDate + ", stopDate=" + stopDate
				+ ", fund=" + fund + ", cusip=" + cusip + "]";
	}

}
