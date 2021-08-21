package com.company;

import java.util.ArrayList;


public class Player {
    private int remainingDices;
    private String name = "";
    private ArrayList<Integer> diceValue = new ArrayList<>();
    private boolean playerActive = true;
    private ArrayList<String> remainingPlayerName = new ArrayList<>();
    private int totalDices;

    public int getTotalDices() {
        return totalDices;
    }

    public void setTotalDices(int totalDices) {
        this.totalDices = totalDices;
    }

    public ArrayList<Integer> getDiceValue() {
        return diceValue;
    }

    public boolean isPlayerActive() {
        return playerActive;
    }

    public ArrayList<String> getRemainingPlayerName() {
        return remainingPlayerName;
    }

    public void setRemainingPlayerName(ArrayList<String> remainingPlayerName) {
        this.remainingPlayerName = remainingPlayerName;
    }

    public void addAll(ArrayList list) {
        remainingPlayerName.addAll(list);
    }


    public static void handCheck(Player player) {
        System.out.println(player.diceValue + " is your roll");
    }

    public void setRemainingDices(int remainingDices) { this.remainingDices = remainingDices; }

    public void setDiceValue(ArrayList<Integer> diceValue) {
        this.diceValue = diceValue;
    }

    public void setPlayerActive(boolean playerActive) {
        this.playerActive = playerActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPlayerActive() {
        return playerActive;
    }

    public String getName() {
        return name;
    }

    public int getRemainingDices() {
        return remainingDices;
    }



}
