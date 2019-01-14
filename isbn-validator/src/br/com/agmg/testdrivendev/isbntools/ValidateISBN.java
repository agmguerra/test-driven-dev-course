package br.com.agmg.testdrivendev.isbntools;

public class ValidateISBN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkISBN(String isbn) {
		
		if (isbn.length() == 13) {
			return valid13DigitsISBN(isbn);
		} else if (isbn.length() == 10) {
			return valid10DigitsISBN(isbn);
		} else {
			throw new NumberFormatException("ISBN deve possuir 10 ou 13 digitos");
		}
		
		
	}
	
	private boolean valid13DigitsISBN(String isbn) {
		if (isbn.length() != 13) {
			throw new NumberFormatException("ISBN deve possuir 10 ou 13 digitos");
		}
		
		int total = 0;
		
		for (int i = 0; i < 13; i++) {
			if (i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * 3;
			}
		}
		
		if ((total % 10) == 0) {
			return true;
		}
		return false;

	}

	private boolean valid10DigitsISBN(String isbn) {
		
		if (isbn.length() != 10) {
			throw new NumberFormatException("ISBN deve possuir 10 ou 13 digitos");
		}
		
		int total = 0;
		
		for (int i = 0; i < 10; i++) {
			if (!Character.isDigit(isbn.charAt(i))) {
				if (i == 9 && isbn.charAt(i) == 'X') {
					total += 10;
				} else {
					throw new NumberFormatException("ISBN deve possuir somente caracteres numéricos");					
				}
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
			}
		}
		
		if ((total % 11) == 0) {
			return true;
		}
		return false;
	}
	

}
