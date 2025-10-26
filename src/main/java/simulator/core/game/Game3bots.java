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

        // Set the starting position
        this.startingPosition = new Position(board, Colour.WHITE);
    }
}
