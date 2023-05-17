import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Non_King {
    ImageIcon pawn_b = new ImageIcon("pawn_b.png");
    ImageIcon pawn_w = new ImageIcon("pawn_w.png");
    Side distinationSide;
    String destinationType;
    boolean destinationOccupied;
    String type="Pawn";
    int numberOfMoves;
    Pawn(Side side, int position) {super(side, position);}

    @Override
    public boolean move(int fromPosition, int toPosition, Tile[] board, JButton[] tile, Pieces pieceType) {
        if (tile[toPosition].getBackground() == Color.GREEN )
        {
            tile[fromPosition].setIcon(null);
            if (board[fromPosition].getSide() == Side.Black) {
                tile[toPosition].setIcon(pawn_b);
                board[toPosition].setSide(Side.Black);
            }
            else if (board[fromPosition].getSide() == Side.White) {
                tile[toPosition].setIcon(pawn_w);
                board[toPosition].setSide(Side.White);
            }

            board[toPosition].setType(this.type);
            board[toPosition].setCurrentPiece(pieceType);
            board[toPosition].setOccupied(true);
            board[fromPosition].setOccupied(false);
            board[fromPosition].setType(null);
            board[fromPosition].setCurrentPiece(Pieces.NoPiece);
            board[fromPosition].setSide(Side.Blank);
            if (board[toPosition].getSide() ==Side.Black)
            {
                if (toPosition>=56 && toPosition<=63)
                    promote(Side.Black,toPosition);
            }
            else if (board[toPosition].getSide() ==Side.White) {
                if (toPosition >= 0 && toPosition <= 7)
                    promote(Side.White, toPosition);
            }
            return true;
        }
        return false;
    }
    @Override
    public ArrayList<Integer> Moves(Pieces piece, Tile[] board, JButton[] tile, int currentPosition) {
        ArrayList<Integer> valid_forward= new ArrayList<>();
        ArrayList<Integer> valid_diagonal= new ArrayList<>();
        this.numberOfMoves=0;

        if(piece.ordinal()>=16 && piece.ordinal()<=23){
            if(currentPosition>8&&currentPosition<15){
                valid_diagonal.add(0,currentPosition+7);
                valid_diagonal.add(1,currentPosition+9);
                valid_forward.add(0,currentPosition+8);
                if(!board[currentPosition+8].isOccupied()){
                    valid_forward.add(1,currentPosition+16);
                }
            }
            else if (currentPosition==8){
                valid_diagonal.add(0,17);
                valid_forward.add(0,16);
                if(!board[currentPosition+8].isOccupied()){
                    valid_forward.add(1,24);
                }
            }
            else if (currentPosition==15) {
                valid_diagonal.add(0,22);
                valid_forward.add(0,23);
                if(!board[currentPosition+8].isOccupied()){
                    valid_forward.add(1,31);
                }
            }
            else if(currentPosition%8==0){
                valid_forward.add(0,currentPosition+8);
                valid_diagonal.add(0,currentPosition+9);
            }
            else if ((currentPosition+1)%8==0) {
                valid_forward.add(0,currentPosition+8);
                valid_diagonal.add(0,currentPosition+7);
            }
            else if(currentPosition<56){
                valid_forward.add(0,currentPosition+8);
                valid_diagonal.add(0,currentPosition+7);
                valid_diagonal.add(1,currentPosition+9);
            }

        } else if (piece.ordinal()>=24 && piece.ordinal()<=31) {
            if(currentPosition>48&&currentPosition<55){
                valid_diagonal.add(0,currentPosition-7);
                valid_diagonal.add(1,currentPosition-9);
                valid_forward.add(0,currentPosition-8);
                if(!board[currentPosition-8].isOccupied()){
                    valid_forward.add(1,currentPosition-16);
                }
            }
            else if (currentPosition==48){
                valid_forward.add(0,40);
                valid_diagonal.add(0,41);
                if(!board[currentPosition-8].isOccupied()){
                    valid_forward.add(1,32);
                }
            } else if (currentPosition==55) {
                valid_forward.add(0,47);
                valid_diagonal.add(0,46);
                if(!board[currentPosition-8].isOccupied()){
                    valid_forward.add(1,39);
                }
            }
            else if(currentPosition%8==0){
                valid_forward.add(0,currentPosition-8);
                valid_diagonal.add(0,currentPosition-7);
            } else if ((currentPosition+1)%8==0) {
                valid_forward.add(0,currentPosition-8);
                valid_diagonal.add(0,currentPosition-9);
            }
            else if(currentPosition>7){
                valid_forward.add(0,currentPosition-8);
                valid_diagonal.add(0,currentPosition-7);
                valid_diagonal.add(1,currentPosition-9);
            }
        }
        for (int i=0;i<valid_forward.size();i++)
        {
            if (board[valid_forward.get(i)].isOccupied()&&board[valid_forward.get(i)].getSide()==board[currentPosition].getSide())
            {
                tile[valid_forward.get(i)].setBackground(Color.RED);
            }
            else {
                if(this.side==side.White)
                {
                    validMove(currentPosition,valid_forward.get(i),side.White,board);
                    checkCheck(0,valid_forward.get(i),currentPosition,side.White,board,tile);
                }else if(this.side==side.Black){
                    validMove(currentPosition,valid_forward.get(i),side.Black,board);
                    checkCheck(1,valid_forward.get(i),currentPosition,side.Black,board,tile);
                }
                returnMove(currentPosition,valid_forward.get(i),board);
            }
        }
        for (int i=0;i<valid_diagonal.size();i++)
        {
            if (board[valid_diagonal.get(i)].isOccupied()&&board[valid_diagonal.get(i)].getSide()!=board[currentPosition].getSide())
            {
                if(this.side==side.White)
                {
                    validMove(currentPosition,valid_diagonal.get(i),side.White,board);
                    checkCheck(0,valid_diagonal.get(i),currentPosition,side.White,board,tile);
                }else if(this.side==side.Black){
                    validMove(currentPosition,valid_diagonal.get(i),side.Black,board);
                    checkCheck(1,valid_diagonal.get(i),currentPosition,side.Black,board,tile);
                }
                returnMove(currentPosition,valid_diagonal.get(i),board);
            }
            else {
                tile[valid_diagonal.get(i)].setBackground(Color.RED);
            }
        }
        return null;
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

    public void promote(Side side, int currentpos){
        if (side==Side.Black)
            new Promotion_b(currentpos);
        else new Promotion_w(currentpos);
    }

    public void validMove(int currentpos,int nextpos,Side side,Tile[]board)
    {
        board[currentpos].setSide(side.Blank);
        board[currentpos].setOccupied(false);
        board[currentpos].setType(null);
        distinationSide=board[nextpos].getSide();
        destinationType=board[nextpos].getType();
        destinationOccupied=board[nextpos].isOccupied();
        board[nextpos].setSide(side);
        board[nextpos].setType("Pawn");
        board[nextpos].setOccupied(true);
    }

    public void returnMove(int currentpos,int nextpos,Tile[]board)
    {
        board[currentpos].setType("Pawn");
        board[currentpos].setOccupied(true);
        board[nextpos].setSide(distinationSide);
        board[nextpos].setType(destinationType);
        board[nextpos].setOccupied(destinationOccupied);
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
        return true;
    }

}