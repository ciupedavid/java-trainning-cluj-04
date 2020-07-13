public class Knight extends Piece {

    String name = "knight";

    public Knight(int color) {
        super("knight", color);
    }

    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        if (((Math.abs(endX - startX) == 2) && (Math.abs(endY - startY) == 1) || (Math.abs(endY - startY) == 2 && Math.abs(endX - startX) == 1))) {
            return true;
        }
        return false;
    }
}
