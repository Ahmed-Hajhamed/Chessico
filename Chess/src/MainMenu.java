import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    JButton start = new JButton("Start NewGame");
    JButton exit= new JButton("Exit Game");
    JButton settings = new JButton("Settings");
    JLabel title=new JLabel("Chessico");
    JLabel team = new JLabel("MADE BY:");
    JLabel member1 = new JLabel("Youssef Abo-El-Ela");
    JLabel member2 = new JLabel("Omar Khaled");
    JLabel member3=new JLabel("Abdullah Mahmoud");
    JLabel member4 = new JLabel("Zeyad Amr");
    JLabel member5= new JLabel("Ahmed Adil");
    ImageIcon play_icon=new ImageIcon("play.png");
    ImageIcon exit_icon=new ImageIcon("exit.png");
    ImageIcon settings_icon =new ImageIcon("settings.png");

    MainMenu(){
        this.setTitle("Chessico");
        this.setLayout(null);
        this.setSize(400,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0x3F3C3C));
        this.setFocusable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        title.setBounds(50,20,300,50);
        title.setFont(new Font("",Font.BOLD,64));
        title.setForeground(Color.WHITE);
        title.setFocusable(false);

        start.setIcon(play_icon);
        start.setBounds(110,115,160,60);
        start.setFocusable(false);
        start.addActionListener(this);
        start.setBackground(new Color(0xFFDB58));
        start.setFont(new Font("",Font.BOLD,12));

        settings.setIcon(settings_icon);
        settings.addActionListener(this);
        settings.setFocusable(false);
        // settings.setBounds(110,255,160,50);
        settings.setBounds(110,210,160,60);
        settings.setBackground(new Color(0xFFDB58));
        settings.setFont(new Font("",Font.BOLD,15));

        exit.setIcon(exit_icon);
        //exit.setBounds(110,325,160,50);
        exit.setBounds(110,300,160,60);
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBackground(new Color(0xFFDB58));
        exit.setFont(new Font("",Font.BOLD,15));

        member1.setFocusable(false);
        member2.setFocusable(false);
        member3.setFocusable(false);
        member4.setFocusable(false);
        member5.setFocusable(false);

        team.setBounds(95,400,300,30);
        team.setFont(new Font("",Font.BOLD,30));
        team.setForeground(new Color(0xFFDB58));

        member1.setBounds(95,460,300,30);
        member1.setFont(new Font("",Font.PLAIN,25));
        member1.setForeground(Color.WHITE);


        member2.setBounds(95,520,300,30);
        member2.setFont(new Font("",Font.PLAIN,25));
        member2.setForeground(Color.WHITE);


        member3.setBounds(95,580,300,30);
        member3.setFont(new Font("",Font.PLAIN,25));
        member3.setForeground(Color.WHITE);

        member4.setBounds(95,640,300,30);
        member4.setFont(new Font("",Font.PLAIN,25));
        member4.setForeground(Color.WHITE);

        member5.setBounds(95,700,300,30);
        member5.setFont(new Font("",Font.PLAIN,25));
        member5.setForeground(Color.WHITE);


        this.add(start);
        this.add(title);
        this.add(exit);
        this.add(settings);
        this.add(team);
        this.add(member1);
        this.add(member2);
        this.add(member3);
        this.add(member4);
        this.add(member5);
        this.setVisible(true);
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
            Turn.count=0;
            Turn.side_now=Side.White;
            new Game();
        }
        if(e.getSource() == settings)
        {
            this.dispose();
            new Settings();
        }

    }
}
