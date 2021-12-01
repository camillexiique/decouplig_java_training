package main.java.fr.lernejo.guessgame;

public class Launcher {
    public static void main(String[] args){
        Player HumanPlayer = new Player() {
            @Override
            public long askNextGuess() {
                Simulation.loopUntilPlayerSucceed();
                return 0;
            }

            @Override
            public void respond(boolean lowerOrGreater) {

            }
        };
        Simulation simu = new Simulation(HumanPlayer);
        simu.initialize();
        HumanPlayer.askNextGuess();

    }
}
