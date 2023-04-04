package logger;

public class Consolelogger {
    private static int counter = 1;

    public static void debug(String message) {
        System.out.println("[debug][" + counter++ + "] - " + message);
    }
}

