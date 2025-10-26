package simulator.gui;

import java.nio.charset.MalformedInputException;
import java.util.List;
import java.util.Optional;


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
import simulator.core.Position;
import simulator.core.Tile;
import simulator.core.game.Game;
import simulator.core.pointsOfInterest.InterestPoint;
import simulator.core.pointsOfInterest.Mine;

public class Board extends GridPane {
    private static final int SQUARE_SIZE = 80;
    private final Game game;
    private Square[][] squares = new Square[10][10];

    private Square selectedSquare = null;
    private int selectedFile = -1;
    private int selectedRank = -1;

    
    public boolean shouldFlip = true;
    public BoardWithBorders border = null;

    public Board(Game game)
    {
        this.game = game;
        initializeBoard();
        //setupFlipControls();
        updateBoard();
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

                InterestPoint point = game.getPosition().getTile(file, 9-rank).getInterestPoint();
                InterestPointRender render = point == null ? null : new InterestPointRender(point);
                squarePane.setPoint(render);

                squares[file][rank] = squarePane;
                add(squarePane, file, rank);

                setSquareHandler(squarePane, file, 9-rank); // to make sure square is correct square
                
            }
        }
    }

    private void updateBoard()
    {
        Position current = game.getPosition();
        
        for (int rank = 0; rank < 10; rank++)
        {
            for (int file = 0; file < 10; file++)
            {
                int displayRank = 9 - rank;

                Tile piece = current.getTile(file, displayRank);
                Color squareColor = (file + rank) % 2 == 0 ? Color.rgb(240, 240, 240) : Color.rgb(231, 231, 231);
                
                Colour tileColour = piece.getColour();
                if (tileColour != null)
                {
                    switch(tileColour)
                    {
                        case Colour.RED:
                            squareColor = Color.RED;
                            break;
                        case Colour.BLUE:
                            squareColor = Color.BLUE;
                            break;
                        case Colour.GREEN:
                            squareColor = Color.GREEN;
                            break;
                        case Colour.YELLOW:
                            squareColor = Color.YELLOW;
                            break;
                        default:
                    }
                }

                squares[file][rank].setColour(squareColor);
                InterestPoint point = game.getPosition().getTile(file, 9-rank).getInterestPoint();
                InterestPointRender render = point == null ? null : new InterestPointRender(point);
                squares[file][rank].setPoint(render);
                //System.out.println("File: " + file + " Rank: " + rank + " Colour " + tileColour + " point " + point);
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
        clearSelections();
        if (selectedSquare == null || selectedSquare != squares[file][rank])
        {
            highlightSelection(file, rank);
            selectedSquare = squares[file][rank];
            selectedFile = file;
            selectedRank = rank;
        }
        else
        {
            selectedSquare = null;
        }

    }


    private void highlightSelection(int file, int rank)
    {
        rank = 9 - rank;

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

    public Square getselectedSquare()
    {
        return selectedSquare;
    }

    public int getSelectedRank()
    {
        return selectedRank;
    }

    public int getSelecteFile()
    {
        return selectedFile;
    }
}
