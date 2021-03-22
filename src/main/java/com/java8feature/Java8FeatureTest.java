package com.java8feature;

import java.util.Iterator;

@FunctionalInterface
interface IMathFunction {
    int calculate(int a, int b);
    static void printResult(int a,int b, String function, IMathFunction fobj) {
        System.out.println("Result of"+function+"is"+fobj.calculate(a, b));
    }
}

    public class Java8FeatureTest {
        public static void main(String[] args) {

            IMathFunction add = Integer::sum;

            IMathFunction multiply = (x, y) -> x * y;
            IMathFunction divide = (int x, int y) -> x / y;

            System.out.println("Addition is" + add.calculate(6,3));
            System.out.println("Multiplication is" + multiply.calculate(6,3));
            System.out.println("Division is" + divide.calculate(6,3));

            IMathFunction.printResult(6,3,"Addition", add);
            IMathFunction.printResult(6,3, "Multiplication", multiply);
            IMathFunction.printResult(6,3,"Division", divide);



        }
    }

