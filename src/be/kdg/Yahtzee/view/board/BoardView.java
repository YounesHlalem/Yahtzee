package be.kdg.Yahtzee.view.board;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Created by Younes & Edvin on 11/02/2017.
 */
public class BoardView extends BorderPane {
    private MenuItem quit;
    private MenuItem load;
    private MenuItem rules;
    private MenuItem combination;
    private ImageView imgDice1;
    private ImageView imgDice2;
    private ImageView imgDice3;
    private ImageView imgDice4;
    private ImageView imgDice5;
    private Button btnRoll;
    private Label lblThrow;
    private Label lblPlayer;
    private ImageView imgPlayer;
    private Label lblOnes;
    private Label lblTwos;
    private Label lblThrees;
    private Label lblFours;
    private Label lblFives;
    private Label lblSixes;
    private Label lbl3Kind;
    private Label lbl4Kind;
    private Label lblFull;
    private Label lblSmall;
    private Label lblLarge;
    private Label lblChance;
    private Label lblYahtzee;
    private Label lblTotal;
    private Label lblPOnes;
    private Label lblPTwos;
    private Label lblPThrees;
    private Label lblPFours;
    private Label lblPFives;
    private Label lblPSixes;
    private Label lblP3Kind;
    private Label lblP4Kind;
    private Label lblPFull;
    private Label lblPSmall;
    private Label lblPLarge;
    private Label lblPChance;
    private Label lblPYahtzee;
    private Label lblPTotal;
    private Label lblRonde;
    private Label lblRondesOver;

    public BoardView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        setPrefSize(650, 450);
        quit = new MenuItem("Hoofdmenu");
        load = new MenuItem("Game laden");
        rules = new MenuItem("Spelregels");
        combination = new MenuItem("Combintaties");
        imgDice1 = new ImageView("be/kdg/Yahtzee/view/images/die0.png");
        imgDice2 = new ImageView("be/kdg/Yahtzee/view/images/die0.png");
        imgDice3 = new ImageView("be/kdg/Yahtzee/view/images/die0.png");
        imgDice4 = new ImageView("be/kdg/Yahtzee/view/images/die0.png");
        imgDice5 = new ImageView("be/kdg/Yahtzee/view/images/die0.png");
        btnRoll = new Button("Rol de stenen");
        lblPlayer = new Label("Speler 1");
        lblThrow = new Label("Je kan nog 3 keer werpen");
        lblRonde = new Label();
        lblRonde.setStyle("-fx-font-size: 18pt; -fx-font-family: Segoe UI Light");
        lblRondesOver = new Label("rondes over");
        lblRondesOver.setStyle("-fx-font-size: 12pt; -fx-font-family: Segoe UI Light");
        imgPlayer = new ImageView("be/kdg/Yahtzee/view/images/user1.png");

        lblOnes = new Label("Ones:");
        lblTwos = new Label("Twos:");
        lblThrees = new Label("Threes:");
        lblFours = new Label("Fours:");
        lblFives = new Label("Fives:");
        lblSixes = new Label("Sixes:");
        lbl3Kind = new Label("Three of a kind:");
        lbl4Kind = new Label("Four of a kind:");
        lblFull = new Label("Full house:");
        lblSmall = new Label("Small straight:");
        lblLarge = new Label("Large straight:");
        lblChance = new Label("Chance:");
        lblYahtzee = new Label("YAHTZEE:");
        lblTotal = new Label("Totaal:");
        lblTotal.setStyle("-fx-text-fill: indianred; -fx-font-size: 15pt; -fx-font-family: Segoe UI Light");

