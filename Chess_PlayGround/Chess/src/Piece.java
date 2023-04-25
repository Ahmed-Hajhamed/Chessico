import javax.swing.*;

public interface Piece {


    public void move(int position);
    public int[] Moves(Pieces piece);

    public void validMoves(Tile[] board , JButton[] tile);

    public void kill();                     //not interface
}
