package com.wildernessdrtech;

public class Main {

    public static void main(String[] args) {
        //Fibonacci();
        Compression();
    }
    private static void Compression(){
        Compression compression = new Compression("ACGT");
        Compression compressionATG = new Compression("ATG");

        compression.decompress();
        compressionATG.decompress();

    }
    private static void Fibonacci() {
        System.out.println(Fibonacci.Fib1(5));
        System.out.println(Fibonacci.Fib1(10));
        System.out.println(Fibonacci.Fib1(40));
        System.out.println(Fibonacci.FibMemoization(500));
        System.out.println(Fibonacci.FibIterative(10));
        Fibonacci.FibStream().limit(41).forEachOrdered(System.out::println);
    }



}
