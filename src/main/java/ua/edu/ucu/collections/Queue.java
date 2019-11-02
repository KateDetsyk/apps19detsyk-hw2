package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList queue = new ImmutableLinkedList();

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        Object first = queue.getFirst();
        queue = queue.removeFirst();
        return first;
    }

    public void enqueue(Object e) {
        queue = queue.add(e);
    }

    public Object[] toArray() {
        return queue.toArray();
    }

}
