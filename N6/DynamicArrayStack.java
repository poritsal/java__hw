public class DynamicArrayStack {
    private int[] stackArray;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArrayStack() {
        this.stackArray = new int[DEFAULT_CAPACITY];
        this.top = -1;
    }

    public void push(int value) {
        if (top == stackArray.length - 1) {
            expandStack();
        }
        stackArray[++top] = value;
        System.out.println("Элемент " + value + " добавлен в стек.");
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст.");
        }
        int poppedValue = stackArray[top--];
        System.out.println("Элемент " + poppedValue + " удален из стека.");
        return poppedValue;
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст.");
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void expandStack() {
        int newCapacity = stackArray.length * 2;
        int[] newStack = new int[newCapacity];
        System.arraycopy(stackArray, 0, newStack, 0, stackArray.length);
        stackArray = newStack;
        System.out.println("Стек расширен. Новая длина стека: " + newCapacity);
    }

    public static void main(String[] args) {
        DynamicArrayStack stack = new DynamicArrayStack();

        System.out.println("Стек пуст? " + stack.isEmpty());

        for (int i = 1; i <= 15; i++) {
            stack.push(i);
        }

        System.out.println("Вершина стека: " + stack.top());

        for (int i = 1; i <= 10; i++) {
            stack.pop();
        }

        System.out.println("Стек пуст? " + stack.isEmpty());
    }
}
