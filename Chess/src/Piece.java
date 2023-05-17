import javax.swing.*;
import java.util.ArrayList;

public interface Piece {
    boolean move(int fromPosition,int toPosition,Tile[] board,JButton[] tile, Pieces pieceType);
    ArrayList<Integer> Moves(Pieces piece,Tile[] board,JButton[] tile, int currentPosition);
    void newTurn();
    int returnNumberOfMoves();
    boolean moved();
}