        lblPOnes = new Label("0 p.");
        lblPTwos = new Label("0 p.");
        lblPThrees = new Label("0 p.");
        lblPFours = new Label("0 p.");
        lblPFives = new Label("0 p.");
        lblPSixes = new Label("0 p.");
        lblP3Kind = new Label("0 p.");
        lblP4Kind = new Label("0 p.");
        lblPFull = new Label("0 p.");
        lblPSmall = new Label("0 p.");
        lblPLarge = new Label("0 p.");
        lblPChance = new Label("0 p.");
        lblPYahtzee = new Label("0 p.");
        lblPTotal = new Label("0 p.");
        lblPTotal.setStyle("-fx-text-fill: indianred; -fx-font-size: 14pt; -fx-font-family: Segoe UI Light");
    }

    public Label getLblRonde() {
        return lblRonde;
    }

    private void layoutNodes() {
        VBox vbDices = new VBox();
        HBox hbDie1 = new HBox();
        HBox hbDie2 = new HBox();
        VBox vbPlayer = new VBox();
        VBox vbcenter = new VBox();
        VBox vbRondes = new VBox();
        HBox hbBottom = new HBox();
        GridPane gridPane = new GridPane();

        vbDices.setSpacing(10);
        hbDie1.setSpacing(10);
        hbDie2.setSpacing(10);
        vbPlayer.setSpacing(10);
        hbBottom.setSpacing(10);
        vbcenter.setSpacing(10);

        hbDie1.getChildren().addAll(imgDice2, imgDice3);
        hbDie2.getChildren().addAll(imgDice4, imgDice5);
        vbPlayer.getChildren().addAll(imgPlayer, lblPlayer);
        imgPlayer.setFitWidth(80);
        imgPlayer.setFitHeight(80);
        vbDices.getChildren().addAll(imgDice1, hbDie1, hbDie2, lblThrow);
        vbRondes.getChildren().addAll(lblRonde, lblRondesOver);
        vbcenter.getChildren().addAll(btnRoll, vbPlayer, vbRondes);
        vbDices.setMargin(imgDice1, new Insets(15, 0, 0, 35));
        vbDices.setMargin(hbDie1, new Insets(15, 0, 0, 50));
        vbDices.setMargin(hbDie2, new Insets(15, 0, 0, 50));
        vbDices.setMargin(lblThrow, new Insets(15, 0, 0, 50));
        vbcenter.setMargin(btnRoll, new Insets(0, 25, 10, 25));
        vbcenter.setMargin(vbPlayer, new Insets(5, 25, 10, 25));
        vbPlayer.setMargin(lblPlayer, new Insets(0, 0, 10, 0));
        vbDices.setAlignment(Pos.CENTER);
        btnRoll.setAlignment(Pos.CENTER);
        vbPlayer.setAlignment(Pos.CENTER);
        vbcenter.setAlignment(Pos.CENTER);
        vbRondes.setAlignment(Pos.CENTER);
        this.setLeft(vbDices);
        this.setCenter(vbcenter);

        gridPane.add(lblOnes, 0, 1, 1, 1);
        gridPane.add(lblTwos, 0, 2, 1, 1);
        gridPane.add(lblThrees, 0, 3, 1, 1);
        gridPane.add(lblFours, 0, 4, 1, 1);
        gridPane.add(lblFives, 0, 5, 1, 1);
        gridPane.add(lblSixes, 0, 6, 1, 1);
        gridPane.add(lbl3Kind, 0, 7, 1, 1);
        gridPane.add(lbl4Kind, 0, 8, 1, 1);
        gridPane.add(lblFull, 0, 9, 1, 1);
        gridPane.add(lblSmall, 0, 10, 1, 1);
        gridPane.add(lblLarge, 0, 11, 1, 1);
        gridPane.add(lblChance, 0, 12, 1, 1);
        gridPane.add(lblYahtzee, 0, 13, 1, 1);
        gridPane.add(lblTotal, 0, 14, 1, 1);

        gridPane.add(lblPOnes, 1, 1, 1, 1);
        gridPane.add(lblPTwos, 1, 2, 1, 1);
        gridPane.add(lblPThrees, 1, 3, 1, 1);
        gridPane.add(lblPFours, 1, 4, 1, 1);
        gridPane.add(lblPFives, 1, 5, 1, 1);
        gridPane.add(lblPSixes, 1, 6, 1, 1);
        gridPane.add(lblP3Kind, 1, 7, 1, 1);
        gridPane.add(lblP4Kind, 1, 8, 1, 1);
        gridPane.add(lblPFull, 1, 9, 1, 1);
        gridPane.add(lblPSmall, 1, 10, 1, 1);
        gridPane.add(lblPLarge, 1, 11, 1, 1);
        gridPane.add(lblPChance, 1, 12, 1, 1);
        gridPane.add(lblPYahtzee, 1, 13, 1, 1);
        gridPane.add(lblPTotal, 1, 14, 1, 1);

        gridPane.setHgap(25);
        gridPane.setVgap(15);
        VBox vbgrid = new VBox();
        vbgrid.getChildren().addAll(gridPane);
        vbgrid.setMargin(gridPane, new Insets(5, 60, 30, 15));
        this.setRight(vbgrid);

        final Menu bestandMenu = new Menu("Menu", null, load, quit);
        final Menu helpMenu = new Menu("Help", null, rules, combination);
        final MenuBar menuBar = new MenuBar(bestandMenu, helpMenu);
        this.setTop(menuBar);
    }

    public ImageView getImgDice1() {
        return imgDice1;
    }

    public ImageView getImgDice2() {
        return imgDice2;
    }

    public ImageView getImgDice3() {
        return imgDice3;
    }

    public ImageView getImgDice4() {
        return imgDice4;
    }

    public ImageView getImgDice5() {
        return imgDice5;
    }

    public Button getBtnRoll() {
        return btnRoll;
    }

    public Label getLblThrow() {
        return lblThrow;
    }

    public Label getLblPlayer() {
        return lblPlayer;
    }

    public ImageView getImgPlayer() {
        return imgPlayer;
    }

    public Label getLblPOnes() {
        return lblPOnes;
    }

    public Label getLblPTwos() {
        return lblPTwos;
    }

    public Label getLblPThrees() {
        return lblPThrees;
    }

    public Label getLblPFours() {
        return lblPFours;
    }

    public Label getLblPFives() {
        return lblPFives;
    }

    public Label getLblPSixes() {
        return lblPSixes;
    }

    public Label getLblP3Kind() {
        return lblP3Kind;
    }

    public Label getLblP4Kind() {
        return lblP4Kind;
    }

    public Label getLblPFull() {
        return lblPFull;
    }

    public Label getLblPSmall() {
        return lblPSmall;
    }

    public Label getLblPLarge() {
        return lblPLarge;
    }

    public Label getLblPChance() {
        return lblPChance;
    }

    public Label getLblPYahtzee() {
        return lblPYahtzee;
    }

    public Label getLblPTotal() {
        return lblPTotal;
    }

    public MenuItem getQuit() {
        return quit;
    }

    public MenuItem getLoad() {
        return load;
    }

    public MenuItem getRules() {
        return rules;
    }

    public MenuItem getCombination() {
        return combination;
    }


}
