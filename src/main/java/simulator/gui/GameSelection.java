package simulator.gui;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import simulator.core.game.Game;
import simulator.core.game.Game3bots;

public class GameSelection extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Label title = new Label("Select game type");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        Button standardButton = new Button("3 bots 1 player");
        standardButton.setOnAction(e -> launchGame(new Game3bots("Hooman")));
        
        root.getChildren().addAll(title, standardButton);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game mode selection");
        primaryStage.show();
    }
    
    private void launchGame(Game game)
    {
        Stage gameStage = new Stage();
        BoardWithBorders board = new BoardWithBorders(game);
        board.connectBoardToThis();

        Scene gameScene = new Scene(board);
        gameStage.setScene(gameScene);
        gameStage.setTitle("skibidi Toalety");
        gameStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
