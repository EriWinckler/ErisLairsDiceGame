import com.company.Cup;
import com.company.Definitions;
import com.company.Dice;
import com.company.Player;



public class main {
    public static void main(String[] args) {

        Definitions Game = new Definitions();
        Dice dice = new Dice();
        Player player = new Player();
        Player player2 = new Player();
        Cup cup = new Cup();


        dice.rollDice();

        System.out.println(player.diceValue);

        System.out.println(player2.diceValue);

        System.out.println(cup.dices);

    }
}
