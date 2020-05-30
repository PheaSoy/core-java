package com.soyphea.java8.exeption;

public class FruitNotFoundException extends RuntimeException {
    public FruitNotFoundException() {
        super();
    }

    public FruitNotFoundException(String message) {
        super(message);
    }
}
