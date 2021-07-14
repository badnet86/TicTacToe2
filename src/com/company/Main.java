package com.company;

import java.util.Scanner;

public class Main {
	private int input;
	private static GameLogic logic;

	public static void main(String[] args) {

		logic = new GameLogic();

		while (logic.gameKeepsRunning()) {
			logic.makeTurn();

		}
	}
}
