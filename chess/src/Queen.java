public class Queen extends Piece{

    String name = "queen";

    public Queen(int color) {
        super("queen", color);
    }

    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        if ((startX == endX ||  startY == endY) ||(Math.abs(startX - endX) == (Math.abs(startY - endY)))) {
            return true;
        } else {
            return  false;
        }
    }
}
