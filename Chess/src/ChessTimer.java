import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessTimer {

    JLabel timeLabel = new JLabel();
  static   int timeMinutes=5;
    int elapsedTime = timeMinutes*60000;
    int seconds =0;
    int minutes =timeMinutes;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            elapsedTime=elapsedTime-1000;
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            if (elapsedTime==0) {
               //reset();
                stop();
                if (Board.blackTimer.elapsedTime==0){new winPage("WHITE");}
                else if (Board.whiteTimer.elapsedTime==0){
                    new winPage("BLACK");
                }

            }
        }

    });


    ChessTimer(){

        timeLabel.setBounds(100,100,200,100);
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);


    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime=timeMinutes*60000;
        seconds =0;
        minutes=timeMinutes;

        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);

    }

}