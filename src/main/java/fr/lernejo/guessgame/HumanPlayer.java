package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer {
    private static LoggerFactory tmp = new LoggerFactory();
    static Logger logger = tmp.getLogger("player");
    Scanner scan = new java.util.Scanner(System.in);
}
