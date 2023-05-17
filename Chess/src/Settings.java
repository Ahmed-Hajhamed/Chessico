import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class Settings extends JFrame implements ActionListener {

    static Color darkColour= Color.BLACK;
    static Color lightColour= Color.WHITE;
    JButton black = new JButton("Black");
    JButton brown= new JButton("Brown");
    JButton green = new JButton("Green");
    JButton fiveMinutes = new JButton("5:00");
    JButton tenMinutes= new JButton("10:00");
    JButton fifteenMinutes = new JButton("15:00");
    JLabel themes = new JLabel();
    JLabel timer = new JLabel();
    JButton gray = new JButton("Gray");
    JButton back = new JButton("");

    ImageIcon back_icon=new ImageIcon("back.png");




    Settings(){

        this.setLayout(null);
        this.setSize(420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0x3F3C3C));
        this.setFocusable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        themes.setText("Themes:");
        themes.setBounds(15,50,140,50);
        themes.setFocusable(false);
        themes.setForeground(new Color(0xFFDB58));
        themes.setFont(new Font("",Font.PLAIN,25));

        timer.setText("Timer:");
        timer.setBounds(220,50,140,50);
        timer.setFocusable(false);
        timer.setForeground(new Color(0xFFDB58));
        timer.setFont(new Font("",Font.PLAIN,25));

        black.setBounds(15,110,140,50);
        black.setFocusable(false);
        black.addActionListener(this);
        black.setBackground(new Color(0xFFDB58));
        black.setFont(new Font("",Font.PLAIN,25));

        brown.setBounds(15,180,140,50);
        brown.setFocusable(false);
        brown.addActionListener(this);
        brown.setBackground(new Color(0xFFDB58));
        brown.setFont(new Font("",Font.PLAIN,25));

        green.setBounds(15,250,140,50);
        green.setFocusable(false);
        green.addActionListener(this);
        green.setBackground(new Color(0xFFDB58));
        green.setFont(new Font("",Font.PLAIN,25));

        gray.setBounds(15,320,140,50);
        gray.setFocusable(false);
        gray.addActionListener(this);
        gray.setBackground(new Color(0xFFDB58));
        gray.setFont(new Font("",Font.PLAIN,25));


        fiveMinutes.setBounds(220,110,140,50);
        fiveMinutes.setFocusable(false);
        fiveMinutes.addActionListener(this);
        fiveMinutes.setBackground(new Color(0xFFDB58));
        fiveMinutes.setFont(new Font("",Font.PLAIN,25));

        tenMinutes.setBounds(220,210,140,50);
        tenMinutes.setFocusable(false);
        tenMinutes.addActionListener(this);
        tenMinutes.setBackground(new Color(0xFFDB58));
        tenMinutes.setFont(new Font("",Font.PLAIN,25));

        fifteenMinutes.setBounds(220,320,140,50);
        fifteenMinutes.setFocusable(false);
        fifteenMinutes.addActionListener(this);
        fifteenMinutes.setBackground(new Color(0xFFDB58));
        fifteenMinutes.setFont(new Font("",Font.PLAIN,25));

        back.setIcon(back_icon);
        back.setBounds(15,0,50,50);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setBackground(null);

        this.setTitle("Themes");
        this.add(black);
        this.add(brown);
        this.add(green);
        this.add(gray);
        this.add(fiveMinutes);
        this.add(tenMinutes);
        this.add(fifteenMinutes);
        this.add(back);
        this.add(themes);
        this.add(timer);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == black) {

            darkColour = Color.black;
            lightColour=Color.white;

        }
        if(e.getSource() == brown)
        {
            darkColour= new Color(Integer.parseInt("592C07",16));
            lightColour= new Color(Integer.parseInt("EEC28A",16));
        }
        if(e.getSource() == green)
        {
            darkColour= new Color(Integer.parseInt("1E7A0A",16));
            lightColour= Color.WHITE;
        }

        if (e.getSource() == gray)
        {
            darkColour= new Color(Integer.parseInt("333033",16));
            lightColour= new Color(Integer.parseInt("A8A2A9",16));

        }
        if (e.getSource()== back){
            this.dispose();
            new MainMenu();
        }
        if (e.getSource()==fiveMinutes){
            ChessTimer.timeMinutes=5;
        }
        if (e.getSource()==tenMinutes){
            ChessTimer.timeMinutes=10;
        }
        if (e.getSource()==fifteenMinutes){
            ChessTimer.timeMinutes=15;
        }
    }


}
