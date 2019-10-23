package java8;

import java.util.function.Predicate;

public class SumCal {


    public static void main(String args[]){

        Calculator calculator = (a, b) -> a+b;

        System.out.println("ok:"+calculator.doCal(2,3));
    }
}
