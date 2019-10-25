package java8.predicate;

import java.util.function.Predicate;

@FunctionalInterface
interface MyPredicate<T> {
    boolean check(T bean);
}



public class Predicate2 {

    public static void main(String args[]) {

        Predicate<String> predicate2222 = varString -> varString.isEmpty();

        Predicate<String> userPredicate = user -> user.contains("P");

        Predicate<String> resultPre = predicate2222.or(userPredicate);
        System.out.println(resultPre.test("Phea"));

        MyPredicate<String> myPredicate = str -> str.contains("C");
        System.out.println(myPredicate.check("HelloC"));

    }

}

