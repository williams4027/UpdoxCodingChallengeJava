package com.updox.prime;

import java.util.List;

/**
 * Basic interface for a prime number generation class that can verify an integer is prime 
 * and create an ordered list of integers based on a given input range.
 * 
 * @author Blake Williams
 */
public interface PrimeNumberGenerator {
	
	/**
	 * generate will take a start and end value and test each whole number in the range,
	 * returning a list of all valid prime numbers found. 
	 * 
	 * @param startingValue Start range positive integer
	 * @param endingValue End range positive integer
	 * @return An ordered list of prime numbers in the given range, including endpoints
	 */
	List<Integer> generate(int startingValue, int endingValue);
	
	/**
	 * isPrime will take an input value and calculate whether that integer is a prime number or not.
	 * The definition of prime number is one that can only be made by multiplying 1 and itself. 
	 * 
	 * @param value Integer value that will be tested for prime
	 * @return Boolean of true if the input number is prime, otherwise false
	 */
	boolean isPrime(int value);
}
