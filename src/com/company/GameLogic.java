package com.company;

/**
 * Class to implement the Logic of the Game Tic Tac Toe. One Player is on turn and has to draw his Symbol in a field.
 * First player who gets 3 symbols of its own in a row has won the game.
 */
public class GameLogic {

    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String field6;
    private String field7;
    private String field8;
    private String field9;

    Player player1 = new Player("Sascha");
    Player player2 = new Player ("Steven");


    /**
     * Method evaluates the current active Player.
     * @return returns active Player which has to make his turn.
     */
    public Player setCurrentPlayer(){
//ToDo: Add If Else to evaluate which was the last player and then set active player.
    player1.setOnTurn(true);
    player2.setOnTurn(false);

    return player1;
}

    /**
     *
     * @param currentPlayer
     * @return returns the selected field of the active Player
     */
    public int playerInput(Player currentPlayer){
        //ToDo: use Scanner input from active Player and return it as int
        return 0;
    }

    /**
     *
     * @return returns X or O. It depends on the Symbol of the active Player
     */
    public String setXorO(){
        //ToDo: Evaluate which is the active Player and return its Symbol X or O
        return "X";
    }
    public void makeTurn(){

        if (playerInput() == 1 && field1.isEmpty()){
          field1 = setXorO();
        }
        if (playerInput() == 2 && field2.isEmpty()){
            field2 = setXorO();
        }
        if (playerInput() == 3 && field3.isEmpty()){
            field3 = setXorO();
        }
        if (playerInput() == 4 && field4.isEmpty()){
            field4 = setXorO();
        }
        if (playerInput() == 5 && field5.isEmpty()){
            field5 = setXorO();
        }
        if (playerInput() == 6 && field6.isEmpty()){
            field6 = setXorO();
        }
        if (playerInput() == 7 && field7.isEmpty()){
            field7 = setXorO();
        }
        if (playerInput() == 8 && field8.isEmpty()){
            field8 = setXorO();
        }
        if (playerInput() == 9 && field9.isEmpty()){
            field9 = setXorO();
        }

        setCurrentPlayer();



    }
}
