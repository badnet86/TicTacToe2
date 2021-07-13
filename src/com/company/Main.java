package com.company;

import java.util.Scanner;

public class Main {
	private int input;
	private static GameLogic logic;

	public static void main(String[] args) {

		logic = new GameLogic();
		logic.initialisePlayer();
		logic.drawPlayground();
		int i = 0;
		while (logic.gameKeepsRunning()) {
			logic.makeTurn(playerInput());
			logic.fillPlayground();
			logic.drawPlayground();
			i++;
		}

	}

	public static int playerInput() {

		Scanner scan = new Scanner(System.in);
		String currentPlayerName = logic.whoIsCurrentPlayer().getName();
		System.out.println("Spieler " + currentPlayerName + " wähle ein Feld:");
		return scan.nextInt();

	}

	public static String playerStringInput() {
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
}
