public class LinkedListDeque<T> {


    private static class ListNode<T> {
        private T item;
        private ListNode next;
        private ListNode prev;
        public ListNode(T val) {
            item = val;
            next = null;
            prev = null;
        }

        public ListNode() {
            item = null;
            next = null;
            prev = null;
        }
    }

    private int size;
    private ListNode sentinel;

    public LinkedListDeque() {
        sentinel = new ListNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

//    public LinkedListDeque(LinkedListDeque other) {
//        sentinel = new ListNode();
//        sentinel.next = sentinel;
//        sentinel.prev = sentinel;
//        size = 0;
//        for (int i = 0; i < other.size(); i++) {
//            this.addLast((T) other.get(i));
//        }
//    }

    public void addFirst(T item) {
        ListNode temp = sentinel.next;
        sentinel.next = new ListNode(item);
        sentinel.next.next = temp;
        temp.prev = sentinel.next;
        sentinel.next.prev = sentinel;
        size++;
    }

    public void addLast(T item) {
        ListNode temp = sentinel.prev;
        temp.next = new ListNode(item);
        temp.next.next = sentinel;
        sentinel.prev = temp.next;
        temp.next.prev = temp;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int k = size;
        ListNode node = sentinel;
        while (k-- > 0) {
            System.out.print(node.item);
            node = node.next;
            if (k > 0) {
                System.out.print(" ");
            }
        }
        System.out.print("\n");
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        ListNode returnNode = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return (T) returnNode.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        ListNode returnNode = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return (T) returnNode.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ListNode node = sentinel;
        while (index-- > 0) {
            node = node.next;
        }
        return (T) node.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, ListNode node) {
        if (index == 0) {
            return (T) node.item;
        }
        return getRecursive(index - 1, node.next);
    }
}
