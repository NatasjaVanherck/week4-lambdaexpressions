package be.pxl.lambdaexpressions.opdracht2;

public class Cryptograaf {
	public static String encryptFirst(String tekst) {
		Bericht bericht = new Bericht(tekst);
		Encryptie encrypt = string -> new StringBuilder(string).reverse().toString();
		return bericht.encrypt(encrypt);
	}

	public static String encryptSimple(String tekst) {
		Bericht bericht = new Bericht(tekst);
		Encryptie encrypt = new Encryptie() {
			@Override
			public String apply(String s) {
				char[] array = s.toUpperCase().toCharArray();
				String lettersToNumbers = "";
				for (int i = 0; i < array.length; i++) {
					if (Character.isLetter(array[i])) {
						lettersToNumbers += Character.getNumericValue(array[i]);
					} else {
						lettersToNumbers += array[i];
					}
					
					if (!(i == array.length - 1)) {
						lettersToNumbers += "-";
					}
				}
				return lettersToNumbers;
			}
		};
		return bericht.encrypt(encrypt);
	}

	public static String encryptLambda(String tekst) {
		Bericht bericht = new Bericht(tekst);
		Encryptie encrypt = string -> {
			char[] array = string.toLowerCase().toCharArray();
			String lettersToNumbers = "";
			int shiftDistance = array.length;
			for (int i = 0; i < array.length; i++) {
				shiftDistance %= 26;			
				if ((array[i] >= 'a') && (array[i] <= 'z')) {
					array[i] += shiftDistance;
					if (array[i] > 'z') {
						// correct overflow
						array[i] = (char) ((array[i] - 'z' + 'a') - 1);
					} else if (array[i] < 'a') {
						// correct underflow
						array[i] = (char) (('z' + array[i]) - 'a' + 1);
					}
				}
				lettersToNumbers += array[i];
			}
			return lettersToNumbers;
		};
		return bericht.encrypt(encrypt);
	}
}
