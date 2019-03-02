import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @org.junit.jupiter.api.Test
    void addElement() {
        TicTacToe temp = new TicTacToe(3);
        temp.addElement(0,0,1);
        assertEquals(temp.getElement(0,0), 1);
    }

    @org.junit.jupiter.api.Test
    void deleteElement() {
        TicTacToe temp = new TicTacToe(3);
        temp.addElement(0,0,2);
        temp.deleteElement(0,0);
        assertEquals(temp.getElement(0,0), 0);
    }

    @org.junit.jupiter.api.Test
    void longestSequence() {
        TicTacToe temp = new TicTacToe(3);
        temp.addElement(0,2,2);
        temp.addElement(1,2,2);
        temp.addElement(2,2,2);
        temp.addElement(0,0,4);
        temp.addElement(1,1,4);
        assertEquals(temp.longestSequence(0), 2);
        assertEquals(temp.longestSequence(1), 0);
        assertEquals(temp.longestSequence(2), 3);
        assertEquals(temp.longestSequence(4), 2);
    }
}