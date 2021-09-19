package be.kdg.Yahtzee.model;

import be.kdg.Yahtzee.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Younes & Edvin on 24/02/2017.
 */
public class Combination {
    public static final String COMBINATION_FILE = "files/combinations.txt";

    private String combination = "";
    public Combination() {
        try (BufferedReader reader = new BufferedReader(new FileReader(COMBINATION_FILE))){
            String line = "";
            while ((line=reader.readLine())!=null){
                combination += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.debug("Unable to load game combinations: " + e.getMessage());
            throw new YahtzeeException("Unable to load the game combinations...");
        }
    }

    public String getCombination(){
        return combination;
    }
}
