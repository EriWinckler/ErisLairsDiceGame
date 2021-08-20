package com.company;

import java.util.Collections;
import java.util.Random;

public class Dice {

    Random random = new Random();

    public void rollDice(Player players) {

        players.diceValue.clear();
        for (int i = 0; i < players.remainingDices; i++) {
            players.diceValue.add(random.nextInt(6) + 1 );
        }

        //Sort the ArrayList
        Collections.sort(players.diceValue);
    }

    public void removeDie(Player player) {
        if (player.remainingDices > 0) {
            player.remainingDices = player.remainingDices - 1;
        } else {
            player.active = false;
        }
    }

}
