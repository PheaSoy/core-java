package com.soyphea.java8.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Optional2 {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Book {
        int id;
        String author;
        String title;
    }


    public static void main(String[] args) {

        List<Book> books = List.of(new Book(1, "Jose Long", "Cloud-Native Java"),
                new Book(1,"Kim","Enterprise Kubernetes"),
                new Book(1, "Bobby Woolf","Enterprise Integration Pattern"));

        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(myList);

        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);

        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }
}
