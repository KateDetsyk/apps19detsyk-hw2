package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList{

    private Node first;
    private Node last;

    private class Node {
        private Object element;
        private Node next = null;
        private Node prev = null;

        private Node(Object element) {
            this.element = element;
        }
    }

    private void copy(ImmutableLinkedList list) {
        Object[] arr = toArray();

        if (arr.length == 0) {
            list.first = null;
            list.last = null;
        } else if (arr.length == 1) {
            Node n = new Node(arr[0]);
            list.first = n;
            list.last = n;
        } else {
            list.first = new Node(arr[0]);
            Node current = list.first;
            for (int i = 1; i < arr.length; i++) {
                Node newNode = new Node(arr[i]);
                current.next = newNode;
                newNode.prev = current;
                current = newNode;
            }
            list.last = current;
        }
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        Node newNode = new Node(e);
        ImmutableLinkedList lst = new ImmutableLinkedList();
        copy(lst);
        if (first == null) {
            newNode.next = null;
            newNode.prev = null;
            lst.first = newNode;
            lst.last = newNode;
        } else {
            lst.last.next = newNode;
            newNode.prev = lst.last;
            lst.last = newNode;
        }
        return lst;
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(e);
        ImmutableLinkedList lst = new ImmutableLinkedList();
        copy(lst);

        if (index == size()) {
            lst.last.next = newNode;
            newNode.prev = lst.last;
            lst.last = newNode;
        }
        Node oldNode = lst.first;
        if (index == 0) {
            newNode.next = lst.first;
            lst.first.prev = newNode;
            lst.first = newNode;
            return lst;
        }
        for (int i = 0; i < index-1; i++) {
            oldNode = oldNode.next;
        }
        newNode.next = oldNode.next;
        oldNode.next.prev = newNode;
        oldNode.next = newNode;
        newNode.prev = oldNode;
        return lst;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        copy(lst);

        for (Object elem: c) {
            Node add_node = new Node(elem);
            lst.last.next = add_node;
            add_node.prev = lst.last;
            lst.last = add_node;
        }
        return lst;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList lst = new ImmutableLinkedList();
        copy(lst);

        if (index == 0) {
            Node oldFirst = lst.first;
            lst.first = new Node(c[0]);
            Node lastNode = lst.first;
            for (int i = 1; i < c.length; i++) {
                Node newNode = new Node(c[i]);
                lastNode.next = newNode;
                newNode.prev = lastNode;
                lastNode = lastNode.next;
            }
            lastNode.next = oldFirst;
            oldFirst.prev = lastNode;
            return lst;
        }

        Node lastNode = lst.first;
        for (int i = 0; i < index-1; i++) {
            lastNode = lastNode.next;
        }
        Node lastNext = lastNode.next;
        for (int i = 0; i < c.length; i++) {
            Node newNode = new Node(c[i]);
            lastNode.next = newNode;
            newNode.prev = lastNode;
            lastNode = lastNode.next;
        }
        lastNode.next = lastNext;
        lastNext.prev = lastNode;
        return lst;
    }

    @Override
    public Object get(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node element = first;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.element;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList lst = new ImmutableLinkedList();
        copy(lst);
        Node last_node = lst.first;
        if (index == 0) {
            lst.first = lst.first.next;
            return lst;
        }
        if (index == size()-1) {
            for (int i = 0; i < size()-2; i++) {
                last_node = last_node.next;
            }
            last_node.next = null;
            lst.last = last_node;
            return lst;
        }
        for (int i = 1; i < size(); i++) {
            if (i == index+1) {
                last_node.prev.next = last_node.next;
                last_node.next.prev = last_node.prev;
            }
            last_node = last_node.next;
        }
        return lst;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList lst = new ImmutableLinkedList();
        copy(lst);

        Node last_node = lst.first;

        Node new_node = new Node(e);
        if (index == 0) {
            Node temp = lst.first;
            lst.first = new_node;
            new_node.next = temp.next;

        }
        for (int i = 1; i < size(); i++) {
            if (i == index) {
                Node temp = last_node;
                last_node = new_node;
                new_node.next = temp.next;
            }
            last_node = last_node.next;
        }
        return lst;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (get(i) == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        Node elem = first;
        if (elem == null) {
            return 0;
        }
        int counter = 1;
        while (elem.next != null) {
            elem = elem.next;
            counter++;
        }
        return counter;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        Node current = first;
        if (first == null) {
            return arr;
        }
        arr[0] = first.element;
        if (size() == 1) {
            return arr;
        }
        int counter = 1;
        while (current.next != null) {
            current = current.next;
            arr[counter] = current.element;
            counter++;
        }
        return arr;
    }

    @Override
    public String toString() {
        String result = "";
        Object[] arr = toArray();

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) {
                result = result + arr[i];
            } else {
                result = result + arr[i] + ", ";
            }
        }
        return result;
    }

    public ImmutableLinkedList addFirst(Object e) {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        copy(lst);
        if (lst.size() == 0) {
            lst = lst.add(e);
        } else {
            lst = lst.add(0, e);
        }
        return lst;
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        return first.element;
    }

    public Object getLast() {
        return last.element;
    }

    public ImmutableLinkedList removeFirst() {
        int index = 0;
        return remove(index);
    }

    public ImmutableLinkedList removeLast() {
        int index = size() - 1;
        return remove(index);
    }
}



