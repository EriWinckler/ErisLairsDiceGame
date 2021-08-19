package com.company;

import java.util.ArrayList;


public class Player {
    public int remainingDices;
    public ArrayList<Integer> diceValue = new ArrayList<>();
    public boolean active = true;
    public String name = "";

    Dice dice = new Dice();

    public Player(String name, int numberOfDice) {
        this.name = name;
        this.remainingDices = numberOfDice;
    }

}
