package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

//    Object peek() - Returns the object from the top of the Stack without removing it
//    Object pop() - Removes and returns the object from the top of the Stack
//    void push(Object e) - Adds an object to the the top of the Stack

    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public Object peek() {
        return stack.getFirst();
    }

    public Object pop() {
        Object last = stack.getFirst();
        stack = stack.removeFirst();
        return last;
    }

    public void push(Object e) {
        stack = stack.addFirst(e);
    }

    public Object[] toArray() {
        return stack.toArray();
    }
}
