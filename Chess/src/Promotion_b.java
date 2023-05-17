import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Promotion_b extends JFrame implements ActionListener {
    int currentpos;
    JPanel queen=new JPanel();
    ImageIcon queen_b = new ImageIcon("queen_b.png");
    JButton queen_text= new JButton("Queen");
    JLabel queen_icon= new JLabel();
    JPanel bishop=new JPanel();
    ImageIcon bishop_b = new ImageIcon("bishop_b.png");
    JButton bishop_text= new JButton("Bishop");
    JLabel bishop_icon= new JLabel();
    JPanel rook=new JPanel();
    ImageIcon rook_b = new ImageIcon("rook_b.png");
    JButton rook_text= new JButton("Rook");
    JLabel rook_icon= new JLabel();
    JPanel knight=new JPanel();
    ImageIcon knight_b = new ImageIcon("knight_b.png");
    JButton knight_text= new JButton("Knight");
    JLabel knight_icon= new JLabel();
    Promotion_b(int currentpos){
        this.currentpos=currentpos;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setResizable(true);
        this.setLayout(new GridLayout(2,2));
        this.setTitle("Choose your desired promotion");
        queen_text.setFont(new Font("",Font.BOLD,25));
        queen.add(queen_text);
        queen_icon.setIcon(queen_b);
        queen.add(queen_icon);
        this.add(queen);
        bishop_text.setFont(new Font("",Font.BOLD,25));
        bishop.add(bishop_text);
        bishop_icon.setIcon(bishop_b);
        bishop.add(bishop_icon);
        this.add(bishop);
        rook_text.setFont(new Font("",Font.BOLD,25));
        rook.add(rook_text);
        rook_icon.setIcon(rook_b);
        rook.add(rook_icon);
        this.add(rook);
        knight_text.setFont(new Font("",Font.BOLD,25));
        knight.add(knight_text);
        knight_icon.setIcon(knight_b);
        knight.add(knight_icon);
        this.add(knight);
        knight_text.addActionListener(this);
        bishop_text.addActionListener(this);
        rook_text.addActionListener(this);
        queen_text.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == queen_text ){
            this.dispose();
            Game.board[currentpos].setCurrentPiece(Pieces.QueenB);
            Game.board[currentpos].setSide(Side.Black);
            Game.board[currentpos].setType("Queen");
            Game.board[currentpos].setOccupied(true);
            Board.piece[currentpos].setIcon(queen_b);
        }
        if (e.getSource() == bishop_text ){
            this.dispose();
            Game.board[currentpos].setCurrentPiece(Pieces.BishopB1);
            Game.board[currentpos].setSide(Side.Black);
            Game.board[currentpos].setType("Bishop");
            Game.board[currentpos].setOccupied(true);
            Board.piece[currentpos].setIcon(bishop_b);
        }
        if (e.getSource() == rook_text ){
            this.dispose();
            Game.board[currentpos].setCurrentPiece(Pieces.RookB1);
            Game.board[currentpos].setSide(Side.Black);
            Game.board[currentpos].setType("Rook");
            Game.board[currentpos].setOccupied(true);
            Board.piece[currentpos].setIcon(rook_b);
        }
        if (e.getSource() == knight_text ){
            this.dispose();
            Game.board[currentpos].setCurrentPiece(Pieces.KnightB1);
            Game.board[currentpos].setSide(Side.Black);
            Game.board[currentpos].setType("Knight");
            Game.board[currentpos].setOccupied(true);
            Board.piece[currentpos].setIcon(knight_b);
        }
    }
}
