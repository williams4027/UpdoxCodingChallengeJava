package com.updox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.updox.prime.UpdoxPrimeNumberGenerator;

/**
 * Base executable class used to kick off the data processing and generate prime
 * numbers.
 * 
 * @author Blake Williams
 */
public class UpdoxCodingChallengeMain {

	/**
	 * Executable command to collect a start and end value range from the user and
	 * generate an ordered list of all prime numbers in that range and log the results to the console.
	 * 
	 * @param args Will not be used
	 * @throws IOException If the input stream is broken
	 */
	public static void main(String[] args) {
		BufferedReader inputReader = null;
		
		System.out.println("Prime Number Generator Started. Please specify the start value of the range of numbers to test:");
		try {
			// Read input from the command line
			inputReader = new BufferedReader(new InputStreamReader(System.in));
			String startValueInput;
			startValueInput = inputReader.readLine();
			System.out.println("Please specify the end value of the range of numbers to test:");
			String endValueInput = inputReader.readLine();
			
			// Process input and produce list of prime numbers
			List<Integer> primeNumberList = performPrimeGeneration(startValueInput, endValueInput);
			System.out.println("Prime Numbers: " + primeNumberList);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Close the reader
			if (inputReader != null) {
				try {
					inputReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Prime Number Generator Completed. Have a nice day!");
	}
	
	/**
	 * Testable function to separate user input collection from prime number generation.
	 * 
	 * @param userStartValueInput String value of the prime range start integer
	 * @param userEndValueInput String value of the prime range end integer
	 * @return An ordered list of prime numbers found in the input range provided (inclusive)
	 */
	public static List<Integer> performPrimeGeneration(String userStartValueInput, String userEndValueInput) {
		int startValue = 0;
		int endValue = 0;
		try {
			startValue = Integer.parseInt(userStartValueInput);
			endValue = Integer.parseInt(userEndValueInput);
		} catch (NumberFormatException e) {
			System.err.println("User input values for prime number generation are not valid integers.");
		}
		
		UpdoxPrimeNumberGenerator primeNumberGenerator = new UpdoxPrimeNumberGenerator();
		return primeNumberGenerator.generate(startValue, endValue);
	}
}
