package be.kdg.Yahtzee.view.highscores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Created by Younes & Edvin on 10/03/2017.
 */
public class HighscoresView extends BorderPane {
    private Label lblTitel;

    private Label[] namen;
    private Label[] scores;

    private Button btnTerug;

    public HighscoresView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        setPrefSize(500, 300);
        lblTitel = new Label("Highscores: ");
        lblTitel.setStyle("-fx-text-fill: wheat; -fx-font-size: 32pt; -fx-font-family: Segoe UI Light");
        btnTerug = new Button("Terug");

        namen = new Label[10];
        scores = new Label[10];
        for (int i = 0; i < 10; i++) {
            namen[i] = new Label("");
            namen[i].setStyle("-fx-font-size: 16pt;");
            scores[i] = new Label("");
            scores[i].setStyle("-fx-font-size: 16pt;");
        }
    }

    private void layoutNodes() {
        GridPane gridPane = new GridPane();

        for (int i = 0; i < 10; i++) {
            gridPane.add(namen[i], 0, i);
            gridPane.add(scores[i], 1, i);
        }

        gridPane.setHgap(25);
        gridPane.setVgap(15);

        btnTerug.setPrefSize(140, 50);
        lblTitel.setMaxWidth(1800);
        lblTitel.setAlignment(Pos.CENTER);
        gridPane.setAlignment(Pos.CENTER);

        this.setCenter(gridPane);
        this.setTop(lblTitel);
        this.setBottom(btnTerug);

    }

    public Button getBtnTerug() {
        return btnTerug;
    }

    public Label getNaamLabels(int i) {
        return namen[i];
    }

    public Label getScoreLabels(int i) {
        return scores[i];
    }
}
