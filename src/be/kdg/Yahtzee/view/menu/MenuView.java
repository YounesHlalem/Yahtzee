package be.kdg.Yahtzee.view.menu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Created by Younes & Edvin on 10/02/2017.
 */
public class MenuView extends BorderPane{
    private Label lblTitel;
    private RadioButton rbSolo;
    private RadioButton rbAI;
    private RadioButton rbPlayers;
    private RadioButton rbStandaard;
    private RadioButton rb5Round;
    private RadioButton rbRounds;
    private Label lblRounds;
    private TextField txtRounds;
    private Label lblFout;
    private Button btnStandard;

    private Button btnHighscore;
    private Button btnExit;
    private Label lblPlayers;
    private ComboBox<String> cbPlayers;

    VBox vbButtons;
    VBox vbPlayers;
    HBox hbPlayer;
    HBox hbRounds;

    public MenuView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        setPrefSize(500, 300);
        lblTitel = new Label("Yahtzee");
        lblTitel.setStyle("-fx-text-fill: wheat; -fx-font-size: 38pt; -fx-font-family: Segoe UI Light");
        btnStandard = new Button("Start");
        btnHighscore = new Button("Highscores");
        lblFout = new Label("");
        rbSolo = new RadioButton("Solo");
        rbStandaard = new RadioButton("Standaard");
        rb5Round = new RadioButton("5 rondes");
        rbRounds = new RadioButton("Custom");
        lblRounds = new Label("Hoeveel rondes?");
        txtRounds = new TextField();

        btnExit = new Button("Afsluiten");
        rbAI = new RadioButton("Computer AI");
        rbPlayers = new RadioButton("Multiplayer");
        lblPlayers = new Label("Hoeveel spelers?");
        this.cbPlayers = new ComboBox<>();
        ObservableList<String> aantalSpelers = FXCollections.observableArrayList("2", "3");
        this.cbPlayers.setItems(aantalSpelers);
        this.cbPlayers.getSelectionModel().select(0);
        ToggleGroup tgPlayers = new ToggleGroup();
        rbPlayers.setToggleGroup(tgPlayers);
        rbAI.setToggleGroup(tgPlayers);
        rbSolo.setToggleGroup(tgPlayers);
        ToggleGroup tgRounds = new ToggleGroup();
        rbStandaard.setToggleGroup(tgRounds);
        rb5Round.setToggleGroup(tgRounds);
        rbRounds.setToggleGroup(tgRounds);

        rbSolo.setSelected(true);
        rbStandaard.setSelected(true);


        vbButtons = new VBox();
        vbPlayers = new VBox();
        hbPlayer = new HBox();
        hbRounds = new HBox();
    }

    private void layoutNodes(){
        btnStandard.setPrefSize(140, 50);
        btnExit.setPrefSize(150, 50);
        btnHighscore.setPrefSize(150, 50);
        txtRounds.setPrefSize(35,20);
        VBox vbtop = new VBox();
        VBox vbbottom = new VBox();
        HBox hbknop = new HBox();

        vbtop.getChildren().addAll(lblTitel,btnStandard);
        hbknop.getChildren().addAll(btnHighscore, btnExit);
        vbbottom.getChildren().addAll(hbknop,lblFout);

        hbRounds.getChildren().addAll(lblRounds,txtRounds);
        vbButtons.getChildren().addAll(rbStandaard, rb5Round, rbRounds, hbRounds);
        hbPlayer.getChildren().addAll(lblPlayers,cbPlayers);
        vbPlayers.getChildren().addAll(rbSolo, rbAI, rbPlayers, hbPlayer);

        vbButtons.setMargin(this.rbStandaard, new Insets(10, 60, 10, 0));
        vbButtons.setMargin(this.rb5Round, new Insets(10, 60, 10, 0));
        vbButtons.setMargin(this.rbRounds, new Insets(10, 60, 2, 0));

        vbPlayers.setMargin(this.rbSolo, new Insets(10, 0, 10, 40));
        vbPlayers.setMargin(this.rbAI, new Insets(10, 0, 10, 40));
        vbPlayers.setMargin(this.rbPlayers, new Insets(10, 0, 2, 40));

        hbPlayer.setMargin(this.lblPlayers, new Insets(12, 0, 10, 65));
        hbPlayer.setMargin(this.cbPlayers, new Insets(10, 50, 10, 10));

        hbRounds.setMargin(this.lblRounds, new Insets(12, 0, 10, 25));
        hbRounds.setMargin(this.txtRounds, new Insets(10, 50, 10, 10));

        vbtop.setMargin(this.lblTitel, new Insets(10, 0, 10, 0));
        vbtop.setMargin(this.btnStandard, new Insets(10, 0, 15, 0));

        hbknop.setMargin(this.btnHighscore, new Insets(10, 40, 10, 40));
        hbknop.setMargin(this.btnExit, new Insets(10, 40, 10, 40));

        lblTitel.setMaxWidth(600);
        vbtop.setAlignment(Pos.CENTER);
        lblTitel.setAlignment(Pos.CENTER);
        hbknop.setAlignment(Pos.CENTER);
        vbbottom.setAlignment(Pos.CENTER);

        this.setTop(vbtop);
        this.setLeft(vbPlayers);
        this.setRight(vbButtons);
        this.setBottom(vbbottom);
    }

    public Button getBtnStandard() {
        return btnStandard;
    }

    public Button getBtnExit() {
        return btnExit;
    }

    public boolean getRbAI() {
        return rbAI.isSelected();
    }

    public boolean getRbPlayers() {
        return rbPlayers.isSelected();
    }

    public String getCbPlayers() {
        return cbPlayers.getValue();
    }

    public boolean getRbSolo() {
        return rbSolo.isSelected();
    }

    public boolean getRbStandaard() {
        return rbStandaard.isSelected();
    }

    public boolean getRb5Round() {
        return rb5Round.isSelected();
    }

    public boolean getRbRounds() {
        return rbRounds.isSelected();
    }

    public String getTxtRounds() {
        return txtRounds.getText();
    }

    public Label getLblFout() {
        return lblFout;
    }

    public Button getBtnHighscore() {
        return btnHighscore;
    }
}
