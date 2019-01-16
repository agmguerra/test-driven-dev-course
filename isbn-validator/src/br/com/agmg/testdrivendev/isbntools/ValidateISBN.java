package br.com.agmg.testdrivendev.isbntools;

public class ValidateISBN {

	private static final int LONG_ISBN_MULTIPLIER = 10;
	private static final int SHORT_ISBN_MULTIPLIER = 11;
	private static final int LONG_ISBN_LENGTH = 13;
	private static final int SHORT_ISBN_LENGTH = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkISBN(String isbn) {
		
		if (isbn.length() == LONG_ISBN_LENGTH) {
			return isValidLongISBN(isbn);
		} else if (isbn.length() == SHORT_ISBN_LENGTH) {
			return isValidShotISBN(isbn);
		} 
		
		throw new NumberFormatException("ISBN deve possuir 10 ou 13 digitos");
		
		
		
	}
	
	private boolean isValidLongISBN(String isbn) {
		if (isbn.length() != LONG_ISBN_LENGTH) {
			throw new NumberFormatException("ISBN deve possuir 10 ou 13 digitos");
		}
		
		int total = 0;
		
		for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
			if (i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * 3;
			}
		}
		
		return (total % LONG_ISBN_MULTIPLIER) == 0;
			

	}

	private boolean isValidShotISBN(String isbn) {
		
		if (isbn.length() != SHORT_ISBN_LENGTH) {
			throw new NumberFormatException("ISBN deve possuir 10 ou 13 digitos");
		}
		
		int total = 0;
		
		for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
			if (!Character.isDigit(isbn.charAt(i))) {
				if (i == 9 && isbn.charAt(i) == 'X') {
					total += 10;
				} else {
					throw new NumberFormatException("ISBN deve possuir somente caracteres numéricos");					
				}
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
			}
		}
		
		return (total % SHORT_ISBN_MULTIPLIER) == 0;
	}
	

}
