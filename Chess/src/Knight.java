import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Knight extends Non_King {
    ImageIcon knight_b = new ImageIcon("knight_b.png");
    ImageIcon knight_w = new ImageIcon("knight_w.png");
    Side destinationSide;
    String destinationType;
    boolean destinationOccupied;
    String type="Knight";
    public int numberOfMoves;

    Knight(Side side, int position) {
        super(side, position);
    }

    @Override
    public boolean move(int fromPosition, int toPosition, Tile[] board, JButton[] tile, Pieces pieceType) {
        if (tile[toPosition].getBackground() == Color.GREEN) {
            tile[fromPosition].setIcon(null);
            if (board[fromPosition].getSide() == Side.Black) {
                tile[toPosition].setIcon(knight_b);
                board[toPosition].setSide(Side.Black);
            } else if (board[fromPosition].getSide() == Side.White) {
                tile[toPosition].setIcon(knight_w);
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


    @Override
    public ArrayList<Integer> Moves(Pieces piece, Tile[] board, JButton[] tile, int currentPosition) {
        ArrayList<Integer> valid = new ArrayList<Integer>();
        this.numberOfMoves=0;
        int position_temp = currentPosition;
        if (piece.ordinal() == 4 || piece.ordinal() == 5 || piece.ordinal() == 6 || piece.ordinal() == 7) {

            if (position_temp % 8< 5) {
                if (position_temp <= 47) {
                    position_temp += 19;
                    valid.add(position_temp);

                    if (board[valid.get(valid.size() - 1)].isOccupied() && board[valid.get(valid.size() - 1)].getSide() == board[currentPosition].getSide()) {
                        tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                    } else {if(piece==Pieces.KnightW1||piece==Pieces.KnightW2)
                    {
                        validMove(currentPosition,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                    }else if(piece==Pieces.KnightB1||piece==Pieces.KnightB2){
                        validMove(currentPosition,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                    }
                        returnMove(currentPosition,position_temp,board);
                    }
                }
                position_temp=currentPosition;

                if (position_temp >= 16) {
                    position_temp -= 13;
                    valid.add(position_temp);

                    if (board[valid.get(valid.size() - 1)].isOccupied() && board[valid.get(valid.size() - 1)].getSide() == board[currentPosition].getSide()) {
                        tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                    } else {if(piece==Pieces.KnightW1||piece==Pieces.KnightW2)
                    {
                        validMove(currentPosition,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                    }else if(piece==Pieces.KnightB1||piece==Pieces.KnightB2){
                        validMove(currentPosition,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                    }
                        returnMove(currentPosition,position_temp,board);
                    }
                }
            }
            position_temp = currentPosition;
            if (position_temp % 8 < 6 ) {
                if (position_temp <= 39) {
                    position_temp += 26;
                    valid.add(position_temp);

                    if (board[valid.get(valid.size() - 1)].isOccupied() && board[valid.get(valid.size() - 1)].getSide() == board[currentPosition].getSide()) {
                        tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                    } else {if(piece==Pieces.KnightW1||piece==Pieces.KnightW2)
                    {
                        validMove(currentPosition,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                    }else if(piece==Pieces.KnightB1||piece==Pieces.KnightB2){
                        validMove(currentPosition,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                    }
                        returnMove(currentPosition,position_temp,board);
                    }
                }
                position_temp=currentPosition;

                if (position_temp >= 24) {
                    position_temp -= 22;
                    valid.add(position_temp);

                    if (board[valid.get(valid.size() - 1)].isOccupied() && board[valid.get(valid.size() - 1)].getSide() == board[currentPosition].getSide()) {
                        tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                    } else {if(piece==Pieces.KnightW1||piece==Pieces.KnightW2)
                    {
                        validMove(currentPosition,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                    }else if(piece==Pieces.KnightB1||piece==Pieces.KnightB2){
                        validMove(currentPosition,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                    }
                        returnMove(currentPosition,position_temp,board);
                    }
                }
            }
            position_temp = currentPosition;
            if (position_temp % 8 > 2) {
                if (position_temp <= 47) {
                    position_temp += 13;
                    valid.add(position_temp);
                    if (board[valid.get(valid.size() - 1)].isOccupied() && board[valid.get(valid.size() - 1)].getSide() == board[currentPosition].getSide()) {
                        tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                    } else {if(piece==Pieces.KnightW1||piece==Pieces.KnightW2)
                    {
                        validMove(currentPosition,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                    }else if(piece==Pieces.KnightB1||piece==Pieces.KnightB2){
                        validMove(currentPosition,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                    }
                        returnMove(currentPosition,position_temp,board);
                    }
                }
                position_temp=currentPosition;
                if (position_temp >= 16) {
                    position_temp -= 19;
                    valid.add(position_temp);

                    if (board[valid.get(valid.size() - 1)].isOccupied() && board[valid.get(valid.size() - 1)].getSide() == board[currentPosition].getSide()) {
                        tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                    } else {if(piece==Pieces.KnightW1||piece==Pieces.KnightW2)
                    {
                        validMove(currentPosition,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                    }else if(piece==Pieces.KnightB1||piece==Pieces.KnightB2){
                        validMove(currentPosition,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                    }
                        returnMove(currentPosition,position_temp,board);
                    }
                }
            }
            position_temp = currentPosition;
            if (position_temp % 8 > 1) {
                if (position_temp <= 39) {
                    position_temp += 22;
                    valid.add(position_temp);
                    if (board[valid.get(valid.size() - 1)].isOccupied() && board[valid.get(valid.size() - 1)].getSide() == board[currentPosition].getSide()) {
                        tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                    } else {if(piece==Pieces.KnightW1||piece==Pieces.KnightW2)
                    {
                        validMove(currentPosition,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                    }else if(piece==Pieces.KnightB1||piece==Pieces.KnightB2){
                        validMove(currentPosition,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                    }
                        returnMove(currentPosition,position_temp,board);
                    }
                }
                position_temp=currentPosition;
                if (position_temp >= 24) {
                    position_temp -= 26;
                    valid.add(position_temp);

                    if (board[valid.get(valid.size() - 1)].isOccupied() && board[valid.get(valid.size() - 1)].getSide() == board[currentPosition].getSide()) {
                        tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                    } else {if(piece==Pieces.KnightW1||piece==Pieces.KnightW2)
                    {
                        validMove(currentPosition,position_temp,side.White,board);
                        checkCheck(0,position_temp,currentPosition,side.White,board,tile);
                    }else if(piece==Pieces.KnightB1||piece==Pieces.KnightB2){
                        validMove(currentPosition,position_temp,side.Black,board);
                        checkCheck(1,position_temp,currentPosition,side.Black,board,tile);
                    }
                        returnMove(currentPosition,position_temp,board);
                    }
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
        board[nextPosition].setType("Knight");
        board[nextPosition].setOccupied(true);
    }

    public void returnMove(int currentPosition,int nextPosition,Tile[]board)
    {
        board[currentPosition].setType("Knight");
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