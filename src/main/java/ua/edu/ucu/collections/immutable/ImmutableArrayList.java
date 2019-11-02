package ua.edu.ucu.collections.immutable;


public final class ImmutableArrayList implements ImmutableList {

    private int size = 0;
    private int capasity = 0;
    private Object[] array = new Object[capasity];

    private static void resize(ImmutableArrayList arr) {
        if (arr.capasity == 0) {
            arr.capasity = 1;
        }
        arr.capasity = arr.capasity*2;

        Object[] oldArr = arr.array;
        arr.array = new Object[arr.capasity];
        arr.size = 0;
        for (Object i: oldArr) {
            arr.array[arr.size] = i;
            arr.size = arr.size + 1;
        }
    }

    public void copy(ImmutableArrayList arr) {
        int index = 0;
        for (Object i : array) {
            if (index >= arr.capasity) {
                resize(arr);
            }
            if (i == null) {
                break;
            }
            arr.array[index] = i;
            index++;
            arr.size = arr.size + 1;
        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        ImmutableArrayList arr = new ImmutableArrayList();
        copy(arr);

        if (arr.size >= arr.capasity) {
            resize(arr);
        }
        arr.array[arr.size] = e;
        arr.size = arr.size + 1;

        return arr;
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableArrayList arr = new ImmutableArrayList();

        int position = 0;
        for (Object i : array) {
            if (i == null) {
                break;
            }
            if (position >= arr.capasity) {
                resize(arr);
            }
            if (position == index) {
                arr.array[position] = e;
                position++;
                arr.size = arr.size + 1;
            }
            if (position >= arr.capasity) {
                resize(arr);
            }
            arr.array[position] = i;
            position++;
            arr.size = arr.size + 1;
        }
        return arr;
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        ImmutableArrayList arr = new ImmutableArrayList();
        copy(arr);

        for (Object aC : c) {
            if (arr.size >= arr.capasity) {
                resize(arr);
            }
            arr.array[arr.size] = aC;
            arr.size = arr.size + 1;
        }
        return arr;
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableArrayList arr = new ImmutableArrayList();
        copy(arr);
        int position = 0;
        for (Object i : array) {
            if (i == null) {
                break;
            }
            if (position >= arr.capasity) {
                resize(arr);
            }
            if (position == index) {
                for (Object elem: c) {
                    if (position >= arr.capasity) {
                        resize(arr);
                    }
                    arr.array[position] = elem;
                    position++;
                    arr.size = arr.size + 1;
                }
            }
            if (position >= arr.capasity) {
                resize(arr);
            }
            arr.array[position] = i;
            position++;
            arr.size = arr.size + 1;
        }
        return arr;
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
        ImmutableArrayList arr = new ImmutableArrayList();

        arr.capasity = capasity;
        arr.array = new Object[capasity];
        int last = 0;
        for (int i = 0; i < size; i++) {
            if (i != index) {
                arr.array[last] = array[i];
                last++;
                arr.size = arr.size + 1;
            }
        }
        return arr;
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableArrayList arr = new ImmutableArrayList();

        for (int i = 0; i < size; i++) {
            if (i >= arr.capasity) {
                resize(arr);
            }
            if (i == index) {
                arr.array[i] = e;
                arr.size = arr.size + 1;
                continue;
            }
            arr.array[i] = array[i];
            arr.size = arr.size + 1;
        }
        return arr;
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        for (Object i: array) {
            if (i == e) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        int len = 0;

        for (Object i : array) {
            if (i == null) {
                break;
            }
            len++;
        }
        return len;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];

        for (int i = 0; i < size; i++) {
            arr[i] = array[i];
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < size; ++i) {
            if (i == size-1) {
                buf.append(array[i]);
            } else {
                buf.append(array[i]);
                buf.append(", ");
            }
        }
        return buf.toString();
    }
}
