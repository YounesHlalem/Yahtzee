package be.kdg.Yahtzee.view.combination;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

/**
 * Created by Younes & Edvin on 24/02/2017.
 */
public class CombinationView extends BorderPane{
    private Label taCombination = new Label();

    public CombinationView() {
        setCenter(taCombination);
        taCombination.setPrefWidth(Double.MAX_VALUE);
        taCombination.setPrefHeight(Double.MAX_VALUE);
        taCombination.setWrapText(true);
        setPrefWidth(550);
        setPrefHeight(450);
        taCombination.setStyle("-fx-font-size: 11pt; -fx-font-family: Calibri Light; -fx-text-fill: wheat; -fx-background-color: derive(#1d1d1d,20%);");
    }

    Label getTaCombination() {
        return taCombination;
    }
}
