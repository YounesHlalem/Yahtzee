package be.kdg.Yahtzee.view.board;

import be.kdg.Yahtzee.model.Board;
import be.kdg.Yahtzee.model.Einde;
import be.kdg.Yahtzee.model.Menu;
import be.kdg.Yahtzee.view.combination.CombinationPresenter;
import be.kdg.Yahtzee.view.combination.CombinationView;
import be.kdg.Yahtzee.view.einde.EindePresenter;
import be.kdg.Yahtzee.view.einde.EindeView;
import be.kdg.Yahtzee.view.help.HelpPresenter;
import be.kdg.Yahtzee.view.help.HelpView;
import be.kdg.Yahtzee.view.menu.MenuPresenter;
import be.kdg.Yahtzee.view.menu.MenuView;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.Random;

/**
 * Created by Younes & Edvin on 11/02/2017.
 */
public class BoardPresenter {
    private Board model;
    private BoardView view;

    public BoardPresenter(Board model, BoardView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        model.inlezen();
        screenupdate();
    }

    public void screenupdate() {
        view.getLblRonde().setText(String.valueOf(model.getAantalRondes()));
        if (model.getSteenCheck(1)) {
            view.getImgDice1().setImage(new Image("be/kdg/Yahtzee/view/images/cdie" + model.getWaardeSteen(1) + ".png"));
        } else {
            view.getImgDice1().setImage(new Image("be/kdg/Yahtzee/view/images/die" + model.getWaardeSteen(1) + ".png"));
        }
        if (model.getSteenCheck(2)) {
            view.getImgDice2().setImage(new Image("be/kdg/Yahtzee/view/images/cdie" + model.getWaardeSteen(2) + ".png"));
        } else {
            view.getImgDice2().setImage(new Image("be/kdg/Yahtzee/view/images/die" + model.getWaardeSteen(2) + ".png"));
        }
        if (model.getSteenCheck(3)) {
            view.getImgDice3().setImage(new Image("be/kdg/Yahtzee/view/images/cdie" + model.getWaardeSteen(3) + ".png"));
        } else {
            view.getImgDice3().setImage(new Image("be/kdg/Yahtzee/view/images/die" + model.getWaardeSteen(3) + ".png"));
        }
        if (model.getSteenCheck(4)) {
            view.getImgDice4().setImage(new Image("be/kdg/Yahtzee/view/images/cdie" + model.getWaardeSteen(4) + ".png"));
        } else {
            view.getImgDice4().setImage(new Image("be/kdg/Yahtzee/view/images/die" + model.getWaardeSteen(4) + ".png"));
        }
        if (model.getSteenCheck(5)) {
            view.getImgDice5().setImage(new Image("be/kdg/Yahtzee/view/images/cdie" + model.getWaardeSteen(5) + ".png"));
        } else {
            view.getImgDice5().setImage(new Image("be/kdg/Yahtzee/view/images/die" + model.getWaardeSteen(5) + ".png"));
        }

        view.getBtnRoll().setDisable(model.isWerpKnop());
        view.getLblThrow().setText("Je kan nog " + model.getAantalThrows() + " keer werpen");

        for (int i = 1; i <= 13; i++) {
            if ((model.getPuntenAangeduid(i) && model.getSpelerAanBeurt() == 1) || (model.getPuntenAangeduid2(i) && model.getSpelerAanBeurt() == 2) || (model.getPuntenAangeduid3(i) && model.getSpelerAanBeurt() == 3)) {
                switch (i) {
                    case 1:
                        view.getLblPOnes().setTextFill(Color.web("66f927"));
                        break;
                    case 2:
                        view.getLblPTwos().setTextFill(Color.web("66f927"));
                        break;
                    case 3:
                        view.getLblPThrees().setTextFill(Color.web("66f927"));
                        break;
                    case 4:
                        view.getLblPFours().setTextFill(Color.web("66f927"));
                        break;
                    case 5:
                        view.getLblPFives().setTextFill(Color.web("66f927"));
                        break;
                    case 6:
                        view.getLblPSixes().setTextFill(Color.web("66f927"));
                        break;
                    case 7:
                        view.getLblP3Kind().setTextFill(Color.web("66f927"));
                        break;
                    case 8:
                        view.getLblP4Kind().setTextFill(Color.web("66f927"));
                        break;
                    case 9:
                        view.getLblPFull().setTextFill(Color.web("66f927"));
                        break;
                    case 10:
                        view.getLblPSmall().setTextFill(Color.web("66f927"));
                        break;
                    case 11:
                        view.getLblPLarge().setTextFill(Color.web("66f927"));
                        break;
                    case 12:
                        view.getLblPChance().setTextFill(Color.web("66f927"));
                        break;
                    case 13:
                        view.getLblPYahtzee().setTextFill(Color.web("66f927"));
                        break;
                }
            } else {
                switch (i) {
                    case 1:
                        view.getLblPOnes().setTextFill(Color.web("fffcdd"));
                        break;
                    case 2:
                        view.getLblPTwos().setTextFill(Color.web("fffcdd"));
                        break;
                    case 3:
                        view.getLblPThrees().setTextFill(Color.web("fffcdd"));
                        break;
                    case 4:
                        view.getLblPFours().setTextFill(Color.web("fffcdd"));
                        break;
                    case 5:
                        view.getLblPFives().setTextFill(Color.web("fffcdd"));
                        break;
                    case 6:
                        view.getLblPSixes().setTextFill(Color.web("fffcdd"));
                        break;
                    case 7:
                        view.getLblP3Kind().setTextFill(Color.web("fffcdd"));
                        break;
                    case 8:
                        view.getLblP4Kind().setTextFill(Color.web("fffcdd"));
                        break;
                    case 9:
                        view.getLblPFull().setTextFill(Color.web("fffcdd"));
                        break;
                    case 10:
                        view.getLblPSmall().setTextFill(Color.web("fffcdd"));
                        break;
                    case 11:
                        view.getLblPLarge().setTextFill(Color.web("fffcdd"));
                        break;
                    case 12:
                        view.getLblPChance().setTextFill(Color.web("fffcdd"));
                        break;
                    case 13:
                        view.getLblPYahtzee().setTextFill(Color.web("fffcdd"));
                        break;
                }
            }
        }

        switch (model.getSpelerAanBeurt()) {
            case 1:
                view.getLblPOnes().setText(model.getPunten(1) + " p.");
                view.getLblPTwos().setText(model.getPunten(2) + " p.");
                view.getLblPThrees().setText(model.getPunten(3) + " p.");
                view.getLblPFours().setText(model.getPunten(4) + " p.");
                view.getLblPFives().setText(model.getPunten(5) + " p.");
                view.getLblPSixes().setText(model.getPunten(6) + " p.");
                view.getLblP3Kind().setText(model.getPunten(7) + " p.");
                view.getLblP4Kind().setText(model.getPunten(8) + " p.");
                view.getLblPFull().setText(model.getPunten(9) + " p.");
                view.getLblPSmall().setText(model.getPunten(10) + " p.");
                view.getLblPLarge().setText(model.getPunten(11) + " p.");
                view.getLblPChance().setText(model.getPunten(12) + " p.");
                view.getLblPYahtzee().setText(model.getPunten(13) + " p.");
                view.getLblPTotal().setText(model.getPunten(14) + " p.");
                view.getImgPlayer().setImage(new Image("be/kdg/Yahtzee/view/images/user1.png"));
                view.getLblPlayer().setText(model.getNamen(0));
                break;
            case 2:
                view.getLblPOnes().setText(model.getPunten2(1) + " p.");
                view.getLblPTwos().setText(model.getPunten2(2) + " p.");
                view.getLblPThrees().setText(model.getPunten2(3) + " p.");
                view.getLblPFours().setText(model.getPunten2(4) + " p.");
                view.getLblPFives().setText(model.getPunten2(5) + " p.");
                view.getLblPSixes().setText(model.getPunten2(6) + " p.");
                view.getLblP3Kind().setText(model.getPunten2(7) + " p.");
                view.getLblP4Kind().setText(model.getPunten2(8) + " p.");
                view.getLblPFull().setText(model.getPunten2(9) + " p.");
                view.getLblPSmall().setText(model.getPunten2(10) + " p.");
                view.getLblPLarge().setText(model.getPunten2(11) + " p.");
                view.getLblPChance().setText(model.getPunten2(12) + " p.");
                view.getLblPYahtzee().setText(model.getPunten2(13) + " p.");
                view.getLblPTotal().setText(model.getPunten2(14) + " p.");
                if (model.isTegenAI()) {
                    view.getImgPlayer().setImage(new Image("be/kdg/Yahtzee/view/images/user_ai.png"));
                    view.getLblPlayer().setText("Computer");
                } else {
                    view.getImgPlayer().setImage(new Image("be/kdg/Yahtzee/view/images/user2.png"));
                    view.getLblPlayer().setText(model.getNamen(1));
                }
                break;
            case 3:
                view.getLblPOnes().setText(model.getPunten3(1) + " p.");
                view.getLblPTwos().setText(model.getPunten3(2) + " p.");
                view.getLblPThrees().setText(model.getPunten3(3) + " p.");
                view.getLblPFours().setText(model.getPunten3(4) + " p.");
                view.getLblPFives().setText(model.getPunten3(5) + " p.");
                view.getLblPSixes().setText(model.getPunten3(6) + " p.");
                view.getLblP3Kind().setText(model.getPunten3(7) + " p.");
                view.getLblP4Kind().setText(model.getPunten3(8) + " p.");
                view.getLblPFull().setText(model.getPunten3(9) + " p.");
                view.getLblPSmall().setText(model.getPunten3(10) + " p.");
                view.getLblPLarge().setText(model.getPunten3(11) + " p.");
                view.getLblPChance().setText(model.getPunten3(12) + " p.");
                view.getLblPYahtzee().setText(model.getPunten3(13) + " p.");
                view.getLblPTotal().setText(model.getPunten3(14) + " p.");
                view.getImgPlayer().setImage(new Image("be/kdg/Yahtzee/view/images/user3.png"));
                view.getLblPlayer().setText(model.getNamen(2));
                break;
        }

        if (model.isEindeSpel()) {
            model.Spelgedaan();
            Einde model = new Einde();
            EindeView bview = new EindeView();
            EindePresenter presenter = new EindePresenter(model, bview);
            view.getScene().setRoot(bview);
            bview.getScene().getWindow().sizeToScene();
        }
    }

