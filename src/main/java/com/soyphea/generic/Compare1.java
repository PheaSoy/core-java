package com.soyphea.generic;

import org.springframework.util.Assert;

public class Compare1 {

    public static <T> boolean compareObject( T t1, T t2){
        return t1.equals(t2);
    }

    public static <T extends Number> boolean compareNumber( T t1, T t2){
        return t1.equals(t2);
    }

    public static void main(String args[]){

        Assert.isTrue(compareObject(1,"2")); // Allow input String because there are no bound

        Assert.isTrue(compareNumber(1,1));// Not allow input String because there are bound T extends Number
    }
}
