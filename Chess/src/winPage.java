import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class winPage extends JFrame implements ActionListener{
    JLabel winner=new JLabel();
    JLabel winning=new JLabel("WINS");
    JLabel title=new JLabel("Chessico");
    JButton start=new JButton("NewGame");
    JButton exit=new JButton("EXIT");
    ImageIcon play_icon=new ImageIcon("play.png");
    ImageIcon exit_icon=new ImageIcon("exit.png");
    ImageIcon logo=new ImageIcon("chess queen logo 2.png");
    JPanel pane1=new JPanel();
    JPanel pane2=new JPanel();

    winPage(String x){
        this.setSize(500,540);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,800,10));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x1F1F21));
        this.setFocusable(false);
        this.setTitle("Chessico");
        this.setIconImage(logo.getImage());

        winner.setText(x);
        winner.setBounds(50,20,100,30);
        winner.setFont(new Font("",Font.BOLD,60));
        winner.setForeground(new Color(0xFFDB58));

        winning.setBounds(50,20,100,30);
        winning.setFont(new Font("",Font.BOLD,60));
        winning.setForeground(new Color(0xFFDB58));

        start.setIcon(play_icon);
        start.setBounds(110,115,160,50);
        start.setFocusable(false);
        start.addActionListener(this);
        start.setBackground(new Color(0xFFDB58));

        exit.setIcon(exit_icon);
        exit.setBounds(110,255,160,50);
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBackground(new Color(0xFFDB58));

        title.setBounds(50,20,400,50);
        title.setFont(new Font("",Font.BOLD,20));
        title.setForeground(Color.WHITE);
        title.setFocusable(false);

        pane1.setBackground(new Color(0x1F1F21));
        pane1.setLayout(new GridLayout(3,1,10,30));
        pane1.setSize(300, 300);
        pane1.setFocusable(false);
        pane1.add(start);
        pane1.add(exit);
        pane1.setVisible(true);

        pane2.setBackground(new Color(0x1F1F21));
        pane2.setLayout(new GridLayout(3,1,10,30));
        pane2.setSize(6, 50);
        pane2.setFocusable(false);
        pane2.setVisible(true);

        this.add(winner);
        this.add(winning);
        this.add(pane2);
        this.add(pane1);
        this.add(title);
        this.setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit)
        {
            System.exit(0);
        }

        if(e.getSource() == start)
        {
            this.dispose();
            new Game();

        }

    }
}
