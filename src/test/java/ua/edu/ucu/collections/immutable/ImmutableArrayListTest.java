package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private ImmutableArrayList arr;

    @Before
    public void setUp() {
        arr = new ImmutableArrayList();

        arr = arr.add(1);
        arr = arr.add(2);
        arr = arr.add(3);
    }

    @Test
    public void testAdd() {
        arr = arr.add(4);
        arr = arr.add("cat");

        Object[] expectedResult = {1, 2, 3, 4, "cat"};
        Object[] actualResult = arr.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddOnPosition() {
        arr = arr.add(1, 500);

        Object[] expectedResult = {1, 500, 2, 3};
        Object[] actualResult = arr.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOnPositionError() {
        arr = arr.add(10, 500);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOnPositionError2() {
        arr = arr.add(-1, 500);
    }

    @Test
    public void testAddAll() {
        Object[] arrToAdd = {"cat", "fox", "raven"};
        arr = arr.addAll(arrToAdd);

        Object[] expectedResult = {1, 2, 3, "cat", "fox", "raven"};
        Object[] actualResult = arr.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddAllOnPosition() {
        Object[] arrToAdd = {"cat", "fox", "raven"};
        arr = arr.addAll(1, arrToAdd);

        Object[] expectedResult = {1, "cat", "fox", "raven", 2, 3};
        Object[] actualResult = arr.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllOnPositionError() {
        Object[] arrToAdd = {"cat", "fox", "raven"};

        arr = arr.addAll(10, arrToAdd);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllOnPositionError2() {
        Object[] arrToAdd = {"cat", "fox", "raven"};

        arr = arr.addAll(-1, arrToAdd);
    }

    @Test
    public void testGet() {
        Object expectedResult = 2;
        Object actualResult = arr.get(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError() {
        Object c = arr.get(3);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError2() {
        Object c = arr.get(-1);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError() {
        arr.remove(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError2() {
        arr.remove(-1);
    }

    @Test
    public void testRemove() {
        arr = arr.remove(1);
        Object[] expectedResult = {1, 3};
        Object[] actualResult = arr.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testSet() {
        arr = arr.set(1, 300);
        Object[] expectedResult = {1, 300, 3};
        Object[] actualResult = arr.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError() {
        arr.set(10, "elem");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError2() {
        arr.set(-1, "elem");
    }

    @Test
    public void testIndexOf() {
        Object expectedResult = 1;
        Object actualResult = arr.indexOf(2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSize() {
        Object expectedResult = 3;
        Object actualResult = arr.size();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testClear() {
        arr = arr.clear();
        Object[] expectedResult = {};
        Object[] actualResult = arr.toArray();

        assertArrayEquals(expectedResult, actualResult);
        assertTrue(arr.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(arr.isEmpty());

        arr = arr.clear();

        assertTrue(arr.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] expectedResult = {1, 2, 3};
        Object[] actualResult = arr.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testToString() {
        String expectedResult = "1, 2, 3";
        String actualResult = arr.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEquals() {
        ImmutableArrayList array = new ImmutableArrayList();

        array = array.add(1);
        array = array.add(2);
        array = array.add(3);

        assertEquals(array, arr);
    }
}
