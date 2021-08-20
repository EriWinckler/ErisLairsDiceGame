package com.company;

import java.util.ArrayList;


public class Player {
    private int remainingDices;

    public ArrayList<Integer> getDiceValue() {
        return diceValue;
    }

    private ArrayList<Integer> diceValue = new ArrayList<>();
    private boolean active = true;
    private String name = "";

    public static void handCheck(Player player) {
        System.out.println(player.diceValue + " is your roll");
    }

    public void setRemainingDices(int remainingDices) {
        this.remainingDices = remainingDices;
    }


    public void setDiceValue(ArrayList<Integer> diceValue) {
        this.diceValue = diceValue;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public int getRemainingDices() {
        return remainingDices;
    }

}
