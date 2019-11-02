package ua.edu.ucu.collections.immutable;


public final class ImmutableArrayList implements ImmutableList{

    private Object[] array;
    private int size;

    public ImmutableArrayList(Object[] array) {
        this.array = array;
        this.size = size();
    }

    @Override
    public ImmutableArrayList add(Object e) {
        int len = size + 1;
        Object[] arr = new Object[len];
        for (int i = 0; i < size; i++) {
            arr[i] = array[i];
        }
        arr[--len] = e;
        return new ImmutableArrayList(arr);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] arr = new Object[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
        arr[index] = e;
        return new ImmutableArrayList(arr);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        int len = size + c.length;
        Object[] arr = new Object[len];
        int last = 0;
        for (int i = 0; i < size; i++) {
            arr[i] = array[i];
            last++;
        }
        for (int i = 0; i < c.length; i++) {
            arr[last] = array[i];
            last++;
        }
        return new ImmutableArrayList(arr);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index + c.length - 1 >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] arr = new Object[size];
        int last = 0;
        for (int i = 0; i < index; i++) {
            arr[i] = array[i];
        }
        for (int i = index; i < size; i++) {
            arr[i] = c[last];
            last++;
        }
        return new ImmutableArrayList(arr);
    }

    @Override
    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int len = size - 1;
        Object[] arr = new Object[len];
        int last = 0;
        for (int i = 0; i < size; i++) {
            if (i != index) {
                arr[last] = array[i];
                last ++;
            }
        }
        return new ImmutableArrayList(arr);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            if (i == index){
                arr[i] = e;
                continue;
            }
            arr[i] = array[i];
        }
        return new ImmutableArrayList(arr);
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        for (Object elem: array) {
            if (elem == e) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        int len = 0;

        if (array == null || array.length == 0) {
            return len;
        }
        for (Object el: array) {
            len ++;
        }
        return len;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList(new Object[0]);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < size(); i++) {
            if (i == size()-1) {
                result = result + array[i];
            } else {
                result = result + array[i] + ", ";
            }
        }
        return result;
    }
}
