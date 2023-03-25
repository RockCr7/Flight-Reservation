package com.psa.flight_reservation.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class reservation extends AbstractClass{
	private boolean checkedIn;
	private int numberOfBags;
	//one to one mapping one passenger only one reservation
	
	@OneToOne
	private passenger psngr;
	
	@OneToOne
	private flight flight;
	
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	public passenger getPsngr() {
		return psngr;
	}
	public void setPsngr(passenger psngr) {
		this.psngr = psngr;
	}
	public flight getFlight() {
		return flight;
	}
	public void setFlight(flight flight) {
		this.flight = flight;
	}
	
}
