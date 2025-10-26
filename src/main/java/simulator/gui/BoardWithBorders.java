package simulator.gui;

import simulator.core.Colour;
import simulator.core.game.Game;

import java.beans.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import simulator.core.player.HumanPlayer;
import simulator.core.player.Player;
import simulator.core.pointsOfInterest.Farm;
import simulator.core.pointsOfInterest.Zone;

public class BoardWithBorders extends GridPane
{
    private static final int SQUARE_SIZE = 80;
    private final Board board;
    private VBox sidePanel;
    private Label coordinateLabel1, coordinateLabel2;
    public Player player;

    public BoardWithBorders(Game game)
    {
        this.board = new Board(game);
        player = game.getCurrentPlayer();
        setupCombinedLayout();
    }

    private void setupCombinedLayout()
    {
        sidePanel = new VBox(10);
        sidePanel.setPadding(new Insets(20));
        sidePanel.setPrefWidth(200);


        coordinateLabel1 = new Label("Your Stats:\n$ : " + player.getWealth()
                + "\nIncome per turn $ : " + player.getIncome()
                + "\nZones : " + player.getTiles()
                + "\nMines : " + player.getMines()
                + "\nFarms : " + player.getFarms()
                + "\nYour colour: " + player.getColour());

        coordinateLabel2 = new Label("No Selection");

        Button buyZone = new Button("Buy a zone");
        Button buildFarm = new Button("Build a farm for 8");
        Button endTurnButton = new Button("End Turn");

        endTurnButton.setOnAction(e -> handleEndTurn());
        buildFarm.setOnAction(e -> handleBuildFarm());
        buyZone.setOnAction(e -> handleBuyZone());
        
        
        sidePanel.getChildren().addAll(coordinateLabel1, coordinateLabel2, buyZone, buildFarm, endTurnButton);
        
        // board is not board with the sidelabel
        buildCoordinateSystem(); // square from (0, 0) to (11, 11)
        add(sidePanel, 12, 0, 1, 12); // Add sidepanel for col 12
    }

    private void handleBuyZone()
    {
        Game game = board.getGame();
    
        Player currentPlayer = game.getCurrentPlayer();

        if(game.getPosition().canAquire(board.getSelecteFile(), board.getSelectedRank()))
        {
            currentPlayer.substractWealth(4);
            if (currentPlayer instanceof HumanPlayer)
                updateStatsDisplay();
            game.getPosition().getTile(board.getSelecteFile(), board.getSelectedRank()).setInterestPoint(new Zone());
            game.getPosition().getTile(board.getSelecteFile(), board.getSelectedRank()).setColour(game.getPosition().getTurn());
            game.getPosition().nextTurn();
            board.updateBoard();
        }
        else
        {
            coordinateLabel2.setText("Can;t buy!");
        }
    }

    private void handleBuildFarm()
    {
        Game game = board.getGame();
    
        Player currentPlayer = game.getCurrentPlayer();

        if(game.getPosition().isOwned(board.getSelecteFile(), board.getSelectedRank()))
        {
            currentPlayer.substractWealth(8);
            if (currentPlayer instanceof HumanPlayer)
                updateStatsDisplay();
            game.getPosition().getTile(board.getSelecteFile(), board.getSelectedRank()).setInterestPoint(new Farm());
            game.getPosition().nextTurn();
            board.updateBoard();
        }
        else
        {
            coordinateLabel2.setText("Can;t buy!");
        }
    }

    private void handleEndTurn()
    {
        Game game = board.getGame();
    
        
        Player currentPlayer = game.getCurrentPlayer();
        currentPlayer.addIncome();
        currentPlayer.addWealth(); 
        if (currentPlayer instanceof HumanPlayer)
            updateStatsDisplay();
        board.updateBoard();
        game.getPosition().nextTurn();

        System.out.println(game.getCurrentPlayer().getColour());
    }

    public void updateStatsDisplay()
    {
        coordinateLabel1.setText("Your Stats:\n$ : " + player.getWealth()
                + "\nIncome per turn $ : " + player.getIncome()
                + "\nZones : " + player.getTiles()
                + "\nMines : " + player.getMines()
                + "\nFarms : " + player.getFarms()
                + "\nYour colour: " + player.getColour());
    }


    public void updateSelectionInfo()
    {
        if (board.getselectedSquare() == null)
        {
            coordinateLabel2.setText("No Selection");
        }
        else
        {
            String message = String.format("Selected: (%d, %d)", board.getSelecteFile(), board.getSelectedRank());

            if (board.getGame().getPosition().isOwned(board.getSelecteFile(), board.getSelectedRank()))
            {
                message += "\nYou may build a farm here!";
            }
            else if (board.getGame().getPosition().canAquire(board.getSelecteFile(), board.getSelectedRank()))
            {
                message += "\nYou may buy this piece of land";
            }
            else
            {
                message += "\nYou can't do anything with it";
            }
            coordinateLabel2.setText(message);
        }
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