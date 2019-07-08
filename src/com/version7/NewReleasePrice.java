package com.version7;

class NewReleasePrice extends Price {
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	double getCharge(int daysRented) {
		return daysRented * 3;
	}

	int getRewardPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}
}