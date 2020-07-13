public class Pawn extends Piece {

    String name = "pawn";

    public Pawn(int color) {
        super("pawn", color);
    }

    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        if (startX != endX) {
            return false;
        }
        if (endY - startY > 1 || endY < startY) {
            return false;
        }
        return true;
    }
}
