package org.example.task2;

public class IntStack {
    private static final int INITIAL_CAPACITY = 10;
    private static final int GROW_FACTOR = 2;

    private int[] elements;
    private int size;

    public IntStack() {
        this.elements = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void push(int element) {
        ensureCapacity();
        elements[size] = element;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній. Неможливо вилучити елемент.");
        }
        size--;
        int element = elements[size];
        elements[size] = 0;
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній. Неможливо переглянути елемент.");
        }
        return elements[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = 0;
        }
        size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * GROW_FACTOR;
            int[] newElements = new int[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    int getCapacity() {
        return elements.length;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "IntStack[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("IntStack[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}