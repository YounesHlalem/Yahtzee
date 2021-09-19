package be.kdg.Yahtzee.view.help;


import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

/**
 * Created by Younes & Edvin on 24/02/2017.
 */
public class HelpView extends BorderPane {
   private Label taRules = new Label();

    public HelpView() {
        setCenter(taRules);
        taRules.setPrefWidth(Double.MAX_VALUE);
        taRules.setPrefHeight(Double.MAX_VALUE);
        taRules.setWrapText(true);
        setPrefWidth(650);
        setPrefHeight(450);
        taRules.setStyle("-fx-font-size: 11pt; -fx-font-family: Calibri Light; -fx-text-fill: wheat; -fx-background-color: derive(#1d1d1d,20%);");
    }

    Label getTaRules() {
        return taRules;
    }
}
