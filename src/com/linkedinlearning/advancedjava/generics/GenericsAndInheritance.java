package com.linkedinlearning.advancedjava.generics;

public class GenericsAndInheritance {

    // A generic class that can hold an object of any type
    static class Box<T> {
        private T content;

        public Box(T content) {
            this.content = content;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "content=" + content +
                    '}';
        }
    }

    // A derived class that adds a color property to Box
    static class ColoredBox<T> extends Box<T> {
        private String color;

        public ColoredBox(T content, String color) {
            super(content); // Call the constructor of the base class
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "ColoredBox{" +
                    "content=" + getContent() + // Use getter from base class
                    ", color='" + color + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        // Create an instance of Box with an Integer
        Box<Integer> integerBox = new Box<>(123);
        System.out.println(integerBox);

        // Create an instance of ColoredBox with a String and color
        ColoredBox<String> coloredStringBox = new ColoredBox<>("Hello Generics", "Blue");
        System.out.println(coloredStringBox);
    }

}
