public class ArrayQueue<T> {
    public static final int defaultCapacity = 8;
    private int capacity;
    private int size;
    private T[] queue;

    private int front, back;
    boolean isEmpty, isFull;

    public ArrayQueue(int capacity) {
        queue = (T[]) new Object[capacity];
        size = 0;
        this.capacity = capacity;

        front = -1;
        back = -1;
        isEmpty = true;
        isFull = false;
    }

    public ArrayQueue() {
        this(defaultCapacity);
    }

    public int capacity() {
        return capacity;
    }

    public boolean add(T item) {
        if (isFull)
            throw new RuntimeException("Queue is isFull.");
        else {
            //Starting queue at the first item.
            if(isEmpty) {
                front = 0;
                back = 0;
                isEmpty = false;
            }else
                back = nextIndex(back);

            queue[back] = item;
            updateFullFlag();
            return true;
        }
    }

    public T remove() {
        if (isEmpty)
            throw new RuntimeException("Queue is isEmpty.");
        else {
            if(isFull)
                isFull = false;

            T item = queue[front];
            front = nextIndex(front);
            updateEmptyFlag();
            return item;
        }
    }

    private void updateFullFlag() {
        //back is following the front.
        if(nextIndex(back) == front)
            isFull = true;
    }

    private void updateEmptyFlag() {
        //front has crossed the back.
        if(nextIndex(back) == front)
            isEmpty = true;
    }

    private int nextIndex(int index) {
        return (index + 1) % capacity;
    }
}
