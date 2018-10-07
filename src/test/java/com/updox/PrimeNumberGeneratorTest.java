package com.updox;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.updox.prime.UpdoxPrimeNumberGenerator;

class PrimeNumberGeneratorTest {
	private UpdoxPrimeNumberGenerator primeNumberGenerator = new UpdoxPrimeNumberGenerator(); 
	
	@Test
	void IsPrimeBaseZeroTest() {
		assertEquals(false, primeNumberGenerator.isPrime(0));
	}
	
	@Test
	void IsPrimeBaseNegativeTest() {
		assertEquals(false, primeNumberGenerator.isPrime(-1));
		assertEquals(false, primeNumberGenerator.isPrime(-100));
	}
	
	@Test
	void IsPrimeBaseOneTest() {
		assertEquals(false, primeNumberGenerator.isPrime(1));
	}
	
	@Test
	void IsPrimeBaseTwoTest() {
		assertEquals(true, primeNumberGenerator.isPrime(2));
	}
	
	@Test
	void IsPrimeRange1Test() {
		HashSet<Integer> primeSet = new HashSet<>();
		Integer[] primeIntegerArray = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
		primeSet.addAll(Arrays.asList(primeIntegerArray));
		
		for (int primeIndex = 0; primeIndex <= 101; primeIndex++) {
			if (primeSet.contains(primeIndex)) {
				assertEquals(true, primeNumberGenerator.isPrime(primeIndex));
			} else {
				assertEquals(false, primeNumberGenerator.isPrime(primeIndex));
			}
		}
	}
	
	@Test
	void IsPrimeRange2Test() {
		HashSet<Integer> primeSet = new HashSet<>();
		Integer[] primeIntegerArray = { 7901, 7907, 7919 };
		for (int i = 0; i < primeIntegerArray.length; i++) {
			primeSet.add(primeIntegerArray[i]);
		}
		
		for (int primeIndex = 7900; primeIndex <= 7920; primeIndex++) {
			if (primeSet.contains(primeIndex)) {
				assertEquals(true, primeNumberGenerator.isPrime(primeIndex));
			} else {
				assertEquals(false, primeNumberGenerator.isPrime(primeIndex));
			}
		}
	}
	
	@Test
	void GenerateNegativePrimeRangeTest() {
		assertEquals(new ArrayList<Integer>(), primeNumberGenerator.generate(-100, 0));
		assertEquals(new ArrayList<Integer>(), primeNumberGenerator.generate(0, -100));
	}

	@Test
	void GenerateZeroPrimeRangeTest() {
		assertEquals(new ArrayList<Integer>(), primeNumberGenerator.generate(0, 0));
	}

	@Test
	void GenerateOnePrimeRangeTest() {
		assertEquals(new ArrayList<Integer>(), primeNumberGenerator.generate(0, 1));
	}
	
	@Test
	void GenerateTwoPrimeRangeTest() {
		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		resultArray.add(2);
		
		assertEquals(resultArray, primeNumberGenerator.generate(0, 2));
		assertEquals(resultArray, primeNumberGenerator.generate(2, 2));
	}
	
	@Test
	void GenerateFirstTwentySixPrimeRangeTest() {
		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		Integer[] primeIntegerArray = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
		resultArray.addAll(Arrays.asList(primeIntegerArray));
		
		assertEquals(resultArray, primeNumberGenerator.generate(0, 101));
		assertEquals(resultArray, primeNumberGenerator.generate(101, 0));
		assertEquals(resultArray, primeNumberGenerator.generate(2, 101));
		assertEquals(resultArray, primeNumberGenerator.generate(101, 2));
		assertEquals(resultArray, primeNumberGenerator.generate(1, 102));
		assertEquals(resultArray, primeNumberGenerator.generate(102, 1));
	}
}
