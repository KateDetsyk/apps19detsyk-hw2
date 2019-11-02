package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAdd() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarraylist = arrayList.add(4);

        Object[] expResult = new Object[]{1, 2, 3, 4};
        Object[] actualResult = newarraylist.toArray();

        assertArrayEquals(expResult, actualResult);
        assertArrayEquals(arr, arrayList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOnPositionError() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarraylist = arrayList.add(8, 4);
    }

    @Test
    public void testAddOnPosition() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarraylist = arrayList.add(1, 4);

        Object[] expResult = new Object[]{1, 4, 3};
        Object[] actualResult = newarraylist.toArray();

        assertArrayEquals(expResult, actualResult);
        assertArrayEquals(arr, arrayList.toArray());
    }

    @Test
    public void testAddAll() {
        Object[] arr = new Object[]{1, 2, 3};
        Object[] addArr = new Object[]{1, 2, 3};

        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarraylist = arrayList.addAll(addArr);

        Object[] expResult = new Object[]{1, 2, 3, 1, 2, 3};
        Object[] actualResult = newarraylist.toArray();

        assertArrayEquals(expResult, actualResult);
        assertArrayEquals(arr, arrayList.toArray());
    }

    @Test
    public void testAddAllFromPosition() {
        Object[] arr = new Object[]{1, 2, 3, 4};
        Object[] addArr = new Object[]{1, 2, 3};

        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarraylist = arrayList.addAll(1, addArr);

        Object[] expResult = new Object[]{1, 1, 2, 3};
        Object[] actualResult = newarraylist.toArray();

        assertArrayEquals(expResult, actualResult);
        assertArrayEquals(arr, arrayList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllFromPositionError() {
        Object[] arr = new Object[]{1, 2, 3};
        Object[] addArr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarraylist = arrayList.addAll(8, addArr);
    }

    @Test
    public void testGet() {
        Object[] arr = new Object[]{1, 2, 3, 4};

        ImmutableArrayList arrayList = new ImmutableArrayList(arr);

        int expResult = 2;
        int actualResult = (int) arrayList.get(1);

        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        int actualResult = (int) arrayList.get(10);
    }

    @Test
    public void testRemove() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarraylist = arrayList.remove(1);

        Object[] expResult = new Object[]{1, 3};
        Object[] actualResult = newarraylist.toArray();

        assertArrayEquals(expResult, actualResult);
        assertArrayEquals(arr, arrayList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarraylist = arrayList.remove(10);
    }

    @Test
    public void testSet() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarraylist = arrayList.set(1 , 100);

        Object[] expResult = new Object[]{1, 100, 3};
        Object[] actualResult = newarraylist.toArray();

        assertArrayEquals(expResult, actualResult);
        assertArrayEquals(arr, arrayList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarraylist = arrayList.set(10, 100);
    }

    @Test
    public void testIndexOf() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);

        int expResult = 2;
        int actualResult = arrayList.indexOf(3);
        assertEquals(expResult, actualResult);

        int expResult1 = -1;
        int actualResult2 = arrayList.indexOf(10);
        assertEquals(expResult1, actualResult2);
    }

    @Test
    public void testSize() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);

        int expResult = 3;
        int actualResult = arrayList.size();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testClear() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);
        ImmutableArrayList newarrayList = arrayList.clear();

        Object[] expResult = new Object[]{};
        Object[] actualResult = newarrayList.toArray();

        assertArrayEquals(expResult, actualResult);

        int expsize = 0;
        int actualsize = newarrayList.size();

        assertEquals(expsize, actualsize);
    }

    @Test
    public void testIsEmpty() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);

        boolean expResult = false;
        boolean actualResult = arrayList.isEmpty();
        assertEquals(expResult, actualResult);

        ImmutableArrayList newarrayList = arrayList.clear();
        boolean expResult1 = true;
        boolean actualResult1 = newarrayList.isEmpty();
        assertEquals(expResult1, actualResult1);
    }

    @Test
    public void testToArray() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);

        Object[] expResult = arr;
        Object[] actualResult = arrayList.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testToString() {
        Object[] arr = new Object[]{1, 2, 3};
        ImmutableArrayList arrayList = new ImmutableArrayList(arr);

        String expResult = "1, 2, 3";
        String actualResult = arrayList.toString();

        assertEquals(expResult, actualResult);
    }
}
