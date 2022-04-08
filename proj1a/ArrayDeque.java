public class ArrayDeque<T> {
    private int capacity = 8;
    private final double fillingFactor = 0.25;
    private int front;
    private int size;
    private T[] arr;
    public ArrayDeque() {
        arr = (T[]) new Object[capacity];
        front = 0;
        size = 0;
    }

//    public ArrayDeque(ArrayDeque other) {
//        arr = (T[]) new Object[other.size()];
//        front = 0;
//        back = 0;
//        for (int i = 0; i < other.size(); i++) {
//            this.addLast((T) other.get(i));
//        }
//        size = other.size();
//        capacity = other.capacity;
//    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[(front + i) % capacity];
        }
        front = 0;
        arr = newArray;
        capacity = newCapacity;
    }

    public void addFirst(T item) {
        if (size == capacity) {
            resize(2 * capacity);
        }
        if (front == 0) {
            front = capacity - 1;
        } else {
            front--;
        }
        arr[front] = item;
        size++;
    }


    public void addLast(T item) {
        if (size == capacity) {
            resize(2 * capacity);
        }
        int back = (front + size) % capacity;
        arr[back] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % capacity;
            System.out.print(arr[idx]);
            if (i != size - 1) {
                System.out.print(" ");
            }
        }
        System.out.print('\n');
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size * 4 < capacity && capacity >= 16) {
            resize(capacity / 4);
        }

        T returnedItem = arr[front];
        arr[front] = null;
        front = (front + 1) % capacity;
        size--;
        return returnedItem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size * 4 < capacity && capacity >= 16) {
            resize(capacity / 4);
        }
        int back = (front + size - 1) % capacity;
        T returnedItem = arr[back];
        arr[back] = null;
        back = back == 0 ? capacity - 1 : back - 1;
        size--;
        return returnedItem;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int idx = (front + index) % capacity;
        return arr[idx];
    }
}
