package java8.stream;

import model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {


    private static int[] numbers = {1, 2, 3, 30, 10, 55, 75, 85};

    private static List<User> users = Arrays.asList(new User("PheaSoy","learning-at-form","pheasoy"),
            new User(null,null,"sidara"));

    public static int sum() {
        int c = IntStream.of(numbers).sum();
        return c;
    }
    public static int sumOdd(){
        int c = IntStream.of(numbers).filter( a -> a%2==0).sum();
        return c;
    }

    public static int sumOnCondition(IntPredicate predicate){
        int c = IntStream.of(numbers).filter(predicate).sum();
        return c;
    }

    public static List<User> collect(){
        return users.stream().filter( user -> user.getLogin().contains("p")).collect(Collectors.toList());
    }

    public static void main(String args[]) {
        System.out.println(sum());
        System.out.println(sumOdd());
        System.out.println(sumOnCondition( value -> value%2==0));
        System.out.println(sumOnCondition( value -> value%2!=0));
        System.out.println(collect());
    }
}
