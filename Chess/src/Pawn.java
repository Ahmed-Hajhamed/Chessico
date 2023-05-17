import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class Pawn extends Non_King {
    ImageIcon pawn_b = new ImageIcon("pawn_b.png");
    ImageIcon pawn_w = new ImageIcon("pawn_w.png");
    Side distinationSide;
    String distinationType;
    boolean distinationOccupied;
    String type="Pawn";
    int numberOfMoves;
    Pawn(Side side, int position) {super(side, position);}

    @Override
    public boolean move(int fromposition, int toposition, Tile[] board, JButton[] tile, Pieces piecetype) {
        if (tile[toposition].getBackground() == Color.GREEN )
        {
        	if(board[toposition].isOccupied()&&board[fromposition].getSide()==side.Black)
        	{
        		Game.borde.whiteDeadPieces.add(board[toposition].getType());
                Game.borde.deadButtons(Game.borde.whiteDeadPieces, side.Black);
        	}else if(board[toposition].isOccupied()&&board[fromposition].getSide()==side.White)
        	{
        		Game.borde.blackDeadPieces.add(board[toposition].getType());
                Game.borde.deadButtons(Game.borde.blackDeadPieces, side.White);
        	}
            tile[fromposition].setIcon(null);
            if (board[fromposition].getSide() == Side.Black) {
                tile[toposition].setIcon(pawn_b);
                board[toposition].setSide(Side.Black);
            }
            else if (board[fromposition].getSide() == Side.White) {
                tile[toposition].setIcon(pawn_w);
                board[toposition].setSide(Side.White);
            }

            board[toposition].setType(this.type);
            board[toposition].setCurrentPiece(piecetype);
            board[toposition].setOccupied(true);
            board[fromposition].setOccupied(false);
            board[fromposition].setType(null);
            board[fromposition].setCurrentPiece(Pieces.NoPiece);
            board[fromposition].setSide(Side.Blank);
            if (board[toposition].getSide() ==Side.Black)
            {
                if (toposition>=56 && toposition<=63)
                    promote(Side.Black,toposition);
            }
            else if (board[toposition].getSide() ==Side.White) {
                if (toposition >= 0 && toposition <= 7)
                    promote(Side.White, toposition);
            }
            return true;
        }else {
        	newTurn();
        	return false;
        }
    }
    @Override
    public ArrayList<Integer> Moves(Pieces piece, Tile[] board, JButton[] tile, int currentpos) {
        ArrayList<Integer> valid_forward= new ArrayList<>();
        ArrayList<Integer> valid_diagonal= new ArrayList<>();
        this.numberOfMoves=0;

        if(piece.ordinal()==16 || piece.ordinal()==17 || piece.ordinal()==18 || piece.ordinal()==19 || piece.ordinal()==20
                || piece.ordinal()==21 || piece.ordinal()==22 || piece.ordinal()==23){
            if(currentpos>8&&currentpos<15){
                valid_diagonal.add(0,currentpos+7);
                valid_diagonal.add(1,currentpos+9);
                valid_forward.add(0,currentpos+8);
                if(!board[currentpos+8].isOccupied()){
                    valid_forward.add(1,currentpos+16);
                }
            }
            else if (currentpos==8){
                valid_diagonal.add(0,17);
                valid_forward.add(0,16);
                if(!board[currentpos+8].isOccupied()){
                    valid_forward.add(1,24);
                }
            }
            else if (currentpos==15) {
                valid_diagonal.add(0,22);
                valid_forward.add(0,23);
                if(!board[currentpos+8].isOccupied()){
                    valid_forward.add(1,31);
                }
            }
            else if(currentpos%8==0){
                valid_forward.add(0,currentpos+8);
                valid_diagonal.add(0,currentpos+9);
            }
            else if ((currentpos+1)%8==0) {
                valid_forward.add(0,currentpos+8);
                valid_diagonal.add(0,currentpos+7);
            }
            else if(currentpos<56){
                valid_forward.add(0,currentpos+8);
                valid_diagonal.add(0,currentpos+7);
                valid_diagonal.add(1,currentpos+9);
            }

        } else if (piece.ordinal()==24 || piece.ordinal()==25 || piece.ordinal()==26 || piece.ordinal()==27 || piece.ordinal()==28
                || piece.ordinal()==29 || piece.ordinal()==30 || piece.ordinal()==31) {
            if(currentpos>48&&currentpos<55){
                valid_diagonal.add(0,currentpos-7);
                valid_diagonal.add(1,currentpos-9);
                valid_forward.add(0,currentpos-8);
                if(!board[currentpos-8].isOccupied()){
                    valid_forward.add(1,currentpos-16);
                }
            }
            else if (currentpos==48){
                valid_forward.add(0,40);
                valid_diagonal.add(0,41);
                if(!board[currentpos-8].isOccupied()){
                    valid_forward.add(1,32);
                }
            } else if (currentpos==55) {
                valid_forward.add(0,47);
                valid_diagonal.add(0,46);
                if(!board[currentpos-8].isOccupied()){
                    valid_forward.add(1,39);
                }
            }
            else if(currentpos%8==0){
                valid_forward.add(0,currentpos-8);
                valid_diagonal.add(0,currentpos-7);
            } else if ((currentpos+1)%8==0) {
                valid_forward.add(0,currentpos-8);
                valid_diagonal.add(0,currentpos-9);
            }
            else if(currentpos>7){
                valid_forward.add(0,currentpos-8);
                valid_diagonal.add(0,currentpos-7);
                valid_diagonal.add(1,currentpos-9);
            }
        }
        for (int i=0;i<valid_forward.size();i++)
        {
            if (board[valid_forward.get(i)].isOccupied()&&board[valid_forward.get(i)].getSide()==board[currentpos].getSide())
            {
                tile[valid_forward.get(i)].setBackground(Color.RED);
            }
            else {
            	if(this.side==side.White)
                {
                	validMove(currentpos,valid_forward.get(i),side.White,board);
                	checkCheck(0,valid_forward.get(i),currentpos,side.White,board,tile);
                }else if(this.side==side.Black){
                	validMove(currentpos,valid_forward.get(i),side.Black,board);
                	checkCheck(1,valid_forward.get(i),currentpos,side.Black,board,tile);
                }
                returnMove(currentpos,valid_forward.get(i),board);
            }
        }
        for (int i=0;i<valid_diagonal.size();i++)
        {
            if (board[valid_diagonal.get(i)].isOccupied()&&board[valid_diagonal.get(i)].getSide()!=board[currentpos].getSide())
            {
            	if(this.side==side.White)
                {
                	validMove(currentpos,valid_diagonal.get(i),side.White,board);
                	checkCheck(0,valid_diagonal.get(i),currentpos,side.White,board,tile);
                }else if(this.side==side.Black){
                	validMove(currentpos,valid_diagonal.get(i),side.Black,board);
                	checkCheck(1,valid_diagonal.get(i),currentpos,side.Black,board,tile);
                }
                returnMove(currentpos,valid_diagonal.get(i),board);
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
    	distinationType=board[nextpos].getType();
    	distinationOccupied=board[nextpos].isOccupied();
    	board[nextpos].setSide(side);
    	board[nextpos].setType("Pawn");
    	board[nextpos].setOccupied(true);
    }
    
    public void returnMove(int currentpos,int nextpos,Tile[]board)
    {
        board[currentpos].setType("Pawn");
        board[currentpos].setOccupied(true);
    	board[nextpos].setSide(distinationSide);
    	board[nextpos].setType(distinationType);
    	board[nextpos].setOccupied(distinationOccupied);
    }
    
    public void checkCheck(int array_num,int position,int currentpos,Side side,Tile[]board,JButton[]tile)
    {
    	if(Game.kings[array_num].isChecked(Game.kings[array_num].getPosition(),board,tile,side))
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