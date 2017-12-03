package com.daugherty.examples;

import java.util.function.Function;

public class Adder {
    public int add(int x, int y) { return x + y; }
    public int add3(int x, int y, int z) { return x + y + z; }

    public Function<Integer, Integer> inc = x -> x + 1;
    public Function<Integer, Integer> dec = x -> x - 1;
    public Function<Integer, Function<Integer, Integer>> sum = x -> y -> x + y;
}
