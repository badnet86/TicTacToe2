package com.company;

public class Player {
    private String name;
    private boolean hasWon;
    private boolean isOnTurn;

    public Player(String name){
        this.name = name;
        hasWon = false;
        isOnTurn = false;
    }

    public boolean isOnTurn() {
        return isOnTurn;
    }

    public void setOnTurn(boolean onTurn) {
        isOnTurn = onTurn;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
