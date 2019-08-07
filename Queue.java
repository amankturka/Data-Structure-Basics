/*
 * QUEUE - FIFO
 * 
 * Operations: Enqueue,Dequeue,IsEmpty,peek
 * 
 */

class Queue {
    int front, rear, size, capacity;
    int arr[];

    public Queue(int capacity) {
        front = this.size = 0;
        this.capacity = capacity;
        rear = capacity - 1;
        arr = new int[this.capacity];
    }

    boolean isFull(Queue queue) {
        return (queue.size == queue.capacity);
    }

    boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }

    void enqueue(int element) {
        if (isFull(this)) {
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.arr[this.rear] = element;
        this.size = this.size + 1;
        System.out.print("Element enqueued" + element);
        System.out.print("\n");
    }

    int dequeue() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        int element = this.arr[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return element;
    }

    int front() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.arr[this.front];
    }

    int rear() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.arr[this.rear];
    }

    public static void main(String args[]) {
        Queue q = new Queue(100);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        q.front();
        q.rear();
        q.enqueue(8);
        System.out.println(q.dequeue() + " dequeued from queue\n");

        System.out.println("Front item is " + q.front());

        System.out.println("Rear item is " + q.rear());
    }
}
