public class Rook extends Piece {

    String name = "rook";

    public Rook(int color) {
        super("rook", color);
    }


    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        if (startX == endX ||  startY == endY) {
            return true;
        } else {
            return  false;
        }
    }
}
