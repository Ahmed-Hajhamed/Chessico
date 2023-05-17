public class Tile {
    private boolean isOccupied;
    private Side side;
    private Pieces currentPiece;
    private String type;
    private int location;

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Pieces getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Pieces currentPiece) {
        this.currentPiece = currentPiece;
    }

    public void setLocation(int location) {
        this.location = location;
    }
    public void setType(String pieceType) {
        this.type=pieceType;
    }
    public String getType() {
        return type;
    }
}
