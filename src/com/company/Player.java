package com.company;

import java.util.ArrayList;


public class Player {
    public int remainingDices;
    public ArrayList<Integer> diceValue = new ArrayList<>();
    public boolean active = true;
    public String name = "";

    public static void handCheck(Player player) {
        System.out.println(player.diceValue + " is your roll");
    }
}
