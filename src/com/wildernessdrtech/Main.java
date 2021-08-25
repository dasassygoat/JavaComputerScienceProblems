package com.wildernessdrtech;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //Fibonacci();
        //Compression();
        //Encryption();
        //PiCalculate();
        //Hanoi();
        //EncryptAnImage();
        Gene();
    }

    public static void Gene(){
        Gene g = new Gene("ACGTACGGATCTCTCTAACG");
        g.main();

    }
    private static void EncryptAnImage() throws IOException {

        File file = new File("D:\\development\\src\\github.com\\journeyman32\\JavaComputerScienceProblems\\img_5822.jpg");
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", bos);
        //ImageIO.write(image, "jpg", new File("output.jpg"));
        System.out.println(bos.toByteArray().length);
        ImageEncryption ie = new ImageEncryption(bos.toByteArray());
        KeyPair encryptedImage = ie.EncryptImage();
        System.out.println(encryptedImage.key1.length + " : " + encryptedImage.key2.length);

        ByteArrayInputStream encryptedImageBytes = new ByteArrayInputStream(encryptedImage.key2);
        BufferedImage bImageEnc = ImageIO.read(encryptedImageBytes);
        for(int i=0; i < encryptedImage.key2.length; i++){
            System.out.print(encryptedImage.key2[i]);
        }
        System.out.print("\n");
        //ImageIO.write(bImageEnc, "jpg", new File("encrypted.jpg") );

        byte[] decryptedImage = ie.DecryptImage();
        ByteArrayInputStream bis = new ByteArrayInputStream(decryptedImage);
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "jpg", new File("decrypted.jpg") );
        System.out.println("image created");
    }
    public static void Hanoi(){
        Hanoi hanoi = new Hanoi(3);
        hanoi.solve();
        System.out.println(hanoi.towerA);
        System.out.println(hanoi.towerB);
        System.out.println(hanoi.towerC);
    }
    public static void PiCalculate(){
        double output = 4/1 -4/3+4/5-4/7;
        System.out.println(output);

        System.out.println(PiCalculator.calculatePi(1000000));
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
        String resultDuplicate = Encryption.decrypt(keyPairDuplicate);
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
