package fr.lernejo.guessgame;

public class Launcher {
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("Veuillez entrer comme argument -interactive OU -auto x, x étant un entier positif");
            return;
        }

        if (args[0].equals("-interactive") && args.length == 1){
            Player HumanPlayer = new Player() {
                @Override
                public long askNextGuess() {
                    Simulation.loopUntilPlayerSucceed(Long.MAX_VALUE, false);
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
        else if (args[0].equals("-auto")){
            if (args.length == 2){
                if (args[1].matches("[+-]?\\d*(\\.\\d+)?")){
                    Player ComputerPlayer = new Player() {
                        @Override
                        public long askNextGuess() {
                            long max_ite = (long) Integer.parseInt(args[1]);
                            Simulation.loopUntilPlayerSucceed(max_ite, true);
                            return 0;
                        }

                        @Override
                        public void respond(boolean lowerOrGreater) {

                        }
                    };
                    Simulation simu = new Simulation(ComputerPlayer);
                    simu.initialize();
                    ComputerPlayer.askNextGuess();
                }
                else{
                    System.out.println("Veuillez entrer comme argument -interactive OU -auto x, x étant un entier positif");
                }
            }
            else{
                System.out.println("Veuillez entrer comme argument -interactive OU -auto x, x étant un entier positif");

            }

        }
        else{
            System.out.println("Veuillez entrer comme argument -interactive OU -auto x, x étant un entier positif");
        }


    }
}
