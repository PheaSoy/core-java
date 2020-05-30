package com.soyphea.java8.function;


import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Function1 {
    public static Logger logger = LogManager.getLogger(Function1.class);

    public static void main(String args[]) {

        logger.info("Increased + Doubled:"+increased_double(10));


        Function<Integer, Integer> add      = (value) -> value + 3;
        Function<Integer, Integer> multiply = (value) -> value * 2;

        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add); //9 execute the left side first (2*3) +3
        Integer result2 = multiplyThenAdd.apply(3);
        System.out.println("andThen:"+result2);

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);//12 execute the right side first. (3+3) *2
        Integer result1 = addThenMultiply.apply(3);
        System.out.println("Compose:"+result1);





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
