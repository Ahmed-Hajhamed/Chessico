import javax.swing.*;
import java.awt.*;

public class Queen extends Non_King {

    Queen(Side side, int position) {
        super(side, position);
    }
    int[] valid= new int[27];;

    @Override
    public void move(int position) {
for (int i=0; i<27; i++) {
	valid[i]=64;
}

move (position);
    }

    @Override
    public int[] Moves(Pieces piece) {
        int position_temp=position;
        if (piece.ordinal() == 0 || piece.ordinal()==1) {
            int i = 0;   int moves=0;
            int left=0; int above=0;
            int right=0; int below=0;
            while (i < 27) {
                while (position_temp % 8 != 7) {
                    valid[i] = position_temp= position_temp + 1;
                    i++;
                    right++;
                }
                position_temp=position;
                while ((position_temp+8) / 8 != 8) {
                    valid[i] =position_temp= position_temp + 8;
                    i++;
                    below++;
                }
                
                
               position_temp=position;
                while (position_temp % 8 != 0) {
                    valid[i] = position_temp= position_temp - 1;
                    i++;
                    left++;
                }
                
                position_temp=position;
                while (position_temp / 8 != 0) {
                    valid[i] = position_temp=position_temp - 8;
                    i++;
                    above++;
                }
             position_temp = position;
               
                moves = Math.max(right , below);
                while (moves > 1) {
                	valid[i] = position_temp +8 * moves + moves;
                	moves--;
                	i++;
                }
                position_temp = position;
                moves = Math.max(left , below);
                while (moves > 0) {
                	valid[i] = position_temp +8 * moves - moves;
                	moves--;
                	i++;
                }
                position_temp = position;
                moves = Math.max(right , above);
                while (moves > 0) {
                	valid[i] = position_temp -8 * moves + moves;
                	moves--;
                	i++;
                }
               position_temp = position;  
                moves = Math.max(left , above);
                while (moves > 0) {
                	valid[i] = position_temp -8 * moves - moves;
                	moves--;
                	i++;
                }
                
               

            }
        }
        return valid;
    }

    @Override
    public void validMoves(Tile[] board , JButton[] tile) {

        for (int i=0; i<27 ; i++)
        {
            if (board[valid[i]].isOccupied() && valid[i] !=64)
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
