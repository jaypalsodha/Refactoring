package com.version7;

abstract class Price {
	abstract int getPriceCode();

	abstract double getCharge(int daysRented);

	int getRewardPoints(int daysRented) {
		return 1;
	}
}