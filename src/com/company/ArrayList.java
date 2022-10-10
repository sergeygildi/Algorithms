package company;

/**
 * An implementation of the ArrayList
 */
public class ArrayList<T> {

    private int size = 0;
    private T[] elements;

    public ArrayList() {
        this.elements = (T[]) new Object[10];
    }

    public void add(T newElement) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = newElement;
        size++;
    }

    public int getSize() {
        return this.size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        return this.elements[index];
    }

    /**
     * Replace the current array of elements with a new one with a capacity of + 50%
     */
    private void grow() {
        T[] newArray = (T[]) new Object[elements.length + elements.length / 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        this.elements = newArray;
    }

}