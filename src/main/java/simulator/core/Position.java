package simulator.core;

import java.util.ArrayList;

import simulator.core.player.Player;
import simulator.core.pointsOfInterest.InterestPoint;

public class Position
{
    //private static final int BOARD_SIZE = 10;

    private Tile[][] board = new Tile[10][10]; // empty board
    private Colour turn;
     

    public Position(Tile[][] board, Colour turn)
    {
        this.board = board;
        this.turn = turn;
    }

    public Boolean isOwned(int file, int rank){
        return getTile(file, rank).getColour() == turn;
    }

    public Boolean canAquire(int file, int rank){
        // fist chech whether the tile is already taken by somebody
        if (getTile(file, rank).getColour() != null) return false;

        ArrayList<Tile> neighbours = getNeighbours(file, rank);

        for(Tile tile : neighbours){
            if(tile.getColour() == turn){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Tile> getNeighbours(int file, int rank){
        ArrayList<Tile> neighbours = new ArrayList<>();

        if (isInBounds(file+1, rank)) neighbours.add(getTile(file+1, rank));
        if (isInBounds(file-1, rank)) neighbours.add(getTile(file-1, rank));
        if (isInBounds(file, rank+1)) neighbours.add(getTile(file, rank+1));
        if (isInBounds(file, rank-1)) neighbours.add(getTile(file, rank-1));

        return neighbours;
    }

    public Boolean isInBounds(int file, int rank){
        return (0 <= file && file < 10 && rank >= 0 && rank < 10);
    }


    public Tile[][] deepCopyBoard()
    {
        Tile[][] newBoard = new Tile[10][10];

        for(int row = 0; row < board.length; row ++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                newBoard[row][col] = board[row][col];
            }
        }

        return newBoard;
    }

    public Tile getTile(int file, int rank)
    {
        return board[file][rank];
    }

    public void buyTile(int file, int rank)
    {
        if (canAquire(file, rank)){
            getTile(file, rank).setColour(turn);
        }
    }

    public void printBoard()
    {
        // nice representation of board for debugging
        for(int rank = board.length-1; rank >= 0; rank --)
        {
            for (int file = 0; file < board[0].length; file++)
            {
                if(board[file][rank] == null)
                {
                    System.out.print("□□□ ");
                }else
                {
                    System.out.print(board[file][rank]+ " ");
                }
            }

            System.out.println();
        }
    }

}