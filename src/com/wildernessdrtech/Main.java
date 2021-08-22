package com.wildernessdrtech;

public class Main {

    public static void main(String[] args) {
        //Fibonacci();
        //Compression();
        Encryption();
    }
    public static void Encryption(){
        KeyPair keyPair = Encryption.encrypt("One time Pad");
        System.out.println(keyPair.key1.toString());
        System.out.println(keyPair.key2.toString());
        String result = Encryption.decrypt(keyPair);
        System.out.println(result);

        KeyPair keyPairDuplicate = Encryption.encrypt("One time Pad");
        System.out.println(keyPairDuplicate.key1.toString());
        System.out.println(keyPairDuplicate.key2.toString());
        String resultDuplicate = Encryption.decrypt(keyPair);
        System.out.println(resultDuplicate);
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
