package be.kdg.Yahtzee;

/**
 * Created by Younes & Edvin on 24/02/2017.
 */
public class Log {
    public static final boolean DEBUG_ON = true;
    public static void debug(String message){
        if (DEBUG_ON) System.out.println(message);
    }
    public static void error(String message){
        System.out.println(message);
    }
}
