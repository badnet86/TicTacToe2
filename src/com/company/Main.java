package com.company;

import java.util.Scanner;

public class Main {
	private int input;
	private static GameLogic logic;

	public static void main(String[] args) {
		// write your code here

		logic = new GameLogic();
		
		int i = 0;
		while (i<9) {
			logic.makeTurn();
			logic.TestOutput();
			i++;
		}
		
		logic.TestOutput();
		System.out.println("Das Spiel ist fertig.");

	}

	public static int playerInput() {

		Scanner scan = new Scanner(System.in);
		String currentPlayerName = logic.whoIsCurrentPlayer().getName();
		System.out.println("Spieler " + currentPlayerName + " wähle ein Feld:");
		return scan.nextInt();

	}

}