    private void aiSpeelt() {
        if (model.getSpelerAanBeurt() == 2 && model.isTegenAI()) {
            screenupdate();
            model.rol();
            dobbel();
            PauseTransition pause = new PauseTransition(
                    Duration.seconds(3));
            pause.setOnFinished(event -> {
                model.Lock(model.aiAanduiden());
                screenupdate();
                model.saveHuidig();
                model.save();
            });
            pause.play();

        }
    }

    private void dobbel() {
        RotateTransition transition = new RotateTransition();
        transition.setNode(view.getImgDice1());
        transition.setDuration(Duration.seconds(0.6));
        transition.setByAngle(360);
        transition.setInterpolator(Interpolator.LINEAR);
        if (!model.getSteenCheck(1)) {
            transition.play();
        }

        RotateTransition transition1 = new RotateTransition();
        transition1.setNode(view.getImgDice2());
        transition1.setDuration(Duration.seconds(0.6));
        transition1.setByAngle(360);
        transition1.setInterpolator(Interpolator.LINEAR);
        if (!model.getSteenCheck(2)) {
            transition1.play();
        }

        RotateTransition transition2 = new RotateTransition();
        transition2.setNode(view.getImgDice3());
        transition2.setDuration(Duration.seconds(0.6));
        transition2.setByAngle(360);
        transition2.setInterpolator(Interpolator.LINEAR);
        if (!model.getSteenCheck(3)) {
            transition2.play();
        }

        RotateTransition transition3 = new RotateTransition();
        transition3.setNode(view.getImgDice4());
        transition3.setDuration(Duration.seconds(0.6));
        transition3.setByAngle(360);
        transition3.setInterpolator(Interpolator.LINEAR);
        if (!model.getSteenCheck(4)) {
            transition3.play();
        }

        RotateTransition transition4 = new RotateTransition();
        transition4.setNode(view.getImgDice5());
        transition4.setDuration(Duration.seconds(0.6));
        transition4.setByAngle(360);
        transition4.setInterpolator(Interpolator.LINEAR);
        if (!model.getSteenCheck(5)) {
            transition4.play();
        }
    }

