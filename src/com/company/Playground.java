package com.company;

public class Playground {

	private static final String HORIZONTAL_AND_VERTICAL_LINE = "|---|---|---|";
	private String[] inputLines = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public void setInputLines(int index, String input) {
		this.inputLines[index] = input;
	}

	public void drawPlayGround() {
		System.out.println(HORIZONTAL_AND_VERTICAL_LINE);
		System.out.println("| " + inputLines[0] + " | " + inputLines[1] + " | " + inputLines[2] + " |");
		System.out.println(HORIZONTAL_AND_VERTICAL_LINE);
		System.out.println("| " + inputLines[3] + " | " + inputLines[4] + " | " + inputLines[5] + " |");
		System.out.println(HORIZONTAL_AND_VERTICAL_LINE);
		System.out.println("| " + inputLines[6] + " | " + inputLines[7] + " | " + inputLines[8] + " |");
		System.out.println(HORIZONTAL_AND_VERTICAL_LINE);

	}

	public void setInputLinesToStart() {
		int z = 1;
		for (int i = 0; i < 9; i++) {
			String toString = String.valueOf(z);
			inputLines[i] = toString;
			z++;
		}
	}
}
