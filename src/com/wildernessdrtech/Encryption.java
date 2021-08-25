package com.wildernessdrtech;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Random;

public class Encryption {

    private static byte[] randomKey(int length){
        byte[] dummy = new byte[length];
        Random random = new Random();
        random.nextBytes(dummy);
        return dummy;
    }

    public static KeyPair encrypt(String original){
        byte[] originalBytes = original.getBytes();
        byte[] dummyKey = randomKey(originalBytes.length);
        byte[] encryptedKey = new byte[originalBytes.length];
        System.out.println("Original length: " + originalBytes.length);
        for(int i = 0; i < originalBytes.length; i++){
            //XOR every byte
            encryptedKey[i] = (byte) (originalBytes[i] ^ dummyKey[i]);
        }
        return new KeyPair(dummyKey,encryptedKey);
    }

    public static KeyPair encrypt(byte[] original, Boolean isImage){

        byte[] dummyKey = randomKey(original.length);
        byte[] encryptedKey = new byte[original.length];
        System.out.println("Original length: " + original.length);
        for(int i = 0; i < original.length; i++){
            //XOR every byte
            encryptedKey[i] = (byte) (original[i] ^ dummyKey[i]);
        }
        return new KeyPair(dummyKey,encryptedKey);
    }

    public static String decrypt(KeyPair keyPair){
        byte[] decrypted = new byte[keyPair.key1.length];
        for(int i=0; i<keyPair.key1.length; i++){
            decrypted[i] = (byte) (keyPair.key1[i] ^ keyPair.key2[i]);
        }
        return new String(decrypted);
    }

    public static byte[] decrypt(KeyPair keyPair, Boolean isImage){
        byte[] decrypted = new byte[keyPair.key1.length];
        for(int i=0; i<keyPair.key1.length; i++){
            decrypted[i] = (byte) (keyPair.key1[i] ^ keyPair.key2[i]);
        }

        return decrypted;
    }
}
