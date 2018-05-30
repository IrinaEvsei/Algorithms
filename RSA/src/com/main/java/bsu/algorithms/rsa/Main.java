package com.main.java.bsu.algorithms.rsa;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        String mText = "Hello world";

        GenerateKeys keys = new GenerateKeys(31);
        BigInteger e = keys.getE();
        BigInteger d = keys.getD();
        BigInteger m = keys.getM();

        System.out.println("Text : " + mText);
        System.out.println("Encrypted : " + RSA.encryptString(mText, e, m));
        System.out.println("Decrypted : " + RSA.decryptString(RSA.encryptString(mText, e, m), d, m));
    }
}