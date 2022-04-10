public interface Deque<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public T get(int k);
    public int size();
    public boolean isEmpty();
    public void printDeque();
    public T removeFirst();
    public T removeLast();
}
