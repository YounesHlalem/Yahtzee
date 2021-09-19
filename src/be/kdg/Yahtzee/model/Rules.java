package be.kdg.Yahtzee.model;

import be.kdg.Yahtzee.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Younes & Edvin on 24/02/2017.
 */
public class Rules {
    public static final String RULES_FILE = "files/rules.txt";

    private String rules = "";

    public Rules() {
        try (BufferedReader reader = new BufferedReader(new FileReader(RULES_FILE))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                rules += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.debug("Unable to load game rules: " + e.getMessage());
            throw new YahtzeeException("Unable to load the game rules...");
        }
    }

    public String getRules() {
        return rules;
    }
}
