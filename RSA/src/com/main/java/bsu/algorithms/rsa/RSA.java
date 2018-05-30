package com.main.java.bsu.algorithms.rsa;

import java.math.BigInteger;

public class RSA {

    private static String str = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static BigInteger encryptDecryptNumber(BigInteger Text, BigInteger ed, BigInteger n) {
        return Text.modPow(ed, n);
    }

    public static String encryptBlock(String mBlock, BigInteger e, BigInteger n) {
        BigInteger sum = RSA.getValueForBlock(mBlock, n);

        return RSA.BigIntegerTwo(sum.modPow(e, n), n, 0);
    }

    public static String decryptBlock(String mBlock, BigInteger d, BigInteger n) {
        BigInteger sum = RSA.BaseN2BigInteger(mBlock);

        return RSA.BigIntegerTwo(sum.modPow(d, n), n, 1);
    }

    public static BigInteger getValueForBlock(String mBlock, BigInteger n) {
        int k = RSA.calculate(n);
        BigInteger N;
        N= BigInteger.valueOf(str.length());

        Long numLong;
        BigInteger prod;
        BigInteger sum = BigInteger.ZERO;

        for(int i = 0; i < k; i++) {
            numLong = (long)str.indexOf(mBlock.charAt(i));
            prod = BigInteger.valueOf(numLong).multiply(N.pow(k-i-1));
            sum = sum.add(prod);
        }

        return sum;
    }

    public static String BigIntegerTwo(BigInteger a, BigInteger n, int op) {
        BigInteger N;
        N = BigInteger.valueOf(str.length());
        int k = RSA.calculate(n);

        if(a.compareTo(N) == -1) {
            Integer integer = new Integer(a.toString());
            return str.substring(integer, integer+1);
        }

        String newStr = "";
        BigInteger mod;
        BigInteger quotient = new BigInteger(a.toString());

        do {
            mod = quotient.mod(N);
            quotient = quotient.divide(N);

            newStr = newStr.concat(str.substring(mod.intValue(), mod.intValue()+1));
        }
        while(quotient.compareTo(N) >= 0);

        newStr = newStr.concat(str.substring(quotient.intValue(), quotient.intValue()+1));

        while(op == 0 && newStr.length() < k+1)
            newStr = newStr.concat(str.substring(0,1));
        while(op == 1 && newStr.length() < k)
            newStr = newStr.concat(str.substring(0,1));

        String result = new StringBuffer(newStr).reverse().toString();

        return result;
    }

    public static BigInteger BaseN2BigInteger(String number) {
        BigInteger N;
        N = BigInteger.valueOf(str.length());
        int len = number.length();

        Long auxLong;
        BigInteger prod;
        BigInteger sum = BigInteger.ZERO;

        for(int i = 0; i < len; i++) {
            auxLong = (long)str.indexOf(number.charAt(i));
            prod = BigInteger.valueOf(auxLong).multiply(N.pow(len-i-1));
            sum = sum.add(prod);
        }

        return sum;
    }

    public static String[] getBlocks(String Text, int k) {
        int ind = 0;
        String[] Blocks = new String[Text.length() / k];

        for(int i = 0; i < Text.length(); i += k)
            Blocks[ind++] = Text.substring(i, i + k);

        return Blocks;
    }

    public static String encryptString(String Text, BigInteger e, BigInteger n) {
        int k = RSA.calculate(n);
        Text = RSA.fillStr(Text, k);
        String[] st = RSA.getBlocks(Text, k);
        String result = "";

        for(int i = 0; i < st.length; i++) {
            result = result.concat(RSA.encryptBlock(st[i], e, n));
        }
        return result;
    }

    public static String decryptString(String Text, BigInteger d, BigInteger n) {
        int k = RSA.calculate(n);
        Text = RSA.fillStr(Text, k + 1);
        String[] newString = RSA.getBlocks(Text, k + 1);
        String result = "";

        for (int i = 0; i < newString.length; i++){
            result = result.concat(RSA.decryptBlock(newString[i], d, n));
        }
        return result;
    }

    public static String fillStr(String Text, int k) {
        int fill = Text.length() % k;

        if(fill == 0) return Text;

        int spaces = k - fill;
        for(int i = 0; i < spaces; i++) {
            Text = Text.concat(" ");
        }
        return Text;
    }

    public static int calculate(BigInteger n) {
        return (int)Math.floor(Math.log(n.longValue())/Math.log(str.length()));
    }
}