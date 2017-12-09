package com.daugherty.examples;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Simmple addition functional examples showing methods, lambdas, functional interfaces
 */
public class Adder {
    /**
     * Two argument method function example
     *
     * @param x first arg
     * @param y second arg
     * @return sum of two args
     */
    public int add(int x, int y) {
        return x + y;
    }

    /**
     * Three argument method function example
     *
     * @param x first arg
     * @param y second arg
     * @param z third arg
     * @return sum of three args
     */
    public int add3(int x, int y, int z) {
        return x + y + z;
    }

    /**
     * Lambda increment function example
     */
    public Function<Integer, Integer> inc = x -> x + 1;

    /**
     * Lambda decrement function example
     */
    public Function<Integer, Integer> dec = x -> x - 1;

    /**
     * Lambda nested sum function example
     * Inner lambda (y) returns Function, outer (x) returns Integer
     */
    public Function<Integer, Function<Integer, Integer>> sum = x -> y -> x + y;

    /**
     * Single argument functional interface example
     */
    public Function<Integer, Integer> oneArgFunctionalInterface = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer x) {
            return inc.apply(x);
        }
    };

    /**
     * Single argument functional interface lambda example
     */
    public Function<Integer, Integer> oneArgLambdaFunctionalInterface = x -> x + 1;

    /**
     * Two argument functional interface example
     */
    public BiFunction<Integer, Integer, Integer> twoArgFunctionalInterface = new BiFunction<Integer, Integer, Integer>() {
        @Override
        public Integer apply(Integer x, Integer y) {
            return add(x, y);
        }
    };

    /**
     * Two argument predicate functional interface (returns Boolean)
     */
    public BiPredicate<Integer, Integer> twoArgPredicateFunctionalInterface = new BiPredicate<Integer, Integer>() {
        @Override
        public boolean test(Integer x, Integer y) {
            return x.compareTo(y) == 0;
        }
    };

    /**
     * Two argument predicate functional interface using lambda (returns Boolean)
     */
    public BiPredicate<Integer, Integer> twoArgLambdaPredicateFunctionalInterface = (x, y) -> x.equals(y);

    /**
     * Three argument functional interface using lambda
     */
    public TriFunction<Integer, Integer, Integer, Integer> lambdaAdd3 = (a, b, c) -> a + b + c;

    /**
     * Comparator implemented as lambda example
     */
    public Comparator<String> lambdaCompareLength = (String first, String second) -> Integer.compare(first.length(), second.length());

    /**
     * Partial Function Example - accepts TriFunction returns Function
     * @param f function arg
     * @param x first value arg
     * @param y second value arg
     * @param <T> type of arg 1
     * @param <U> type of arg 2
     * @param <V> type of function arg
     * @param <R> return type
     * @return return Function<U, V, R>
     */
    public static <T, U, V, R> Function<V, R> partialAcceptTriReturnFunction(TriFunction<T, U, V, R> f, T x, U y) {
        return (z) -> f.apply(x, y, z);
    }

/**
 * Partial Function Example - accepts TriFunction returns Function
 * @param f function arg
 * @param x first value arg
 * @param <T> type of arg 1
 * @param <U> type of arg 2
 * @param <V> type of function arg
 * @param <R> return type
 * @return return BiFunction<V, R>
 */
    public static <T, U, V, R> BiFunction<U, V, R> partialAcceptTriReturnBiFunction(TriFunction<T, U, V, R> f, T x) {
        return (y, z) -> f.apply(x, y, z);
    }

/**
 * Partial Function Example - accepts TriFunction returns Function
 * @apiNote public
 * @param f function arg
 * @param x first value arg
 * @param <T> type of arg 1
 * @param <U> type of arg 2
 * @param <R> return type
 * @return return BiFunction<U, R>
 */
    public static <T, U, R> Function<U, R> partialAcceptBiReturnFunction(BiFunction<T, U, R> f, T x) {
        return (z) -> f.apply(x, z);
    }

}
