import javax.swing.*;

public interface Piece {
    enum Side {
        black, white
    }

    public void move();

    public boolean isMoveValid();

    public void kill();                     //not interface
}
