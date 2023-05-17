import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Board extends JFrame implements ActionListener {




    static ImageIcon pawn_b = new ImageIcon("pawn_b.png");
   static ImageIcon pawn_w = new ImageIcon("pawn_w.png");
    static ImageIcon king_b = new ImageIcon("king_b.png");
    static ImageIcon king_w = new ImageIcon("king_w.png");
    static ImageIcon rook_b = new ImageIcon("rook_b.png");
    static ImageIcon rook_w = new ImageIcon("rook_w.png");
    static ImageIcon queen_b = new ImageIcon("queen_b.png");
    static ImageIcon queen_w = new ImageIcon("queen_w.png");
    static ImageIcon knight_b = new ImageIcon("knight_b.png");
    static ImageIcon knight_w = new ImageIcon("knight_w.png");
    static ImageIcon bishop_b = new ImageIcon("bishop_b.png");
    static ImageIcon bishop_w = new ImageIcon("bishop_w.png");

    static JButton[] piece = new JButton[64];
    public static JButton[]WhiteDeads=new JButton[18];
    public static JButton[]blackDeads=new JButton[18];
    JPanel whiteKills=new JPanel();
    JPanel blackKiils=new JPanel();
    JButton exit = new JButton();
    JPanel ChessPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    static JLabel whiteTimerLabel = new JLabel();
    static JLabel blackTimerLabel= new JLabel();
    static ChessTimer whiteTimer = new ChessTimer();
    static ChessTimer blackTimer= new ChessTimer();

    static ArrayList<String>whiteDeadPieces;
    static ArrayList<String> blackDeadPieces;

    static int white = 1;
    static  Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            whiteTimerLabel.setText("WHITE: "+whiteTimer.minutes_string+":"+whiteTimer.seconds_string);
            blackTimerLabel.setText("BLACK: "+blackTimer.minutes_string+":"+blackTimer.seconds_string);
        }

    });


    Board() {
        whiteDeadPieces=new ArrayList<String>();
        blackDeadPieces=new ArrayList<String>();

        whiteTimerLabel.setText("WHITE: "+whiteTimer.minutes_string+":"+whiteTimer.seconds_string);
        blackTimerLabel.setText("BLACK: "+blackTimer.minutes_string+":"+blackTimer.seconds_string);
        whiteTimer.reset();
        blackTimer.reset();
        whiteTimer.start();
        //blackTimer.stop();
        timer.start();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1560, 800);
        this.setResizable(true);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1F1F21));

        ChessPanel.setBounds(367, 0, 800, 800);
        ChessPanel.setVisible(true);
        ChessPanel.setLayout(null);

        whiteKills.setBounds(35, 310, 300, 420);
        whiteKills.setFocusable(false);
        whiteKills.setLayout(null);
        whiteKills.setBackground(new Color(0x9695A0));
        whiteKills.setVisible(true);

        blackKiils.setBounds(1197, 310, 300, 420);
        blackKiils.setFocusable(false);
        blackKiils.setLayout(null);
        blackKiils.setBackground(new Color(0x9695A0));
        blackKiils.setVisible(true);

        whiteTimerLabel.setFocusable(false);
        whiteTimerLabel.setBounds(0, 25, 300, 50);
        whiteTimerLabel.setFont(new Font("", Font.PLAIN, 45));

        blackTimerLabel.setFocusable(false);
        blackTimerLabel.setBounds(0, 25, 300, 50);
        blackTimerLabel.setFont(new Font("", Font.PLAIN, 45));

        panel1.setBounds(35, 200, 300, 100);
        panel1.setVisible(true);
        panel1.setLayout(null);
        panel1.setBackground(new Color(0x9695A0));
        panel1.add(whiteTimerLabel);

        panel2.setBounds(1197, 200, 300, 100);
        panel2.setVisible(true);
        panel2.setLayout(null);
        panel2.setBackground(new Color(0x9695A0));
        panel2.add(blackTimerLabel);


        exit.addActionListener(this);
        exit.setText("Exit The Match");
        exit.setBounds(0, 0, 150, 50);
        exit.setBackground(new Color(0x9695A0));

        for (int i = 0; i < 64; i++) {
            ChessPanel.add(piece[i] = new JButton());
            piece[i].setBounds((i % 8) * 100, (i / 8) * 100, 100, 100);
            piece[i].setFocusable(false);
            piece[i].addActionListener(this);
        }
        for(int i=0;i<18;i++)
        {
            whiteKills.add(blackDeads[i]=new JButton());
            blackDeads[i].setBounds((i%3)*100,(i/3)*70,100,70);
            blackDeads[i].setFocusable(false);
        }

        for(int i=0;i<18;i++)
        {
            blackKiils.add(WhiteDeads[i]=new JButton());
            WhiteDeads[i].setBounds((i%3)*100,(i/3)*70,100,70);
            WhiteDeads[i].setFocusable(false);
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
        piece[58].setIcon(bishop_w);
        piece[61].setIcon(bishop_w);
        piece[59].setIcon(queen_w);
        piece[60].setIcon(king_w);

        for (int i = 0; i < 64; i++) {
            if (white == 1) {
                piece[i].setBackground(Settings.lightColour);
                if ((i + 1) % 8 == 0) {
                    continue;
                }
                white = 0;
            } else {
                piece[i].setBackground(Settings.darkColour);
                if ((i + 1) % 8 == 0) {
                    continue;
                }
                white = 1;
            }
        }
        this.setTitle("Chessico");
        this.setVisible(true);
        this.add(ChessPanel);
        this.add(panel1);
        this.add(panel2);
        this.add(whiteKills);
        this.add(blackKiils);
        this.add(exit);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            whiteTimer.reset();
            blackTimer.reset();
            this.dispose();
            new MainMenu();
        }

    }
    static void deadButtons(ArrayList<String>deads,Side side)
    {
        for(int i=0;i<deads.size();i++)
        {
            if(deads.get(i)=="Bishop")
            {
                if(side==side.Black)
                {
                    WhiteDeads[i].setIcon(bishop_w);
                }else {
                    blackDeads[i].setIcon(bishop_b);
                }
            }else if(deads.get(i)=="Knight")
            {
                if(side==side.Black)
                {
                    WhiteDeads[i].setIcon(knight_w);
                }else {
                    blackDeads[i].setIcon(knight_b);
                }
            }else if(deads.get(i)=="Rook")
            {
                if(side==side.Black)
                {
                    WhiteDeads[i].setIcon(rook_w);
                }else {
                    blackDeads[i].setIcon(rook_b);
                }
            }else if(deads.get(i)=="Queen")
            {
                if(side==side.Black)
                {
                    WhiteDeads[i].setIcon(queen_w);
                }else {
                    blackDeads[i].setIcon(queen_b);
                }
            }else if(deads.get(i)=="Pawn")
            {
                if(side==side.Black)
                {
                    WhiteDeads[i].setIcon(pawn_w);
                }else {
                    blackDeads[i].setIcon(pawn_b);
                }
            }
        }
    }
}