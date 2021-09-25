public class Vector<T> {

    private T[] array;
    private int size;

    Vector(T[] array, int size) {
        this.size = size;
        this.array = array;
    }

    public T[] getArray() {
        return this.array;
    }

    public int getSize() {
        return this.size;
    }

    public T getElement(int index) {
        return this.array[index];
    }

    public void setElement(T element, int index) {
        this.array[index] = element;
    }

    public int checkType() {
        if (array instanceof Integer[]) {
            return 1;
        }
        if (array instanceof Double[]) {
            return -1;
        }
        return 0;
    }

    public int getMinIndex() {
        int minIndex = 0;
        for (int i = 1; i < this.size; i++) {
            if (((Comparable) this.getElement(i)).compareTo(this.getElement(minIndex)) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int getMaxIndex() {
        int maxIndex = 0;
        for (int i = 1; i < this.size; i++) {
            if (((Comparable) this.getElement(i)).compareTo(this.getElement(maxIndex)) > 0) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public T getMinElement() {
        return this.getElement(getMinIndex());
    }

    public T getMaxElement() {
        return this.getElement(getMaxIndex());
    }
}
