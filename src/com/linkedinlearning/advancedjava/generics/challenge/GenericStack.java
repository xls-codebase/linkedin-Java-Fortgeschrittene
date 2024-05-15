package com.linkedinlearning.advancedjava.generics.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericStack<T> {
    private List<T> stack;

    public GenericStack() {
        this.stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public Optional<T> pop() {
        if (isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(stack.remove(stack.size() - 1));
    }

    public Optional<T> peek() {
        if (isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(stack.get(stack.size() - 1));
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");

        System.out.println("String Stack Size: " + stringStack.size());
        stringStack.peek().ifPresent(peek -> System.out.println("Peek: " + peek));
        stringStack.pop().ifPresent(pop -> System.out.println("Popped: " + pop));
        System.out.println("String Stack Size after pop: " + stringStack.size());

        stringStack.pop().ifPresent(pop -> System.out.println("Popped: " + pop));
        stringStack.pop().ifPresentOrElse(pop -> System.out.println("Popped: " + pop),
                () -> System.out.println("Empty"));

        GenericStack<Integer> integerStack = new GenericStack<>();
        integerStack.push(1);
        integerStack.push(2);

        System.out.println("\nInteger Stack Size: " + integerStack.size());
        integerStack.peek().ifPresent(peek -> System.out.println("Peek: " + peek));
        integerStack.pop().ifPresent(pop -> System.out.println("Popped: " + pop));
        System.out.println("Integer Stack Size after pop: " + integerStack.size());
    }
}
