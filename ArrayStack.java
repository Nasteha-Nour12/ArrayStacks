package CH10Generic;
//Nasteha habib ibrahim C1220845
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> {
        private final static int DEFAULT_CAPACITY = 2;
        public T[] stacks;
        int top;

        public ArrayStack() {
            this(DEFAULT_CAPACITY);
        }

        public ArrayStack(int initialCapacity) {
            top = 0;
            stacks = (T[]) (new Object[initialCapacity]);
        }

        public void push(T element) {
            if (size() == stacks.length) {
                expandCapacity();
            }
            stacks[top] = element;
            top++;
        }

        public T pop() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            stacks[top - 1] = null;
            top--;
            return stacks[top];
        }

        public T peek() {
            if (isEmpty()) {
                System.out.println("The stack is empty");
            }
            return stacks[top - 1];
        }

        public int size() {
            return top;
        }

        private void expandCapacity() {
            stacks = Arrays.copyOf(stacks, stacks.length * 2);
        }

        public boolean isEmpty() {
            return top == 0;
        }

        public void concatTwoStacks(ArrayStack s1, ArrayStack s2, ArrayStack combinedStack) {
            if (s1.size() == s2.size()) {

                int index = s1.top - 1;

                while (index >= 0) {
                    combinedStack.push(s1.stacks[index] + " " + s2.stacks[index]);
                    index--;
                }
            } else {
                System.out.println("The two stack are not same!");
            }
        }

        public void addToTheStack(ArrayStack<T> s1, ArrayStack<T> unique) {

            int index = s1.top - 1;
            while (index >= 0) {
                boolean matchItem = false;
                int i = unique.top - 1;
                while (i >= 0) {
                    if (unique.stacks[i].equals(s1.stacks[index])) {
                        matchItem = true;
                        break;
                    }
                    i--;
                }
                if (!matchItem) {
                    unique.push(s1.stacks[index]);
                }
                index--;
            }
        }

        public void merge(ArrayStack<T> stack1, ArrayStack<T> stack2, ArrayStack<T> uniqueStack) {
            addToTheStack(stack2, uniqueStack);
            addToTheStack(stack1, uniqueStack);
        }

        public void display() {
            int index = top -1;

            while (index >= 0) {
                System.out.println(stacks[index]);
                index--;
            }
        }

        public static void main(String[] args) {




            ArrayStack<Integer> list1 = new ArrayStack<>();
            ArrayStack<Integer> list2 = new ArrayStack<>();

            list1.push(400);
            list1.push(200);
            list1.push(300);
            list1.push(100);

            list2.push(100);
            list2.push(200);
            list2.push(500);
            list2.push(300);


            ArrayStack<Integer> uniqueStack = new ArrayStack<>();

            uniqueStack.merge(list1, list2, uniqueStack);
            uniqueStack.display();
        }
    }

