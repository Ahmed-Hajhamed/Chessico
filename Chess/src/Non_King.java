public abstract class Non_King implements Piece{
    protected int position;
    protected boolean isKilled;
    protected Side side;


    Non_King(Side side,int position)
    {
        this.side=side;
        this.position=position;
        this.isKilled=false;
    }
}