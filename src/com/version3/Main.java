package com.version3;

/*  WHAT IS REFACTORING?
Refactoring is the process of changing a software system in such a way that 
it does not alter the external behavior of the code yet improves its internal structure. 

It is a disciplined way to clean up code that minimizes the chances of introducing bugs. 

In essence when you refactor you are improving the design of the code after it has been written.
 */

// To understand the refactoring lets take and simple example

/*It is a program to calculate and print a statement of a customer’s charges at a video store. 
 * 
 * The program is told which movies a customer rented and for how long. 
 * 
 * It then calculates the charges, which depend on how long the movie is rented, 
 * and identifies the type movie. 
 * 
 * There are three kinds of movies: regular, children’s, and new releases. 
 * 
 * In addition to calculating charges, the statement also computes 
 * frequent reward points, which vary depending on whether the film is a new release.
*/

public class Main {

	public static void main(String[] args) {
		Customer customer1 = new Customer("Jaypal Sodha");
		Movie movie = new Movie("Kabir Singh", 0);
		Rental rental = new Rental(movie, 3);
		customer1.addRental(rental);
		System.out.println(customer1.statement());
	}
}
