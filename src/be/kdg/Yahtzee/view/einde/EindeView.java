package be.kdg.Yahtzee.view.einde;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Created by Younes & Edvin on 11/03/2017.
 */
public class EindeView extends BorderPane {
    private Label lblTitel;
    private Label lblWinnaar;
    private Label lblTweede;
    private Label lblDerde;
    private Button btnVolgende;
    private ImageView imgKroon;

    public EindeView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        setPrefSize(650, 450);
        lblTitel = new Label("Winnaar!");
        lblTitel.setStyle("-fx-text-fill: wheat; -fx-font-size: 32pt; -fx-font-family: Segoe UI Light");
        lblWinnaar = new Label("");
        lblWinnaar.setStyle("-fx-text-fill: antiquewhite; -fx-font-size: 20pt; -fx-font-family: Segoe UI Light");
        lblTweede = new Label("");
        lblTweede.setStyle("-fx-text-fill: antiquewhite; -fx-font-size: 18pt; -fx-font-family: Segoe UI Light; -fx-opacity: 0.8;");
        lblDerde = new Label("");
        lblDerde.setStyle("-fx-text-fill: antiquewhite; -fx-font-size: 16pt; -fx-font-family: Segoe UI Light; -fx-opacity: 0.6;");
        btnVolgende = new Button("Verder");
        imgKroon = new ImageView("be/kdg/Yahtzee/view/images/kroon.png");
    }

    private void layoutNodes() {
        btnVolgende.setPrefSize(140, 50);
        imgKroon.setFitWidth(160);
        imgKroon.setFitHeight(100);
        VBox vbCenter = new VBox();

        vbCenter.setSpacing(15);
        vbCenter.getChildren().addAll(lblTitel, imgKroon, lblWinnaar, lblTweede, lblDerde, btnVolgende);

        vbCenter.setMargin(lblTitel, new Insets(20, 0, 10, 0));
        vbCenter.setMargin(lblWinnaar, new Insets(0, 0, 10, 0));
        vbCenter.setMargin(lblTweede, new Insets(0, 0, 10, 0));
        vbCenter.setMargin(lblDerde, new Insets(0, 0, 10, 0));
        vbCenter.setMargin(btnVolgende, new Insets(10, 0, 20, 0));
        vbCenter.setMargin(imgKroon, new Insets(5, 0, 5, 0));

        lblTitel.setMaxWidth(1800);
        vbCenter.setAlignment(Pos.CENTER);
        lblTitel.setAlignment(Pos.CENTER);

        this.setCenter(vbCenter);
    }

    public Label getLblWinnaar() {
        return lblWinnaar;
    }

    public Button getBtnVolgende() {
        return btnVolgende;
    }

    public Label getLblTweede() {
        return lblTweede;
    }

    public Label getLblDerde() {
        return lblDerde;
    }

    public ImageView getImgKroon() {
        return imgKroon;
    }
}
