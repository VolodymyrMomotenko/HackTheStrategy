package simulator.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        GameSelection gameSelection = new GameSelection();
        gameSelection.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
