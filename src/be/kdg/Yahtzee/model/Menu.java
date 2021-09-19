package be.kdg.Yahtzee.model;

import be.kdg.Yahtzee.view.board.BoardPresenter;
import be.kdg.Yahtzee.view.board.BoardView;
import be.kdg.Yahtzee.view.highscores.HighscoresPresenter;
import be.kdg.Yahtzee.view.highscores.HighscoresView;
import be.kdg.Yahtzee.view.menu.MenuView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.*;
import java.util.Optional;

/**
 * Created by Younes & Edvin on 10/02/2017.
 */
public class Menu {
    private String schrijf = "";
    private int aantalspelers = 0;

    public void settings() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter((new FileWriter("files/game_start.txt"))))) {
            pw.write(schrijf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(int speler, int ronde, int rondes, int spelers) {
        switch (speler) {
            case 1:
                schrijf = "1|";
                break;
            case 2:
                schrijf = "0|";
                break;
            case 3:
                schrijf = spelers + "|";
                break;
        }

        switch (ronde) {
            case 1:
                schrijf += "13";
                break;
            case 2:
                schrijf += "5";
                break;
            case 3:
                schrijf += rondes;
                break;
        }
    }

    public void spelerNamen(String een, String twee, String drie) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter((new FileWriter("files/players.txt"))))) {
            pw.write(een + "|" + twee + "|" + drie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void laadgeg() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(("files/game_start.txt")));
            String line = br.readLine();
            String[] velden = line.split("\\|");
            aantalspelers = Integer.parseInt(velden[0]);
        } catch (FileNotFoundException e) {
            aantalspelers = 1;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    public int getAantalspelers() {
        return aantalspelers;
    }
}
