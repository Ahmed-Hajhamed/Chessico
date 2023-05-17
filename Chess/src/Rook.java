import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Rook extends Non_King {
    ImageIcon rook_b = new ImageIcon("rook_b.png");
    ImageIcon rook_w = new ImageIcon("rook_w.png");
    String type="Rook";
    boolean moved=false;
    int numberOfMoves;
    Side distinationSide;
    String distinationType;
    boolean distinationOccupied;

    Rook(Side side, int position) {
        super(side, position);
    }

    @Override
    public boolean move(int fromposition,int toposition,Tile[] board,JButton[] tile, Pieces piecetype) {
        if (tile[toposition].getBackground() == Color.GREEN)
        {
            tile[fromposition].setIcon(null);
            if (board[fromposition].getSide() == Side.Black) {
                tile[toposition].setIcon(rook_b);
                board[toposition].setSide(Side.Black);
            }
            else if (board[fromposition].getSide() == Side.White){
                tile[toposition].setIcon(rook_w);
                board[toposition].setSide(Side.White);
            }

            board[toposition].setType(this.type);
            board[toposition].setCurrentPiece(piecetype);
            board[toposition].setOccupied(true);
            board[fromposition].setOccupied(false);
            board[fromposition].setType(null);
            board[fromposition].setCurrentPiece(Pieces.NoPiece);
            board[fromposition].setSide(Side.Blank);
            this.moved=true;

            return true;
        }
        return false;

    }

    @Override
    public ArrayList<Integer> Moves(Pieces piece,Tile[] board,JButton[] tile, int currentpos) {
        ArrayList<Integer> valid= new ArrayList<Integer>();
        this.numberOfMoves=0;
        int position_temp=currentpos;
        if (piece.ordinal() == 0 || piece.ordinal()==1 || piece.ordinal()==2 || piece.ordinal()==3) {


            while (position_temp % 8 != 7) {
                valid.add(++position_temp);
                if(board[valid.get(valid.size()-1)].isOccupied())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.RookW1||piece==Pieces.RookW2)
                    {
                        validMove(currentpos,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.RookB1||piece==Pieces.RookB2){
                        validMove(currentpos,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                        returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                    if(piece==Pieces.RookW1||piece==Pieces.RookW2)
                    {
                        validMove(currentpos,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.RookB1||piece==Pieces.RookB2){
                        validMove(currentpos,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                }


            }
            position_temp=currentpos;
            while (position_temp % 8 != 0) {
                valid.add(--position_temp);
                if(board[valid.get(valid.size()-1)].isOccupied())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.RookW1||piece==Pieces.RookW2)
                    {
                        validMove(currentpos,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.RookB1||piece==Pieces.RookB2){
                        validMove(currentpos,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                        returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                    if(piece==Pieces.RookW1||piece==Pieces.RookW2)
                    {
                        validMove(currentpos,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.RookB1||piece==Pieces.RookB2){
                        validMove(currentpos,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                }


            }
            position_temp=currentpos;
            while (position_temp<=55) {
                position_temp += 8;
                valid.add(position_temp);
                if(board[valid.get(valid.size()-1)].isOccupied())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.RookW1||piece==Pieces.RookW2)
                    {
                        validMove(currentpos,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.RookB1||piece==Pieces.RookB2){
                        validMove(currentpos,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                        returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                    if(piece==Pieces.RookW1||piece==Pieces.RookW2)
                    {
                        validMove(currentpos,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.RookB1||piece==Pieces.RookB2){
                        validMove(currentpos,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                }



            }
            position_temp=currentpos;
            while (position_temp >=8) {
                position_temp -= 8;
                valid.add(position_temp);
                if(board[valid.get(valid.size()-1)].isOccupied())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.RookW1||piece==Pieces.RookW2)
                    {
                        validMove(currentpos,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.RookB1||piece==Pieces.RookB2){
                        validMove(currentpos,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                        returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                    if(piece==Pieces.RookW1||piece==Pieces.RookW2)
                    {
                        validMove(currentpos,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.RookB1||piece==Pieces.RookB2){
                        validMove(currentpos,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                }



            }

        }

        return valid ;
    }

    @Override
    public void newTurn() {
        int i = 0;
        for (int j = 0; j < 64; j++) {

            if (i % 2 == 0) {
                if (j % 2 == 0)
                    Board.piece[j].setBackground(Settings.lightColour);
                else Board.piece[j].setBackground(Settings.darkColour);

            } else if (i % 2 != 0) {
                if (j % 2 == 0)
                    Board.piece[j].setBackground(Settings.darkColour);
                else Board.piece[j].setBackground(Settings.lightColour);

            }
            if (j % 8 == 7)
                i++;
        }
    }


    public void validMove(int currentpos,int nextpos,Side side,Tile[]board)
    {
        board[currentpos].setSide(side.Blank);
        board[currentpos].setOccupied(false);
        board[currentpos].setType(null);
        distinationSide=board[nextpos].getSide();
        distinationType=board[nextpos].getType();
        distinationOccupied=board[nextpos].isOccupied();
        board[nextpos].setSide(side);
        board[nextpos].setType("Rook");
        board[nextpos].setOccupied(true);
    }

    public void returnMove(int currentpos,int nextpos,Tile[]board)
    {
        board[currentpos].setType("Rook");
        board[currentpos].setOccupied(true);
        board[nextpos].setSide(distinationSide);
        board[nextpos].setType(distinationType);
        board[nextpos].setOccupied(distinationOccupied);
    }

    public void checkCheck(int array_num,int position,int currentpos,Side side,Tile[]board,JButton[]tile)
    {
        if(Game.kings[array_num].isChecked(Game.kings[array_num].getPosition(),board, side))
        {
            tile[position].setBackground(Color.RED);
            board[currentpos].setSide(side);
            Game.kings[array_num].checkersNum=0;
            Game.kings[array_num].checkers.clear();
        }else {
            tile[position].setBackground(Color.GREEN);
            board[currentpos].setSide(side);
            this.numberOfMoves++;
        }
    }
    @Override
    public int returnNumberOfMoves() {
        return numberOfMoves;
    }
    @Override
    public boolean moved() {
        return moved;
    }
}
