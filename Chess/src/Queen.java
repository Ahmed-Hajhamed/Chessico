import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Queen extends Non_King{
    ImageIcon queen_b = new ImageIcon("queen_b.png");
    ImageIcon queen_w = new ImageIcon("queen_w.png");
    String type="Queen";
    Side distinationSide;
    String distinationType;
    boolean distinationOccupied;
    int numberOfMoves;
    Queen(Side side,int position){
        super(side,position);

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
                tile[toposition].setIcon(queen_b);
                board[toposition].setSide(Side.Black);
            }
            else if (board[fromposition].getSide() == Side.White) {
                tile[toposition].setIcon(queen_w);
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
        for (int i = 0; i < 64; i++) {
            if (Board.white == 1) {
                Board.piece[i].setBackground(Settings.lightColour);
                if ((i + 1) % 8 == 0) {
                    continue;
                }
                Board.white = 0;
            }
            else {
                Board.piece[i].setBackground(Settings.darkColour);
                if ((i + 1) % 8 == 0) {
                    continue;
                }
                Board.white = 1;
            }
        }
        new Turn();
    }


    @Override
    public ArrayList<Integer> Moves(Pieces piece,Tile[] board,JButton[] tile, int currentpos) {
        ArrayList<Integer> valid=new ArrayList<Integer>();
        this.numberOfMoves=0;
        int position_temp=currentpos;
        if(piece.ordinal()==12 || piece.ordinal()==13){

            while(position_temp%8!=7 && position_temp<56){
                position_temp+=9;  valid.add(position_temp);if(board[valid.get(valid.size()-1)].isOccupied())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                	if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                }


            }
            position_temp=currentpos;
            while(position_temp%8!=0 && position_temp<56){
                position_temp+=7;  valid.add(position_temp); if(board[valid.get(valid.size()-1)].isOccupied())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                	if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                }


            }
            position_temp=currentpos;
            while(position_temp%8!=7 && position_temp>7){
                position_temp-=7; valid.add(position_temp);if(board[valid.get(valid.size()-1)].isOccupied())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                	if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                }


            }
            position_temp=currentpos;
            while(position_temp%8!=0 && position_temp>7  ){
                position_temp-=9;  valid.add(position_temp);if(board[valid.get(valid.size()-1)].isOccupied())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                	if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                }


            }
            position_temp=currentpos;
            while (position_temp % 8 != 7) {
                valid.add(++position_temp);
                if(board[valid.get(valid.size()-1)].isOccupied())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                	if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
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
                    else {if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                	if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
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
                if(board[valid.get(valid.size()-1)].isOccupied()) //board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                	if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
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
                if(board[valid.get(valid.size()-1)].isOccupied()) //board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                {
                    if(board[valid.get(valid.size()-1)].getSide()==board[currentpos].getSide())
                    {tile[valid.get(valid.size() - 1)].setBackground(Color.RED);
                        break;   }
                    else {if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
                    	validMove(currentpos,position_temp,side.Black,board);
                    	checkCheck(1,position_temp,currentpos,side.Black,board,tile);
                    }
                    returnMove(currentpos,position_temp,board);
                        break;   }

                }
                else {
                	if(piece==Pieces.QueenW)
                    {
                    	validMove(currentpos,position_temp,side.White,board);
                    	checkCheck(0,position_temp,currentpos,side.White,board,tile);
                    }else if(piece==Pieces.QueenB){
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
    	board[nextpos].setType("Queen");
    	board[nextpos].setOccupied(true);
    }
    
    public void returnMove(int currentpos,int nextpos,Tile[]board)
    {
        board[currentpos].setType("Queen");
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



