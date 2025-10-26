package simulator.core.game;

import simulator.core.Colour;
import simulator.core.Position;
import simulator.core.Tile;
import simulator.core.pointsOfInterest.InterestPoint;
import simulator.core.pointsOfInterest.Mine;
import simulator.gui.InterestPointRender;

public class Game3bots extends Game
{

    public Game3bots(String p1, String p2)
    {
        super(p1, p2);
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

        board[0][1].setInterestPoint(new Mine());

        // Set the starting position
        this.startingPosition = new Position(board, Colour.WHITE);
    }
}
