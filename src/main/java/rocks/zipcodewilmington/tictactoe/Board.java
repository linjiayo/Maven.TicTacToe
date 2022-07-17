package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Character[][] board;
    public Board(Character[][] matrix) {
        board = matrix;
    }

    private Boolean isInFavorOfChar(Character c) {
        int[] count = new int[8];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == c) {
                    count[row]++;
                    count[col + 3]++;
                    count[7] = (row + col == 2) ? ++count[7] : count[7];
                    count[6] = (row == col) ? ++count[6]  : count[6];
                }
            }
        }
        for (int i : count) {
            if (i == 3) {
                return true;
            }
        }
        return false;
    }

    public Boolean isInFavorOfX() {
        return isInFavorOfChar('X');
    }

    public Boolean isInFavorOfO() {
        return isInFavorOfChar('O');
    }

    public Boolean isTie() {
        return !(isInFavorOfX() || isInFavorOfO());
    }

    public String getWinner() {
        if (isInFavorOfX()) {
            return "X";
        } else if (isInFavorOfO()) {
            return "O";
        } else return "";
    }

}
