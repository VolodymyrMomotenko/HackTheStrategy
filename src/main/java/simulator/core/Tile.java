package simulator.core;

import simulator.core.pointsOfInterest.InterestPoint;

public class Tile
{
    public int file;
    public int rank;
    public InterestPoint interestPoint;
    public Colour colour;

    public Tile(int file, int rank)
    {
        this.file = file;
        this.rank = rank;

    }

    public void setInterestPoint(InterestPoint interestPoint)
    {
        this.interestPoint = interestPoint;
    }

    public void setColour(Colour colour)
    {
        this.colour = colour;
    }

    public InterestPoint getInterestPoint()
    {
        return interestPoint;
    }

    public Colour getColour()
    {
        return colour;
    }
}
