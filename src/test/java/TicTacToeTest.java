import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @org.junit.jupiter.api.Test
    void addElement() {
        TicTacToe temp = new TicTacToe(3);
        temp.addElement(0,0, TicTacToe.Element.Y);
        assertEquals(temp.getElement(0,0), TicTacToe.Element.Y);
    }

    @org.junit.jupiter.api.Test
    void deleteElement() {
        TicTacToe temp = new TicTacToe(3);
        temp.addElement(0,0, TicTacToe.Element.X);
        temp.deleteElement(0,0);
        assertEquals(temp.getElement(0,0), TicTacToe.Element.EMPTY);
    }

    @org.junit.jupiter.api.Test
    void longestSequence() {
        TicTacToe temp = new TicTacToe(3);
        temp.addElement(0,2, TicTacToe.Element.X);
        temp.addElement(1,2, TicTacToe.Element.X);
        temp.addElement(2,2, TicTacToe.Element.X);
        assertEquals(temp.longestSequence(TicTacToe.Element.EMPTY), 3);
    }
}