package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue q;

    @Before
    public void setUp() {
        Object[] arr = {1, 2, 3};
        q = new Queue();
        for (Object i: arr) {
            q.enqueue(i);
        }
    }

    @Test
    public void testPeek() {
        Object expectedResult = 1;
        Object actualResult = q.peek();
        assertEquals(actualResult, expectedResult);
    }
    
    @Test
    public void testEnqueue() {
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);

        Object[] expectedResult = {1, 2, 3, 4, 5, 6};
        Object[] actualResult = q.toArray();

        assertArrayEquals(actualResult, expectedResult);
    }

    @Test
    public void testDequeue() {
        Object expectedRemoved = 1;
        Object actualRemoved = q.dequeue();
        Object expectedResult = 2;
        Object actualResult = q.peek();

        assertEquals(actualResult, expectedResult);
        assertEquals(actualRemoved, expectedRemoved);
    }

    @Test
    public void testToArray() {
        Object[] expectedResult = {1, 2, 3};
        Object[] actualResult = q.toArray();
        assertArrayEquals(actualResult, expectedResult);
    }
}
