package be.kdg.Yahtzee.view.players;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Younes & Edvin on 16/03/2017.
 */
public class PlayersView extends BorderPane {
    private Label lblTitel;
    private Label lblPlayer1;
    private Label lblPlayer2;
    private Label lblPlayer3;
    private TextField txtEerste;
    private TextField txtTweede;
    private TextField txtDerde;
    private Button btnVerder;
    private Button btnTerug;

    public PlayersView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        setPrefSize(500, 300);

        lblTitel = new Label("Spelers: ");
        lblTitel.setStyle("-fx-text-fill: wheat; -fx-font-size: 32pt; -fx-font-family: Segoe UI Light");
        lblPlayer1 = new Label("Speler 1:");
        lblPlayer1.setStyle("-fx-text-fill: antiquewhite; -fx-font-size: 20pt; -fx-font-family: Segoe UI Light");
        lblPlayer2 = new Label("Speler 2:");
        lblPlayer2.setStyle("-fx-text-fill: antiquewhite; -fx-font-size: 20pt; -fx-font-family: Segoe UI Light");
        lblPlayer3 = new Label("Speler 3:");
        lblPlayer3.setStyle("-fx-text-fill: antiquewhite; -fx-font-size: 20pt; -fx-font-family: Segoe UI Light");

        lblPlayer2.setVisible(false);
        lblPlayer3.setVisible(false);

        txtEerste = new TextField("Speler1");
        txtTweede = new TextField("Speler2");
        txtDerde = new TextField("Speler3");

        txtTweede.setVisible(false);
        txtDerde.setVisible(false);

        btnVerder = new Button("Verder");
        btnTerug = new Button("Terug");
    }

    private void layoutNodes() {
        btnVerder.setPrefSize(150, 50);
        btnTerug.setPrefSize(150, 50);
        txtEerste.setPrefSize(100,20);
        txtTweede.setPrefSize(100,20);
        txtDerde.setPrefSize(100,20);

        GridPane gridPane = new GridPane();
        gridPane.add(lblPlayer1, 0, 1, 1, 1);
        gridPane.add(lblPlayer2, 0, 2, 1, 1);
        gridPane.add(lblPlayer3, 0, 3, 1, 1);
        gridPane.add(txtEerste, 1, 1, 1, 1);
        gridPane.add(txtTweede, 1, 2, 1, 1);
        gridPane.add(txtDerde, 1, 3, 1, 1);
        gridPane.setHgap(25);
        gridPane.setVgap(15);

        HBox hbButton = new HBox(btnTerug,btnVerder);

        lblTitel.setMaxWidth(1800);
        lblTitel.setAlignment(Pos.CENTER);
        gridPane.setAlignment(Pos.CENTER);
        hbButton.setAlignment(Pos.CENTER);

        hbButton.setMargin(this.btnTerug, new Insets(10, 40, 20, 40));
        hbButton.setMargin(this.btnVerder, new Insets(10, 40, 20, 40));

        this.setCenter(gridPane);
        this.setTop(lblTitel);
        this.setBottom(hbButton);
    }

    public Label getLblPlayer1() {
        return lblPlayer1;
    }

    public Label getLblPlayer2() {
        return lblPlayer2;
    }

    public Label getLblPlayer3() {
        return lblPlayer3;
    }

    public TextField getTxtEerste() {
        return txtEerste;
    }

    public TextField getTxtTweede() {
        return txtTweede;
    }

    public TextField getTxtDerde() {
        return txtDerde;
    }

    public Button getBtnVerder() {
        return btnVerder;
    }

    public Button getBtnTerug() {
        return btnTerug;
    }
}
