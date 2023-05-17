public class Game {

    Game() {

        setBoard();
        createPieces();
        //new Board();
        play();
    }

    static Tile[] board = new Tile[64];
    static Non_King[] pieces = new Non_King[32];
    static King[]kings=new King[2];
    static Board borde =new Board();

    void setBoard() {

        for (int i = 0; i < 64; i++) {
            board[i] = new Tile();
            board[i].setLocation(i);
        }
        for (int i = 0; i < 16; i++) {
            board[i].setOccupied(true);
            board[i].setSide(Side.Black);
        }
        for (int i = 16; i < 48; i++) {
            board[i].setOccupied(false);
            board[i].setSide(Side.Blank);
        }
        for (int i = 48; i < 64; i++) {
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
        board[0].setType("Rook");
        board[1].setType("Knight");
        board[2].setType("Bishop");
        board[3].setType("Queen");
        board[4].setType("King");
        board[5].setType("Bishop");
        board[6].setType("Knight");
        board[7].setType("Rook");
        board[8].setType("Pawn");
        board[9].setType("Pawn");
        board[10].setType("Pawn");
        board[11].setType("Pawn");
        board[12].setType("Pawn");
        board[13].setType("Pawn");
        board[14].setType("Pawn");
        board[15].setType("Pawn");
        board[48].setType("Pawn");
        board[49].setType("Pawn");
        board[50].setType("Pawn");
        board[51].setType("Pawn");
        board[52].setType("Pawn");
        board[53].setType("Pawn");
        board[54].setType("Pawn");
        board[55].setType("Pawn");
        board[56].setType("Rook");
        board[57].setType("Knight");
        board[58].setType("Bishop");
        board[59].setType("Queen");
        board[60].setType("King");
        board[61].setType("Bishop");
        board[62].setType("Knight");
        board[63].setType("Rook");
    }

    void  createPieces() {
        Rook b_rook1 = new Rook(Side.Black, 0);
        Rook b_rook2 = new Rook(Side.Black, 7);
        Rook w_rook1 = new Rook(Side.White, 56);
        Rook w_rook2 = new Rook(Side.White, 63);
        Bishop b_bishop2 = new Bishop(Side.Black, 5);
        Bishop w_bishop1 = new Bishop(Side.White, 58);
        Bishop b_bishop1 = new Bishop(Side.Black, 2);
        Bishop w_bishop2 = new Bishop(Side.White, 61);
        Pawn b_pawn1 = new Pawn(Side.Black,8);
        Pawn b_pawn2 = new Pawn(Side.Black,9);
        Pawn b_pawn3 = new Pawn(Side.Black,10);
        Pawn b_pawn4 = new Pawn(Side.Black,11);
        Pawn b_pawn5 = new Pawn(Side.Black,12);
        Pawn b_pawn6 = new Pawn(Side.Black,13);
        Pawn b_pawn7 = new Pawn(Side.Black,14);
        Pawn b_pawn8 = new Pawn(Side.Black,15);
        Pawn w_pawn1 = new Pawn(Side.White,47);
        Pawn w_pawn2 = new Pawn(Side.White,48);
        Pawn w_pawn3 = new Pawn(Side.White,49);
        Pawn w_pawn4 = new Pawn(Side.White,50);
        Pawn w_pawn5 = new Pawn(Side.White,51);
        Pawn w_pawn6 = new Pawn(Side.White,52);
        Pawn w_pawn7 = new Pawn(Side.White,53);
        Pawn w_pawn8 = new Pawn(Side.White,54);
        Knight w_knight1=new Knight(Side.White,57);
        Knight w_knight2=new Knight(Side.White,62);
        Knight b_knight1=new Knight(Side.Black,1);
        Knight b_knight2=new Knight(Side.Black,6);
        King w_king=new King(Side.White,60);
        King b_king=new King(Side.Black,4);
        Queen b_queen = new Queen(Side.Black,3);
        Queen w_queen = new Queen(Side.White,59);

        pieces[0] = b_rook1;
        pieces[1] = b_rook2;
        pieces[2] = w_rook1;
        pieces[3] = w_rook2;
        pieces[4] = b_bishop2;
        pieces[5] = w_bishop1;
        pieces[6] = b_bishop1;
        pieces[7] = w_bishop2;
        pieces[8]=w_knight1;
        pieces[9]=w_knight2;
        pieces[10]=b_knight1;
        pieces[11]=b_knight2;
        pieces[16] = b_pawn1;
        pieces[17] = b_pawn2;
        pieces[18] = b_pawn3;
        pieces[19] = b_pawn4;
        pieces[20] = b_pawn5;
        pieces[21] = b_pawn6;
        pieces[22] = b_pawn7;
        pieces[23] = b_pawn8;
        pieces[24] = w_pawn1;
        pieces[25] = w_pawn2;
        pieces[26] = w_pawn3;
        pieces[27] = w_pawn4;
        pieces[28] = w_pawn5;
        pieces[29] = w_pawn6;
        pieces[30] = w_pawn7;
        pieces[31] = w_pawn8;
        pieces[12] = b_queen;
        pieces[13] = w_queen;
        kings[0]=w_king;
        kings[1]=b_king;

    }
    public void play() {
        new Turn();
    }
}