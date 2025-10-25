package simulator.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
       
        Pane root = new Pane();

        Label label = new Label("Wery kool!");
        label.setLayoutX(50);
        label.setLayoutY(20);

        root.getChildren().add(label);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Strategy Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
