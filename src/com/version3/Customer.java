package com.version3;

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
		double totalAmount = 0;
		int rewardPoints = 0;
		Iterator<Rental> iterator = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (iterator.hasNext()) {
			double thisAmount = 0;
			Rental each = iterator.next();

			thisAmount = amountFor(each);

			// add frequent renter points
			rewardPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				rewardPoints++;

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;

		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(rewardPoints) + " frequent renter points";
		return result;
	}

	private double amountFor(Rental aRental) {
		return aRental.getCharges();
	}
}