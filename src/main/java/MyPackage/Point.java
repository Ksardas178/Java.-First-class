package MyPackage;

public final class Point {
    private final int x;
    private final int y;

    public Point(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
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
        StringBuilder result = new StringBuilder();
        result.append("("+x+", "+y+')');
        return result.toString();
    }
}