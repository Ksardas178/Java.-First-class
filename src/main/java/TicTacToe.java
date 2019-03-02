import java.util.ArrayList;
import java.util.Collections;

public final class TicTacToe {
    private final int size;
    private int[][] field;

    public TicTacToe(int size) {
        if (size <= 0) throw new IllegalArgumentException("Размер поля выражается натуральным числом");
        else {
            this.size = size;
            this.field = new int[size][size];
        }
    }

    private boolean onField(int x, int y) {
        if ((x > 0) && (y > 0) && (x <= size) && (y <= size)) return true;
        else return false;
    }

    private void checkSize(int x, int y) {
        if (!onField(x, y)) throw new IllegalArgumentException("Выбрана клетка за пределами поля");
    }

    public void addElement(int x, int y, int el) {
        checkSize(x, y);
        if (field[x - 1][y - 1] != 0) throw new IllegalStateException("Клетка занята");
        else field[x - 1][y - 1] = el;
    }

    public void deleteElement(int x, int y) {
        checkSize(x, y);
        field[x - 1][y - 1] = 0;
    }

    private enum direction {
        RIGHT(1, 0),
        RIGHT_DOWN(1, 1),
        DOWN(0, 1),
        LEFT_DOWN(-1, 1);

        private final int x;
        private final int y;

        direction(int newX, int newY) {
            x = newX;
            y = newY;
        }
    }

    private int countElements(direction dir, int el, int x, int y) {
        int amount = 0;
        do {
            amount++;
            x += dir.x;
            y += dir.y;
        } while (onField(x, y) && (field[x][y] == el));
        return amount;
    }

    public int longestSequence(int el) {
        int maxSeqLength = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == el) {
                    ArrayList<Integer> listOfLengths = new ArrayList<Integer>();
                    listOfLengths.add(countElements(direction.RIGHT, el, i, j));
                    listOfLengths.add(countElements(direction.RIGHT_DOWN, el, i, j));
                    listOfLengths.add(countElements(direction.LEFT_DOWN, el, i, j));
                    listOfLengths.add(countElements(direction.DOWN, el, i, j));
                    listOfLengths.add(maxSeqLength);
                    maxSeqLength = Collections.max(listOfLengths);
                }
            }
        }
        return maxSeqLength;
    }
}

