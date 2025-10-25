package simulator.gui;

import java.util.List;
import java.util.Optional;

import javax.swing.text.Position;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import simulator.core.Colour;
import simulator.core.game.Game;

public class Board extends GridPane {
    private static final int SQUARE_SIZE = 80;
    private final Game game;
    private Square[][] squares = new Square[10][10];

    private Integer selectedFile = null;
    private Integer selectedRank = null;

    
    public boolean shouldFlip = true;
    public Colour colourDisplayPerspective = Colour.WHITE; 
    public BoardWithBorders border = null;

    public Board(Game game)
    {
        this.game = game;
        initializeBoard();
        //setupFlipControls();
        //updatePosition();
    }

    private void initializeBoard()
    {
        getChildren().clear();
        
        for (int rank = 0; rank < 10; rank++)
        {
            for (int file = 0; file < 10; file++)
            {
                Color squareColor = (file + rank) % 2 == 0 ? Color.rgb(240, 240, 240) : Color.rgb(231, 231, 231);
                Square squarePane = new Square(squareColor, SQUARE_SIZE);
                squares[file][rank] = squarePane;
                add(squarePane, file, rank);

                setSquareHandler(squarePane, file, 9-rank); // to make sure square is correct square
                
            }
        }
    }

    // needs to be a seperste function because lambda wants final variables
    private void setSquareHandler(Square square, final int file, final int rank)
    {
        square.setOnMouseClicked(e -> handleSquareClick(file, rank));
    }

    private void handleSquareClick(int file, int rank)
    {

        highlightSelection(file, rank);

    }


    private void highlightSelection(int file, int rank)
    {
        rank = colourDisplayPerspective == Colour.WHITE ? 9 - rank : rank;

        Square pane = squares[file][rank];
        Rectangle highlight = new Rectangle(SQUARE_SIZE, SQUARE_SIZE, Color.YELLOW);
        highlight.setOpacity(0.5);
        pane.setHighlight(highlight);
    }

    private void clearSelections()
    {
        for (int f = 0; f < 10; f++)
        {
            for (int r = 0; r < 10; r++)
            {
                Square pane = squares[f][r];
                pane.setHighlight(null);
            }
        }
    }

    public int getSquareSize()
    {
        return SQUARE_SIZE;
    }
    
    private void showAlert(String messege)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(messege);

        alert.showAndWait();
    }
}
