import java.util.List;
import java.util.*;
class Game
{
    public enum Piece { Empty , X , O};

    static int[][] winConditions = new int[][]
    {
        { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
        { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
        { 0, 4, 8 }, { 2, 4, 6 }
    };

    public Piece[] Grid = new Piece[9];

    public Piece CurrentTurn = Piece.X;

    int Choice = 0;

    public Piece Computer;
    public Piece Player;

    public Game()
    {
        CurrentTurn = Piece.X;
        Player = Piece.X;
        MakeMove(1);
        MakeMove(2);
        MakeMove(3);

    }

    public void Reset()
    {
        CurrentTurn = Piece.X;
        SetPlayer(Piece.X);
        Grid = new Piece[9];
    }

    public void SetPlayer(Piece Player)
    {
        this.Player = Player;
        this.Computer = switchPiece(Player);
    }

    public void MakeMove(int Move)
    {
        if(CurrentTurn == Player)
        {
            Grid = makeGridMove(Grid, CurrentTurn, Move);
            CurrentTurn = switchPiece(CurrentTurn);
        }
        else if(CurrentTurn == Computer)
        {
            minimax(cloneGrid(Grid), CurrentTurn);
            Grid = makeGridMove(Grid, CurrentTurn, Choice);
            CurrentTurn = switchPiece(CurrentTurn);
            System.out.println(Choice);
        }
    }

    int minimax(Piece[] InputGrid, Piece Player)
    {
        Piece[] Grid = cloneGrid(InputGrid);

        if (checkScore(Grid, Computer) != 0)
            return checkScore(Grid, Computer);
        else if (checkGameEnd(Grid)) return 0;

        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Integer> moves = new ArrayList<>();

        for (int i = 0; i < 9; i++)
        {
            if (Grid[i] == Piece.Empty)
            {
                scores.add(minimax(makeGridMove(Grid, Player, i), switchPiece(Player)));
                moves.add(i);
            }
        }

        if(Player == Computer)
        {

            int MaxScoreIndex = scores.indexOf(Collections.max(scores));
            Choice = moves.get(MaxScoreIndex);
            return Collections.max(scores);
        }
        else
        {
            int MinScoreIndex = scores.indexOf(Collections.min(scores));
            Choice = moves.get(MinScoreIndex);
            return Collections.min(scores);
        }
    }

    static int checkScore(Piece[] Grid, Piece Player)
    {
        if (checkGameWin(Grid, Player)) return 10;

        else if (checkGameWin(Grid, switchPiece(Player))) return -10;

        else return 0;
    }

    static boolean checkGameWin(Piece[] Grid, Piece Player)
    {
        for(int i = 0; i < 8; i++)
        {
            if
                    (
                    Grid[winConditions[i][0]] == Player &&
                Grid[winConditions[i][1]] == Player &&
                Grid[winConditions[i][2]] == Player
            )
            {
                return true;
            }
        }
        return false;
    }

    static boolean checkGameEnd(Piece[] Grid)
    {
        for (Piece p : Grid) if (p == Piece.Empty) return false;
        return true;
    }

    static Piece switchPiece(Piece Piece)
    {
        if (Piece == Piece.X) return Piece.O;
        else return Piece.X;
    }

    static Piece[] cloneGrid(Piece[] Grid)
    {
        Piece[] Clone = new Piece[9];
        for (int i = 0; i < 9; i++) Clone[i] = Grid[i];

        return Clone;
    }

    static Piece[] makeGridMove(Piece[] Grid, Piece Move, int Position)
    {
        Piece[] newGrid = cloneGrid(Grid);
        newGrid[Position] = Move;
        return newGrid;
    }

    public static void main(String a[]){
        Game game = new Game();

    }
}