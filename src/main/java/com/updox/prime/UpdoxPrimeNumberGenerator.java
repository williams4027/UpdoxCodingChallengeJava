package com.updox.prime;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic prime number generation class.
 * 
 * @author Blake Williams
 */
public class UpdoxPrimeNumberGenerator implements PrimeNumberGenerator {

	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		ArrayList<Integer> primeNumberList = new ArrayList<>();
		
		// Ensure that the ranges go from min to max range values
		int rangeStart = Math.min(startingValue, endingValue);
		int rangeEnd = Math.max(startingValue, endingValue);
		
		// Iterate through each index between the start/end values and check for primeness
		for (int rangeIndex = rangeStart; rangeIndex <= rangeEnd; rangeIndex++) {
			boolean isIndexPrime = isPrime(rangeIndex);
			if (isIndexPrime) {
				primeNumberList.add(rangeIndex);
			}
		}
		
		return primeNumberList;
	}

	@Override
	public boolean isPrime(int value) {
		// Base case for negative numbers, 0 and 1 (none are prime)
		if (value <= 1) {
			return false;
		}
		// Base case for two (first prime) and all even numbers (all even numbers are not prime) for a quick optimization
		if (value == 2) {
			return true;
		} else if (value % 2 == 0) {
			return false;
		}
		
		// Iterate through all values from 3 to the square root of value to check if value is divisible (return true if divisible)
		// We can ignore numbers above the square root because they would have already been found in lower multiples
		boolean isPrime = true;
		for (int primeIndex = 3; primeIndex <= Math.sqrt(value); primeIndex++) {
			if (value % primeIndex == 0) {
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}
}
