public class Game {

    Game(){
        setBoard();
        createPieces();
    }

    void setBoard()
    {
      Tile[] board=new Tile[64];
        for (int i =0;i<64;i++)
        {
            board[i].setLocation(i);
        }
        for (int i=0;i<16;i++)
        {
        board[i].setOccupied(true);
        board[i].setSide(Side.Black);
        }
        for (int i=16;i<48;i++)
        {
            board[i].setOccupied(false);
            board[i].setSide(Side.Blank);
        }
        for (int i=48;i<64;i++)
        {
            board[i].setOccupied(true);
            board[i].setSide(Side.White);
        }
        board[0].setCurrentPiece(Pieces.Rook);
        board[1].setCurrentPiece(Pieces.Knight);
        board[2].setCurrentPiece(Pieces.Bishop);
        board[3].setCurrentPiece(Pieces.Queen);
        board[4].setCurrentPiece(Pieces.King);
        board[5].setCurrentPiece(Pieces.Bishop);
        board[6].setCurrentPiece(Pieces.Knight);
        board[7].setCurrentPiece(Pieces.Rook);
        for (int i=8; i<16 ; i++)
            board[i].setCurrentPiece(Pieces.Pawn);
        for (int i=48; i<56 ; i++)
            board[i].setCurrentPiece(Pieces.Pawn);
        board[56].setCurrentPiece(Pieces.Rook);
        board[57].setCurrentPiece(Pieces.Knight);
        board[58].setCurrentPiece(Pieces.Bishop);
        board[59].setCurrentPiece(Pieces.Queen);
        board[60].setCurrentPiece(Pieces.King);
        board[61].setCurrentPiece(Pieces.Bishop);
        board[62].setCurrentPiece(Pieces.Knight);
        board[63].setCurrentPiece(Pieces.Rook);
    }

    Non_King[] createPieces()
    {
       Rook b_rook1=new Rook(Side.Black,0);
       Rook b_rook2=new Rook(Side.Black,7);
       Non_King[] pieces=new Non_King[2];
       pieces[0]=b_rook1;
       pieces[1]=b_rook2;
       return pieces;
    }
}

