package simulator.core.game;

import simulator.core.Colour;
import simulator.core.Position;
import simulator.core.Tile;
import simulator.core.player.Player;
import simulator.core.player.BotPlayer;
import simulator.core.player.HumanPlayer;
import simulator.core.pointsOfInterest.Farm;
import simulator.core.pointsOfInterest.InterestPoint;
import simulator.core.pointsOfInterest.Mine;
import simulator.core.pointsOfInterest.Zone;
import simulator.gui.InterestPointRender;

public class Game3bots extends Game
{

    public Game3bots(String p1)
    {
        super(p1);
        this.players[0] = new HumanPlayer(Colour.RED);
        this.players[1] = new BotPlayer(Colour.BLUE);
        this.players[2] = new BotPlayer(Colour.YELLOW);
        this.players[3] = new BotPlayer(Colour.GREEN);
    }


    @Override
    protected void initializePosition()
    {
        // Create an empty board for now
        Tile[][] board = new Tile[10][10];

        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
                board[x][y] = new Tile(x, y);
        }

        board[3][3].setInterestPoint(new Mine());
        board[3][6].setInterestPoint(new Mine());
        board[6][3].setInterestPoint(new Mine());
        board[6][6].setInterestPoint(new Mine());


        board[0][0].setInterestPoint(new Farm());




        board[0][0].setColour(Colour.RED);
        board[9][0].setColour(Colour.GREEN);
        board[9][9].setColour(Colour.YELLOW);
        board[0][9].setColour(Colour.BLUE);

        // Set the starting position
        this.position = new Position(board, Colour.RED);
    }
}
