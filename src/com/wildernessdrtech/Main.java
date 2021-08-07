package com.wildernessdrtech;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Fibonacci.Fib1(5));
        System.out.println(Fibonacci.Fib1(10));
        System.out.println(Fibonacci.Fib1(40));
        System.out.println(Fibonacci.FibMemoization(500));
        System.out.println(Fibonacci.FibIterative(10));
        Fibonacci.FibStream().limit(41).forEachOrdered(System.out::println);
    }
}
