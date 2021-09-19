package be.kdg.Yahtzee.model;

import java.io.*;
import java.util.Optional;

/**
 * Created by Younes & Edvin on 11/03/2017.
 */
public class Einde {
    private String[] winner;
    private String[] player = new String[11];
    private String[] point = new String[11];


    public void WinnaarInlezen() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(("files/win.txt")));
            String line = br.readLine();
            winner = line.split("-");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    public void inlezenScores() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(("files/highscores.txt")));
            int i = 0;
            String lijn = br.readLine();
            while (lijn != null) {
                String[] gegeven = lijn.split("-");
                player[i] = gegeven[0];
                point[i] = gegeven[1];
                lijn = br.readLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scoreOpslaan() {
        for (int i = 10; i > 0; i--) {
            int temp = 0;
            String tempnaam = "";
            point[10] = winner[1];
            player[10] = winner[0];
            if (Integer.parseInt(point[i - 1]) < Integer.parseInt(point[i])) {
                temp = Integer.parseInt(point[i - 1]);
                point[i - 1] = point[i];
                point[i] = String.valueOf(temp);
                tempnaam = player[i - 1];
                player[i - 1] = player[i];
                player[i] = String.valueOf(tempnaam);
            }
        }

        try (PrintWriter pw = new PrintWriter(new BufferedWriter((new FileWriter("files/highscores.txt"))))) {
            for (int i = 0; i < 10; i++) {
                pw.write(player[i] + "-" + point[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWinner(int i) {
        return winner[i];
    }
}
