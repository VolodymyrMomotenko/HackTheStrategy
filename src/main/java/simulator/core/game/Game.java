package simulator.core.game;


import java.util.ArrayList;
import java.util.List;

import simulator.core.Colour;
import simulator.core.Position;
import simulator.core.player.Player;

public abstract class Game
{
    protected String firstplayer;
    protected Position position;
    protected Position cachedCurrentPosition;

    protected Player[] players = new Player[4];

    private int moveCounter; // for 50 move rule

    private Boolean isGameEnd = false;

    
    public Game(String p1, Position startingPosition)
    {
        this.firstplayer = p1;
        this.position = startingPosition;
    }

    // Overloaded constructor for games that generate their starting position
    public Game(String p1)
    {
        this(p1, null);
        initializePosition();
    }

    protected abstract void initializePosition();

    public Position getPosition()
    {
        return position;
    }

    public String getFirstPlayer()
    {
        return firstplayer;
    }

    public Boolean hasGameEnded()
    {
        return isGameEnd;
    }

}
