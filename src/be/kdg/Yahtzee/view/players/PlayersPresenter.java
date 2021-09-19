package be.kdg.Yahtzee.view.players;

import be.kdg.Yahtzee.model.Board;
import be.kdg.Yahtzee.model.Menu;
import be.kdg.Yahtzee.view.board.BoardPresenter;
import be.kdg.Yahtzee.view.board.BoardView;
import be.kdg.Yahtzee.view.menu.MenuPresenter;
import be.kdg.Yahtzee.view.menu.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Younes & Edvin on 16/03/2017.
 */
public class PlayersPresenter {
    private Menu model;
    private PlayersView view;

    public PlayersPresenter(Menu model, PlayersView view) {
        this.model = model;
        this.view = view;
        viewupdate();
        addEventHandlers();
    }

    private void viewupdate(){
        model.laadgeg();
        switch (model.getAantalspelers()){
            case 3: view.getLblPlayer3().setVisible(true); view.getTxtDerde().setVisible(true);
            case 2: view.getLblPlayer2().setVisible(true); view.getTxtTweede().setVisible(true); break;
        }
    }

    private void addEventHandlers() {
        view.getBtnVerder().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.spelerNamen(view.getTxtEerste().getText(),view.getTxtTweede().getText(),view.getTxtDerde().getText());

                Board model = new Board();
                BoardView bview = new BoardView();
                BoardPresenter presenter = new BoardPresenter(model,bview);
                view.getScene().setRoot(bview);
                bview.getScene().getWindow().sizeToScene();
            }
        });
        view.getBtnTerug().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Menu model = new Menu();
                MenuView bview = new MenuView();
                MenuPresenter presenter = new MenuPresenter(model,bview);
                view.getScene().setRoot(bview);
                bview.getScene().getWindow().sizeToScene();
            }
        });
    }
}
