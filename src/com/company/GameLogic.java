package com.company;

import java.util.Scanner;

/**
 * Class to implement the Logic of the Game Tic Tac Toe. One Player is on turn
 * and has to draw his Symbol in a field. First player who gets 3 symbols of its
 * own in a row wins the game.
 */
public class GameLogic {

	private String[] fields = { "", "", "", "", "", "", "", "", "" };

	private Playground playground = new Playground();
	private int input = 0;
	Player player1 = new Player("Player1");
	Player player2 = new Player("Player2");

	public GameLogic() {
		initialisePlayer();
		drawPlayground();
	}

	public void makeTurn() {
		this.input = playerInput();
		fieldIsOccupied(input);
		for (int i = 0; i < 9; i++) {
			if (input - 1 == i && fields[i].equals("")) {
				fields[i] = setXorO();
				setCurrentPlayer();
				fillPlayground();
				drawPlayground();
			}
		}
	}

	public boolean gameKeepsRunning() {
		String input;
		boolean bool = true;
		if (IsThereWinner() || draw()) {
			if (WhoIsWinner() != null) {
				System.out.println(WhoIsWinner().getName() + " hat gewonnen.");
				System.out.println(player1.getName() + " hat " + player1.getWinningPoints() + " Siegpunkte.");
				System.out.println(player2.getName() + " hat " + player2.getWinningPoints() + " Siegpunkte.");
			}
			System.out.println("Möchten Sie neustarten");
			Scanner scan = new Scanner(System.in);
			input = scan.next();
			if (input.toLowerCase().equals("ja")) {
				resetFields();
				playground.setInputLinesToStart();
				playground.drawPlayGround();
				bool = true;
			} else {
				bool = false;
				endWinner();
			}
		}
		return bool;
	}

	private void fillPlayground() {

		for (int i = 0; i < 9; i++) {
			if (!fields[i].equals("")) {
				playground.setInputLines(i, fields[i]);
			}
		}
	}

	private void drawPlayground() {
		playground.drawPlayGround();
	}

	private void initialisePlayer() {
		System.out.println("Gib den Namen für Player 1 ein: ");
		player1.setName(playerStringInput());
		System.out.println("Gib den Namen für Player 2 ein: ");
		player2.setName(playerStringInput());
	}

	private String playerStringInput() {
		String input;
		Scanner scan = new Scanner(System.in);
		input = scan.next();
		return input;
	}

	private int playerInput() {
		int input = 0;
		Scanner scan = new Scanner(System.in);
		String currentPlayerName = whoIsCurrentPlayer().getName();
		System.out.println("Spieler " + currentPlayerName + " wähle ein Feld:");
		input = scan.nextInt();
		return input;
	}

	/**
	 * Method sets the current active Player.
	 *
	 * @return returns active Player which has to make his turn.
	 */
	private void setCurrentPlayer() {

		if (player1.isOnTurn() == false && player2.isOnTurn() == false) {
			player1.setOnTurn(true);
			player2.setOnTurn(false);
		}
		if (player1.isOnTurn() == false && player2.isOnTurn() == true) {
			player1.setOnTurn(true);
			player2.setOnTurn(false);
		} else {
			player1.setOnTurn(false);
			player2.setOnTurn(true);
		}

	}

	private Player whoIsCurrentPlayer() {
		Player currentPlayer = player1;
		if (player1.isOnTurn() == true)
			currentPlayer = player1;
		if (player2.isOnTurn() == true)
			currentPlayer = player2;
		return currentPlayer;
	}

	/**
	 * @return returns X or O. It depends on the Symbol of the active Player
	 */
	private String setXorO() {
		String symbol = null;
		if (whoIsCurrentPlayer() == player1)
			symbol = "X";
		if (whoIsCurrentPlayer() == player2)
			symbol = "O";
		return symbol;
	}

	private void fieldIsOccupied(int input) {
		for (int i = 0; i < 9; i++) {
			if (input - 1 == i && !fields[i].equals("")) {
				System.out.println("Feld ist besetzt. Anderes Feld wählen.");
			}
		}
	}

