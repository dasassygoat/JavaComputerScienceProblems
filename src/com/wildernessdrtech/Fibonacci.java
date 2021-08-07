package com.wildernessdrtech;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Fibonacci {
    //fib(n) = fib(fib(n-1) + fib(n-2)

    public static int Fib1(int n) {
        if(n < 2){
            return n;
        }
        //System.out.println(Fib1(n-1) + Fib1(n-2));
        return Fib1(n-1) + Fib1(n-2);
    }
    static Map<Integer, Integer> memo = new HashMap<>(Map.of(0,0,1,1));

    public static int FibMemoization(int n){
        if(!memo.containsKey(n)){
            //memoization step
            memo.put(n,FibMemoization(n-1) + FibMemoization(n-2));
        }
        return memo.get(n);
    }
    public static int FibIterative(int n){
        int last=0;
        int next = 1;
        for(int i=0; i< n; i++){
            int oldLast = last;
            //System.out.println("Old last: " + oldLast);
            last = next;
            //System.out.println("New last: " + last);
            next = oldLast + next;
            System.out.println("Next: " + next);
        }
        return last;
    }
    private static int last = 0, next = 1;
    public static IntStream FibStream(){
            return IntStream.generate(() -> {
                int oldLast = last;
                last = next;
                next = oldLast + next;
                return oldLast;
            });
    }

}
