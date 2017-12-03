package com.daugherty.examples;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T a, U b, V c);
}
