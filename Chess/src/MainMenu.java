import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    JButton start = new JButton("Start NewGame");
    JButton exit= new JButton("Exit Game");
    JButton stats = new JButton("Statistics");
    JLabel title=new JLabel("Chessico");
    ImageIcon play_icon=new ImageIcon("play.png");
    ImageIcon stats_icon=new ImageIcon("stats.png");
    ImageIcon exit_icon=new ImageIcon("exit.png");

    MainMenu(){
        this.setLayout(null);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0x000080));
        this.setFocusable(false);

        title.setBounds(50,20,300,50);
        title.setFont(new Font("",Font.BOLD,64));
        title.setForeground(Color.WHITE);
        title.setFocusable(false);

        start.setIcon(play_icon);
        start.setBounds(110,115,160,50);
        start.setFocusable(false);
        start.addActionListener(this);
        start.setBackground(new Color(0xFFDB58));

        stats.setIcon(stats_icon);
        stats.setBounds(110,185,160,50);
        stats.setFocusable(false);
        stats.addActionListener(this);
        stats.setBackground(new Color(0xFFDB58));

        exit.setIcon(exit_icon);
        exit.setBounds(110,255,160,50);
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBackground(new Color(0xFFDB58));

        this.add(start);
        this.add(title);
        this.add(stats);
        this.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == exit)
    {
        System.exit(0);
    }

    if(e.getSource() == start)
    {
        this.dispose();
        new Board();
    }

    }
}
