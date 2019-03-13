package MyPackage;

public final class Point {
    private final int x;
    private final int y;

    //package-private
    Point(int newX, int newY) {
        x = newX;
        y = newY;
    }

    //package-private
    int getX() {
        return x;
    }

    //package-private
    int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Point) {
            Point other = (Point) obj;
            return (this.x == other.x && this.y == other.y);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = this.x;
        result += 29 * this.y;
        return result;
    }

    @Override
    public String toString() {
        return ("(" + x + ", " + y + ')');
    }
}