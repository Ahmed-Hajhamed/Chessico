import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class King implements Piece{
	int position;
	static int checkersNum;
	protected boolean isChecked;
	protected Side side;
	boolean moved=false;
	int numberOfMoves;
	static ArrayList<Integer>checkers=new ArrayList<Integer>();
    ImageIcon king_b = new ImageIcon("king_b.png");
    ImageIcon king_w = new ImageIcon("king_w.png");
    ImageIcon rook_b = new ImageIcon("rook_b.png");
    ImageIcon rook_w = new ImageIcon("rook_w.png");
    private String type="King";
	private final static int[] KnightMoves= {-26,-22,-19,-13,13,19,22,26};
	private final static int[] KnightFiles= {2,2,3,3,3,3,2,2};
	
	King(Side side,int position)
	{
		this.side=side;
		this.position=position;
	}
	
	
	ArrayList<Integer>valid=new ArrayList<Integer>();
	public void validMoves(Tile[] board,JButton[]tile)
	{
		for(int i=0;i<valid.size();i++)
		{
			if(board[valid.get(i)].isOccupied())
			{
				tile[valid.get(i)].setBackground(Color.RED);
			}else
				tile[valid.get(i)].setBackground(Color.GREEN);
		}
	}
	
	
	
	

    public int getPosition() {
        return position;
    }
    
    public int getCheckersNum() {
    	return checkersNum;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public static boolean isChecked(int posi,Tile[] board,JButton[]tile,Side side) {
    	checkersNum=0;
    	checkers.clear();
    	boolean check=false;
    	
    	//special checks
    	if(side==side.White)
    	{
    		if(posi/8==3)
    		{
    			if(!board[posi-8].isOccupied())
    			{
    				if(board[posi-16].isOccupied()&&board[posi-16].getType()=="Pawn"&&board[posi-16].getSide()==side.Black)
    				{
						checkersNum++;
						check=true;
    				}
    			}
    		}
    	}else if(side==side.Black)
    	{
    		if(posi/8==4)
    		{
    			if(!board[posi+8].isOccupied())
    			{
    				if(board[posi+16].isOccupied()&&board[posi+16].getType()=="Pawn"&&board[posi+16].getSide()==side.White)
    				{
						checkersNum++;
						check=true;
    				}
    			}
    		}
    	}
    	
    	//for diagonals
    	for(int i=posi ;;)
    	{
    		if(i%8!=7)
    		{
    			i-=7;
    			if(i>=0) {
    			if(board[i].isOccupied())
    			{
    				if(posi-7==i&&side!=board[i].getSide()&&((side==side.White&&board[i].getType()=="Pawn")||board[i].getType()=="King"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else if(side!=board[i].getSide()&&board[i].getType()=="Queen")
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else break;
    			}
    			}else break;
    		}else break;
    	}
    	for(int i=posi;;)
    	{
    		if(i%8!=0)
    		{
    			i+=7;
    			if(i<64) {
    			if(board[i].isOccupied())
    			{
    				if(posi+7==i&&side!=board[i].getSide()&&((side==side.Black&&board[i].getType()=="Pawn")||board[i].getType()=="King"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else if(side!=board[i].getSide()&&board[i].getType()=="Queen")
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else break;
    			}
    		}else break;
    		}else break;
    	}
    	for(int i=posi;;)
    	{
    		if(i%8!=0)
    		{
    			i-=9;
    			if(i>=0) {
    			if(board[i].isOccupied())
    			{
    				if(posi-9==i&&side!=board[i].getSide()&&((side==side.White&&board[i].getType()=="Pawn")||board[i].getType()=="King"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else if(side!=board[i].getSide()&&board[i].getType()=="Queen")
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else break;
    			}
    			}else break;
    		}else break;
    	}
    	for(int i=posi;;)
    	{
    		if(i%8!=7)
    		{
    			i+=9;
    			if(i<64) {
    			if(board[i].isOccupied())
    			{
    				if(posi+9==i&&side!=board[i].getSide()&&((side==side.Black&&board[i].getType()=="Pawn")||board[i].getType()=="King"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else if(side!=board[i].getSide()&&board[i].getType()=="Queen")
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else break;
    			}
    			}else break;
    		}else break;
    	}
    	
    	
    	//for Files
    	for(int i=posi;;)
    	{
    		if(i%8!=7)
    		{
    			i++;
    			if(board[i].isOccupied())
    			{
    				if(posi+1==i&&side!=board[i].getSide()&&(board[i].getType()=="Bishop"||board[i].getType()=="King"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}
    				if(side!=board[i].getSide()&&(board[i].getType()=="Rook"||board[i].getType()=="Queen"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else break;
    			}else continue;
    		}else break;
    	}
    	for(int i=posi;;)
    	{
    		if(i%8!=0)
    		{
    			i--;
    			if(board[i].isOccupied())
    			{
    				if(posi-1==i&&side!=board[i].getSide()&&(board[i].getType()=="Bishop"||board[i].getType()=="King"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}
    				if(side!=board[i].getSide()&&(board[i].getType()=="Rook"||board[i].getType()=="Queen"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else break;
    			}else continue;
    		}else break;
    	}
    	for(int i=posi;;)
    	{
    		if(i/8!=0)
    		{
    			i-=8;
    			if(board[i].isOccupied())
    			{
    				if(posi-8==i&&side!=board[i].getSide()&&(board[i].getType()=="Pawn"||board[i].getType()=="King"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}
    				if(side!=board[i].getSide()&&(board[i].getType()=="Rook"||board[i].getType()=="Queen"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else {
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
    				}else break;
    			}else continue;
    		}else break;
    	}
    	for(int i=posi;;)
    	{
    		if(i/8!=7)
    		{
    			i+=8;
    			if(board[i].isOccupied())
    			{
    				if(posi+8==i&&side!=board[i].getSide()&&(board[i].getType()=="Pawn"||board[i].getType()=="King")) 
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}
    				if(side!=board[i].getSide()&&(board[i].getType()=="Rook"||board[i].getType()=="Queen"))
    				{
    					if(checkers.size()!=0)
						for(int j=0;j<checkers.size();j++)
						{
							if(checkers.get(j)==i)
								break;
							else if(j+1==checkers.size())
							{
								checkers.add(i);
								checkersNum++;
								check=true;
							}
						}
    					else {
    						checkers.add(i);
    						checkersNum++;
    						check=true;
    					}
						break;
    				}else break;
    			}else continue;
    		}else break;
    	}
    	
    	//for Knights
    	for(int i=0;i<8;i++)
    	{
    		int square=posi+KnightMoves[i];
    		if(square>=0&&square<64&&(Math.abs(square%8-posi%8)==KnightFiles[i]))
    		{
    			if(board[square].isOccupied())
    				{
    					if(side!=board[square].getSide()&&board[square].getType()=="Knight")
    						{
    						if(checkers.size()!=0)
    							for(int j=0;j<checkers.size();j++)
    								{
    									if(checkers.get(j)==i)
    										break;
    									else if(j+1==checkers.size())
    									{
    										checkers.add(i);
    										checkersNum++;
    										check=true;
    									}
    								}
        					else {
        						checkers.add(i);
        						checkersNum++;
        						check=true;
        					}
    							break;
    						}
    				}
    		}
    	}
    	
    	//for Bishops
    	int loops=3;
    	for(int i=posi;i%8!=7&&loops>0;loops--)
    	{
			i-=7;
			if(i>=0) {
			if(board[i].isOccupied())
			{
				if(side!=board[i].getSide()&&board[i].getType()=="Bishop")
				{
					if(checkers.size()!=0)
					for(int j=0;j<checkers.size();j++)
					{
						if(checkers.get(j)==i)
							break;
						else if(j+1==checkers.size())
						{
							checkers.add(i);
							checkersNum++;
							check=true;
						}
					}
					else {
						checkers.add(i);
						checkersNum++;
						check=true;
					}
					break;
				}
			}
    	}else break;
		}
    	loops=3;
    	for(int i=posi;i%8!=0&&loops>0;loops--)
    	{
    		i-=9;
    		if(i>=0) {
			if(board[i].isOccupied())
			{
				if(side!=board[i].getSide()&&board[i].getType()=="Bishop")
				{
					if(checkers.size()!=0)
					for(int j=0;j<checkers.size();j++)
					{
						if(checkers.get(j)==i)
							break;
						else if(j+1==checkers.size())
						{
							checkers.add(i);
							checkersNum++;
							check=true;
						}
					}
					else {
						checkers.add(i);
						checkersNum++;
						check=true;
					}
					break;
				}
			}
    	}else break;
    	}
    	loops=3;
    	for(int i=posi;i%8!=7&&loops>0;loops--)
    	{
    		i+=9;
    		if(i<64) {
			if(board[i].isOccupied())
			{
				if(side!=board[i].getSide()&&board[i].getType()=="Bishop")
				{
					if(checkers.size()!=0)
					for(int j=0;j<checkers.size();j++)
					{
						if(checkers.get(j)==i)
							break;
						else if(j+1==checkers.size())
						{
							checkers.add(i);
							checkersNum++;
							check=true;
						}
					}
					else {
						checkers.add(i);
						checkersNum++;
						check=true;
					}
					break;
				}
			}
			}else break;
    	}
    	loops=3;
    	for(int i=posi;i%8!=0&&loops>0;loops--)
    	{
    		i+=7;
    		if(i<64) {
			if(board[i].isOccupied())
			{
				if(side!=board[i].getSide()&&board[i].getType()=="Bishop")
				{
					if(checkers.size()!=0)
					for(int j=0;j<checkers.size();j++)
					{
						if(checkers.get(j)==i)
							break;
						else if(j+1==checkers.size())
						{
							checkers.add(i);
							checkersNum++;
							check=true;
						}
					}
					else {
						checkers.add(i);
						checkersNum++;
						check=true;
					}
					break;
				}
			}
    	}else break;
    }
    	return check;
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
        	if((fromposition==4||fromposition==60)&&(toposition==58||toposition==62||toposition==2||toposition==6))
        	{
        		if(toposition==2)
        		{
        			tile[toposition].setIcon(king_b);
        			board[toposition].setSide(side.Black);
        			moveForCastle(0,3,board,tile);
        			board[3].setCurrentPiece(Pieces.RookB1);
        			tile[3].setIcon(rook_b);
        		}else if(toposition==6)
        		{
        			tile[toposition].setIcon(king_b);
        			board[toposition].setSide(side.Black);
        			moveForCastle(7,5,board,tile);
        			board[5].setCurrentPiece(Pieces.RookB2);
        			tile[5].setIcon(rook_b);
        		}else if(toposition==58)
        		{
        			tile[toposition].setIcon(king_w);
        			board[toposition].setSide(side.White);
        			moveForCastle(56,59,board,tile);
        			board[59].setCurrentPiece(Pieces.RookW1);
        			tile[59].setIcon(rook_w);
        		}else if(toposition==62)
        		{
        			tile[toposition].setIcon(king_w);
        			board[toposition].setSide(side.White);
        			moveForCastle(63,61,board,tile);
        			board[61].setCurrentPiece(Pieces.RookW2);
        			tile[61].setIcon(rook_w);
        		}
        	}
        	else {
            	if (board[fromposition].getSide() == Side.Black) {
                	tile[toposition].setIcon(king_b);
                	board[toposition].setSide(Side.Black);
            	}
            	else if (board[fromposition].getSide() == Side.White) {
                	tile[toposition].setIcon(king_w);
                	board[toposition].setSide(Side.White);
            	}
            }

            this.position=toposition;
            board[toposition].setType("King");
            board[toposition].setCurrentPiece(piecetype);
            board[toposition].setOccupied(true);
            board[fromposition].setOccupied(false);
            board[fromposition].setType(null);
            board[fromposition].setCurrentPiece(Pieces.NoPiece);
            board[fromposition].setSide(Side.Blank);
            this.moved=true;
            if(this.side==side.Black) {
            	Game.kings[1].setPosition(toposition);
            }else Game.kings[0].setPosition(toposition);
            
            
            return true;
        }else {
        	newTurn();
        	return false;
        }	
}

	@Override
	public ArrayList<Integer> Moves(Pieces piece,Tile[] board,JButton[]tile, int currentpos) {
		this.numberOfMoves=0;
		int positionTest=currentpos-8;
		if(piece.ordinal()==14||piece.ordinal()==15)
		{
			board[currentpos].setSide(side.Blank);
			board[currentpos].setType(null);
			board[currentpos].setOccupied(false);
			
			if(!this.moved)
			{
				if(this.side==side.White)
				{
					if(!board[61].isOccupied()&&!board[62].isOccupied()&&board[63].isOccupied()&&!Game.pieces[3].moved())
					{
						if(isChecked(62,board,tile,this.side))
						{
							tile[62].setBackground(Color.RED);
							checkersNum=0;
							checkers.clear();
						}else {
							tile[62].setBackground(Color.GREEN);
							this.numberOfMoves++;
							valid.add(positionTest);
						}
					}
					if(board[56].isOccupied()&&!Game.pieces[2].moved()&&!board[57].isOccupied()&&!board[58].isOccupied()&&!board[59].isOccupied())
					{
						if(isChecked(58,board,tile,this.side))
						{
							tile[58].setBackground(Color.RED);
							checkersNum=0;
							checkers.clear();
						}else {
							tile[58].setBackground(Color.GREEN);
							this.numberOfMoves++;
							valid.add(positionTest);
						}
					}
				}else if(this.side==side.Black)
				{
					if(!board[6].isOccupied()&&!board[5].isOccupied()&&board[7].isOccupied()&&!Game.pieces[1].moved())
					{
						if(isChecked(6,board,tile,this.side))
						{
							tile[6].setBackground(Color.RED);
							checkersNum=0;
							checkers.clear();
						}else {
							tile[6].setBackground(Color.GREEN);
							this.numberOfMoves++;
							valid.add(positionTest);
						}
					}
					if(board[0].isOccupied()&&!Game.pieces[0].moved()&&!board[1].isOccupied()&&!board[2].isOccupied()&&!board[3].isOccupied())
					{
						if(isChecked(2,board,tile,this.side))
						{
							tile[2].setBackground(Color.RED);
							checkersNum=0;
							checkers.clear();
						}else {
							tile[2].setBackground(Color.GREEN);
							this.numberOfMoves++;
							valid.add(positionTest);
						}
					}
				}
			}
			
			for(int i=0;i<3;i++,positionTest+=8)
			{
				if(positionTest>=0&&positionTest<64)
				{
					if(positionTest!=currentpos)
					{
						if(board[positionTest].isOccupied()&&board[positionTest].getSide()==this.side)
						{
							tile[positionTest].setBackground(Color.RED);
						}else {
							
							if(isChecked(positionTest,board,tile,this.side))
							{
								tile[positionTest].setBackground(Color.RED);
								checkersNum=0;
								checkers.clear();
							}else {
								tile[positionTest].setBackground(Color.GREEN);
								this.numberOfMoves++;
								valid.add(positionTest);
							}
						}
					}
					if(positionTest%8!=0)
					{
						if(board[positionTest-1].isOccupied()&&board[positionTest-1].getSide()==this.side)
						{
							tile[positionTest-1].setBackground(Color.RED);
						}else {
							
							if(isChecked(positionTest-1,board,tile,this.side))
							{
								tile[positionTest-1].setBackground(Color.RED);
								checkersNum=0;
								checkers.clear();
							}else {
								valid.add(positionTest-1);
								tile[positionTest-1].setBackground(Color.GREEN);
								this.numberOfMoves++;
							}
						}
					}
					if(positionTest%8!=7)
					{
						if(board[positionTest+1].isOccupied()&&board[positionTest+1].getSide()==this.side)
						{
							tile[positionTest+1].setBackground(Color.RED);
						}else {
							
							if(isChecked(positionTest+1,board,tile,this.side))
							{
								tile[positionTest+1].setBackground(Color.RED);
								checkersNum=0;
								checkers.clear();
							}else {
								valid.add(positionTest+1);
								tile[positionTest+1].setBackground(Color.GREEN);
								this.numberOfMoves++;
							}
						}
					}
				}else continue;
			}
			board[currentpos].setSide(this.side);
			board[currentpos].setType(this.type);
			board[currentpos].setOccupied(true);
		}
		return valid;
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

    public int returnNumberOfMoves() {
    	return numberOfMoves;
    }
    @Override
    public boolean moved() {
		return true;
    }
    
    public void moveForCastle(int rookfirstPos,int rookSecondPos,Tile[]board,JButton[]tile)
    {
    	tile[rookfirstPos].setIcon(null);
    	board[rookfirstPos].setType(null);
    	board[rookfirstPos].setOccupied(false);
    	board[rookfirstPos].setSide(side.Blank);
    	board[rookfirstPos].setCurrentPiece(Pieces.NoPiece);
    	board[rookSecondPos].setType("Rook");
    	board[rookSecondPos].setOccupied(true);
    	board[rookSecondPos].setSide(this.side);
    }
    
}
