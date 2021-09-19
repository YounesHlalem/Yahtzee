package be.kdg.Yahtzee;

import be.kdg.Yahtzee.model.Menu;
import be.kdg.Yahtzee.view.menu.MenuPresenter;
import be.kdg.Yahtzee.view.menu.MenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Younes & Edvin on 10/02/2017.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuView view = new MenuView();
        Menu model = new Menu();
        MenuPresenter presenter = new MenuPresenter(model,view);
        Scene scene = new Scene(view);
        scene.getStylesheets().add("css/Style.css");
        primaryStage.setTitle("Yahtzee");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
