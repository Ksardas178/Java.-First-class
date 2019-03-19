package MyPackage;

import java.util.Arrays;

import static java.lang.Integer.max;

public final class Sequence {//Описывает последовательность одинаковых элементов
    private Element el;
    private Point[] borders;

    Sequence(Point start, Point end, Element element) {
        el = element;
        borders = new Point[2];
        borders[0] = start;
        borders[1] = end;
    }

    //package-private
    int length() {
        if (el == null) throw new IllegalStateException("Последовательность пуста");
        return max(Math.abs(borders[1].getY() - borders[0].getY()), Math.abs(borders[1].getX() - borders[0].getX()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Sequence) {
            Sequence other = (Sequence) obj;
            return (this.borders[0].equals(other.borders[0]) && this.borders[1].equals(other.borders[1])
                    && this.el == other.el);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = this.el.hashCode();
        result += 17 * Arrays.hashCode(this.borders);
        return result;
    }

    @Override
    public String toString() {
        return ('[' + borders[0].toString() + ", " + borders[1].toString() + ", " + el.toString() + ']');
    }
}