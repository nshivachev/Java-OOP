package encapsulationLab.smartArray;

public class SmartArray {
    private Integer[] data;
    private int size;

    public SmartArray() {
        this.data = new Integer[4];
        size = 0;
    }

    public void add(int element) {
        if (this.size == this.data.length) {
            this.data = grow();
        }

        this.data[size] = element;
        this.size++;
    }

    private Integer[] grow() {
        Integer[] newData = new Integer[this.data.length * 2];

        System.arraycopy(this.data, 0, newData, 0, this.data.length);

        return newData;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }

        return this.data[size];
    }

    public int size() {
        return this.size;
    }

    public int remove(int index) {
        return 0;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }

        return false;
    }
}
