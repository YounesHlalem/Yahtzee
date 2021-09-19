package be.kdg.Yahtzee.view.einde;

import be.kdg.Yahtzee.model.Einde;
import be.kdg.Yahtzee.model.Menu;
import be.kdg.Yahtzee.view.menu.MenuPresenter;
import be.kdg.Yahtzee.view.menu.MenuView;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import javafx.util.Duration;

import java.util.Optional;

/**
 * Created by Younes & Edvin on 11/03/2017.
 */
public class EindePresenter {
    private Einde model;
    private EindeView view;

    public EindePresenter(Einde model, EindeView view) {
        this.model = model;
        this.view = view;
        model.WinnaarInlezen();
        update();
        addEventHandlers();
    }

    private void update() {
        view.getLblWinnaar().setText(model.getWinner(0) + ": " + model.getWinner(1));
        if(Integer.parseInt(model.getWinner(6)) == 3){
            view.getLblTweede().setText(model.getWinner(2) + ": " + model.getWinner(3));
            view.getLblDerde().setText(model.getWinner(4) + ": " + model.getWinner(5));
        }else if(Integer.parseInt(model.getWinner(6)) == 2){
            view.getLblTweede().setText(model.getWinner(2) + ": " + model.getWinner(3));
        }
        kroon();
    }

    private void kroon() {
        ScaleTransition transition1 = new ScaleTransition();
        transition1.setNode(view.getImgKroon());
        transition1.setByX(0.1);
        transition1.setByY(0.1);
        transition1.setDuration(Duration.seconds(0.7));
        transition1.setAutoReverse(true);
        transition1.setCycleCount(Timeline.INDEFINITE);
        transition1.play();
    }

    private void addEventHandlers() {
        view.getBtnVolgende().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.inlezenScores();
                model.scoreOpslaan();
                MenuView viewm = new MenuView();
                Menu modelm = new Menu();
                MenuPresenter presenter = new MenuPresenter(modelm, viewm);
                view.getScene().setRoot(viewm);
                viewm.getScene().getWindow().sizeToScene();
            }
        });
    }
}
