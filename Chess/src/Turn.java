public class Turn {
    Turn() {
        turnPlay();
    }
    static int count =0;
    static Side side_now=Side.White;

    public void turnPlay()
    {
        if (count==0)
            new ButtonCatcher();

    }
}
