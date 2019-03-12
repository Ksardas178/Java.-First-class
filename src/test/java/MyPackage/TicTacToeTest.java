package MyPackage;

import MyPackage.Element;
import MyPackage.Point;
import MyPackage.Sequence;
import MyPackage.TicTacToe;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @org.junit.jupiter.api.Test
    void addElement() {
        TicTacToe temp = new TicTacToe(3);
        temp.addElement(0,0, Element.Y);
        assertEquals(temp.getElement(0,0), Element.Y);
        temp.addElement(2,1, Element.X);
        assertEquals(temp.getElement(2,1), Element.X);
        assertEquals(temp.getElement(1,1), Element.EMPTY);
        temp = new TicTacToe(15);
        temp.addElement(13,10, Element.X);
        assertEquals(temp.getElement(13,10), Element.X);
    }

    @org.junit.jupiter.api.Test
    void deleteElement() {
        TicTacToe temp = new TicTacToe(3);
        temp.addElement(0,0, Element.X);
        temp.deleteElement(0,0);
        assertEquals(temp.getElement(0,0), Element.EMPTY);
        temp.addElement(2,0, Element.Y);
        temp.deleteElement(2,0);
        assertEquals(temp.getElement(2,0), Element.EMPTY);
    }

    @org.junit.jupiter.api.Test
    void longestSequence() {
        TicTacToe temp = new TicTacToe(3);
        temp.addElement(0,2, Element.X);
        temp.addElement(1,2, Element.X);
        temp.addElement(2,2, Element.X);
        Point start = new Point(0,0);
        Point end = new Point(2,0);
        Sequence testSeq = new Sequence(start, end, Element.EMPTY);
        assertEquals(testSeq, temp.longestSequence(Element.EMPTY));
        start = new Point(0,2);
        end = new Point(2, 2);
        testSeq = new Sequence(start, end, Element.X);
        assertEquals(testSeq, temp.longestSequence(Element.X));
        temp.addElement(0,0, Element.Y);
        temp.addElement(1,1, Element.Y);
        start = new Point(0,0);
        end = new Point(1, 1);
        testSeq = new Sequence(start, end, Element.Y);
        assertEquals(testSeq, temp.longestSequence(Element.Y));
    }
}