package Educative.ChessGame.accounts;

import Educative.ChessGame.Person;

public class Player extends Account {
    private Person person;
    private boolean whiteSide = false;
    private int totalGamesPlayed;

    public Player(Person person, boolean whiteSide) {
        this.person = person;
        this.whiteSide = whiteSide;
    }

    public boolean isWhiteSide() {
        return whiteSide;
    }

    public boolean isChecked() {
        // Implement logic to check if player's king is in check
        return false;
    }

    public Person getPerson() {
        return person;
    }
    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }
}
