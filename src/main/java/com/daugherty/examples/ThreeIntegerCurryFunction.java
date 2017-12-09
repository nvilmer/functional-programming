package com.daugherty.examples;

import java.util.function.Function;

public interface ThreeIntegerCurryFunction extends Function<Integer, Function<Integer, Function<Integer, Integer>>> {}

