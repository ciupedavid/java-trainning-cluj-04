public abstract class Piece {

    String name;
    int color;
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Piece(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public abstract boolean canMove(int startX, int startY, int endX, int endY);

    @Override
    public String toString() {
        if (color == 0) {
            return ANSI_YELLOW + name.toUpperCase() + ANSI_RESET;
        } else {
            return ANSI_PURPLE + name.toUpperCase() + ANSI_RESET;
        }
    }
}
