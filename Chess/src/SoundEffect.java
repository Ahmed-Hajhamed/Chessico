import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class SoundEffect {

       public Clip moveSound;
 public Clip checkSound;
 public Clip checkMateSound;

       SoundEffect() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        File file = new File("checkSound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
         checkSound = AudioSystem.getClip();
        checkSound.open(audioStream);

        File file2 = new File("checkMateSound.wav");
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
         checkMateSound = AudioSystem.getClip();
        checkMateSound.open(audioStream2);

        File file3 = new File("moveSound.wav");
        AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
         moveSound = AudioSystem.getClip();
        moveSound.open(audioStream3);

 }


}
