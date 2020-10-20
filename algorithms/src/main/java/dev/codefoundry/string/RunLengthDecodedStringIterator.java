package dev.codefoundry.string;

public class RunLengthDecodedStringIterator {
	private String value;
	private int index;

	private int totalChars;
	private String character;

	public RunLengthDecodedStringIterator(String s) {
		this.value = s;
	}

	public String next() {
		if (!hasnext()) {
			return null;
		}

		return readString();
	}

	private String readString() {
		if (--this.totalChars == 0) {
			String r = this.character;
			this.character = null;
			return r;
		}

		return this.character;
	}

	private boolean hasString() {
		return this.character != null && this.totalChars > 0;
	}

	private boolean needToReadNextChar() {
		return this.character == null && this.index < this.value.length() - 1;
	}

	private void readNextChar() {
		StringBuilder digits = new StringBuilder();
		char digit;
		while (Character.isDigit(digit = this.value.charAt(this.index++))) {
			digits.append(digit);
		}

		if (digits.length() == 0) {
			this.character = String.valueOf(digit);
			this.totalChars = 1;
		} else {
			this.character = String.valueOf(digit);
			this.totalChars = Integer.parseInt(digits.toString());
		}
	}

	public boolean hasnext() {
		if (needToReadNextChar()) {
			readNextChar();
		}

		return hasString();
	}

	public static void main(String[] args) {
		RunLengthDecodedStringIterator itr = new RunLengthDecodedStringIterator("2a1b");
		System.out.println(itr.next());
		System.out.println(itr.hasnext());
		System.out.println(itr.next());
		System.out.println(itr.next());
		System.out.println(itr.hasnext());
	}
}
