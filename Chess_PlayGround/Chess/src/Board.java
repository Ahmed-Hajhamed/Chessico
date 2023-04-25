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
    ImageIcon bishop_b  = new ImageIcon("bishop_b.png");
    ImageIcon bishop_w = new ImageIcon("bishop_w.png");

    JButton [][] piece = new JButton[8][8];
    JPanel[] grid= new JPanel[64];
    Board(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800,800));
        this.setResizable(false);
        this.setLayout(new GridLayout(8,8));

        for (int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                this.add(piece[i][j]= new JButton());
                piece[i][j].setFocusable(false);
                piece[i][j].addActionListener(this);
            }
        }
        for(int i=0;i<8;i++)
        {
            piece [1][i].setIcon(pawn_b);
            piece [6][i].setIcon(pawn_w);
        }

        piece[0][0].setIcon(rook_b);
        piece[0][7].setIcon(rook_b);
        piece[0][1].setIcon(knight_b);
        piece[0][6].setIcon(knight_b);
        piece[0][2].setIcon(bishop_b);
        piece[0][5].setIcon(bishop_b);
        piece[0][3].setIcon(queen_b);
        piece[0][4].setIcon(king_b);
        piece[7][0].setIcon(rook_w);
        piece[7][7].setIcon(rook_w);
        piece[7][1].setIcon(knight_w);
        piece[7][6].setIcon(knight_w);
        piece[7][2].setIcon(bishop_w);
        piece[7][5].setIcon(bishop_w);
        piece[7][3].setIcon(queen_w);
        piece[7][4].setIcon(king_w);

        for (int col=0;col<8;col+=2)
        {
            for (int row=0;row<8;row+=2)
            {
                piece[row][col].setBackground(Color.WHITE);
            }
            for (int row=1;row<8;row+=2)
            {
                piece[row][col].setBackground(Color.BLACK);
            }
        }
        for (int col=1;col<8;col+=2)
        {
            for (int row=0;row<8;row+=2)
            {
                piece[row][col].setBackground(Color.BLACK);
            }
            for (int row=1;row<8;row+=2)
            {
                piece[row][col].setBackground(Color.WHITE);
            }
        }
            this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==piece[0][0])
            if (piece[0][0])
    }

    public boolean checkOccupation(Tile[] board )
}

