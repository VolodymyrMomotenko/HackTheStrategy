package simulator.core.player;

import simulator.core.Colour;
import java.util.Random;

public class BotPlayer extends Player{
    public BotPlayer(Colour colour)
    {
        super(colour);
    }

    public void botScript(){
        Random random = new Random();
    
        int choice = random.nextInt(4);

        switch(choice){
            case 0:
                // case 1 SKIP the turn to collect more money
                break;
            case 1:
                // case 2 aquire an adjoining TILE (if there's enough money)
                if(this.getWealth() < 10){
                    break;
                }
                else{
                    // buy a tile

                    break;
                }
                
            case 2:
                // case 3 get a FARM for a random tile (if there's enough money)
                if(this.getWealth() < 8){
                    break;
                }
                else{
                    // get a farm
                    break;
                }
            case 3:
                // check if there is a MINE and order a mine if there is one unless there is not enough money
                if(this.getWealth() < 15){
                    break;
                }
                else{
                    // check for a MINE
                    // if there is a mine nearby - buy it
                    break;
                }
            default:
                // skip the turn :)
        }
    }
}
