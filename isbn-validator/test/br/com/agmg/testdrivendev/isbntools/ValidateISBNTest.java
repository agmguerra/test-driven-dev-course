package br.com.agmg.testdrivendev.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateISBNTest {

	@Test
	public void checkValid10DigitsISBN() {
		ValidateISBN validate = new ValidateISBN();
		boolean result = validate.checkISBN("8577990907");
		assertTrue("first value",result);
		
		result = validate.checkISBN("8501403784");
		assertTrue("13 isbn second value",result);	
	}
	
	@Test
	public void checkValid13DigitsISBN() {
		ValidateISBN validate = new ValidateISBN();
		boolean result = validate.checkISBN("9788511000559");
		assertTrue("13 isbn first value",result);
		
		result = validate.checkISBN("9788532652751");
		assertTrue("second value",result);	

	}
	
	@Test
	public void ISBNNumbersEndingInAnXAreValid() {
		ValidateISBN validate = new ValidateISBN();
		boolean result = validate.checkISBN("012000030X");
		assertTrue("X no décimo caracter",result);

	}
	
	@Test
	public void checkInvalid10DigitsISBN() {
		ValidateISBN validate = new ValidateISBN();
		boolean result = validate.checkISBN("8577990906");
		assertFalse(result);
	}
	
	@Test
	public void checkInvalid13DigitsISBN() {
		ValidateISBN validate = new ValidateISBN();
		boolean result = validate.checkISBN("9788532652759");
		assertFalse(result);
	}

	
	@Test(expected = NumberFormatException.class)
	public void nineDigitsISBNAreNotAllowed() {
		ValidateISBN validate = new ValidateISBN();
		validate.checkISBN("577990906");
	}
	
	@Test(expected = NumberFormatException.class)
	public void nonNumericISBNAreNotAllowed() {
		ValidateISBN validate = new ValidateISBN();
		validate.checkISBN("helloworld");

	}


}
