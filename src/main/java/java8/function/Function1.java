package java8.function;

import org.apache.log4j.Logger;

import java.util.function.Function;

public class Function1 {

    public static Logger logger = Logger.getLogger(Function1.class);

    public static void main(String args[]) {
        logger.info("Increased + Doubled:"+increased_double(10));

        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);

        Integer result1 = addThenMultiply.apply(3);
        System.out.println(result1);


        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);

        Integer result2 = multiplyThenAdd.apply(3);
        System.out.println(result2);

        Function<Integer, Integer>  multiplyThenAdd1 = add.compose(multiply);

        Integer result3 = multiplyThenAdd1.apply(3);
        System.out.println(result3);


    }

    public static Function<Integer,Integer> increase(int a) {
        Function<Integer, Integer> ok = s -> s +1;
        return  ok;
    }

    public static Integer increased_double(Integer a){
        return increase(a).andThen( myA -> myA*2).apply(subtract(a) );
    }

    public static int subtract(int c){
        return c - 10;
    }
}
