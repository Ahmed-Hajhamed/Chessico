import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ToButtonCatcher implements ActionListener {
    SoundEffect soundEffect;
        {
        try {
            soundEffect = new SoundEffect();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static int kingWposition=60;
    static int kingBposition=4;
    static int k;
    int piece_array_number;
    public static int duplicate;
    Side side;
    Pieces piecetype;
    ToButtonCatcher(int j,int piece_array_number,Pieces piecetype,Side side){
        k=j;
        this.side=side;
        this.piece_array_number=piece_array_number;
        this.piecetype=piecetype;
        for (int i=0;i<64;i++)
        {
            Board.piece[i].addActionListener(this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 64; i++) {
            if (e.getSource() == Board.piece[i]&&(this.piecetype!=Pieces.KingW&&this.piecetype!=Pieces.KingB)) {
                boolean hasmoved=Game.pieces[this.piece_array_number].move(k, i, Game.board, Board.piece,this.piecetype);
                if (hasmoved) {
                    duplicate = i;
                    Turn.count++;
                    if (side == Side.White) {
                        Turn.side_now = Side.Black;
                        Board.blackTimer.start();
                        Board.whiteTimer.stop();
                        soundEffect.moveSound.start();
                        if(Game.kings[1].isChecked(Game.kings[1].getPosition(),Game.board,Board.piece,Side.Black))
                        {
                            isCheckMate(Side.Black,Game.board);
                            soundEffect.checkSound.start();
                        }
                    } else {
                        Turn.side_now = Side.White;
                        soundEffect.moveSound.start();
                        Board.whiteTimer.start();
                        Board.blackTimer.stop();
                        if(Game.kings[0].isChecked(Game.kings[0].getPosition(),Game.board,Board.piece,Side.White))
                        {
                            isCheckMate(Side.White,Game.board);
                            soundEffect.checkSound.start();
                        }
                    }
                    Game.pieces[this.piece_array_number].newTurn();
                }else {
                    int x=4;
                }
            }else if(e.getSource()==Board.piece[i]) {
                boolean hasmoved = Game.kings[this.piece_array_number].move(k, i, Game.board, Board.piece, this.piecetype);
                if (hasmoved) {
                    duplicate = i;
                    Turn.count++;
                    if (side == Side.White) {
                        Turn.side_now = Side.Black;
                        Board.blackTimer.start();
                        Board.whiteTimer.stop();
                        soundEffect.moveSound.start();
                    } else {
                        Turn.side_now = Side.White;
                        Board.whiteTimer.start();
                        Board.blackTimer.stop();
                        soundEffect.moveSound.start();
                    }
                }
                Game.kings[this.piece_array_number].newTurn();
            }
            Board.piece[i].removeActionListener(this);
        }
    }


    public void isCheckMate(Side side,Tile[]board) {
        int validMoves=0;
        for(int i=0;i<64;i++)
        {
            if(side==side.White&&board[i].getSide()==side.White)
            {
                if(board[i].getType()=="Pawn")
                {
                    Game.pieces[26].Moves(Pieces.PawnW4, Game.board, Board.piece, i);
                    validMoves+=Game.pieces[26].returnNumberOfMoves();
                }else if(board[i].getType()=="Queen")
                {
                    Game.pieces[12].Moves(Pieces.QueenW, Game.board, Board.piece, i);
                    validMoves+=Game.pieces[12].returnNumberOfMoves();
                }else if(board[i].getType()=="Rook")
                {
                    Game.pieces[2].Moves(Pieces.RookW1, Game.board, Board.piece, i);
                    validMoves+=Game.pieces[2].returnNumberOfMoves();
                }else if(board[i].getType()=="Knight")
                {
                    Game.pieces[9].Moves(Pieces.KnightW2, Game.board, Board.piece, i);
                    validMoves+=Game.pieces[9].returnNumberOfMoves();
                }else if(board[i].getType()=="Bishop")
                {
                    Game.pieces[7].Moves(Pieces.BishopW2, Game.board, Board.piece, i);
                    validMoves+=Game.pieces[7].returnNumberOfMoves();
                }else if(board[i].getType()=="King")
                {
                    Game.kings[0].Moves(Pieces.KingW, Game.board, Board.piece, i);
                    validMoves+=Game.kings[0].returnNumberOfMoves();
                }
            }else if(side==side.Black&&board[i].getSide()==side.Black) {
                if(board[i].getType()=="Pawn")
                {
                    Game.pieces[19].Moves(Pieces.PawnB4, Game.board, Board.piece, i);
                    validMoves+=Game.pieces[19].returnNumberOfMoves();
                }else if(board[i].getType()=="Queen")
                {
                    Game.pieces[13].Moves(Pieces.QueenB, Game.board, Board.piece, i);
                    validMoves+=Game.pieces[13].returnNumberOfMoves();
                }else if(board[i].getType()=="Rook")
                {
                    Game.pieces[0].Moves(Pieces.RookB1, Game.board, Board.piece, i);
                    validMoves+=Game.pieces[0].returnNumberOfMoves();
                }else if(board[i].getType()=="Knight")
                {
                    Game.pieces[10].Moves(Pieces.KnightB2, Game.board, Board.piece, i);
                    validMoves+=Game.pieces[10].returnNumberOfMoves();
                }else if(board[i].getType()=="Bishop")
                {
                    Game.pieces[4].Moves(Pieces.BishopB2, Game.board, Board.piece, i);
                    validMoves+=Game.pieces[4].returnNumberOfMoves();
                }else if(board[i].getType()=="King")
                {
                    Game.kings[1].Moves(Pieces.KingB, Game.board, Board.piece, i);
                    validMoves+=Game.kings[1].returnNumberOfMoves();
                }
            }
        }

        if(validMoves==0)
        {
            soundEffect.checkMateSound.start();
            soundEffect.checkSound.stop();
            if(side==side.White)
                new winPage("BLACK");
            else new winPage("WHITE");
        }else return;
    }
}


//import javax.sound.sampled.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//public class ToButtonCatcher implements ActionListener {
//    SoundEffect soundEffect;
//    {
//        try {
//            soundEffect = new SoundEffect();
//        } catch (LineUnavailableException e) {
//            throw new RuntimeException(e);
//        } catch (UnsupportedAudioFileException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    static int k;
//    int piece_array_number;
//    public static int duplicate;
//    Side side;
//    Pieces piecetype;
//    ToButtonCatcher(int j,int piece_array_number,Pieces piecetype,Side side){
//
//
//        k=j;
//        this.side=side;
//        this.piece_array_number=piece_array_number;
//        this.piecetype=piecetype;
//        for (int i=0;i<64;i++)
//        {
//            Board.piece[i].addActionListener(this);
//        }
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        for (int i = 0; i < 64; i++) {
//            if (e.getSource() == Board.piece[i]&&(this.piecetype!=Pieces.KingW&&this.piecetype!=Pieces.KingB)) {
//                duplicate=i;
//                boolean hasmoved=Game.pieces[this.piece_array_number].move(k, i, Game.board, Board.piece,this.piecetype);
//                //Turn.count++;
//                if (hasmoved) {
//                    duplicate = i;
//                    Turn.count++;
//                    if (side == Side.White) {
//                        Turn.side_now = Side.Black;
//                        Board.blackTimer.start();
//                        Board.whiteTimer.stop();
//                        soundEffect.moveSound.start();
//                        if(Game.kings[1].isChecked(Game.kings[1].getPosition(),Game.board, Side.Black))
//                        {
//                            isCheckMate(Side.Black,Game.board);
//                            soundEffect.checkSound.start();
//                        }
//                    }else {
//                        Turn.side_now = Side.White;
//                        Board.whiteTimer.start();
//                        Board.blackTimer.stop();
//                        soundEffect.moveSound.start();
//                        if (Game.kings[0].isChecked(Game.kings[0].getPosition(), Game.board, Side.White)) {
//                            isCheckMate(Side.White, Game.board);
//                            soundEffect.checkSound.start();
//                        }
//                    }
//                }
//                Game.pieces[this.piece_array_number].newTurn();
//            }
//        else if(e.getSource()==Board.piece[i]) {
//            duplicate = i;
//            boolean hasmoved = Game.kings[this.piece_array_number].move(k, i, Game.board, Board.piece, this.piecetype);
//            //Turn.count++;
//            if (hasmoved) {
//                duplicate = i;
//                Turn.count++;
//                if (side == Side.White) {
//                    Turn.side_now = Side.Black;
//                    Board.blackTimer.start();
//                    Board.whiteTimer.stop();
//                    soundEffect.moveSound.start();
//
//                } else {
//                    Turn.side_now = Side.White;
//                    Board.blackTimer.stop();
//                    Board.whiteTimer.start();
//                    soundEffect.moveSound.start();
//                }
//            }
//            Game.kings[this.piece_array_number].newTurn();
//        }
//        Board.piece[i].removeActionListener(this);
//    }
//    }
//
//
//
//    public void isCheckMate(Side side,Tile[]board) {
//
//        int validMoves=0;
//        for(int i=0;i<64;i++)
//        {
//            if(side==side.White&&board[i].getSide()==side.White)
//            {
//                if(board[i].getType()=="Pawn")
//                {
//                    Game.pieces[26].Moves(Pieces.PawnW4, Game.board, Board.piece, i);
//                    validMoves+=Game.pieces[26].returnNumberOfMoves();
//                }else if(board[i].getType()=="Queen")
//                {
//                    Game.pieces[12].Moves(Pieces.QueenW, Game.board, Board.piece, i);
//                    validMoves+=Game.pieces[12].returnNumberOfMoves();
//                }else if(board[i].getType()=="Rook")
//                {
//                    Game.pieces[2].Moves(Pieces.RookW1, Game.board, Board.piece, i);
//                    validMoves+=Game.pieces[2].returnNumberOfMoves();
//                }else if(board[i].getType()=="Knight")
//                {
//                    Game.pieces[9].Moves(Pieces.KnightW2, Game.board, Board.piece, i);
//                    validMoves+=Game.pieces[9].returnNumberOfMoves();
//                }else if(board[i].getType()=="Bishop")
//                {
//                    Game.pieces[7].Moves(Pieces.BishopW2, Game.board, Board.piece, i);
//                    validMoves+=Game.pieces[7].returnNumberOfMoves();
//                }else if(board[i].getType()=="King")
//                {
//                    Game.kings[0].Moves(Pieces.KingW, Game.board, Board.piece, i);
//                    validMoves+=Game.kings[0].returnNumberOfMoves();
//                }
//            }else if(side==side.Black&&board[i].getSide()==side.Black) {
//                if(board[i].getType()=="Pawn")
//                {
//                    Game.pieces[19].Moves(Pieces.PawnB4, Game.board, Board.piece, i);
//                    validMoves+=Game.pieces[19].returnNumberOfMoves();
//                }else if(board[i].getType()=="Queen")
//                {
//                    Game.pieces[13].Moves(Pieces.QueenB, Game.board, Board.piece, i);
//                    validMoves+=Game.pieces[13].returnNumberOfMoves();
//                }else if(board[i].getType()=="Rook")
//                {
//                    Game.pieces[0].Moves(Pieces.RookB1, Game.board, Board.piece, i);
//                    validMoves+=Game.pieces[0].returnNumberOfMoves();
//                }else if(board[i].getType()=="Knight")
//                {
//                    Game.pieces[10].Moves(Pieces.KnightB2, Game.board, Board.piece, i);
//                    validMoves+=Game.pieces[10].returnNumberOfMoves();
//                }else if(board[i].getType()=="Bishop")
//                {
//                    Game.pieces[4].Moves(Pieces.BishopB2, Game.board, Board.piece, i);
//                    validMoves+=Game.pieces[4].returnNumberOfMoves();
//                }else if(board[i].getType()=="King")
//                {
//                    Game.kings[1].Moves(Pieces.KingB, Game.board, Board.piece, i);
//                    validMoves+=Game.kings[1].returnNumberOfMoves();
//                }
//            }
//        }
//
//        if(validMoves==0)
//        {
//            soundEffect.checkMateSound.start();
//            soundEffect.checkSound.close();
//
//            if(side==side.White){
//                Board.whiteTimer.stop();
//                new winPage("BLACK");}
//            else {
//                Board.blackTimer.stop();
//                new winPage("WHITE");
//            }
//        }else return;
//     }
//}