    private void addEventHandlers() {
        view.getBtnRoll().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.rol();
                dobbel();
                screenupdate();
                model.saveHuidig();
                model.save();
            }
        });
        view.getImgDice1().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.DiceClick(1);
                screenupdate();
                model.saveHuidig();
                model.save();
            }
        });
        view.getImgDice2().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.DiceClick(2);
                screenupdate();
                model.saveHuidig();
                model.save();
            }
        });
        view.getImgDice3().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.DiceClick(3);
                screenupdate();
                model.saveHuidig();
                model.save();
            }
        });
        view.getImgDice4().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.DiceClick(4);
                screenupdate();
                model.saveHuidig();
                model.save();
            }
        });
        view.getImgDice5().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.DiceClick(5);
                screenupdate();
                model.saveHuidig();
                model.save();
            }
        });
        view.getLblPOnes().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(1);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblPTwos().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(2);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblPThrees().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(3);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblPFours().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(4);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblPFives().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(5);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblPSixes().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(6);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblP3Kind().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(7);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblP4Kind().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(8);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblPFull().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(9);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblPSmall().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(10);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblPLarge().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(11);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblPChance().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(12);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getLblPYahtzee().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.Lock(13);
                screenupdate();
                model.saveHuidig();
                model.save();
                aiSpeelt();
            }
        });
        view.getQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (model.sluit()) {
                    MenuView vieww = new MenuView();
                    Menu modell = new Menu();
                    MenuPresenter presenter = new MenuPresenter(modell, vieww);
                    view.getScene().setRoot(vieww);
                    vieww.getScene().getWindow().sizeToScene();
                }
            }
        });
        view.getRules().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HelpView helpView = new HelpView();
                new HelpPresenter(helpView);
                Stage helpStage = new Stage();
                helpStage.setTitle("Rules of the game");
                helpStage.initOwner(view.getScene().getWindow());
                helpStage.initModality(Modality.APPLICATION_MODAL);
                helpStage.setScene(new Scene(helpView));
                helpStage.setX(view.getScene().getWindow().getX());
                helpStage.setY(view.getScene().getWindow().getY() + 100);
                helpStage.showAndWait();
            }
        });
        view.getCombination().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CombinationView combinationView = new CombinationView();
                new CombinationPresenter(combinationView);
                Stage combinationStage = new Stage();
                combinationStage.setTitle("Combinations");
                combinationStage.initOwner(view.getScene().getWindow());
                combinationStage.initModality(Modality.APPLICATION_MODAL);
                combinationStage.setScene(new Scene(combinationView));
                combinationStage.setX(view.getScene().getWindow().getX());
                combinationStage.setY(view.getScene().getWindow().getY() + 100);
                combinationStage.showAndWait();
            }
        });
        view.getLoad().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.loadSave();
                screenupdate();
            }
        });
    }
}