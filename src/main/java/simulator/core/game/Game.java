package simulator.core.game;


import java.util.ArrayList;
import java.util.List;

import simulator.core.Colour;
import simulator.core.Position;

public abstract class Game
{
    protected String whitePlayer; // may store Addr of playent if i ever make it a web-application
    protected String blackPlayer;
    protected Position startingPosition;
    protected Position cachedCurrentPosition;

    private int moveCounter; // for 50 move rule

    private Boolean isGameEnd = false;

    
    public Game(String p1, String p2, Position startingPosition)
    {
        this.whitePlayer = p1;
        this.blackPlayer = p2;
        this.startingPosition = startingPosition;
    }

    // Overloaded constructor for games that generate their starting position
    public Game(String p1, String p2)
    {
        this(p1, p2, null);
        initializePosition();
    }

    protected abstract void initializePosition();

    public Position getStartingPosition()
    {
        return startingPosition;
    }

    public String getWhitePlayer()
    {
        return whitePlayer;
    }


    public String getBlackPlayer()
    {
        return blackPlayer;
    }


    public Boolean hasGameEnded()
    {
        return isGameEnd;
    }

}
