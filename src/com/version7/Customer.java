package com.version7;

import java.util.ArrayList;
import java.util.Iterator;

class Customer {
	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	};

	public void addRental(Rental rental) {
		rentalList.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {

		Iterator<Rental> iterator = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (iterator.hasNext()) {
			Rental each = iterator.next();

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharges()) + "\n";

		}
		// add footer lines
		result += "Amount owed is " + getTotalCharges() + "\n";
		result += "You earned " + getTotalFrequentRewardPoints() + " frequent renter points";
		return result;
	}

	public double getTotalCharges() {
		double result = 0;
		Iterator<Rental> iterator = rentalList.iterator();

		while (iterator.hasNext()) {
			Rental each = iterator.next();
			result += each.getCharges();
		}
		return result;
	}

	public double getTotalFrequentRewardPoints() {
		double result = 0;
		Iterator<Rental> iterator = rentalList.iterator();

		while (iterator.hasNext()) {
			Rental each = iterator.next();
			result += each.getRewardPoints();
		}
		return result;
	}

	public String htmlStatement() {
		Iterator<Rental> iterator = rentalList.iterator();
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		while (iterator.hasNext()) {
			Rental each = (Rental) iterator.next();
			// show figures for each rental
			result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharges()) + "<BR>\n";
		}
		// add footer lines
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharges()) + "</EM><P>\n";
		result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRewardPoints())
				+ "</EM> frequent renter points<P>";
		return result;
	}
}