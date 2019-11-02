package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    private ImmutableLinkedList lst1;
    private ImmutableLinkedList lst2;

    @Before
    public void setUp() {
        lst1 = new ImmutableLinkedList();
        lst1 = lst1.add(1);
        lst1 = lst1.add(2);
        lst1 = lst1.add(3);

        lst2 = new ImmutableLinkedList();
        Object[] lsArr = new Object[]{"cat", "dog", "racoon", "bird", "fox", "wolf"};

        for (Object elem: lsArr) {
            lst2 = lst2.add(elem);
        }
    }
    @Test
    public void testAdd() {
        Object[] expectedResult = {1, 2, 3};
        Object[] actualResult = lst1.toArray();

        Object expectedLast = 3;
        Object actualLast = lst1.getLast();

        assertArrayEquals(expectedResult, actualResult);
        assertEquals(expectedLast, actualLast);
    }

    @Test
    public void testAddOnPosition() {
        lst1 = lst1.add(1, 100);
        Object[] expectedResult = {1, 100, 2, 3};
        Object[] actualResult = lst1.toArray();

        Object expectedLast = 100;
        Object actualLast = lst1.get(1);

        assertArrayEquals(expectedResult, actualResult);
        assertEquals(expectedLast, actualLast);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOnPositionError() {
        lst1 = lst1.add(4, 100);
    }

    @Test
    public void testAddAll() {
        Object[] addArr = new Object[]{4, 5, 6};
        lst1 = lst1.addAll(addArr);
        Object[] expectedResult = {1, 2, 3, 4, 5, 6};
        Object[] actualResult = lst1.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddAllFromIndex() {
        Object[] addArr = new Object[]{4, 5, 6};

        lst2 = lst2.addAll(0, addArr);
        Object[] expectedResult = {4, 5, 6, "cat", "dog", "racoon",  "bird", "fox", "wolf"};
        Object[] actualResult = lst2.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllFromIndexError() {
        Object[] addArr = new Object[]{4, 5, 6};
        lst2 = lst2.addAll(6, addArr);
    }

    @Test
    public void testGet() {
        Object expectedResult = "racoon";
        Object actualResult = lst2.get(2);

        assertEquals(expectedResult, actualResult);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError() {
        lst2.get(20);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError() {
        lst2.remove(20);
    }

    @Test
    public void testRemove() {
        lst2 = lst2.remove(3);
        Object[] expectedResult = {"cat", "dog", "racoon", "fox", "wolf"};
        Object[] actualResult = lst2.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError() {
        lst2.set(20, 'k');
    }

    @Test
    public void testSet() {
        lst2 = lst2.set(0, "k");
        Object[] expectedResult = {"k", "dog", "racoon", "bird", "fox", "wolf"};
        Object[] actualResult = lst2.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        Object expectedResult = 2;
        Object actualResult = lst2.indexOf("racoon");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSize() {
        Object expectedResult = 6;
        Object actualResult = lst2.size();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testClear() {
        lst2 = lst2.clear();
        Object[] expectedResult = {};
        Object[] actualResult = lst2.toArray();


        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsEmpty() {
        boolean expectedResult = false;
        boolean actualResult = lst2.isEmpty();
        lst2 = lst2.clear();

        boolean expectedResult1 = true;
        boolean actualResult1 = lst2.isEmpty();

        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult1, actualResult1);
    }

    @Test
    public void testToArray() {
        Object[] expectedResult = {"cat", "dog", "racoon", "bird", "fox", "wolf"};
        Object[] actualResult = lst2.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testToString() {
        String expectedResult = "cat, dog, racoon, bird, fox, wolf";
        String actualResult = lst2.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddFirst() {
        lst2 = lst2.addFirst("raven");
        Object[] expectedResult = {"raven", "cat", "dog", "racoon", "bird", "fox", "wolf"};
        Object[] actualResult = lst2.toArray();

        assertArrayEquals(expectedResult, actualResult);

        Object expectedFirst = "raven";
        Object actualFirst = lst2.getFirst();

        assertEquals(expectedFirst, actualFirst);
    }

    @Test
    public void testAddLast() {
        lst2 = lst2.addLast("raven");
        Object[] expectedResult = {"cat", "dog", "racoon", "bird", "fox", "wolf", "raven"};
        Object[] actualResult = lst2.toArray();

        assertArrayEquals(expectedResult, actualResult);

        Object expectedFirst = "raven";
        Object actualFirst = lst2.getLast();

        assertEquals(expectedFirst, actualFirst);
    }

    @Test
    public void testGetFirst() {
        Object expectedFirst = "cat";
        Object actualFirst = lst2.getFirst();

        assertEquals(expectedFirst, actualFirst);
    }

    @Test
    public void testGetLast() {
        Object expectedLast = "wolf";
        Object actualLast = lst2.getLast();

        assertEquals(expectedLast, actualLast);
    }

    @Test
    public void testRemoveFirst() {
        lst2 = lst2.removeFirst();
        Object[] expectedResult = {"dog", "racoon", "bird", "fox", "wolf"};
        Object[] actualResult = lst2.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testRemoveLast() {
        lst2 = lst2.removeLast();
        Object[] expectedResult = {"cat", "dog", "racoon", "bird", "fox"};
        Object[] actualResult = lst2.toArray();

        assertArrayEquals(expectedResult, actualResult);
    }
}
