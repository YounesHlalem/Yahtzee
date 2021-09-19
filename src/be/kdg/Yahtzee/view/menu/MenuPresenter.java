package be.kdg.Yahtzee.view.menu;

import be.kdg.Yahtzee.model.Board;
import be.kdg.Yahtzee.model.Highscores;
import be.kdg.Yahtzee.model.Menu;
import be.kdg.Yahtzee.view.board.BoardPresenter;
import be.kdg.Yahtzee.view.board.BoardView;
import be.kdg.Yahtzee.view.highscores.HighscoresPresenter;
import be.kdg.Yahtzee.view.highscores.HighscoresView;
import be.kdg.Yahtzee.view.players.PlayersPresenter;
import be.kdg.Yahtzee.view.players.PlayersView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Younes & Edvin on 10/02/2017.
 */
public class MenuPresenter {
    private Menu model;
    private MenuView view;

    public MenuPresenter(Menu model, MenuView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtnStandard().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (view.getRbStandaard() || view.getRb5Round()) {
                        start();
                        model.settings();
                        startGame();
                    } else {
                        if ((Integer.parseInt(view.getTxtRounds()) > 0 && view.getRbRounds() && Integer.parseInt(view.getTxtRounds()) <= 13)) {
                            start();
                            model.settings();
                            startGame();
                        } else {
                            view.getLblFout().setText(" Kies een getal tussen 0 en 13!");
                        }
                    }
                } catch (IllegalArgumentException e) {
                    view.getLblFout().setText(" Geef een geldige waarde in!");
                }
            }
        });
        view.getBtnExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        view.getBtnHighscore().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startHighscores();
            }
        });
    }

    private void start() {
        int speler = 1;
        int ronde = 1;
        int spelspelers = 1;
        int rondes = 1;

        if (view.getRbSolo()) {
            speler = 1;
        } else if (view.getRbAI()) {
            speler = 2;
        } else if (view.getRbPlayers()) {
            speler = 3;
            spelspelers = Integer.parseInt(view.getCbPlayers());
        }

        if (view.getRbStandaard()) {
            ronde = 1;
        } else if (view.getRb5Round()) {
            ronde = 2;
        } else if (view.getRbRounds()) {
            ronde = 3;
            rondes = Integer.parseInt(view.getTxtRounds());
        }
        model.start(speler, ronde, rondes, spelspelers);
    }

    private void startGame() {
        Menu model = new Menu();
        PlayersView bview = new PlayersView();
        PlayersPresenter presenter = new PlayersPresenter(model, bview);
        view.getScene().setRoot(bview);
        bview.getScene().getWindow().sizeToScene();
    }

    private void startHighscores() {
        Highscores model = new Highscores();
        HighscoresView bview = new HighscoresView();
        HighscoresPresenter presenter = new HighscoresPresenter(model, bview);
        view.getScene().setRoot(bview);
        bview.getScene().getWindow().sizeToScene();
    }
}
