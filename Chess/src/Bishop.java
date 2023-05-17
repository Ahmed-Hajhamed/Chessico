import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Non_King{
    ImageIcon bishop_b = new ImageIcon("bishop_b.png");
    ImageIcon bishop_w = new ImageIcon("bishop_w.png");
    Side destinationSide;
    String destinationType;
    boolean destinationOccupied;
    private String type="Bishop";
    int numberOfMoves;
    Bishop(Side side,int position){super(side,position);
    }
    @Override
    public boolean move(int fromPosition,int toPosition,Tile[] board,JButton[] tile, Pieces pieceType){
        if (tile[toPosition].getBackground() == Color.GREEN )
        {
            tile[fromPosition].setIcon(null);
            if (board[fromPosition].getSide() == Side.Black) {
                tile[toPosition].setIcon(bishop_b);
                board[toPosition].setSide(Side.Black);
            }
            else if (board[fromPosition].getSide() == Side.White) {
                tile[toPosition].setIcon(bishop_w);
                board[toPosition].setSide(Side.White);
            }

            board[toPosition].setType(this.type);
            board[toPosition].setCurrentPiece(pieceType);
            board[toPosition].setOccupied(true);
            board[fromPosition].setOccupied(false);
            board[fromPosition].setType(null);
            board[fromPosition].setCurrentPiece(Pieces.NoPiece);
            board[fromPosition].setSide(Side.Blank);

            return true;
        }
        return false;
    }
    @Override
    public void newTurn()
    {
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
    @Override
    public ArrayList<Integer> Moves(Pieces piece,Tile[] board,JButton[] tile, int currentPosition) {
        ArrayList<Integer> valid=new ArrayList<Integer>();    int cnt=0;
        this.numberOfMoves=0;
        int position_temp=currentPosition;      //detects bishop current position
        if(piece.ordinal()==8 || piece.ordinal()==9|| piece.ordinal()==10 || piece.ordinal()==11){

            while(position_temp%8!=7 && position_temp<56 && cnt<3){     //not in last column or raw
                position_temp+=9;  valid.add(position_temp);
                cnt++;
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentPosition].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else {if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                    validMove(currentPosition,position_temp,side.White,board);
                    checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                    validMove(currentPosition,position_temp,side.Black,board);
                    checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                }
                    returnMove(currentPosition,position_temp,board);
                }

            }
            position_temp=currentPosition;   cnt=0;
            while(position_temp%8!=0 && position_temp<56 && cnt<3){        //not in first column or last raw
                position_temp+=7;  valid.add(position_temp);  cnt++;
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentPosition].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else{if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                    validMove(currentPosition,position_temp,side.White,board);
                    checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                    validMove(currentPosition,position_temp,side.Black,board);
                    checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                }
                    returnMove(currentPosition,position_temp,board);
                }

            }
            position_temp=currentPosition;    cnt=0;
            while(position_temp%8!=7 && position_temp>7 && cnt<3){       //not in last column or first raw
                position_temp-=7; valid.add(position_temp);  cnt++;
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentPosition].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else {if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                    validMove(currentPosition,position_temp,side.White,board);
                    checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                    validMove(currentPosition,position_temp,side.Black,board);
                    checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                }
                    returnMove(currentPosition,position_temp,board);
                }
            }
            position_temp=currentPosition;  cnt=0;
            while(position_temp%8!=0 && position_temp>7 && cnt<3){       //not in first column or raw
                position_temp-=9;  valid.add(position_temp);  cnt++;
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentPosition].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else {if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                    validMove(currentPosition,position_temp,side.White,board);
                    checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                    validMove(currentPosition,position_temp,side.Black,board);
                    checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                }
                    returnMove(currentPosition,position_temp,board);
                }

            }

            //the following is for special move:

            position_temp=currentPosition;
            if(position_temp%8!=7){valid.add(++position_temp);
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentPosition].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else {if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                    validMove(currentPosition,position_temp,side.White,board);
                    checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                    validMove(currentPosition,position_temp,side.Black,board);
                    checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                }
                    returnMove(currentPosition,position_temp,board);
                }
            }
            position_temp=currentPosition;
            if(position_temp%8!=0){valid.add(--position_temp);
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentPosition].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else {if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                    validMove(currentPosition,position_temp,side.White,board);
                    checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                    validMove(currentPosition,position_temp,side.Black,board);
                    checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                }
                    returnMove(currentPosition,position_temp,board);
                }

            }

        }
        return valid;
    }

    public void validMove(int currentPosition,int nextPosition,Side side,Tile[]board)
    {
        board[currentPosition].setSide(side.Blank);
        board[currentPosition].setOccupied(false);
        board[currentPosition].setType(null);
        destinationSide=board[nextPosition].getSide();
        destinationType=board[nextPosition].getType();
        destinationOccupied=board[nextPosition].isOccupied();
        board[nextPosition].setSide(side);
        board[nextPosition].setType("Bishop");
        board[nextPosition].setOccupied(true);
    }

    public void returnMove(int currentPosition,int nextPosition,Tile[]board)
    {
        board[currentPosition].setType("Bishop");
        board[currentPosition].setOccupied(true);
        board[nextPosition].setSide(destinationSide);
        board[nextPosition].setType(destinationType);
        board[nextPosition].setOccupied(destinationOccupied);
    }

    public void checkCheck(int array_num,int position,int currentPosition,Side side,Tile[]board,JButton[]tile)
    {
        if(Game.kings[array_num].isChecked(Game.kings[array_num].getPosition(),board, side))
        {
            tile[position].setBackground(Color.RED);
            board[currentPosition].setSide(side);
            Game.kings[array_num].checkersNum=0;
            Game.kings[array_num].checkers.clear();
        }else {
            tile[position].setBackground(Color.GREEN);
            board[currentPosition].setSide(side);
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