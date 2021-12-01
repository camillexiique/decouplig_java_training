package fr.lernejo.logger;

public class LoggerFactory implements Logger{

    public static Logger getLogger(String name){

        return new ConsoleLogger();
    }

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
