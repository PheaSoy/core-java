package com.soyphea.generic;

public class Box<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends T> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(10);
        integerBox.inspect(11); // error: this is still String!

        Box<String> integerBox2 = new Box<String>();
        integerBox2.set("10");
        integerBox2.inspect("11"); // error: this is still String!
    }
}