import static sun.misc.Version.println;

public class Program {
    public static void main(String[] args) {
        TicTacToe temp = new TicTacToe(3);
        int r = temp.longestSequence(TicTacToe.Element.Y);
    }
}
