package com.linkedinlearning.advancedjava.generics.challenge;

import java.util.Optional;
import java.util.Stack;

public class GenericStackMySolution<T> {

    private final Stack<T> stack;

    public GenericStackMySolution() {
        this.stack = new Stack<>();
    }

    public T push(T item) {
        return stack.push(item);
    }

    public Optional<T> pop() {
        return stack.isEmpty() ? Optional.empty() : Optional.of(stack.pop());
    }

    public Optional<T> peek() {
        return stack.isEmpty() ? Optional.empty() : Optional.of(stack.peek());
    }

    public static void main(String[] args) {
        GenericStack<String> genericStack = new GenericStack<>();

        genericStack.push("this");
        genericStack.push("is");
        genericStack.push("a");
        genericStack.pop();
        Optional <String> peek = genericStack.peek();
        peek.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));
        genericStack.push("test");
        genericStack.pop();
        genericStack.pop();
        genericStack.pop();
        Optional<String> peek2 = genericStack.peek();
        peek2.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));

        GenericStack<Integer> genericStack2 = new GenericStack<>();

        genericStack2.push(1);
        genericStack2.push(2);
        genericStack2.push(3);
        genericStack2.pop();
        Optional <Integer> peekInt = genericStack2.peek();
        peekInt.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));
        genericStack2.push(4);
        genericStack2.pop();
        genericStack2.pop();
        genericStack2.pop();
        Optional<Integer> peek2Int = genericStack2.peek();
        peek2Int.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));

    }
}


