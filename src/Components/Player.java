package Components;

import java.util.Random;
import java.util.Scanner;

public class Player {

        Random randomNum = new Random();

        int [] dice = new int[5];

        String playerName;
        
        int remainingDices = 5;

        public static int getRandomInteger(int maximum, int minimum){ return ((int) (Math.random()*(maximum - minimum))) + minimum; }



}


