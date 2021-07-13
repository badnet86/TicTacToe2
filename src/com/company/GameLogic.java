package com.company;

/**
 * Class to implement the Logic of the Game Tic Tac Toe. One Player is on turn
 * and has to draw his Symbol in a field. First player who gets 3 symbols of its
 * own in a row wins the game.
 */
public class GameLogic {

	private String[] fields = { "", "", "", "", "", "", "", "", "" };

	private int input = 0;

	Player player1 = new Player("Player1");
	Player player2 = new Player("Player2");

	public void initialisePlayer() {
		System.out.println("Gib den Namen für Player 1 ein: ");
		player1.setName(Main.playerStringInput());
		System.out.println("Gib den Namen für Player 2 ein: ");
		player2.setName(Main.playerStringInput());
	}

	public void makeTurn() {
		input = Main.playerInput();
		fieldIsOccupied(input);
		for (int i = 0; i < 9; i++) {
			if (input - 1 == i && fields[i].equals("")) {
				fields[i] = setXorO();
				setCurrentPlayer();
			}
		}
	}

	/**
	 * Method sets the current active Player.
	 *
	 * @return returns active Player which has to make his turn.
	 */
	public void setCurrentPlayer() {

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

	public Player whoIsCurrentPlayer() {
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
	public String setXorO() {
		String symbol = null;
		if (whoIsCurrentPlayer() == player1)
			symbol = "X";
		if (whoIsCurrentPlayer() == player2)
			symbol = "O";
		return symbol;
	}

	public void fieldIsOccupied(int input) {
		for (int i = 0; i < 9; i++) {
			if (input - 1 == i && !fields[i].equals("")) {
				System.out.println("Feld ist besetzt. Anderes Feld wählen.");
			}
		}
	}

	public boolean IsThereWinner() {
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
		}
		return winner;
	}

	public boolean draw() {
		boolean bool = false;

		if (!fields[0].equals("") && !fields[1].equals("") && !fields[2].equals("") && !fields[3].equals("")
				&& !fields[4].equals("") && !fields[5].equals("") && !fields[6].equals("") && !fields[7].equals("")
				&& !fields[8].equals("")) {
			bool = true;
			System.out.println("Es ist unentschieden.");
		}
		return bool;
	}

	public Player WhoIsWinner() {
		Player winner = null;
		if (player1.isHasWon())
			winner = player1;
		if (player2.isHasWon())
			winner = player2;
		return winner;
	}

	public void TestOutput() {
		System.out.println("Feld 1: " + fields[0] + " Feld 2: " + fields[1] + " Feld 3: " + fields[2]);
		System.out.println("Feld 4: " + fields[3] + " Feld 5: " + fields[4] + " Feld 6: " + fields[5]);
		System.out.println("Feld 7: " + fields[6] + " Feld 8: " + fields[7] + " Feld 9: " + fields[8]);
	}

}
