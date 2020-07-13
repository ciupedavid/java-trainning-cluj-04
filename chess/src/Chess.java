import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Chess {

    private Piece[][] chessBoard;

    public static final Pattern move = Pattern.compile("[a-h][1-8][a-h][1-8]|q");

    public Chess(Piece[][] chessBoard) {
        this.setInitialBoard(chessBoard);
    }

    public void setInitialBoard(Piece[][] a) {

        for(int j = 0; j < a[0].length; j++) {
            a[1][j] = new Pawn(1);
            a[6][j] = new Pawn(0);
        }

        a[0][0] = new Rook(1);
        a[0][7] = new Rook(1);
        a[7][0] = new Rook(0);
        a[7][7] = new Rook(0);

        a[0][1] = new Knight(1);
        a[0][6] = new Knight(1);
        a[7][1] = new Knight(0);
        a[7][6] = new Knight(0);

        a[0][2] = new Bishop(1);
        a[0][5] = new Bishop(1);
        a[7][2] = new Bishop(0);
        a[7][5] = new Bishop(0);

        a[0][3] = new Queen(1);
        a[0][4] = new King(1);
        a[7][4] = new Queen(0);
        a[7][3] = new King(0);

        this.chessBoard = a;
    }

    public void movePiece(char a, char b, char x, char y) throws IllegalAccessException {
        if ((a != x || b != y) && chessBoard[8 - ((int) b - 48)][(int) a - 97] != null) {
            int a1 = (int) a - 97;
            int b1 = (int) b - 48;

            int x1 = (int) x - 97;
            int y1 = (int) y - 48;
            if (!chessBoard[8 - b1][a1].canMove(a1, b1, x1, y1)) {
                throw new IllegalAccessException("Invalid move");
            } else {
                chessBoard[8 - y1][x1] = chessBoard[8 - b1][a1];
                chessBoard[8 - b1][a1] = null;
            }
        }
    }

    public void playChess() {
        boolean loopCondition = true;
        System.out.println("enter values of the form [a-h][1-8][a-h][1-8]\n\n");
        System.out.println("To exit, enter q\n");
        System.out.println(toString() + "\n\n");

        do {
            Scanner s = new Scanner(System.in);
            try {
                String movePiece = s.next(move);
                if (movePiece.charAt(0) == 'q') {
                    loopCondition = false;
                    break;
                }
                char c1 = movePiece.charAt(0);
                char c2 = movePiece.charAt(1);
                char c3 = movePiece.charAt(2);
                char c4 = movePiece.charAt(3);
                movePiece(c1, c2, c3, c4);
                System.out.println(toString());

            } catch (InputMismatchException e) {
                System.out.println("input of the form [a-h][1-8][a-h][1-8]");
                s = new Scanner(System.in);
            } catch (IllegalAccessException e) {
                System.out.println("Invalid move, try again");
            }
        } while (loopCondition);
    }

    public static void startGame() {
        Piece[][] board = new Piece[8][8];
        Chess game = new Chess(board);
        game.playChess();
    }

    public String inputBoard(int i, int j) {
        String input = "";
        if (chessBoard[i][j] == null) {
            input = "       ";
        } else if (chessBoard[i][j].name.length() == 4) {
            input = chessBoard[i][j] + "   ";
        } else if (chessBoard[i][j].name.length() == 5) {
            input = chessBoard[i][j] + "  ";
        } else if (chessBoard[i][j].name.length() == 6) {
            input = chessBoard[i][j] + " ";
        }
        return input;
    }

    public String toString() {
        String board = "       a        b        c        d        e        f        g        h     \n";
        board += "  +-------+--------+--------+--------+--------+--------+--------+--------+  \n";
        board += "8 |" + inputBoard(0,0) + "| " + inputBoard(0,1) + "| " + inputBoard(0,2) + "| " + inputBoard(0,3) + "| " + inputBoard(0,4) + "| " +
                inputBoard(0,5) + "| " + inputBoard(0,6) + "| " + inputBoard(0,7) + "| 8\n";
        board += "  +-------+--------+--------+--------+--------+--------+--------+--------+  \n";
        board += "7 |" + inputBoard(1,0) + "| " + inputBoard(1,1) + "| " + inputBoard(1,2) + "| " + inputBoard(1,3) + "| " + inputBoard(1,4) + "| " +
                inputBoard(1,5) + "| " + inputBoard(1,6) + "| " + inputBoard(1,7) + "| 7\n";
        board += "  +-------+--------+--------+--------+--------+--------+--------+--------+  \n";
        board += "6 |" + inputBoard(2,0) + "| " + inputBoard(2,1) + "| " + inputBoard(2,2) + "| " + inputBoard(2,3) + "| " + inputBoard(2,4) + "| " +
                inputBoard(2,5) + "| " + inputBoard(2,6) + "| " + inputBoard(2,7) + "| 6\n";
        board += "  +-------+--------+--------+--------+--------+--------+--------+--------+  \n";
        board += "5 |" + inputBoard(3,0) + "| " + inputBoard(3,1) + "| " + inputBoard(3,2) + "| " + inputBoard(3,3) + "| " + inputBoard(3,4) + "| " +
                inputBoard(3,5) + "| " + inputBoard(3,6) + "| " + inputBoard(3,7) + "| 5\n";
        board += "  +-------+--------+--------+--------+--------+--------+--------+--------+  \n";
        board += "4 |" + inputBoard(4,0) + "| " + inputBoard(4,1) + "| " + inputBoard(4,2) + "| " + inputBoard(4,3) + "| " + inputBoard(4,4) + "| " +
                inputBoard(4,5) + "| " + inputBoard(4,6) + "| " + inputBoard(4,7) + "| 4\n";
        board += "  +-------+--------+--------+--------+--------+--------+--------+--------+  \n";
        board += "3 |" + inputBoard(5,0) + "| " + inputBoard(5,1) + "| " + inputBoard(5,2) + "| " + inputBoard(5,3) + "| " + inputBoard(5,4) + "| " +
                inputBoard(5,5) + "| " + inputBoard(5,6) + "| " + inputBoard(5,7) + "| 3\n";
        board += "  +-------+--------+--------+--------+--------+--------+--------+--------+  \n";
        board += "2 |" + inputBoard(6,0) + "| " + inputBoard(6,1) + "| " + inputBoard(6,2) + "| " + inputBoard(6,3) + "| " + inputBoard(6,4) + "| " +
                inputBoard(6,5) + "| " + inputBoard(6,6) + "| " + inputBoard(6,7) + "| 6\n";
        board += "  +-------+--------+--------+--------+--------+--------+--------+--------+  \n";
        board += "1 |" + inputBoard(7,0) + "| " + inputBoard(7,1) + "| " + inputBoard(7,2) + "| " + inputBoard(7,3) + "| " + inputBoard(7,4) + "| " +
                inputBoard(7,5) + "| " + inputBoard(7,6) + "| " + inputBoard(7,7) + "| 1\n";
        board += "  +-------+--------+--------+--------+--------+--------+--------+--------+  \n";
        board += "     a        b        c        d        e        f        g        h     ";
        return board;
    }

}