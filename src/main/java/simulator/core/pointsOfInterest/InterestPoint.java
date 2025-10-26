package simulator.core.pointsOfInterest;

public abstract class InterestPoint {
    int price;
    int valuePerTurn;

    public InterestPoint(int price, int valuePerTurn)
    {
        this.price = price;
        this.valuePerTurn = valuePerTurn;
    }
}
