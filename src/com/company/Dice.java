package com.company;

import java.util.Collections;
import java.util.Random;

public class Dice {

    Random random = new Random();

    public void rollDice(Player players) {

        players.getDiceValue().clear();
        for (int i = 0; i < players.getRemainingDices(); i++) {
            players.getDiceValue().add(random.nextInt(6) + 1 );
        }

        //Sort the ArrayList
        Collections.sort(players.getDiceValue());
    }

    public void removeDie(Player player) {
        if (player.getRemainingDices() > 0) {
            player.setRemainingDices(player.getRemainingDices() - 1);
            player.getDiceValue().remove(player.getDiceValue().size() - 1);
        } else {
            player.setActive(false);
        }
    }

}
