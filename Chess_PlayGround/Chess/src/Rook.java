import javax.swing.*;
import java.awt.*;

public class Rook extends Non_King {

    Rook(Side side, int position) {
        super(side, position);
    }
    int[] valid= new int[14];;

    @Override
    public void move(int position) {

    }

    @Override
    public int[] Moves(Pieces piece) {
        if (piece.ordinal() == 0) {
            int i = 0;
            int j = 1;
            int k = 1;
            int l = 1;
            while (i < 14) {
                while (position % 8 != 7) {
                    valid[i] = position + j;
                    i++;
                    j++;
                }
                while (position % 8 != 0) {
                    valid[i] = position - k;
                    i++;
                    k++;
                }
                while ((position + 8 * l) / 8 != 7) {
                    valid[i] = position + 8 * l;
                    l++;
                    i++;
                }
                while ((position + 8 * l) / 8 != 0) {
                    valid[i] = position - 8 * l;
                    l++;
                    i++;
                }

            }
        }
        return valid;
    }

    @Override
    public void validMoves(Tile[] board , JButton[] tile) {
        for (int i=0; i<14 ; i++)
        {
            if (board[valid[i]].isOccupied())
            {
                tile[valid[i]].setBackground(Color.RED);
            }
            else tile[valid[i]].setBackground(Color.GREEN);
        }
    }

    @Override
    public void kill() {

    }
}
