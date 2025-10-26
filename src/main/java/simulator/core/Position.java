package simulator.core;


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