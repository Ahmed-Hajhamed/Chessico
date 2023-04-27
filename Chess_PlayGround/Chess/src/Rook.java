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
        int position_temp=position;
        if (piece.ordinal() == 0 || piece.ordinal()==1) {
            int i = 0;
            while (i < 14) {
                while (position_temp % 8 != 7) {
                    valid[i] = position_temp= position_temp + 1;
                    i++;;
                }
                position_temp=position;
                while (position_temp % 8 != 0) {
                    valid[i] = position_temp= position_temp - 1;
                    i++;
                }
                position_temp=position;
                while ((position_temp+8) / 8 != 8) {
                    valid[i] =position_temp= position_temp + 8;
                    i++;
                }
                position_temp=position;
                while (position_temp / 8 != 0) {
                    valid[i] = position_temp=position_temp - 8;
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
