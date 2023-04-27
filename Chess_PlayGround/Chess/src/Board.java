import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Board extends JFrame implements ActionListener {


    ImageIcon pawn_b = new ImageIcon("pawn_b.png");
    ImageIcon pawn_w = new ImageIcon("pawn_w.png");
    ImageIcon king_b = new ImageIcon("king_b.png");
    ImageIcon king_w = new ImageIcon("king_w.png");
    ImageIcon rook_b = new ImageIcon("rook_b.png");
    ImageIcon rook_w = new ImageIcon("rook_w.png");
    ImageIcon queen_b = new ImageIcon("queen_b.png");
    ImageIcon queen_w = new ImageIcon("queen_w.png");
    ImageIcon knight_b = new ImageIcon("knight_b.png");
    ImageIcon knight_w = new ImageIcon("knight_w.png");
    ImageIcon bishop_b = new ImageIcon("bishop_b.png");
    ImageIcon bishop_w = new ImageIcon("bishop_w.png");

    JButton[] piece = new JButton[64];

    Board() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 800));
        this.setResizable(false);
        this.setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 64; i++) {
            this.add(piece[i] = new JButton());
            piece[i].setFocusable(false);
            piece[i].addActionListener(this);
        }
        for (int i = 8; i < 16; i++) {
            piece[i].setIcon(pawn_b);
        }
        for (int i = 48; i < 56; i++) {
            piece[i].setIcon(pawn_w);
        }

        piece[0].setIcon(rook_b);
        piece[7].setIcon(rook_b);
        piece[1].setIcon(knight_b);
        piece[6].setIcon(knight_b);
        piece[2].setIcon(bishop_b);
        piece[5].setIcon(bishop_b);
        piece[3].setIcon(queen_b);
        piece[4].setIcon(king_b);
        piece[56].setIcon(rook_w);
        piece[63].setIcon(rook_w);
        piece[57].setIcon(knight_w);
        piece[62].setIcon(knight_w);
        piece[61].setIcon(bishop_w);
        piece[58].setIcon(bishop_w);
        piece[59].setIcon(queen_w);
        piece[60].setIcon(king_w);
        int i = 0;
        for (int j = 0; j < 64; j++) {

            if (i % 2 == 0) {
                if (j % 2 == 0)
                    piece[j].setBackground(Color.WHITE);
                else piece[j].setBackground(Color.BLACK);

            } else if (i % 2 != 0) {
                if (j % 2 == 0)
                    piece[j].setBackground(Color.BLACK);
                else piece[j].setBackground(Color.WHITE);

            }
            if (j % 8 == 7)
                i++;
        }
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 64; i++) {
            if (e.getSource() == piece[i]) {
                if (Game.board[i].getSide() == Side.Black) {
                    switch (Game.board[i].getCurrentPiece()) {
                        case RookB1: {
                                Game.pieces[0].Moves(Pieces.RookB1);
                                Game.pieces[0].validMoves(Game.board, piece);
                                break;
                        }
                        case RookB2: {
                            Game.pieces[1].Moves(Pieces.RookB2);
                            Game.pieces[1].validMoves(Game.board, piece);
                            break;
                        }
                    }
                }
            }

        }
    }
}


