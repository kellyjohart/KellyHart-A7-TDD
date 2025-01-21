package com.coderscampus;

public class CustomArrayList<T> implements CustomList<T> {
    private Object[] items;
    private int size;

    public CustomArrayList() {
        items = new Object[10];
        size = 0;
    }

    @Override
    public boolean add(T item) {
        if (size == items.length) {
            resizeArray();
        }
        items[size++] = item;
        return true;
    }

    @Override
    public boolean add(int index, T item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + " - out of bounds");
        }
        if (size == items.length) {
            resizeArray();
        }
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + " - out of bounds");
        }
        return (T) items[index];
    }


    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + " - out of bounds");
        }
        T item = (T) items[index];
        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }
        size--;
        return item;
    }

    private void resizeArray() {
        Object[] tempArray = new Object[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            tempArray[i] = items[i];
        }
        items = tempArray;
    }
}
