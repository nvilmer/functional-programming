package com.daugherty.exec;

import com.daugherty.examples.Adder;

public class Runner {
    /**
     * Pretty much to get rid of unused warnings in Adder class
     */
    public static void main(String[] args) {
        System.out.println("*** Run Adder class functions ***");
        Adder adder = new Adder();
        System.out.println("add 3 and 5: " + adder.add(3, 5));
        System.out.println("add 3 and 5 and 7: " + adder.add3(3, 5, 7));
        System.out.println("increment 12: " + adder.inc.apply(12));
        System.out.println("decrement 12: " + adder.dec.apply(12));
        System.out.println("sum 10 and 6: " + adder.sum.apply(10).apply(6));
        System.out.println("increment 10: " + adder.oneArgFunctionalInterface.apply(10));
        System.out.println("increment 12 " + adder.oneArgLambdaFunctionalInterface.apply(12));
        System.out.println("add 2 and 7: " + adder.twoArgFunctionalInterface.apply(2, 7));
        System.out.println("compare 5 and 5: " + adder.twoArgPredicateFunctionalInterface.test(5, 5));
        System.out.println("compare 5 and 5: " + adder.twoArgLambdaPredicateFunctionalInterface.test(5, 5));
    }

}
