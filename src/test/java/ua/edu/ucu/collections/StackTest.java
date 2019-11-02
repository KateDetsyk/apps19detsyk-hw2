package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    private Stack s;

    @Before
    public void setUp() {
        Object[] arr = {1, 2, 3};
        s = new Stack();
        for (Object i: arr) {
            s.push(i);
        }
    }
    
    @Test
    public void testPeek() {
        Object expectedResult = 3;
        Object actualResult = s.peek();

        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void testPop() {
        Object expectedRemoved = 3;
        Object actualRemoved = s.pop();
        Object expectedResult = 2;
        Object actualResult = s.peek();

        assertEquals(actualResult, expectedResult);
        assertEquals(actualRemoved, expectedRemoved);
    }

    @Test
    public void testPush() {
        s.push(4);
        s.push(5);
        s.push(6);

        Object[] expectedResult = {6, 5, 4, 3, 2, 1};
        Object[] actualResult = s.toArray();

        assertArrayEquals(actualResult, expectedResult);
    }

    @Test
    public void testToArray() {
        Object[] expectedResult = {3, 2, 1};
        Object[] actualResult = s.toArray();

        assertArrayEquals(actualResult, expectedResult);
    }
}
