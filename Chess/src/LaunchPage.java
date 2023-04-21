import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage extends JFrame implements ActionListener {

    JButton start = new JButton("Start NewGame");
    JButton exit= new JButton("Exit Game");
    JButton stats = new JButton("Statistics");
    JLabel title=new JLabel("Chessico");
    ImageIcon play=new ImageIcon("play.png");

    LaunchPage(){
        this.setLayout(null);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0x000080));

        title.setBounds(50,20,300,50);
        title.setFont(new Font("",Font.BOLD,64));
        title.setForeground(Color.WHITE);

        start.setIcon(play);
        start.setBounds(110,115,160,50);
        start.setFocusable(false);

        stats.setBounds(110,185,160,50);

        exit.setBounds(110,255,160,50);
        exit.addActionListener(this);

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
    }
}
