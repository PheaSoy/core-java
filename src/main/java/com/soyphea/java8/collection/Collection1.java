package com.soyphea.java8.collection;

import com.soyphea.java8.exeption.FruitNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class Collection1 {

    // Now we are able to create immutable list.
    static List<String> fruits = List.of("Apple", "Orange", "Coconut");

    private static String findFruit(String fruit) {
        return fruits.parallelStream().filter(f -> f.equals(fruit)).findFirst().orElseThrow(() -> new FruitNotFoundException());
    }

    private static String findFruitOldJava(String fruit){
        for(String f: fruits){
            if (f.equals(fruit)){
                return f;
            } else {
                throw new FruitNotFoundException();
            }
        }
        return null;
    }

    private static List<String> fruitContain(String contain){
        return fruits.stream().filter(f-> f.contains(contain)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(findFruit("Apple"));
        System.out.println(fruitContain("e"));
    }

}
