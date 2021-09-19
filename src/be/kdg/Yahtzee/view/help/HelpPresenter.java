package be.kdg.Yahtzee.view.help;

import be.kdg.Yahtzee.model.Rules;
import be.kdg.Yahtzee.model.YahtzeeException;
import javafx.scene.control.Alert;

/**
 * Created by Younes & Edvin on 24/02/2017.
 */
public class HelpPresenter {
    public HelpPresenter(HelpView view) {
        try {
            view.getTaRules().setText(new Rules().getRules());
        } catch (YahtzeeException me) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(me.getMessage());
            alert.showAndWait();
        }
    }
}
