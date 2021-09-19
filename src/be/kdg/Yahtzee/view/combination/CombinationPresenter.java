package be.kdg.Yahtzee.view.combination;

import be.kdg.Yahtzee.model.Combination;
import be.kdg.Yahtzee.model.YahtzeeException;
import javafx.scene.control.Alert;

/**
 * Created by Younes & Edvin on 24/02/2017.
 */
public class CombinationPresenter {
    public CombinationPresenter(CombinationView view) {
        try {
            view.getTaCombination().setText(new Combination().getCombination());
        } catch (YahtzeeException me) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(me.getMessage());
            alert.showAndWait();
        }
    }
}
