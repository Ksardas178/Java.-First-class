import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class TicTacToe {
    private Element[][] field;

    public TicTacToe(int size) {
        if (size <= 0) throw new IllegalArgumentException("Размер поля выражается натуральным числом");
        else {
            this.field = new Element[size][size];
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++) {
                    field[i][j] = Element.EMPTY;
                }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof TicTacToe) {
            TicTacToe other = (TicTacToe) obj;
            return (Arrays.deepEquals(this.field, other.field) && this.field.length == other.field.length);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = this.field.length;
        result += 31 * Arrays.hashCode(this.field);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                result.append(field[i][j]);
                result.append('|');
            }
            result.append('\n');
        }
        return result.toString();
    }

    public enum Element {
        X,
        Y,
        EMPTY
    }

    private boolean onField(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < field.length) && (y < field.length);
    }

    private void checkSize(int x, int y) {
        if (!onField(x, y)) throw new IllegalArgumentException("Выбрана клетка за пределами поля");
    }

    public void addElement(int x, int y, Element el) {
        checkSize(x, y);
        if (field[x][y] != Element.EMPTY) throw new IllegalStateException("Клетка занята");
        else field[x][y] = el;
    }

    public void deleteElement(int x, int y) {
        checkSize(x, y);
        field[x][y] = Element.EMPTY;
    }

    private enum Direction {
        RIGHT(1, 0),
        RIGHT_DOWN(1, 1),
        DOWN(0, 1),
        LEFT_DOWN(-1, 1);

        private final int x;
        private final int y;

        Direction(int newX, int newY) {
            x = newX;
            y = newY;
        }
    }

    private int countElements(Direction dir, Element el, int x, int y) {
        int amount = 0;
        do {
            amount++;
            x += dir.x;
            y += dir.y;
        } while (onField(x, y) && (field[x][y] == el));
        return amount;
    }

    public int longestSequence(Element el) {
        int maxSeqLength = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == el) {
                    ArrayList<Integer> listOfLengths = new ArrayList<>();
                    listOfLengths.add(countElements(Direction.RIGHT, el, i, j));
                    listOfLengths.add(countElements(Direction.RIGHT_DOWN, el, i, j));
                    listOfLengths.add(countElements(Direction.LEFT_DOWN, el, i, j));
                    listOfLengths.add(countElements(Direction.DOWN, el, i, j));
                    listOfLengths.add(maxSeqLength);
                    maxSeqLength = Collections.max(listOfLengths);
                }
            }
        }
        return maxSeqLength;
    }

    public Element getElement(int x, int y) {
        checkSize(x, y);
        return field[x][y];
    }
}

