package be.kdg.Yahtzee.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Younes & Edvin on 10/03/2017.
 */
public class Highscores {
    private String[] naam = new String[10];
    private String[] scores = new String[10];

    public void Highsc() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(("files/highscores.txt")));
            String line = br.readLine();
            int teller = 0;
            while (line != null) {
                String[] tijdelijk = line.split("-");
                naam[teller] = tijdelijk[0];
                scores[teller] = tijdelijk[1];
                teller++;
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNaam(int i) {
        return naam[i];
    }

    public String getScores(int i) {
        return scores[i];
    }
}
