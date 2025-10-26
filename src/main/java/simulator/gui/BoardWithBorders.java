package simulator.gui;

import simulator.core.Colour;
import simulator.core.game.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardWithBorders extends GridPane
{
    private static final int SQUARE_SIZE = 80;
    private final Board board;
    private VBox sidePanel;
    private Label coordinateLabel1, coordinateLabel2, coordinateLabel3, coordinateLabel4;

    public BoardWithBorders(Game game)
    {
        this.board = new Board(game);
        setupCombinedLayout();
    }

    private void setupCombinedLayout()
    {
        sidePanel = new VBox(10);
        sidePanel.setPadding(new Insets(20));
        sidePanel.setPrefWidth(200);
        
         
        coordinateLabel1 = new Label("Your Stats:\n$ : " + "\nIncome per turn $ : " + "\nZones : " + "\nMines : " + "\nFarms : ");

        coordinateLabel2 = new Label("Bot 1");

        coordinateLabel3 = new Label("Bot 2");

        coordinateLabel4 = new Label("Bot 3");

        Button endTurnButton = new Button("End Turn");
        
        sidePanel.getChildren().addAll(coordinateLabel1,coordinateLabel2, coordinateLabel3, coordinateLabel4, endTurnButton);
        
        // board is not board with the sidelabel
        buildCoordinateSystem(); // square from (0, 0) to (11, 11)
        add(sidePanel, 12, 0, 1, 12); // Add sidepanel for col 12
    }

    public void connectBoardToThis()
    {
        board.border = this;
    }

    private void buildCoordinateSystem() {
        
        setGridLinesVisible(false);
        
        addEmptySquare(0, 0); // top left
        addEmptySquare(11, 0); // top right
        addEmptySquare(0, 11); // bottom left
        addEmptySquare(11, 11); // bottom right

        
        for (int file = 0; file < 10; file++)
        {
            
            addEmptySquare(1 + file, 0); // top border
            addEmptySquare(1 + file, 11); // bottom border
        }

        for (int rank = 0; rank < 10; rank++)
        {   
            addEmptySquare(0, 1 + rank); // left border
            addEmptySquare(11, 1 + rank); // right border
        }

        add(board, 1, 1, 10, 10);
    }

    private void addEmptySquare(int col, int row)
    {
        Rectangle empty = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
        empty.setFill(Color.BLACK);
        add(empty, col, row);
    }
}