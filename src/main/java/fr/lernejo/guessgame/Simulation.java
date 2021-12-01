package main.java.fr.lernejo.guessgame;

import main.java.fr.lernejo.logger.Logger;
import main.java.fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;
import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private static final HumanPlayer player = new HumanPlayer();
    private static long numberToGuess;

    public Simulation(Player player) {
        System.out.println("bonjour");

    }

    public void initialize() {

        SecureRandom random = new SecureRandom();
        numberToGuess = random.nextInt(100);
    }

    /**
     * @return true if the player have guessed the right number
     */
    private static boolean nextRound() {
        long number = 0;

        System.out.println("Donnez un nombre ?");
        Scanner scan = new Scanner(System.in);
        number = scan.nextInt();

        if (number == numberToGuess){
            player.logger.log("bravo !");
            return true;
        }
        else if (number > numberToGuess){
            player.logger.log("c'est moins !");
        }
        else if (number < numberToGuess){
            player.logger.log("c'est plus !");
        }
        return false;
    }

    public static void loopUntilPlayerSucceed() {
        while (!nextRound()){
         nextRound();
        }

    }
}
