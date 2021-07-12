package com.company;

/**
 * Class to implement the Logic of the Game Tic Tac Toe. One Player is on turn
 * and has to draw his Symbol in a field. First player who gets 3 symbols of its
 * own in a row wins the game.
 */
public class GameLogic {

	private String field1 = "";
	private String field2 = "";
	private String field3 = "";
	private String field4 = "";
	private String field5 = "";
	private String field6 = "";
	private String field7 = "";
	private String field8 = "";
	private String field9 = "";

	Player player1 = new Player("Sascha");
	Player player2 = new Player("Steven");

	/**
	 * Method sets the current active Player.
	 * 
	 * @return returns active Player which has to make his turn.
	 */
	public void setCurrentPlayer() {
//ToDo: Add If Else to evaluate which was the last player and then set active player.
		if (player1.isOnTurn() == false && player2.isOnTurn() == false) {
			player1.setOnTurn(true);
			player2.setOnTurn(false);
		}
		if (player1.isOnTurn() == false && player2.isOnTurn() == true) {
			player1.setOnTurn(true);
			player2.setOnTurn(false);
		}
		else
		 {
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
	 *
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

	public void makeTurn() {

		int input = Main.playerInput();

		if (input == 1 && field1.equals("")) {
			field1 = setXorO();
		}
		if (input == 2 && field2.equals("")) {
			field2 = setXorO();
		}
		if (input == 3 && field3.equals("")) {
			field3 = setXorO();
		}
		if (input == 4 && field4.equals("")) {
			field4 = setXorO();
		}
		if (input == 5 && field5.equals("")) {
			field5 = setXorO();
		}
		if (input == 6 && field6.equals("")) {
			field6 = setXorO();
		}
		if (input == 7 && field7.equals("")) {
			field7 = setXorO();
		}
		if (input == 8 && field8.equals("")) {
			field8 = setXorO();
		}
		if (input == 9 && field9.equals("")) {
			field9 = setXorO();
		}

		setCurrentPlayer();

	}

	public void TestOutput() {
		System.out.println("Feld 1: " + field1 + " Feld 2: " + field2 + " Feld 3: " + field3);
		System.out.println("Feld 4: " + field4 + " Feld 5: " + field5 + " Feld 6: " + field6);
		System.out.println("Feld 7: " + field7 + " Feld 8: " + field8 + " Feld 9: " + field9);

		System.out.println(whoIsCurrentPlayer().getName());
	}
}
