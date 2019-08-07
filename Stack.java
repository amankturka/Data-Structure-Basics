/*
 * STACK - LIFO
 * 
 * Operations: Push,Pop,IsEmpty,Top
 * 
 */

class Stack {
    static final int max_size = 100;
    static int top = -1;
    static int A[] = new int[max_size];

    void push(int x) {
        if (top == max_size - 1) {
            // throw exception : stack overflow
            System.out.println("Stack overflow");
            return;
        }
        A[++top] = x;
    }

    void pop() {
        if (top == -1) {
            // throw exeception: stack underflow
            System.out.println("Stack underflow");
            return;
        }
        top--;
    }

    int top() {
        return A[top];
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    static void print() {
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.println(A[i]);
        }
        System.out.print("\n");
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        print();
        s.pop();
        int t = s.top();
        System.out.print("\n top --");
        System.out.print(t);
        System.out.print("\n");
        print();
        boolean empty = s.isEmpty();
        System.out.print("\n isEmpty----");
        System.out.print(empty);
        System.out.print("\n");
        s.push(5);
        print();
    }
}