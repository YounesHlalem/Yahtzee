package be.kdg.Yahtzee.model;

/**
 * Created by Younes & Edvin on 24/02/2017.
 */
public class YahtzeeException extends RuntimeException {
    public YahtzeeException(String s) {
        super(s);
    }

    public YahtzeeException(Throwable cause) {
        super(cause);
    }
}
