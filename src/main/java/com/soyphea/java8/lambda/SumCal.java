package com.soyphea.java8.lambda;

public class SumCal {


    public static void main(String args[]){

        Calculator calculator = (a, b) -> a+b;

        System.out.println("ok:"+calculator.doCal(2,3));
    }
}
