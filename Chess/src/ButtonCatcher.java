import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonCatcher implements ActionListener {

    ButtonCatcher() {
        if (Turn.count == 0)
            createActionListeners();
    }

    private void createActionListeners() {
        for (int i = 0; i < 64; i++) {
            Board.piece[i].addActionListener(this);
        }
    }
    //(Game.board[i].getSide() == Side.White && Turn.side_now==Side.White)
    @Override
    public void actionPerformed(ActionEvent e) {
        int piece_array_no;
        for (int i = 0; i < 64; i++) {
            if (e.getSource() == Board.piece[i]) {
                if (Game.board[i].getSide() ==  Turn.side_now) {
                    switch (Game.board[i].getCurrentPiece()) {
                        case RookB1: {
                            piece_array_no=0;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.RookB1, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case RookB2: {
                            piece_array_no=1;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.RookB2, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case RookW1: {
                            piece_array_no=2;
                            if (i!=ToButtonCatcher.duplicate && Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.RookW1, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case RookW2: {
                            piece_array_no=3;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.RookW2, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }

                        case BishopB2: {
                            piece_array_no = 4;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.BishopB2, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case BishopW1: {
                            piece_array_no = 5;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.BishopW1, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case BishopB1: {
                            piece_array_no = 6;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide())
                            {
                                Game.pieces[piece_array_no].Moves(Pieces.BishopB1, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case BishopW2: {
                            piece_array_no = 7;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.BishopW2, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnB1: {
                            piece_array_no = 16;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnB1, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnB2: {
                            piece_array_no = 17;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnB2, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnB3: {
                            piece_array_no = 18;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnB3, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnB4: {
                            piece_array_no = 19;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnB4, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());

                            }
                            break;
                        }
                        case PawnB5: {
                            piece_array_no = 20;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnB5, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnB6: {
                            piece_array_no = 21;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnB6, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnB7: {
                            piece_array_no = 22;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnB7, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnB8: {
                            piece_array_no = 23;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnB8, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnW1: {
                            piece_array_no = 24;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnW1, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnW2: {
                            piece_array_no = 25;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnW2, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnW3: {
                            piece_array_no = 26;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnW3, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnW4: {
                            piece_array_no = 27;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnW4, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnW5: {
                            piece_array_no = 28;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnW5, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnW6: {
                            piece_array_no = 29;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnW6, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnW7: {
                            piece_array_no = 30;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnW7, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case PawnW8: {
                            piece_array_no = 31;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.PawnW8, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case KnightW1: {
                            piece_array_no = 8;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.KnightW1, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case KnightW2: {
                            piece_array_no = 9;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.KnightW2, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case KnightB1: {
                            piece_array_no = 10;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.KnightB1, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case KnightB2: {
                            piece_array_no = 11;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.KnightB2, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case KingW:{
                            piece_array_no=0;
                            if(i!=ToButtonCatcher.duplicate&&Turn.side_now==Game.board[i].getSide()) {
                                Game.kings[piece_array_no].Moves(Pieces.KingW, Game.board, Board.piece, i);
                                new ToButtonCatcher(i,piece_array_no,Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case KingB:{
                            piece_array_no=1;
                            if(i!=ToButtonCatcher.duplicate&&Turn.side_now==Game.board[i].getSide()) {
                                Game.kings[piece_array_no].Moves(Pieces.KingB, Game.board, Board.piece, i);
                                new ToButtonCatcher(i,piece_array_no,Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case QueenB: {
                            piece_array_no = 13;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.QueenB, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                        case QueenW: {
                            piece_array_no = 12;
                            if (i!=ToButtonCatcher.duplicate&& Turn.side_now==Game.board[i].getSide()) {
                                Game.pieces[piece_array_no].Moves(Pieces.QueenW, Game.board, Board.piece, i);
                                new ToButtonCatcher(i, piece_array_no, Game.board[i].getCurrentPiece(),Game.board[i].getSide());
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}
