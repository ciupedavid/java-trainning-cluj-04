public class Bishop extends Piece {

    String name = "bishop";

    public Bishop(int color) {
        super("bishop", color);
    }

    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        if (Math.abs(startX - endX) == (Math.abs(startY - endY))) {
            return true;
        } else {
            return false;
        }
    }
}
