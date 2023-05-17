import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class Bishop extends Non_King{
    ImageIcon bishop_b = new ImageIcon("bishop_b.png");
    ImageIcon bishop_w = new ImageIcon("bishop_w.png");
    Side distinationSide;
    String distinationType;
    boolean distinationOccupied;
	private String type="Bishop";
	int numberOfMoves;
    Bishop(Side side,int position){super(side,position);
    }

    @Override
    public boolean move(int fromposition,int toposition,Tile[] board,JButton[] tile, Pieces piecetype){
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
                tile[toposition].setIcon(bishop_b);
                board[toposition].setSide(Side.Black);
            }
            else if (board[fromposition].getSide() == Side.White) {
                tile[toposition].setIcon(bishop_w);
                board[toposition].setSide(Side.White);
            }

            board[toposition].setType(this.type);
            board[toposition].setCurrentPiece(piecetype);
            board[toposition].setOccupied(true);
            board[fromposition].setOccupied(false);
            board[fromposition].setType(null);
            board[fromposition].setCurrentPiece(Pieces.NoPiece);
            board[fromposition].setSide(Side.Blank);

            return true;
        }else {
        	newTurn();
        	return false;
        }
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
    public ArrayList<Integer> Moves(Pieces piece,Tile[] board,JButton[] tile, int currentpos) {
        ArrayList<Integer> valid=new ArrayList<Integer>();    int cnt=0;
        this.numberOfMoves=0;
        int position_temp=currentpos;      //detects bishop current position
        if(piece.ordinal()==8 || piece.ordinal()==9|| piece.ordinal()==10 || piece.ordinal()==11){

            while(position_temp%8!=7 && position_temp<56 && cnt<3){     //not in last column or raw
                position_temp+=9;  valid.add(position_temp);
                cnt++;
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else {if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                	validMove(currentpos,position_temp,side.White,board);
                	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                	validMove(currentpos,position_temp,side.Black,board);
                	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                }
                returnMove(currentpos,position_temp,board);
                }

            }
            position_temp=currentpos;   cnt=0;
            while(position_temp%8!=0 && position_temp<56 && cnt<3){        //not in first column or last raw
                position_temp+=7;  valid.add(position_temp);  cnt++;
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else{if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                	validMove(currentpos,position_temp,side.White,board);
                	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                	validMove(currentpos,position_temp,side.Black,board);
                	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                }
                returnMove(currentpos,position_temp,board);
                }

            }
            position_temp=currentpos;    cnt=0;
            while(position_temp%8!=7 && position_temp>7 && cnt<3){       //not in last column or first raw
                position_temp-=7; valid.add(position_temp);  cnt++;
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else {if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                	validMove(currentpos,position_temp,side.White,board);
                	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                	validMove(currentpos,position_temp,side.Black,board);
                	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                }
                returnMove(currentpos,position_temp,board);
                }
            }
            position_temp=currentpos;  cnt=0;
            while(position_temp%8!=0 && position_temp>7 && cnt<3){       //not in first column or raw
                position_temp-=9;  valid.add(position_temp);  cnt++;
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else {if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                	validMove(currentpos,position_temp,side.White,board);
                	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                	validMove(currentpos,position_temp,side.Black,board);
                	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                }
                returnMove(currentpos,position_temp,board);
                }

            }

            //the following is for special move:

            position_temp=currentpos;
            if(position_temp%8!=7){valid.add(++position_temp);
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else {if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                	validMove(currentpos,position_temp,side.White,board);
                	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                	validMove(currentpos,position_temp,side.Black,board);
                	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                }
                returnMove(currentpos,position_temp,board);
                }
            }
            position_temp=currentpos;
            if(position_temp%8!=0){valid.add(--position_temp);
                if(board[valid.get(valid.size()-1)].isOccupied() && board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide()){
                    tile[valid.get(valid.size()-1)].setBackground(Color.RED);
                }
                else {if(piece==Pieces.BishopW1||piece==Pieces.BishopW2)
                {
                	validMove(currentpos,position_temp,side.White,board);
                	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                }else if(piece==Pieces.BishopB1||piece==Pieces.BishopB2){
                	validMove(currentpos,position_temp,side.Black,board);
                	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                }
                returnMove(currentpos,position_temp,board);
                }

            }

        }
        return valid;
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
    	board[nextpos].setType("Bishop");
    	board[nextpos].setOccupied(true);
    }
    
    public void returnMove(int currentpos,int nextpos,Tile[]board)
    {
        board[currentpos].setType("Bishop");
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



