import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener{

    JFrame frame = new JFrame();
    JLabel title=new JLabel("Welcome To");
    JLabel title2=new JLabel("Chessico");
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton playAsGuestButton = new JButton("Play As Guest");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();

    HashMap<String,String> loginInfo = new HashMap<String,String>();

    LoginPage(HashMap<String,String> loginInfoOriginal){

        frame.setSize(500,540);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0x1F1F21));
        frame.setFocusable(false);
        frame.setTitle("Chessico");

        loginInfo = loginInfoOriginal;

        userIDLabel.setBounds(70,200,85,25);
        userIDLabel.setForeground(new Color(0xFFDB58));
        userIDLabel.setFont(new Font("",Font.BOLD,15));

        userPasswordLabel.setBounds(70,250,85,25);
        userPasswordLabel.setForeground(new Color(0xFFDB58));
        userPasswordLabel.setFont(new Font("",Font.BOLD,15));

        messageLabel.setBounds(160,400,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(175,200,200,25);
        userPasswordField.setBounds(175,250,200,25);

        loginButton.setBounds(175,300,100,50);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setBackground(new Color(0xFFDB58));

        resetButton.setBounds(275,300,100,50);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setBackground(new Color(0xFFDB58));

        playAsGuestButton.setBounds(175,350,200,50);
        playAsGuestButton.setFocusable(false);
        playAsGuestButton.addActionListener(this);
        playAsGuestButton.setBackground(new Color(0xFFDB58));

        title.setFocusable(false);
        title.setBounds(70,25,500,50);
        title.setFont(new Font("",Font.BOLD,60));
        title.setForeground(new Color(0xFFDB58));
        title2.setFocusable(false);
        title2.setBounds(110,85,500,50);
        title2.setFont(new Font("",Font.BOLD,60));
        title2.setForeground(new Color(0xFFDB58));

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(playAsGuestButton);
        frame.add(title);
        frame.add(title2);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");
        }

        if(e.getSource()==loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(loginInfo.containsKey(userID)) {
                if(loginInfo.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    new MainMenu();
                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }

            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found");
            }
        }
        if(e.getSource()==playAsGuestButton) {
            frame.dispose();
            new MainMenu();
        }
    }
}