package be.kdg.Yahtzee.view.highscores;

import be.kdg.Yahtzee.model.Board;
import be.kdg.Yahtzee.model.Highscores;
import be.kdg.Yahtzee.model.Menu;
import be.kdg.Yahtzee.view.board.BoardPresenter;
import be.kdg.Yahtzee.view.board.BoardView;
import be.kdg.Yahtzee.view.menu.MenuPresenter;
import be.kdg.Yahtzee.view.menu.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Younes & Edvin on 10/03/2017.
 */
public class HighscoresPresenter {
    private Highscores model;
    private HighscoresView view;

    public HighscoresPresenter(Highscores model, HighscoresView view) {
        this.model = model;
        this.view = view;
        update();
        addEventHandlers();
    }

    private void update(){
        model.Highsc();
        for (int i = 0; i < 10; i++) {
            view.getNaamLabels(i).setText(model.getNaam(i));
            view.getScoreLabels(i).setText(model.getScores(i));
        }
    }

    private void addEventHandlers() {
        view.getBtnTerug().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuView viewm = new MenuView();
                Menu modelm = new Menu();
                MenuPresenter presenter = new MenuPresenter(modelm,viewm);
                view.getScene().setRoot(viewm);
                viewm.getScene().getWindow().sizeToScene();
            }
        });
    }
}
