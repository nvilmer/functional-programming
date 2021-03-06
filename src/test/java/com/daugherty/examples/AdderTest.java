package com.daugherty.examples;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class AdderTest {
    private Adder adder;

    @Before
    public void setup() {
        adder = new Adder();
    }

    @Test
    public void testAdd() throws Exception {
        Integer results = adder.add(3, 5);
        assertEquals(Integer.valueOf(8), results);
    }

    @Test
    public void testAdd3() throws Exception {
        Integer results = adder.add3(3, 5, 7);
        assertEquals(Integer.valueOf(15), results);
    }

    @Test
    public void testInc() throws Exception {
        Integer results = adder.inc.apply(12);
        assertEquals(Integer.valueOf(13), results);
    }


    @Test
    public void testDec() throws Exception {
        Integer results = adder.dec.apply(12);
        assertEquals(Integer.valueOf(11), results);
    }

    @Test
    public void testSum() throws Exception {
        Integer results = adder.sum.apply(10).apply(6);
        assertEquals(Integer.valueOf(16), results);
    }

    @Test
    public void testOneArgFunctionalInterface() throws Exception {
        Integer results = adder.oneArgFunctionalInterface.apply(10);
        assertEquals(Integer.valueOf(11), results);
    }

    @Test
    public void testOneArgLambdaFunctionalInterface() throws Exception {
        Integer results = adder.oneArgLambdaFunctionalInterface.apply(20);
        assertEquals(Integer.valueOf(21), results);
    }

    @Test
    public void testTwoArgFunctionalInterface() throws Exception {
        Integer results = adder.twoArgFunctionalInterface.apply(2, 7);
        assertEquals(Integer.valueOf(9), results);
    }

    @Test
    public void testTwoArgPredicateFunctionalInterface() throws Exception {
        assertTrue(adder.twoArgPredicateFunctionalInterface.test(5, 5));
        assertFalse(adder.twoArgPredicateFunctionalInterface.test(4, 9));
    }

    @Test
    public void testTwoArgPredicateAndFunctionalInterface() throws Exception {
        BiPredicate<Integer, Integer> pred1 = adder.twoArgPredicateFunctionalInterface;
        BiPredicate<Integer, Integer> pred2 = adder.twoArgPredicateFunctionalInterface;

        assertFalse(pred1.and(pred2).test(4, 5));
    }

    @Test
    public void testTwoArgLambaPredicateFunctionalInterface() throws Exception {
        BiPredicate<Integer, Integer> pred1 = adder.twoArgPredicateFunctionalInterface;
        BiPredicate<Integer, Integer> pred2 = adder.twoArgLambdaPredicateFunctionalInterface;

        assertTrue(pred1.and(pred2).test(3, 3));
    }

    @Test
    public void testThreeArgFunctionalInterface() throws Exception {
        Integer results = adder.lambdaAdd3.apply(3, 5, 9);
        assertEquals(Integer.valueOf(17), results);
    }

    @Test
    public void testWordLengthCompare() throws Exception {
        String[] words = new String[] {"abcdef", "ghi", "do", "fred"};
        List<String> sortedList = new ArrayList<>(Arrays.asList(words));
        sortedList.sort(adder.lambdaCompareLength);
        assertThat(sortedList, containsInAnyOrder(words));
        assertThat(sortedList, not(contains(words)));
    }

    @Test
    public void testPartialTriFunctionToFunctionAdder() throws Exception {
        Function<Integer, Integer> triAdder = adder.partialAcceptTriReturnFunction(adder.lambdaAdd3, 4, 9);
        assertEquals(Integer.valueOf(16), triAdder.apply(3));
    }

    @Test
    public void testPartialTriFunctiontoBiFunctionAdder() throws Exception {
        BiFunction<Integer, Integer, Integer> biAdder = adder.partialAcceptTriReturnBiFunction(adder.lambdaAdd3, 10);
        Function<Integer, Integer> adderFunc = adder.partialAcceptBiReturnFunction(biAdder, 20);
        assertEquals(Integer.valueOf(60), adderFunc.apply(30));
    }

    @Test
    public void testComparePartialAdders() throws Exception {
        Function<Integer, Integer> triAdder = adder.partialAcceptTriReturnFunction(adder.lambdaAdd3, 10, 20);
        BiFunction<Integer, Integer, Integer> biAdder = adder.partialAcceptTriReturnBiFunction(adder.lambdaAdd3, 10);
        Function<Integer, Integer> adderFunc = adder.partialAcceptBiReturnFunction(biAdder, 20);
        assertEquals(triAdder.apply(30), adderFunc.apply(30));
    }

    @Test
    public void testCurryLambdaMultiplication() throws Exception {
        assertTrue(Integer.valueOf(63).equals(adder.curriedMultiplication.apply(7).applyAsInt(9)));
    }

    @Test
    public void testBiFunctionToCurryAdd() throws Exception {
        assertTrue(Integer.valueOf(9).equals(adder.curryBiFunction(adder.twoArgFunctionalInterface).apply(4).apply(5)));
    }

    @Test
    public void testFunctionCurryMultiply() throws Exception {
        assertTrue(Integer.valueOf(990).equals(adder.curryMultiplyThreeIntegerFunction().apply(9).apply(10).apply(11)));
    }

    @Test
    public void testUncurryBiFunctionAdd() throws Exception {
        assertTrue(Integer.valueOf(18).equals(adder.uncurryBiFunction(adder.curryBiFunction(adder.twoArgFunctionalInterface)).apply(13, 5)));

    }
}
