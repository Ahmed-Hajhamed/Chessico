
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage extends JFrame implements ActionListener {

    JLabel title =new JLabel("Chessico");
    JLabel team = new JLabel("DONE BY:");
    JLabel member1 = new JLabel("Youssef Abo-El-Ela");
    JLabel member2 = new JLabel("Omar Khaled");
    JLabel member3=new JLabel("Abdullah Mahmoud");
    JLabel member4 = new JLabel("Zeyad Amr");
    JLabel member5= new JLabel("Ahmed Adel");
    JButton mainMenu =new JButton("Main Menu");
    LaunchPage(){
        this.setSize(400,400);
        this.getContentPane().setBackground(new Color(0x000080));
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x000080));
        this.setFocusable(false);

        title.setBounds(50,20,300,50);
        title.setFont(new Font("",Font.BOLD,64));
        title.setForeground(Color.WHITE);

        mainMenu.addActionListener(this);
        mainMenu.setFocusable(false);
        mainMenu.setBounds(180,300,200,50);
        mainMenu.setBackground(new Color(0xFFDB58));

        member1.setFocusable(false);
        member2.setFocusable(false);
        member3.setFocusable(false);
        member4.setFocusable(false);
        member5.setFocusable(false);


        team.setBounds(95,80,300,50);
        team.setFont(new Font("",Font.BOLD,30));
        team.setForeground(new Color(0xFFDB58));



        member1.setBounds(95,115,300,50);
        member1.setFont(new Font("",Font.PLAIN,25));
        member1.setForeground(Color.WHITE);


        member2.setBounds(95,145,300,50);
        member2.setFont(new Font("",Font.PLAIN,25));
        member2.setForeground(Color.WHITE);


        member3.setBounds(95,175,300,50);
        member3.setFont(new Font("",Font.PLAIN,25));
        member3.setForeground(Color.WHITE);


        member4.setBounds(95,205,300,50);
        member4.setFont(new Font("",Font.PLAIN,25));
        member4.setForeground(Color.WHITE);


        member5.setBounds(95,235,300,50);
        member5.setFont(new Font("",Font.PLAIN,25));
        member5.setForeground(Color.WHITE);


        this.add(title);
        this.add(mainMenu);
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
    if (e.getSource() == mainMenu)
    {
        this.dispose();
        new MainMenu();
    }

    }
}
