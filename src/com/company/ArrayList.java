package company;

/**
 * An implementation of the ArrayList
 */
public class ArrayList<T> {

    private int size = 0;
    private Object[] elements;

    public ArrayList() {
        this.elements = new Object[10];
    }

    public void add(T newElement) {
        if (size == elements.length) {
            // If the array has reached the limit, we increase the capacity,
            // otherwise we immediately add the element
            grow();
        }

        elements[size] = newElement;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        return (T) this.elements[index];
    }

    /**
     * Replace the current array of elements with a new one with a capacity of + 50%
     */
    private void grow() {
        Object[] newArray = new Object[elements.length + elements.length / 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        this.elements = newArray;
    }

    public static void main(String[] args) {
        final var ar = new ArrayList<Integer>();
        for (int i = 0; i < 2000; i++) {
            ar.add(i);
        }
        System.out.println(ar.size);
    }

}