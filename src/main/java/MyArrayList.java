public class MyArrayList {
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(Object o) {
        if (size == elements.length) {
            ensureCapasity();
        }
        elements[size] = o;
        size++;
    }

    public void addElements(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            if (size == elements.length) {
                ensureCapasity();
            }
            elements[size] = objects[i];
            size++;
        }
    }

    public void addOfIndex(int index, Object o) {
        for (int i = size; i > index; i--) {
            if (size == elements.length) {
                ensureCapasity();
            }
            elements[i] = elements[i - 1];
        }
        elements[index] = o;
        size++;
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void ensureCapasity() {
        Object[] newArray = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return elements[index];
    }
}



