package com.wildernessdrtech;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageEncryption {
    private byte[] image;
    private byte[] decryptedImage;

    private KeyPair encryptedImage;

    public ImageEncryption(byte[] image) throws IOException {
        this.image = image;
    }
    public KeyPair EncryptImage(){
        encryptedImage = Encryption.encrypt(image, true);
        return encryptedImage;
    }

    public byte[] DecryptImage(){
        decryptedImage = Encryption.decrypt(encryptedImage, true);
        return decryptedImage;

    }

    public byte[] GetEncryptedImage(){

        return encryptedImage.key2;
    }
}
