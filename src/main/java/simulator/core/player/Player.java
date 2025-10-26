package simulator.core.player;

import simulator.core.Colour;

public abstract class Player {
    private Colour colour;
    private int wealth;
    private int tiles;
    private int mines;
    private int farms;
    private int income;

    public Player(Colour colour){
        this.colour = colour;
        this.wealth = 10;
        this.tiles = 4;
        this.mines = 0;
        this.farms = 0;
        this.income = 0;
    }

    // getters
    public Colour getColour(){
        return this.colour;
    }

    public int getWealth(){
        return this.wealth;
    }

    public int getTiles(){
        return this.tiles;
    }

    public int getMines(){
        return this.mines;
    }

    public int getFarms(){
        return this.farms;
    }

    public int getIncome(){
        return this.income;
    }


    // kinda setters (more like adders)
    public void addWealth(){
        this.wealth += this.income;
    }

    public void addIncome(){
        this.income = this.tiles + this.mines * 4 + this.farms * 2;
    }

    public void addOneTile(){
        this.tiles += 1;
    }

    public void addOneMine(){
        this.mines += 1;
    }

    public void addOneFarm(){
        this.farms += 1;
    }

    public void substractWealth(int price){ this.wealth -= price; }
}
