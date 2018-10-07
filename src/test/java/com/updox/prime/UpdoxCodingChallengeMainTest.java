package com.updox.prime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.updox.UpdoxCodingChallengeMain;

/**
 * @author Blake Williams
 */
class UpdoxCodingChallengeMainTest {
	private final ByteArrayOutputStream testOutStream = new ByteArrayOutputStream();
	private final ByteArrayOutputStream testErrStream = new ByteArrayOutputStream();
	private ByteArrayInputStream testInStream;
	
	private final PrintStream originalSysOut = System.out;
	private final PrintStream originalSysErr = System.err;
	private final InputStream originalSystemIn = System.in;
	
	@BeforeEach
	public void setUpStreams() {
	    System.setOut(new PrintStream(testOutStream));
	    System.setErr(new PrintStream(testErrStream));
	}
	
	private void provideUserInput(String userInputString) {
		testInStream = new ByteArrayInputStream(userInputString.getBytes());
        System.setIn(testInStream);
    }

	@AfterEach
	public void restoreStreams() {
	    System.setOut(originalSysOut);
	    System.setErr(originalSysErr);
	    System.setIn(originalSystemIn);
	}
	
	@Test
	public void testMain() {
		provideUserInput("0\n20\n");
		String[] args = new String[] {};
		UpdoxCodingChallengeMain.main(args);
	    assertEquals("Prime Number Generator Started. Please specify the start value of the range of numbers to test:\n" + 
	    		"Please specify the end value of the range of numbers to test:\n" + 
	    		"Prime Numbers: [2, 3, 5, 7, 11, 13, 17, 19]\n" +
	    		"Prime Number Generator Completed. Have a nice day!\n",
	    		testOutStream.toString());
	    assertEquals("", testErrStream.toString());
	}
	
	@Test
	public void testMainInvalidInput() {
		provideUserInput("Test\nString\n");
		String[] args = new String[] {};
		UpdoxCodingChallengeMain.main(args);
	    assertEquals("Prime Number Generator Started. Please specify the start value of the range of numbers to test:\n" + 
	    		"Please specify the end value of the range of numbers to test:\n" + 
	    		"Prime Numbers: []\n" +
	    		"Prime Number Generator Completed. Have a nice day!\n",
	    		testOutStream.toString());
	    assertEquals("User input values for prime number generation are not valid integers.\n", testErrStream.toString());
	}
	
	@Test
	public void testPerformPrimeGeneration() {
		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		Integer[] primeIntegerArray = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
		resultArray.addAll(Arrays.asList(primeIntegerArray));
		
		List<Integer> primeList = UpdoxCodingChallengeMain.performPrimeGeneration("2", "50");
	    assertEquals(resultArray, primeList);
	    
	    List<Integer> primeListReverseInput = UpdoxCodingChallengeMain.performPrimeGeneration("50", "2");
	    assertEquals(resultArray, primeListReverseInput);
	}
}