	private boolean IsThereWinner() {
		boolean winner = false;
		player1.setHasWon(false);
		player2.setHasWon(false);
		if ((fields[0].equals("X") && fields[1].equals("X") && fields[2].equals("X"))
				|| (fields[3].equals("X") && fields[4].equals("X") && fields[5].equals("X"))
				|| (fields[6].equals("X") && fields[7].equals("X") && fields[8].equals("X"))
				|| (fields[0].equals("X") && fields[3].equals("X") && fields[6].equals("X"))
				|| (fields[1].equals("X") && fields[4].equals("X") && fields[7].equals("X"))
				|| (fields[2].equals("X") && fields[5].equals("X") && fields[8].equals("X"))
				|| (fields[0].equals("X") && fields[4].equals("X") && fields[8].equals("X"))
				|| (fields[2].equals("X") && fields[4].equals("X") && fields[6].equals("X"))) {
			winner = true;
			player1.setHasWon(true);
			player1.setWinningPoints();
		}
		if ((fields[0].equals("O") && fields[1].equals("O") && fields[2].equals("O"))
				|| (fields[3].equals("O") && fields[4].equals("O") && fields[5].equals("O"))
				|| (fields[6].equals("O") && fields[7].equals("O") && fields[8].equals("O"))
				|| (fields[0].equals("O") && fields[3].equals("O") && fields[6].equals("O"))
				|| (fields[1].equals("O") && fields[4].equals("O") && fields[7].equals("O"))
				|| (fields[2].equals("O") && fields[5].equals("O") && fields[8].equals("O"))
				|| (fields[0].equals("O") && fields[4].equals("O") && fields[8].equals("O"))
				|| (fields[2].equals("O") && fields[4].equals("O") && fields[6].equals("O"))) {
			winner = true;
			player2.setHasWon(true);
			player2.setWinningPoints();
		}
		return winner;
	}

	private boolean draw() {
		boolean bool = false;

		if (!fields[0].equals("") && !fields[1].equals("") && !fields[2].equals("") && !fields[3].equals("")
				&& !fields[4].equals("") && !fields[5].equals("") && !fields[6].equals("") && !fields[7].equals("")
				&& !fields[8].equals("")) {
			bool = true;
			System.out.println("Es ist unentschieden.");
		}
		return bool;
	}

	private Player WhoIsWinner() {
		Player winner = null;
		if (player1.isHasWon()) {
			winner = player1;
		}
		if (player2.isHasWon()) {
			winner = player2;
		}

		return winner;
	}

	private void resetFields() {
		for (int i = 0; i < 9; i++) {
			fields[i] = "";
		}
	}

	private void endWinner() {
		if (player1.getWinningPoints() > player2.getWinningPoints()) {
			System.out.println(player1.getName() + " hat " + player1.getWinningPoints() + " Siegpunkte.");
			System.out.println(player2.getName() + " hat " + player2.getWinningPoints() + " Siegpunkte.");
			System.out.println(player1.getName() + " hat den Gesamtsieg errungen. Bravo!!!");
		}

		if (player2.getWinningPoints() > player1.getWinningPoints()) {
			System.out.println(player2.getName() + " hat " + player2.getWinningPoints() + " Siegpunkte.");
			System.out.println(player1.getName() + " hat " + player1.getWinningPoints() + " Siegpunkte.");
			System.out.println(player2.getName() + " hat den Gesamtsieg errungen. Bravo!!!");
		}

		if (player2.getWinningPoints() == player1.getWinningPoints()) {

			System.out.println("Es gibt keinen Gesamtsieger. Es ist unentschieden. Good game!!");
		}

	}

	public void TestOutput() {
		System.out.println("Feld 1: " + fields[0] + " Feld 2: " + fields[1] + " Feld 3: " + fields[2]);
		System.out.println("Feld 4: " + fields[3] + " Feld 5: " + fields[4] + " Feld 6: " + fields[5]);
		System.out.println("Feld 7: " + fields[6] + " Feld 8: " + fields[7] + " Feld 9: " + fields[8]);
	}

}
