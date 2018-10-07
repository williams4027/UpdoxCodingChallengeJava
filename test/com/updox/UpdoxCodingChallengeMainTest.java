/**
 * 
 */
package com.updox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	    		"Prime Number Generator Completed. Have a nice day!", testOutStream.toString());
	    assertEquals("", testErrStream.toString());
	}
}
