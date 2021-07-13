package com.company;

/**
 * Class to implement the Logic of the Game Tic Tac Toe. One Player is on turn
 * and has to draw his Symbol in a field. First player who gets 3 symbols of its
 * own in a row wins the game.
 */
public class GameLogic {
//	private String field1 = "";
//	private String field2 = "";
//	private String field3 = "";
//	private String field4 = "";
//	private String field5 = "";
//	private String field6 = "";
//	private String field7 = "";
//	private String field8 = "";
//	private String field9 = "";

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
			if (input-1 == i && fields[i].equals("")) {
				fields[i] = setXorO();
				setCurrentPlayer();
			}

		}
		if (IsThereWinner())
			System.out.println("Gewinner ist: " + WhoIsWinner());
	}

//		for(int i = 1; i < 10; i++)
//		{field = "field" + i;
//		System.out.println(field);
//			if (input == i && field1.equals(""))
//			{System.out.println("Treffer");
//				field = setXorO();
//			setCurrentPlayer();}
//	}
//		if (input == 1 && field1.equals("")) {
//			field1 = setXorO();
//			setCurrentPlayer();
//		}
//		if (input == 2 && field2.equals("")) {
//			field2 = setXorO();
//			setCurrentPlayer();
//		}
//		if (input == 3 && field3.equals("")) {
//			field3 = setXorO();
//			setCurrentPlayer();
//		}
//		if (input == 4 && field4.equals("")) {
//			field4 = setXorO();
//			setCurrentPlayer();
//		}
//		if (input == 5 && field5.equals("")) {
//			field5 = setXorO();
//			setCurrentPlayer();
//		}
//		if (input == 6 && field6.equals("")) {
//			field6 = setXorO();
//			setCurrentPlayer();
//		}
//		if (input == 7 && field7.equals("")) {
//			field7 = setXorO();
//			setCurrentPlayer();
//		}
//		if (input == 8 && field8.equals("")) {
//			field8 = setXorO();
//			setCurrentPlayer();
//		}
//		if (input == 9 && field9.equals("")) {
//			field9 = setXorO();
//			setCurrentPlayer();

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

	public boolean fieldIsOccupied(int input) {
		boolean b = false;

		for (int i = 0; i < 9; i++) {
			if (input-1 == i && !fields[i].equals("")) {
				System.out.println("Feld ist besetzt. Anderes Feld wählen.");
				b = true;
			}
		}
		return b;
	}

//		if (input == 1 && !field1.equals("")) {
//			System.out.println("Feld ist besetzt. Anderes Feld wählen.");
//			b = true;
//		}
//		if (input == 2 && !field2.equals("")) {
//			System.out.println("Feld ist besetzt. Anderes Feld wählen.");
//			b = true;
//		}
//		if (input == 3 && !field3.equals("")) {
//			System.out.println("Feld ist besetzt. Anderes Feld wählen.");
//			b = true;
//		}
//		if (input == 4 && !field4.equals("")) {
//			System.out.println("Feld ist besetzt. Anderes Feld wählen.");
//			b = true;
//		}
//		if (input == 5 && !field5.equals("")) {
//			System.out.println("Feld ist besetzt. Anderes Feld wählen.");
//			b = true;
//		}
//		if (input == 6 && !field6.equals("")) {
//			System.out.println("Feld ist besetzt. Anderes Feld wählen.");
//			b = true;
//		}
//		if (input == 7 && !field7.equals("")) {
//			System.out.println("Feld ist besetzt. Anderes Feld wählen.");
//			b = true;
//		}
//		if (input == 8 && !field8.equals("")) {
//			System.out.println("Feld ist besetzt. Anderes Feld wählen.");
//			b = true;
//		}
//		if (input == 9 && !field9.equals("")) {
//			System.out.println("Feld ist besetzt. Anderes Feld wählen.");
//			b = true;
//		}
//		return b;

	public boolean IsThereWinner() {
		boolean winner = false;
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

	public String WhoIsWinner() {
		Player winner = null;
		if (player1.isHasWon())
			winner = player1;
		if (player2.isHasWon())
			winner = player2;
		return winner.getName();
	}

	public void TestOutput() {
		System.out.println("Feld 1: " + fields[0] + " Feld 2: " + fields[1] + " Feld 3: " + fields[2]);
		System.out.println("Feld 4: " + fields[3] + " Feld 5: " + fields[4] + " Feld 6: " + fields[5]);
		System.out.println("Feld 7: " + fields[6] + " Feld 8: " + fields[7] + " Feld 9: " + fields[8]);
	}

}
