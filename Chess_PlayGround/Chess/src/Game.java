public class Game {

    Game(){
        setBoard();
        createPieces();
        new Board();
    }
    static Tile[] board=new Tile[64];
    static Non_King[] pieces=new Non_King[2];
     void setBoard()
    {

        for (int i =0;i<64;i++)
        {
            board[i]=new Tile();
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
        board[0].setCurrentPiece(Pieces.RookB1);
        board[1].setCurrentPiece(Pieces.KnightB1);
        board[2].setCurrentPiece(Pieces.BishopB1);
        board[3].setCurrentPiece(Pieces.QueenB);
        board[4].setCurrentPiece(Pieces.KingB);
        board[5].setCurrentPiece(Pieces.BishopB2);
        board[6].setCurrentPiece(Pieces.KnightB2);
        board[7].setCurrentPiece(Pieces.RookB2);
        board[8].setCurrentPiece(Pieces.PawnB1);
        board[9].setCurrentPiece(Pieces.PawnB2);
        board[10].setCurrentPiece(Pieces.PawnB3);
        board[11].setCurrentPiece(Pieces.PawnB4);
        board[12].setCurrentPiece(Pieces.PawnB5);
        board[13].setCurrentPiece(Pieces.PawnB6);
        board[14].setCurrentPiece(Pieces.PawnB7);
        board[15].setCurrentPiece(Pieces.PawnB8);
        board[48].setCurrentPiece(Pieces.PawnW1);
        board[49].setCurrentPiece(Pieces.PawnW2);
        board[50].setCurrentPiece(Pieces.PawnW3);
        board[51].setCurrentPiece(Pieces.PawnW4);
        board[52].setCurrentPiece(Pieces.PawnW5);
        board[53].setCurrentPiece(Pieces.PawnW6);
        board[54].setCurrentPiece(Pieces.PawnW7);
        board[55].setCurrentPiece(Pieces.PawnW8);
        board[56].setCurrentPiece(Pieces.RookW1);
        board[57].setCurrentPiece(Pieces.KnightW1);
        board[58].setCurrentPiece(Pieces.BishopW1);
        board[59].setCurrentPiece(Pieces.QueenW);
        board[60].setCurrentPiece(Pieces.KingW);
        board[61].setCurrentPiece(Pieces.BishopW2);
        board[62].setCurrentPiece(Pieces.KnightW2);
        board[63].setCurrentPiece(Pieces.RookW2);
    }

    Non_King[] createPieces()
    {
       Rook b_rook1=new Rook(Side.Black,0);
       Rook b_rook2=new Rook(Side.Black,7);
       pieces[0]=b_rook1;
       pieces[1]=b_rook2;
       return pieces;
    }
}

