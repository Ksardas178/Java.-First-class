package MyPackage;

import java.util.Arrays;

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
        result += 31 * Arrays.deepHashCode(this.field);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                result.append(field[j][i]);
                for (int l = 0; l < Element.longest() - field[j][i].toString().length(); l++) {
                    result.append(' ');
                }
                result.append('|');
            }
            result.append('\n');
        }
        return result.toString();
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

    private Sequence countElements(Direction dir, Element el, int x, int y) {
        Point start = new Point(x, y);
        do {
            x += dir.x;
            y += dir.y;
        } while (onField(x, y) && (field[x][y] == el));
        Point end = new Point(x - dir.x, y - dir.y);
        return new Sequence(start, end, el);
    }

    public Sequence longestSequence(Element el) {
        Sequence seq = null;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++)
                if (field[i][j] == el)
                    for (Direction dir : Direction.values())
                        if (seq == null || seq.length() < countElements(dir, el, i, j).length())
                            seq = countElements(dir, el, i, j);


        }
        return seq;
    }

    public Element getElement(int x, int y) {
        checkSize(x, y);
        return field[x][y];
    }
}

