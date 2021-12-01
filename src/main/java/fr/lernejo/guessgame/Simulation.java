package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;
import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private static final HumanPlayer player = new HumanPlayer();
    private static long numberToGuess;
    private static int max_number = 100;
    private static int nb_bot_down = 0;
    private static int nb_bot_up = max_number;
    private static int bas_haut = 1;

    public Simulation(Player player) {
        System.out.println("bonjour");

    }

    public void initialize() {

        SecureRandom random = new SecureRandom();
        numberToGuess = random.nextInt(max_number);
    }
    private static boolean nextRoundBot() {
        long number = 0;
        number = (nb_bot_down + nb_bot_up) /2;





        System.out.println("Le bot propose " + number);


        if (number == numberToGuess){
            player.logger.log("bravo !");

            return true;
        }
        else if (number > numberToGuess){
            player.logger.log("c'est moins !");
            nb_bot_up = (int) number;
            bas_haut = 0;
        }
        else if (number < numberToGuess){
            player.logger.log("c'est plus !");
            nb_bot_down = (int) number;
            bas_haut = 1;
        }
        return false;
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

    public static void loopUntilPlayerSucceed(long max_ite, boolean bot) {
        boolean win = false;
        long t1 = System.currentTimeMillis();
        if (!bot){
            while (!win && max_ite > 0){

                win = nextRound();
                max_ite--;
            }
        }
        else{
            while (!win && max_ite > 0){

                win = nextRoundBot();
                max_ite--;
            }
        }

        long t2 = System.currentTimeMillis();
        long tmp = t2-t1;
        int time = (int) tmp;
        int secondes = time/1000;
        int millisecondes = time % 1000;
        System.out.println("Vous avez mis : " + secondes + "." + millisecondes + "secondes");
        if (win){
            System.out.println("Bravo pour avoir trouvé avant de perdre");
        }
        else{
            System.out.println("Mais désolé vous avez perdu");
        }

    }
}
