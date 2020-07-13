public class King extends Piece{

    String name = "king";

    public King(int color) {
        super("king", color);
    }

    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        if ((Math.abs(endX-startX) == 1) || (Math.abs(endY-startY) == 1)) {
            return true;
        } else {
            return false;
        }
    }
}
