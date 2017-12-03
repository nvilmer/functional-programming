package com.daugherty.exec;

import com.daugherty.examples.Adder;

import java.util.Arrays;
import java.util.function.Function;

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
        System.out.println("add 3 and 5 and 9: " + adder.lambdaAdd3.apply(3, 5, 9));

        String[] words = new String[] {"abcdef", "ghi", "do", "fred"};
        System.out.println("Word order before sort (list): ");
        Arrays.asList(words).forEach(System.out::println);
        Arrays.sort(words, adder.lambdaCompareLength);
        System.out.println("Words sorted by length: " + Arrays.asList(words));

        Function triAdder = Adder.partial(adder.lambdaAdd3, 4, 9);
        System.out.println("add 4 and 9 and 3: " + triAdder.apply(3));
    }

}
